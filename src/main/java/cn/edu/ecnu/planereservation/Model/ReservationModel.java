package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationModel {
    protected long reservationId;
    protected String datetime;
    protected String paymentId;
    protected long passengerId;
    protected long flightId;
    protected long state;
    protected long seatId;
    protected long uid;
}
