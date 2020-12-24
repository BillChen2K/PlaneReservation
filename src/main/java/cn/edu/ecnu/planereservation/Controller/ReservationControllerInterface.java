package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Model.Joined.FlightTableItem;
import cn.edu.ecnu.planereservation.Model.PassengerModel;
import cn.edu.ecnu.planereservation.Model.PaymentModel;
import cn.edu.ecnu.planereservation.Model.ReservationModel;

/**
 * '
 * Workflow:
 * create() -> setAssociatedFlight() -> setPayment() -> save();
 * @author billchen
 * @version 1.0
 * @create 2020-12-23 23:46
 **/
public interface ReservationControllerInterface {
    public int save();
    public void create();
}
