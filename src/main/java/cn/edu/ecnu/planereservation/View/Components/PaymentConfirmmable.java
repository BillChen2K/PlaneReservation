package cn.edu.ecnu.planereservation.View.Components;

import cn.edu.ecnu.planereservation.Model.PaymentModel;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-09 19:09
 **/
public interface PaymentConfirmmable {
	public void paymentDidFinished(PaymentModel p);
	public void paymentDidCanceled();
}
