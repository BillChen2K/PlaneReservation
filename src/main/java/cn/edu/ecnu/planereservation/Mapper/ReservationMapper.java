package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.Joined.ReservationDetailModel;
import cn.edu.ecnu.planereservation.Model.ReservationModel;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:21
 **/
@Mapper
public interface ReservationMapper {

    @Select("SELECT * FROM reservation WHERE uid=#{1}")
    ArrayList<ReservationModel> selectReservationByUid(long uid);

    @Select("SELECT * FROM reservation NATURAL JOIN flight NATURAL JOIN flight_description NATURAL JOIN payment NATURAL JOIN passenger NATURAL JOIN seat WHERE uid=#{1};")
    ArrayList<ReservationDetailModel> selectReservationDetailsByUid(long uid);

    @Select("SELECT * FROM reservation WHERE reservation_id=#{1}")
    ReservationModel selectReservationById(long reservation_id);

    @Select("SELECT * FROM reservation NATURAL JOIN passenger NATURAL JOIN seat NATURAL JOIN flight_description NATURAL JOIN passenger NATURAL JOIN seat WHERE reservation_id=#{1}")
    HashMap<String, String>selectReservationDetailById();

    @Update("UPDATE reservation SET state=#{param1} WHERE reservation_id=#{param2}")
    void updateReservationState(long state, long reservation_id);

    @Update("UPDATE reservation  " +
            "SET datetime=#{datetime}, payment_id=#{paymentId}, passenger_id=#{passengerId}, flight_id=#{flightId}, state=#{state} " +
            "WHERE reservation_id=#{reservationId}")
    void updateReservationAll(ReservationModel reservationModel);

    @Insert("INSERT INTO reservation (datetime, payment_id, passenger_id, flight_id, state, seat_id, uid) " +
            "VALUES ( #{datetime}, #{paymentId}, #{passengerId}, #{flightId}, #{state}, #{seatId}, #{uid})")
    @Options(useGeneratedKeys = true, keyProperty = "reservationId")
    int insertReservation(ReservationModel reservationModel);

}
