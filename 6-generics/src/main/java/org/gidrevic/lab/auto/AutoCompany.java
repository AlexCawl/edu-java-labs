package org.gidrevic.lab.auto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import org.gidrevic.lab.auto.cars.Car;
import org.gidrevic.lab.util.DuplicateException;
import org.gidrevic.lab.util.NotFoundException;
import org.gidrevic.lab.util.Owner;

public class AutoCompany implements Owner<Integer, Car> {
    private final Map<Integer, Car> cars = new HashMap<>();

    @Override
    public Optional<Car> getById(Integer id) {
        Car car = cars.get(id);
        if (car == null) {
            return Optional.empty();
        } else {
            return Optional.of(car);
        }
    }

    @Override
    public void add(Car item) throws DuplicateException {
        cars.compute(item.id(), (k, v) -> {
            if (v == null) {
                return item;
            } else {
                throw new DuplicateException();
            }
        });
    }

    @Override
    public void remove(Car item) throws NotFoundException {
        if (cars.remove(item.id()) == null) {
            throw new NotFoundException();
        }
    }

    @Override
    public void removeById(Integer id) throws NotFoundException {
        if (cars.remove(id) == null) {
            throw new NotFoundException();
        }
    }

    @Override
    @SafeVarargs
    public final Optional<Car> find(Predicate<Car>... conditions) {
        return cars.values().stream().filter(car -> {
            for (Predicate<Car> p : conditions) {
                if (!p.test(car)) {
                    return false;
                }
            }
            return true;
        }).findAny();
    }
}
