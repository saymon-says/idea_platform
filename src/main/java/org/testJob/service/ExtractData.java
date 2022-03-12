package org.testJob.service;

import org.apache.commons.math3.stat.descriptive.rank.Percentile;
import org.testJob.model.Ticket;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ExtractData {

    public static long getDateTimeFlight(Ticket ticket) {
        String depDateTime = ticket.getDeparture_date() + " " + ticket.getDeparture_time();

        String arrDateTime = ticket.getArrival_date() + " " + ticket.getArrival_time();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");

        LocalDateTime departureDateTime = LocalDateTime.parse(depDateTime, formatter);
        LocalDateTime arrivalDateTime = LocalDateTime.parse(arrDateTime, formatter);

        return Duration.between(departureDateTime, arrivalDateTime).toMinutes();
    }

    public static double findAverageTime(List<Ticket> tickets) {

        return createDateTimeFlight(tickets).stream()
                .mapToDouble(d -> d)
                .average()
                .orElse(0.0);
    }

    public static long findPercentileFlightTime(List<Ticket> tickets, double percentileValue) {

        double[] array = createDateTimeFlight(tickets).stream().mapToDouble(d -> d).toArray();

        Percentile percentile = new Percentile();
        percentile.setData(array);

        return Duration.ofMinutes((long) percentile.evaluate(percentileValue)).toMinutes();
    }

    private static List<Long> createDateTimeFlight(List<Ticket> tickets) {
        List<Long> dateTimeFlight = new ArrayList<>();
        for (Ticket ticket : tickets) {
            dateTimeFlight.add(getDateTimeFlight(ticket));
        }
        return dateTimeFlight;
    }

}
