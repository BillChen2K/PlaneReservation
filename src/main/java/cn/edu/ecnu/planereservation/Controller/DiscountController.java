package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Core.DiscountStrategy.*;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

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
		DiscountStrategy[] discounts = {new DiscountByAmount(100),
		new DiscountByAmount(250),
		new DiscountByAmount(400),
		new DiscountByPercent(0.95),
		new DiscountByPercent(0.85),
		new DiscountByPercent(0.75),
		new DiscountNEveryN(30, 200),
		new DiscountNEveryN(60, 300),
		new DiscountNEveryN(110, 500)};
		ArrayList<DiscountStrategy> discountOutput = new ArrayList<>();
		for (int i = 0; i < 3; i++){
			discountOutput.add(discounts[rd.nextInt(discounts.length)]);
		}
		discountOutput.add(new DiscountNoWay());
		return discountOutput;
	}
}
