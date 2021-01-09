package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.SeatModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
public interface SeatMapper {

    @Select("SELECT * FROM seat WHERE flight_id=#{1}")
    ArrayList<SeatModel> selectSeatsByFlightId(long flight_id);

    @Update("UPDATE seat SET available_count=#{param1} WHERE seat_id=#{param2}")
    void updateSeatAvailableCount(long availableCount, long seatId);

    @Select("SELECT * FROM seat WHERE seat_id=#{1}")
    SeatModel selectSeatDetailBySeatId(long seatId);

}
