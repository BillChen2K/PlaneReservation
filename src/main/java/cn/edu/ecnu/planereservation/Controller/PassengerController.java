package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Mapper.PassengerMapper;
import cn.edu.ecnu.planereservation.Model.PassengerModel;
import cn.edu.ecnu.planereservation.Util.Shared;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-23 23:32
 **/
@Component
@Slf4j
public class PassengerController {

    @Autowired
    PassengerMapper passengerMapper;

    @Getter
    private PassengerModel passenger;
    private Boolean isNewPassenger;

    public void setNewPassenger(String name, String id, String phone){
        passenger = new PassengerModel(0, name, id, Shared.currentUser.getUid(), phone);
        isNewPassenger = true;
    }

    public void setExistedPassenger(PassengerModel p){
        passenger = p;
        isNewPassenger = false;
    }
    /**
     * Save current passenger and return a passenger object.
     * New passenger will be saved automatically.
     * @return The passenger model about the reservation.
     */
    public PassengerModel saveAndGetPassenger() {
        if (isNewPassenger) {
            // Save to database
            passengerMapper.insertPassenger(passenger);
            log.info("New passenger inserted.");
            return passenger;
        }
        else {
            // Previous existed passenger
            return passenger;
        }
    }

    public PassengerModel getExistedPassengerById(long passengerId) {
        return passengerMapper.selectPassengersByPassengerId(passengerId);
    }
}
