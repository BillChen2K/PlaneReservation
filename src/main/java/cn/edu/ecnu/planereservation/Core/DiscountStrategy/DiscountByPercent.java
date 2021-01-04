package cn.edu.ecnu.planereservation.Core.DiscountStrategy;

/**
 * Discount by percentage
 *
 * @author billchen
 * @version 1.0
 * @create 2021-01-04 21:22
 **/
public class DiscountByPercent implements DiscountStrategy {

	private double percentage;

	public DiscountByPercent(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String getUIText() {
		return String.format("%.2f%% Off", 100 * (1 - percentage)) ;
	}

	@Override
	public double getDiscountedPrice(double originalPrice) {
		return originalPrice * percentage;
	}
}
