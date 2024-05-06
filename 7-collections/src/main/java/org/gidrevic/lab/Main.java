package org.gidrevic.lab;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.gidrevic.lab.schedule.Schedule;
import org.gidrevic.lab.schedule.ScheduleValidator;
import org.gidrevic.lab.schedule.TimeTable;
import org.gidrevic.lab.util.DuplicateException;
import org.gidrevic.lab.util.NotFoundException;

public class Main {
    private static final LocalDateTime night = LocalDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0));
    private static final LocalDateTime morning = LocalDateTime.of(LocalDate.now(), LocalTime.of(6, 0, 0));
    private static final LocalDateTime noon = LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 0, 0));
    private static final LocalDateTime evening = LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 0, 0));

    private static List<Schedule> getSchedules() {
        return List.of(
                new Schedule(0, 15, night, morning, "A", "B"),
                new Schedule(1, 64, morning, morning.plusHours(2), "B", "C"),
                new Schedule(10, 128, noon, evening, "F", "D"),
                new Schedule(11, 51, morning, night, "E", "H"),
                new Schedule(100, 9, noon, noon.plusMinutes(40), "N", "O"),
                new Schedule(101, 12, evening, evening.plusHours(2).plusMinutes(15), "P", "A"),
                new Schedule(110, 17, night, night.plusHours(8).plusMinutes(24), "A", "T"),
                new Schedule(111, 62, night, noon, "C", "V")
        );
    }

    private static Schedule getDuplicate() {
        return new Schedule(0, 15, night, morning, "A", "B");
    }

    private static void skip() {
        System.out.println();
    }

    public static void main(String[] args) {
        TimeTable timeTable = new TimeTable();
        for (Schedule schedule : getSchedules()) {
            System.out.println("Adding: " + schedule);
            timeTable.add(schedule);
        }
        skip();

        // Add duplicate
        Schedule schedule = getDuplicate();
        System.out.println("Trying to add duplicate: " + schedule);
        try {
            timeTable.add(schedule);
        } catch (DuplicateException e) {
            System.out.println("Caught exception: " + e);
            System.out.println(e.getMessage());
        }
        skip();

        // Deleting schedule
        System.out.println("Deleting: " + schedule);
        timeTable.remove(schedule);
        skip();

        // Deleting schedule by ID
        System.out.println("Deleting schedule by id: " + 111);
        timeTable.removeById(111);
        skip();

        // Deleting non-existing schedule
        System.out.println("Deleting non-existing schedule: " + schedule);
        try {
            timeTable.remove(schedule);
        } catch (NotFoundException e) {
            System.out.println("Caught exception: " + e);
        }
        skip();

        // Deleting non-existing schedule by ID
        System.out.println("Deleting non-existing schedule by id: " + schedule);
        try {
            timeTable.removeById(schedule.id());
        } catch (NotFoundException e) {
            System.out.println("Caught exception: " + e);
        }
        skip();

        // Check is it deleted
        System.out.println("Check if deleted: " + schedule);
        System.out.println(timeTable.getById(schedule.id()));
        skip();

        // Find route that departs in noon
        System.out.println("Find route that departs in noon:");
        System.out.println(timeTable.find(
                new ScheduleValidator(item -> item.getDepartureDate().equals(noon))
        ));
        skip();

        // Find route that arrives in night
        System.out.println("Find route that arrives in night:");
        System.out.println(timeTable.find(
                new ScheduleValidator(item -> item.getArrivalDate().equals(night))
        ));
        skip();

        // Find all routes more than 6 hours
        System.out.println("Find all routes more than 6 hours:");
        System.out.println(timeTable.findAll(
                ScheduleValidator.travelTimeMoreThan(Duration.of(6, ChronoUnit.HOURS))
        ));
        skip();

        // Find all routes more than 30 minutes and less than 3 hours
        System.out.println("Find all routes more than 30 minutes and less than 3 hours:");
        System.out.println(timeTable.findAll(
                ScheduleValidator.travelTimeMoreThan(Duration.of(30, ChronoUnit.MINUTES)),
                ScheduleValidator.travelTimeLessThan(Duration.of(3, ChronoUnit.HOURS))
        ));
        skip();

        // FIND ANY
        System.out.println("Find any:");
        System.out.println(timeTable.find(
                ScheduleValidator.any()
        ));
    }
}