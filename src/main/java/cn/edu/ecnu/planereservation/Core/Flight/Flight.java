package cn.edu.ecnu.planereservation.Core.Flight;

import cn.edu.ecnu.planereservation.Mapper.AirportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:20
 **/
@Component
public class Flight {

    @Autowired
    AirportMapper airportMapper;
    public Flight() {

        airportMapper.selectAllAirports();
    }
}
