package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationModel {
    protected long reservationId;
    protected String datetime;
    protected String payment;
    protected long passengerId;
    protected long flightId;
    protected long state;
    protected long uid;
    protected long seatId;
}
