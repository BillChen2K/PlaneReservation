package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.ReservationModel;
import cn.edu.ecnu.planereservation.Model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:21
 **/
@Mapper
public interface ReservationMapper {

    @Select("SELECT * FROM reservation WHERE passenger_id=#{1}")
    ReservationModel selectReservationByPassengerId(long passenger_id);

}
