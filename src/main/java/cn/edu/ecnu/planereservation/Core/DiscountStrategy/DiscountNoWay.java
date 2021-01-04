package cn.edu.ecnu.planereservation.Core.DiscountStrategy;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-25 13:05
 **/
public class DiscountNoWay implements DiscountStrategy{

    @Override
    public String getUIText() {
        return "No Discount";
    }

    @Override
    public double getDiscountedPrice(double originalPrice) {
        return originalPrice;
    }
}
