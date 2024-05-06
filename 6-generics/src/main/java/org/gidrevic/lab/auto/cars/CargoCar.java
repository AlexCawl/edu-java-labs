package org.gidrevic.lab.auto.cars;

import org.gidrevic.lab.auto.CarColor;
import org.gidrevic.lab.auto.CarType;

public class CargoCar extends Car {
    public CargoCar(Integer id, String name, Double price, CarColor color) {
        super(id, name, price, CarType.CARGO, color);
    }
}
