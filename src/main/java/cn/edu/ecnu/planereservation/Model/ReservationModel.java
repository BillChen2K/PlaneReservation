package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationModel {
    protected long reservation_id;
    protected String datetime;
    protected String payment;
    protected long passenger_id;
    protected long flight_id;
    protected long state;
}
