package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Mapper.FlightDescriptionMapper;
import cn.edu.ecnu.planereservation.Mapper.SeatMapper;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-22 11:31 下午
 **/
@Component
public class FlightController {

    @Autowired
    SeatMapper seatMapper;

    @Autowired
    FlightDescriptionMapper flightDescriptionMapper;

    public ArrayList<SeatModel> getSeatsByFlightId(long flight_id) {
        return seatMapper.selectSeatsByFlightId(flight_id);
    }
}
