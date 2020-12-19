package cn.edu.ecnu.planereservation.Core.Reservation;

import cn.edu.ecnu.planereservation.Mapper.ReservationMapper;
import cn.edu.ecnu.planereservation.Model.ReservationModel;
import com.sun.codemodel.internal.JStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:18
 **/
@Component
public class Reservation extends ReservationModel {

    @Autowired
    ReservationMapper reservationMapper;

    public int save() {
        return 0;
    }

    public int cancel() {
        if (state == 0) {
            //想要取消的订单已经被取消
            return 0;
        }
        else {
            //取消成功
            state = 1;
            return 1;
        }
    }
}
