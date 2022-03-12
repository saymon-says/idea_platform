package org.testJob.model;

import lombok.Data;

@Data
public class Ticket {

    private String origin;

    private String origin_name;

    private String destination;

    private String destination_name;

    private String departure_time;

    private String departure_date;

    private String arrival_date;

    private String arrival_time;

    private String carrier;

    private long stops;

    private long price;

}
