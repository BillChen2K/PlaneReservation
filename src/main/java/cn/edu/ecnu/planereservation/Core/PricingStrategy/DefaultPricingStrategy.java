package cn.edu.ecnu.planereservation.Core.PricingStrategy;

import cn.edu.ecnu.planereservation.Model.SeatModel;

import java.time.LocalDateTime;

/**
 * Pricing Strategy.
 *
 * @author billchen
 * @version 1.0
 * @create 2021-01-06 10:25
 **/
public class DefaultPricingStrategy implements PricingStrategy{

	/**
	 * Raise price for `RemainNumberOffset` for each available seat.
	 */
	private double remainCountRaisingAmount;

	/**
	 * Raise price for `TimeOffset` at certain time.
	 */
	private double timeOffsetRaisingAmount;

	private TimeVariationStrategy timeVariationStrategy;

	/**
	 * Time variation Strategy
	 */
	public enum TimeVariationStrategy {
		RaiseAtOddMinute, RaiseAtEvenMinute, RaiseAtOddHour, RaiseAtEvenHour,
		RaiseAtFirstHalfMinute
	}

	/**
	 * Check if it's time is suitable for raise price.
	 * @return
	 */
	private Boolean isAtRaiseTime() {
		LocalDateTime now = LocalDateTime.now();
		switch (timeVariationStrategy) {
			case RaiseAtOddHour:
				return now.getHour() % 2 == 1;
			case RaiseAtEvenHour:
				return now.getHour() % 2 == 0;
			case RaiseAtOddMinute:
				return now.getMinute() % 2 == 1;
			case RaiseAtEvenMinute:
				return now.getMinute() % 2 == 0;
			case RaiseAtFirstHalfMinute:
				return now.getSecond() <= 30;
			default:
				return false;
		}
	}

	@Override
	public double getPricing(SeatModel seat) {
		double price = seat.getPrice();
		if (isAtRaiseTime()) {
			price += timeOffsetRaisingAmount;
		}
		return price + seat.getAvailableCount() * remainCountRaisingAmount;
	}

	public DefaultPricingStrategy(double remainCountRaisingAmount, double timeOffsetRaisingAmount,
								  TimeVariationStrategy timeVariationStrategy) {
		this.remainCountRaisingAmount = remainCountRaisingAmount;
		this.timeOffsetRaisingAmount = timeOffsetRaisingAmount;
		this.timeVariationStrategy = timeVariationStrategy;
	}

	@Override
	public String toString() {
		return "DefaultPricingStrategy {" +
				"remainCountRaisingAmount=" + remainCountRaisingAmount +
				", timeOffsetRaisingAmount=" + timeOffsetRaisingAmount +
				", timeVariationStrategy=" + timeVariationStrategy +
				'}';
	}
}
