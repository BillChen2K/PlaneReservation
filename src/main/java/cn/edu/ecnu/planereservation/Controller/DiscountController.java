package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Core.DiscountStrategy.*;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-04 21:41
 **/
@Component
public class DiscountController {

	/**
	 * Get discount strategies for a certain seat.
	 * The randomized result will be exactly the same for seat with same seat_id.
	 * @param seat
	 * @return
	 */
	public ArrayList<DiscountStrategy> getDiscountBySeat(SeatModel seat) {
		Random rd = new Random(seat.getSeatId());
		Calendar calendar = Calendar.getInstance();
		ArrayList<DiscountStrategy> discountOutput = new ArrayList<>();
		if (calendar.get(Calendar.SECOND) < 30) {
			// Discounts are available only when second is smaller than 30.
			DiscountStrategy[] discounts = {new DiscountByAmount(100),
					new DiscountByAmount(250),
					new DiscountByAmount(400),
					new DiscountByPercent(0.95),
					new DiscountByPercent(0.85),
					new DiscountByPercent(0.75),
					new DiscountNEveryN(30, 200),
					new DiscountNEveryN(60, 300),
					new DiscountNEveryN(110, 500)};
			for (int i = 0; i < 3; i++){
				discountOutput.add(discounts[rd.nextInt(discounts.length)]);
			}
		}
		discountOutput.add(new DiscountNoWay());
		return discountOutput;
	}

	/**
	 * Get one randomized discount. Used for notification system.
	 * @param seat
	 * @return
	 */
	public DiscountStrategy getOneRandomDiscountBySeat(SeatModel seat) {
		var allDiscounts = getDiscountBySeat(seat);
		Random rd = new Random();
		return allDiscounts.get(rd.nextInt(allDiscounts.size()));
	}
}
