package cn.edu.ecnu.planereservation.Controller.Payment;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:18
 **/
public class AlipayPayment implements Payment {

	private double amount;

	@Override
	public int confirmPayment() {
		return 0;
	}

	public AlipayPayment(double amount) {
		this.amount = amount;
	}
}
