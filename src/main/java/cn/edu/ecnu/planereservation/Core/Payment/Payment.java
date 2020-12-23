package cn.edu.ecnu.planereservation.Core.Payment;

import cn.edu.ecnu.planereservation.Model.PaymentModel;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:18
 **/
public interface Payment {
	public int confirmPayment();
	public PaymentModel getModel();
}
