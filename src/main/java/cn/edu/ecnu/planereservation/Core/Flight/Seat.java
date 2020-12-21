package cn.edu.ecnu.planereservation.Core.Flight;

import cn.edu.ecnu.planereservation.Mapper.SeatMapper;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:20
 **/

@Component
public class Seat extends SeatModel {

    @Autowired
    SeatMapper seatMapper;

    public int reserve(){
        SeatModel querySeat = seatMapper.selectSeatByFlight(flight_id);
        if (querySeat == null){
            //不存在
            return -2;
        }
        if (querySeat.getAvailable_count() == 0){
            //没有空余座位
            return -1;
        }
        else{
            //预定座位成功
            seat_id = querySeat.getSeat_id();
            type = querySeat.getType();
            price = querySeat.getPrice();
            available_count = querySeat.getAvailable_count();
            available_count--;
            seatMapper.updateSeatAvailablecount(available_count, flight_id);
            return 0;
        }
    }

    public int cancel(){
        SeatModel querySeat = seatMapper.selectSeatByFlight(flight_id);
        if (querySeat == null){
            //不存在
            return -2;
        }
        else {
            //取消成功
            seat_id = querySeat.getSeat_id();
            type = querySeat.getType();
            price = querySeat.getPrice();
            available_count = querySeat.getAvailable_count();
            available_count++;
            seatMapper.updateSeatAvailablecount(available_count, flight_id);
            return 0;
        }
    }
}
