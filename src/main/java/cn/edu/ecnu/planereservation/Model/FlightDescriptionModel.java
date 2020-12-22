package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class FlightDescriptionModel {
    protected long flightDescriptionId;
    protected String flightNumber;
    protected String model;
    protected long flyToAirportId;
    protected long flyFromAirportId;
    protected Time departureTime;
    protected int flightDurationMinutes;
}
