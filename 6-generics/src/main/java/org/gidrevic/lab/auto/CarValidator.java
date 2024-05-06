package org.gidrevic.lab.auto;

import java.util.function.Predicate;
import org.gidrevic.lab.auto.cars.Car;

public class CarValidator implements Predicate<Car> {
    private final Predicate<Car> condition;

    public CarValidator(Predicate<Car> condition) {
        this.condition = condition;
    }

    @Override
    public boolean test(Car car) {
        return condition.test(car);
    }

    public static CarValidator any() {
        return new CarValidator(item -> true);
    }

    public static CarValidator none() {
        return new CarValidator(item -> false);
    }

    public static CarValidator economyType() {
        return new CarValidator(item -> item.getType() == CarType.ECONOMY);
    }

    public static CarValidator businessType() {
        return new CarValidator(item -> item.getType() == CarType.BUSINESS);
    }

    public static CarValidator cargoType() {
        return new CarValidator(item -> item.getType() == CarType.CARGO);
    }
}
