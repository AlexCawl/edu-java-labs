package org.gidrevic.lab.schedule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.gidrevic.lab.util.DuplicateException;
import org.gidrevic.lab.util.NotFoundException;
import org.gidrevic.lab.util.Owner;

public class TimeTable implements Owner<Integer, Schedule> {
    private final Map<Integer, Schedule> schedules = new HashMap<>();

    @Override
    public Optional<Schedule> getById(Integer id) {
        Schedule schedule = schedules.get(id);
        if (schedule == null) {
            return Optional.empty();
        } else {
            return Optional.of(schedule);
        }
    }

    @Override
    public void add(Schedule item) throws DuplicateException {
        schedules.compute(item.id(), (k, v) -> {
            if (v == null) {
                return item;
            } else {
                throw new DuplicateException();
            }
        });
    }

    @Override
    public void remove(Schedule item) throws NotFoundException {
        if (schedules.remove(item.id()) == null) {
            throw new NotFoundException();
        }
    }

    @Override
    public void removeById(Integer id) throws NotFoundException {
        if (schedules.remove(id) == null) {
            throw new NotFoundException();
        }
    }

    @SafeVarargs
    @Override
    public final Optional<Schedule> find(Predicate<Schedule>... conditions) {
        return schedules.values().stream().filter(car -> {
            for (Predicate<Schedule> p : conditions) {
                if (!p.test(car)) {
                    return false;
                }
            }
            return true;
        }).findAny();
    }

    @SafeVarargs
    @Override
    public final List<Schedule> findAll(Predicate<Schedule>... conditions) {
        return schedules.values().stream().filter(car -> {
            for (Predicate<Schedule> p : conditions) {
                if (!p.test(car)) {
                    return false;
                }
            }
            return true;
        }).collect(Collectors.toList());
    }
}
