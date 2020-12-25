package cn.edu.ecnu.planereservation.Controller;

import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-25 10:35
 **/
@Component
public class ReservationHistoryController {

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
}
