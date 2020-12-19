package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.FlightModel;
import cn.edu.ecnu.planereservation.Model.ReservationModel;
import cn.edu.ecnu.planereservation.Model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface FlightMapper {

    @Select("SELECT * FROM flight WHERE fly_from_airport_id=#{1} AND fly_to_airport_id=#{2}")
    ArrayList<FlightModel> selectFlightByAirport(long fly_from_airport_id, long fly_to_airport_id);
}
