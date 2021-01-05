package cn.edu.ecnu.planereservation.Core.DiscountSystem;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * Applied observer pattern as well as singleton.
 *
 * @author billchen
 * @version 1.0
 * @create 2021-01-05 23:28
 **/
public class DiscountDispatcher {
	private ArrayList<DiscountListener> listeners;

	private static DiscountDispatcher discountDispatcher = null;

	/**
	 * Send notification to all listeners.
	 */
	private DiscountDispatcher() {
		for (DiscountListener listener: listeners) {
			listener.onDiscountClosed(null, null);
		}
	}

	/**
	 * @return Return a singleton instance of the discount dispacher.
	 */
	public static DiscountDispatcher getInstance() {
		if (discountDispatcher == null) {
			discountDispatcher = new DiscountDispatcher();
		}
		return discountDispatcher;

	}
}
