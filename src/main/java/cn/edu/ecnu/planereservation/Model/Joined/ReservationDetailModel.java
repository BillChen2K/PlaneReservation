package cn.edu.ecnu.planereservation.Model.Joined;

import cn.edu.ecnu.planereservation.Model.PaymentModel;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

/**
 * Join everything!!! Awesome!!!
 * @author billchen
 * @version 1.0
 * @create 2020-12-24 22:24
 **/
@Component
@Getter
@Setter
@Accessors(chain = true)
public class ReservationDetailModel {
    protected int flightId;
    protected int flightDescriptionId;
    protected Date departureDate;
    protected String flightNumber;
    protected String model;
    protected long flyToAirportId;
    protected long flyFromAirportId;
    protected Time departureTime;
    protected int flightDurationMinutes;
    protected long reservationId;
    protected String datetime;
    protected long paymentId;
    protected long passengerId;
    protected int state;
    protected long seatId;
    protected long uid;
    protected PaymentModel.PaymentMethod paymentMethod;
    double realPrice;
    String orderNumber;
    protected SeatModel.SeatType type;
    protected double price;
    protected long availableCount;
    protected String name;
    protected String identityNumber;
    protected String phone;
}
