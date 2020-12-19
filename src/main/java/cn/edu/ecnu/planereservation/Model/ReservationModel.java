package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationModel {
    protected long reservaation_id;
    protected String datetime;
    protected String paymeny;
    protected long passenger_id;
    protected long flight_id;
    protected long state;
}
