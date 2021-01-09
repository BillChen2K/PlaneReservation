package cn.edu.ecnu.planereservation.Core.DiscountSystem;

import cn.edu.ecnu.planereservation.Controller.DiscountController;
import cn.edu.ecnu.planereservation.Mapper.FlightMapper;
import cn.edu.ecnu.planereservation.Mapper.SeatMapper;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import cn.edu.ecnu.planereservation.Util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;

/**
 *
 * Applied observer pattern as well as singleton.
 *
 * @author billchen
 * @version 1.0
 * @create 2021-01-05 23:28
 **/
@Component
@Slf4j
public class DiscountDispatcher {

	private ArrayList<DiscountListener> listeners = new ArrayList<>();

	private static DiscountDispatcher discountDispatcher = null;

	@Autowired
	SeatMapper seatMapper;

	@Autowired
	FlightMapper flightMapper;

	@Autowired
	DiscountController discountController;

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
			discountDispatcher = SpringContextUtil.getBean(DiscountDispatcher.class);
		}
		return discountDispatcher;
	}

	public void addListeners(DiscountListener discountListener) {
		listeners.add(discountListener);
		Calendar calendar = Calendar.getInstance();
		if(calendar.get(Calendar.SECOND) <= 30) {
			// Discount available
			openDiscount();
		}
		else{
			closeDiscount();
		}
	}

	/**
	 * Scheduled every minute: Open Discount
	 */
	@Scheduled(cron="0 * *  * * ?")
	private void openDiscount(){
		log.info("Discount opened.");
		SeatModel seat = new SeatModel();
		/* LM6252 - C */
		/**
		 * Discount available.
		 */
		seat.setSeatId(100316);
		for (DiscountListener listener: listeners) {
			listener.onDiscountOpened(seat,
									  discountController.getOneRandomDiscountBySeat(seat));
		}
	}

	/**
	 * Scheduled every minute at second 30: Close Discount
	 */
	@Scheduled(cron="30 * *  * * ?")
	private void closeDiscount() {
		log.info("Discounts closed.");
		for (DiscountListener listener: listeners) {
			listener.onDiscountClosed(null, null);
		}
	}

}
