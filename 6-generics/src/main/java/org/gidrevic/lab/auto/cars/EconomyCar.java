package org.gidrevic.lab.auto.cars;

import org.gidrevic.lab.auto.CarColor;
import org.gidrevic.lab.auto.CarType;

public class EconomyCar extends Car {
    public EconomyCar(Integer id, String name, Double price, CarColor color) {
        super(id, name, price, CarType.ECONOMY, color);
    }
}
