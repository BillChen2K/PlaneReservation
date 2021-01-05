package cn.edu.ecnu.planereservation.Core.DiscountSystem;

import cn.edu.ecnu.planereservation.Core.DiscountStrategy.DiscountStrategy;
import cn.edu.ecnu.planereservation.Model.SeatModel;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-05 23:29
 **/
public interface DiscountListener {
	public void onDiscountOpened(SeatModel seatModel, DiscountStrategy ds);
	public void onDiscountClosed(SeatModel seatModel, DiscountStrategy ds);
}
