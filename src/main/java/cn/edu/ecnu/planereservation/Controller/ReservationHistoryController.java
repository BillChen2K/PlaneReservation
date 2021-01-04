package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-25 10:35
 **/
@Component
public class ReservationHistoryController {


    @Autowired
    ReservationMapper reservationMapper;

    public enum ReservationStatus {
        Finished, Canceled
    }

    public ReservationStatus getReservationStatus(int statusCode) {
        switch (statusCode) {
            case 0:
                return ReservationStatus.Canceled;
            default:
                return ReservationStatus.Finished;
        }
    }

    /**
     * Cancel reservation by ID.
     * @param reservationId
     */
    public void cancelReservationById(long reservationId) {
        reservationMapper.updateReservationState(0, reservationId);
    }
}
