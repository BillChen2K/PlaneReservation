package cn.edu.ecnu.planereservation.Core.Payment.Impl;

import cn.edu.ecnu.planereservation.Core.Payment.Payment;
import cn.edu.ecnu.planereservation.Model.PaymentModel;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:18
 **/
public class AlipayPayment implements Payment {

	private double amount;

	@Override
	public PaymentModel getModel() {
		return new PaymentModel();
	}

	@Override
	public int confirmPayment() {
		return 0;
	}

	public AlipayPayment(double amount) {
		this.amount = amount;
	}
}
