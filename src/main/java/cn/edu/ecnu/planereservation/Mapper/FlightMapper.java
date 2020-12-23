package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.FlightModel;
import cn.edu.ecnu.planereservation.Model.Joined.FlightTableItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-23 12:02 上午
 **/
@Mapper
public interface FlightMapper {

    @Select("SELECT * FROM flight WHERE flight_description_id=#{1}")
    ArrayList<FlightModel> selectFlightsByDescriptionId(long description_id);

    @Select("SELECT * FROM flight NATURAL JOIN flight_description WHERE flight_description_id=#{1}")
    ArrayList<FlightTableItem> selectFlightDetailsByDescriptionId(long description_id);
}
