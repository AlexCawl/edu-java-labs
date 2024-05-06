package org.gidrevic.lab.schedule;

import java.time.Duration;
import java.util.function.Predicate;

public class ScheduleValidator implements Predicate<Schedule> {
    private final Predicate<Schedule> condition;

    public ScheduleValidator(Predicate<Schedule> condition) {
        this.condition = condition;
    }

    @Override
    public boolean test(Schedule schedule) {
        return condition.test(schedule);
    }

    public static ScheduleValidator travelTimeMoreThan(Duration duration) {
        return new ScheduleValidator(
                schedule -> Duration.between(schedule.getDepartureDate(), schedule.getArrivalDate())
                                    .getSeconds() >= duration.toSeconds()
        );
    }

    public static ScheduleValidator travelTimeLessThan(Duration duration) {
        return new ScheduleValidator(
                schedule -> Duration.between(schedule.getDepartureDate(), schedule.getArrivalDate())
                                                         .getSeconds() <= duration.toSeconds()
        );
    }

    public static ScheduleValidator any() {
        return new ScheduleValidator(item -> true);
    }
}
