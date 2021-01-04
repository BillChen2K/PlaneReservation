package cn.edu.ecnu.planereservation.Core.DiscountStrategy;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-04 21:34
 **/
public class DiscountNEveryN implements DiscountStrategy {

	private double amount;
	private double threshold;

	public DiscountNEveryN(double amount, double threshold) {
		this.amount = amount;
		this.threshold = threshold;
	}

	@Override
	public String getUIText() {
		return String.format("Discount ￥%.2f every ￥%.2f", amount, threshold);
	}

	@Override
	public double getDiscountedPrice(double originalPrice) {
		return originalPrice - amount * ((int) (originalPrice / threshold));
	}
}
