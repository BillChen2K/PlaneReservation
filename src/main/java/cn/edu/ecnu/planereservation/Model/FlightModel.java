package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightModel {
    protected long flight_id;
    protected String flight_number;
    protected String model;
    protected long fly_to_airport_id;
    protected long fly_from_airport_id;
    protected String datetime;
}
