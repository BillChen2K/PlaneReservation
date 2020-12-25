package cn.edu.ecnu.planereservation.Core.DiscountStrategy;

/**
 * Used to make discount
 *
 * @author billchen
 * @version 1.0
 * @create 2020-12-23 12:07 上午
 **/
public interface DiscountStrategy {
    public double getDiscountedPrice(double originalPrice);
}
