package cn.edu.ecnu.planereservation.Core.PricingStrategy;

import cn.edu.ecnu.planereservation.Model.SeatModel;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-06 10:22
 **/
public interface PricingStrategy {
	public double getPricing(SeatModel seat);
}
