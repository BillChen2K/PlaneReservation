package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.ReservationModel;
import cn.edu.ecnu.planereservation.Model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:21
 **/
@Mapper
public interface ReservationMapper {

    @Select("SELECT * FROM reservation WHERE passenger_id=#{1}")
    ReservationModel selectReservationByPassengerId(long passenger_id);

    @Select("SELECT * FROM reservation WHERE reservation_id=#{1}")
    ReservationModel selectReservationByReservationid(long reservation_id);

    @Update("UPDATE reservation SET state=#{1} WHERE reservation_id=#{2}")
    void updateReservationState(long state, long reservation_id);

    @Update("UPDATE reservation  " +
            "SET datetime=#{1}, paymeny=#{2}, passenger_id=#{3}, flight_id=#{4}, state=#{5} " +
            "WHERE reservation_id=#{6}")
    void updateReservationAll(String datetime, String payment, long passenger_id, long flight_id, long state, long reservation_id);
}
