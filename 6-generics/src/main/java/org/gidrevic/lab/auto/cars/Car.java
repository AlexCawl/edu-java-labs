package org.gidrevic.lab.auto.cars;

import org.gidrevic.lab.auto.CarColor;
import org.gidrevic.lab.auto.CarType;
import org.gidrevic.lab.util.Indexable;

public class Car implements Indexable<Integer> {
    private final Integer id;
    private final String name;
    private final Double price;
    private final CarType type;
    private final CarColor color;

    public Car(Integer id, String name, Double price, CarType type, CarColor color) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.color = color;
    }

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;
        return id.equals(car.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public CarType getType() {
        return type;
    }

    public CarColor getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s, %s, %s)", name, price, type, color);
    }
}

