package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.PassengerModel;
import cn.edu.ecnu.planereservation.Model.ReservationModel;
import cn.edu.ecnu.planereservation.Model.UserModel;
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

    @Select("SELECT * FROM reservation WHERE reservation_id=#{1}")
    ReservationModel selectReservationByReservationid(long reservation_id);
    /**
     * Select detail of a certain reservation.
     * @return
     */
    @Select("SELECT * FROM reservation NATURAL JOIN passenger NATURAL JOIN seat NATURAL JOIN flight_description WHERE reservation_id=#{1}")
    HashMap<String, String>selectReservationDetails();

    @Update("UPDATE reservation SET state=#{1} WHERE reservation_id=#{2}")
    void updateReservationState(long state, long reservation_id);

    @Update("UPDATE reservation  " +
            "SET datetime=#{1}, paymeny=#{2}, passenger_id=#{3}, flight_id=#{4}, state=#{5} " +
            "WHERE reservation_id=#{6}")
    void updateReservationAll(String datetime, String payment, long passenger_id, long flight_id, long state, long reservation_id);

    @Insert("INSERT INTO reservation (datetime, payment, passenger_id, flight_id, state, seat_id, uid) " +
            "VALUES ( #{datetime}, #{payment}, #{passengerId}, #{flightId}, #{state}, #{seatId}, #{uid})")
    @Options(useGeneratedKeys = true, keyProperty = "reservationId")
    int insertReservation(ReservationModel reservationModel);

}
