package cn.edu.ecnu.planereservation.Core.Reservation;

import cn.edu.ecnu.planereservation.Mapper.ReservationMapper;
import cn.edu.ecnu.planereservation.Model.ReservationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:18
 **/
@Component
public class Reservation extends ReservationModel {

    @Autowired
    ReservationMapper reservationMapper;


    public static final int Canceled = 0;
    public static final int Active = 1;

    public int save() {
        ReservationModel queryReservation = reservationMapper.selectReservationByReservationid(reservationId);
        if (queryReservation == null){
            //不存在
            return -2;
        }
        else{
            //更改成功
            reservationMapper.updateReservationAll(datetime, payment, passengerId, flightId, state, reservationId);
            return 0;
        }
    }

    public int cancel() {
        ReservationModel queryReservation = reservationMapper.selectReservationByReservationid(reservationId);
        if (queryReservation == null){
            //不存在
            return -2;
        }
        else if (queryReservation.getState() == Canceled){
            //想要取消的订单已经被取消
            return -1;
        }
        else {
            //取消成功
            state = Canceled;
            reservationMapper.updateReservationState(state, reservationId);
            return 1;
        }
    }
}
