package org.testJob;

import org.testJob.parser.FlightTimeParser;
import org.testJob.service.ExtractData;

public class App {
    public static void main(String[] args) {

        FlightTimeParser flightTimeParser = new FlightTimeParser();

        System.out.println("Average flight time: " + ExtractData.findAverageTime(flightTimeParser.parse()));
        System.out.println("Percentile flight time: "
                + ExtractData.findPercentileFlightTime(flightTimeParser.parse(), 90));
    }
}
