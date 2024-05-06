package org.gidrevic.lab.schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.gidrevic.lab.util.Indexable;

public class Schedule implements Indexable<Integer> {
    private final Integer id;
    private final Integer route;
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;
    private final String from;
    private final String to;

    public Schedule(Integer id, Integer route, LocalDateTime departureDate, LocalDateTime arrivalDate, String from, String to) {
        this.id = id;
        this.route = route;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.from = from;
        this.to = to;
    }

    public Integer getRoute() {
        return route;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public Integer id() {
        return id;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;

        Schedule schedule = (Schedule) o;
        return route.equals(schedule.route) && from.equals(schedule.from) && to.equals(schedule.to);
    }

    @Override
    public int hashCode() {
        int result = route.hashCode();
        result = 31 * result + from.hashCode();
        result = 31 * result + to.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s -> %s, [%s | %s])", route, from, to, departureDate, arrivalDate);
    }
}
