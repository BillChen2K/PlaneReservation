package cn.edu.ecnu.planereservation.Core.User;

import cn.edu.ecnu.planereservation.Mapper.PassengerMapper;
import cn.edu.ecnu.planereservation.Model.PassengerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:21
 **/
@Component
public class Passenger extends PassengerModel {

    @Autowired
    PassengerMapper passengerMapper;


}
