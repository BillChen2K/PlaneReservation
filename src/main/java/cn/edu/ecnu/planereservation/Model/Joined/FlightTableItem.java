package cn.edu.ecnu.planereservation.Model.Joined;

import cn.edu.ecnu.planereservation.Model.SeatModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-23 11:02 上午
 **/
@Component
@Getter
@Setter
public class FlightTableItem {
    protected int flightId;
    protected int flightDescriptionId;
    protected Date departureDate;
    protected String flightNumber;
    protected String model;
    protected long flyToAirportId;
    protected long flyFromAirportId;
    protected Time departureTime;
    protected int flightDurationMinutes;

    protected ArrayList<SeatModel> seats;
}
