package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.SeatModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface SeatMapper {

    @Select("SELECT * FROM seat WHERE flight_id=#{1}")
    SeatModel selectSeatByFlight(long flight_id);

    @Update("UPDATE seat SET available_count=#{1} WHERE flight_id=#{2}")
    void updateSeatAvailablecount(long available_count, long flight_id);

}
