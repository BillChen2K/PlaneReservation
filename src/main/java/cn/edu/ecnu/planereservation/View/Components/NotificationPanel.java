/*
 * Created by JFormDesigner on Tue Jan 05 23:14:29 CST 2021
 */

package cn.edu.ecnu.planereservation.View.Components;

import cn.edu.ecnu.planereservation.Core.DiscountStrategy.DiscountStrategy;
import cn.edu.ecnu.planereservation.Core.DiscountSystem.DiscountDispatcher;
import cn.edu.ecnu.planereservation.Core.DiscountSystem.DiscountListener;
import cn.edu.ecnu.planereservation.Mapper.FlightMapper;
import cn.edu.ecnu.planereservation.Mapper.SeatMapper;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
@Component
public class NotificationPanel extends JPanel implements DiscountListener {
	public NotificationPanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		labNotif = new JLabel();

		//======== this ========
		setLayout(null);

		//---- labNotif ----
		labNotif.setText("Notif: LM6252 is now being discounted!");
		labNotif.setFont(new Font("SF Pro Display", Font.BOLD | Font.ITALIC, 14));
		labNotif.setBackground(null);
		labNotif.setForeground(new Color(231, 70, 70));
		add(labNotif);
		labNotif.setBounds(0, 0, 875, 25);

		{
			// compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < getComponentCount(); i++) {
				Rectangle bounds = getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			setMinimumSize(preferredSize);
			setPreferredSize(preferredSize);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel labNotif;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	/**
	 * Singleton Discount Dispatcher
	 */
	DiscountDispatcher discountDispatcher;

	@Autowired
	FlightMapper flightMapper;

	@Autowired
	SeatMapper seatMapper;

	@Override
	public void onDiscountOpened(SeatModel seatModel, DiscountStrategy ds) {
		SeatModel seatDetail = seatMapper.selectSeatDetailBySeatId(seatModel.getSeatId());
		labNotif.setText(String.format("Notif: LM6252 - %s is now being discounted! (%s).",
									   seatDetail.getType().name(),
									   ds.getUIText()));
	}

	@Override
	public void onDiscountClosed(SeatModel seatModel, DiscountStrategy ds) {
		labNotif.setText("Currently no discount available.");
	}

	public void load() {
		discountDispatcher = DiscountDispatcher.getInstance();
		discountDispatcher.addListeners(this);
	}
}
