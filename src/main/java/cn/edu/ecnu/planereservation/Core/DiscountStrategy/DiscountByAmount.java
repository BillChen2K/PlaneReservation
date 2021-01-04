package cn.edu.ecnu.planereservation.Core.DiscountStrategy;

import lombok.extern.slf4j.Slf4j;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-04 21:28
 **/
@Slf4j
public class DiscountByAmount implements DiscountStrategy{
	private double amount;

	public DiscountByAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String getUIText() {
		return "￥" + String.valueOf(amount) + " Off";
	}

	@Override
	public double getDiscountedPrice(double originalPrice) {
		if (amount >= originalPrice) {
			log.warn("Discount amount is greater than original price, may lead to unexpected behaviour.");
		}
		return Math.max(originalPrice - amount, 0.01);
	}
}
