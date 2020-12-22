package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.FlightDescriptionModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface FlightDescriptionMapper {

    @Select("SELECT * FROM flight_description WHERE fly_from_airport_id=#{fly_from_airport_id} AND fly_to_airport_id=#{fly_to_airport_id}")
    ArrayList<FlightDescriptionModel> selectFlightByAirport(long fly_from_airport_id, long fly_to_airport_id);
}
