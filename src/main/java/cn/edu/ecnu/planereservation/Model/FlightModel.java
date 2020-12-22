package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-22 2:13 下午
 **/
@Getter
@Setter
public class FlightModel {
    protected int flightId;
    protected int flightDescriptionId;
    protected Date departureDate;
}
