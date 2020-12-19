package cn.edu.ecnu.planereservation.Core;

import cn.edu.ecnu.planereservation.Core.Flight.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:16
 **/
@Component
public class FlightSystem {
    @Autowired
    Flight flight;

}
