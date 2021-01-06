package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Mapper.ReservationMapper;
import cn.edu.ecnu.planereservation.Model.Joined.ReservationDetailModel;
import cn.edu.ecnu.planereservation.Model.ReservationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    /**
     * Reservation Tracking Status. Status `CANCELED` should always be the last one.
     */
    public enum ReservationTrackingStatus {
        PURCHASED, SEAT_LOCKED, CHECKED_IN, FINISHED, CANCELED
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
     * Pick a random status from a reservation detail model. Random seed is set to ensure it generate the
     * same result for every reservation detail model.
     * @param detail
     * @return A randomized tracking status.
     */
    public ReservationTrackingStatus getTrackingStatus(ReservationDetailModel detail) {
        if (getReservationStatus(detail.getState()) == ReservationStatus.Canceled) {
            return ReservationTrackingStatus.CANCELED;
        }
        else {
            Random rd = new Random(detail.getReservationId() * detail.getFlyToAirportId() + 358989);
            List<ReservationTrackingStatus> trackingStatusesValues =
                    Collections.unmodifiableList(Arrays.asList(ReservationTrackingStatus.values()));
            return trackingStatusesValues.get(rd.nextInt(trackingStatusesValues.size() - 1));
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
