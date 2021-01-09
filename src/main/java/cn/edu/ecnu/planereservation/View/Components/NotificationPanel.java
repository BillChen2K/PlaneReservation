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
		// Generated using JFormDesigner Evaluation license - unknown
		labNotif = new JLabel();

		//======== this ========
		setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
		. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder
		. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .
		awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
		;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
		) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
		;
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
	// Generated using JFormDesigner Evaluation license - unknown
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
