package org.gidrevic.lab;

import java.util.List;
import org.gidrevic.lab.auto.*;
import org.gidrevic.lab.auto.cars.BusinessCar;
import org.gidrevic.lab.auto.cars.Car;
import org.gidrevic.lab.auto.cars.CargoCar;
import org.gidrevic.lab.auto.cars.EconomyCar;
import org.gidrevic.lab.util.DuplicateException;
import org.gidrevic.lab.util.NotFoundException;

public class Main {
    private static List<Car> getCars() {
        return List.of(
                new Car(0, "Haval", 430.0, CarType.ECONOMY, CarColor.RED),
                new EconomyCar(1, "Tank", 215.5, CarColor.BLUE),
                new Car(10, "Mercedes C class", 337.4, CarType.BUSINESS, CarColor.SILVER),
                new BusinessCar(11, "Audi 2007", 660.0, CarColor.YELLOW),
                new Car(100, "BMW E class", 420.2, CarType.ECONOMY, CarColor.GREEN),
                new Car(101, "Custom vehicle", 744.7, CarType.CARGO, CarColor.WHITE),
                new Car(110, "KAMAZ", 537.0, CarType.CARGO, CarColor.GREEN),
                new CargoCar(111, "MAN CargoCar 2009", 639.6, CarColor.RED),
                new Car(1000, "Lada Vesta", 150.2, CarType.ECONOMY, CarColor.WHITE),
                new BusinessCar(1001, "Rolls-Royse", 879.0, CarColor.BLACK),
                new BusinessCar(1010, "Mercedes E class", 228.7, CarColor.SILVER),
                new Car(1011, "Mercedes S class", 611.6, CarType.BUSINESS, CarColor.SILVER),
                new EconomyCar(1100, "VAZ 2106", 149.0, CarColor.BLACK),
                new EconomyCar(1101, "VOLGA 3110", 380.9, CarColor.BLACK),
                new Car(1110, "Chevrolet Camaro", 337.0, CarType.BUSINESS, CarColor.YELLOW),
                new Car(1111, "Mustang", 860.1, CarType.BUSINESS, CarColor.RED)
        );
    }

    private static void skip() {
        System.out.println();
    }

    private static Car getDuplicate() {
        return new Car(1001, "Rolls-Royse", 879.0, CarType.BUSINESS, CarColor.BLACK);
    }

    public static void main(String[] args) {
        AutoCompany company = new AutoCompany();
        for (Car car : getCars()) {
            System.out.println("Adding: " + car);
            company.add(car);
        }
        skip();

        // Add duplicate
        Car car = getDuplicate();
        System.out.println("Trying to add duplicate: " + car);
        try {
            company.add(car);
        } catch (DuplicateException e) {
            System.out.println("Caught exception: " + e);
            System.out.println(e.getMessage());
        }
        skip();

        // Deleting car
        System.out.println("Deleting: " + car);
        company.remove(car);
        skip();

        // Deleting car by ID
        System.out.println("Deleting car by id: " + 0);
        company.removeById(0);
        skip();

        // Deleting non-existing car
        System.out.println("Deleting non-existing car: " + car);
        try {
            company.remove(car);
        } catch (NotFoundException e) {
            System.out.println("Caught exception: " + e);
        }
        skip();

        // Deleting non-existing car by ID
        System.out.println("Deleting non-existing car by id: " + car);
        try {
            company.removeById(car.id());
        } catch (NotFoundException e) {
            System.out.println("Caught exception: " + e);
        }
        skip();

        // Check is it deleted
        System.out.println("Check if deleted: " + car);
        System.out.println(company.getById(car.id()));
        skip();

        // Find ECONOMY CHEAPER THAN 300
        System.out.println("Find economy car that cheaper than 300:");
        System.out.println(company.find(
                CarValidator.economyType(),
                new CarValidator(item -> item.getPrice() < 300.0)
        ));
        skip();

        // FIND RED CARGO
        System.out.println("Find red cargo car:");
        System.out.println(company.find(
                CarValidator.cargoType(),
                new CarValidator(item -> item.getColor() == CarColor.RED)
        ));
        skip();

        // FIND MERCEDES
        System.out.println("Find mercedes:");
        System.out.println(company.find(
                new CarValidator(item -> item.getName().toLowerCase().contains("mercedes"))
        ));
        skip();

        // FIND YELLOW BUSINESS
        System.out.println("Find yellow business car:");
        System.out.println(company.find(
                CarValidator.businessType(),
                new CarValidator(item -> item.getColor() == CarColor.YELLOW)
        ));
        skip();

        // FIND ANY
        System.out.println("Find any:");
        System.out.println(company.find(
                CarValidator.any()
        ));
    }
}