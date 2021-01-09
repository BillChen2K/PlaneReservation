/*
 * Created by JFormDesigner on Tue Jan 05 23:04:25 CST 2021
 */

package cn.edu.ecnu.planereservation.View;

import org.springframework.stereotype.Component;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author unknown
 */
@Component
public class FavouritePanel extends JPanel {
	public FavouritePanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - unknown
		panelHistory = new JPanel();
		var labelUI7 = new JLabel();
		scrollPane2 = new JScrollPane();
		tableDetail = new JTable();
		btnBuy = new JButton();
		scrollPane3 = new JScrollPane();
		listFavourites = new JList<>();
		labHint = new JLabel();
		comboDate = new JComboBox();
		labHint2 = new JLabel();
		labHint3 = new JLabel();
		comboDate2 = new JComboBox();
		labPrice = new JLabel();
		labUI9 = new JLabel();
		labOriginalPrice = new JLabel();
		var labUI10 = new JLabel();
		btnBuy2 = new JButton();

		//======== this ========
		setPreferredSize(new Dimension(1120, 606));
		setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
		javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax
		.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
		.awt.Font("Dialo\u0067",java.awt.Font.BOLD,12),java.awt
		.Color.red), getBorder())); addPropertyChangeListener(new java.beans.
		PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("borde\u0072".
		equals(e.getPropertyName()))throw new RuntimeException();}});
		setLayout(null);

		//======== panelHistory ========
		{
			panelHistory.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.setLayout(null);

			//---- labelUI7 ----
			labelUI7.setText("Here's your favourite ticket configurations. You can choose one from it and purchase another one in one click.");
			labelUI7.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labelUI7);
			labelUI7.setBounds(30, 25, 880, 18);

			//======== scrollPane2 ========
			{

				//---- tableDetail ----
				tableDetail.setModel(new DefaultTableModel(
					new Object[][] {
						{null, null},
						{null, null},
					},
					new String[] {
						"Key", "Value"
					}
				) {
					boolean[] columnEditable = new boolean[] {
						false, false
					};
					@Override
					public boolean isCellEditable(int rowIndex, int columnIndex) {
						return columnEditable[columnIndex];
					}
				});
				tableDetail.setRowHeight(24);
				scrollPane2.setViewportView(tableDetail);
			}
			panelHistory.add(scrollPane2);
			scrollPane2.setBounds(565, 65, 555, 340);

			//---- btnBuy ----
			btnBuy.setText("CONFIRM RESERVATION AND PAY");
			btnBuy.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(btnBuy);
			btnBuy.setBounds(565, 510, 545, 36);

			//======== scrollPane3 ========
			{

				//---- listFavourites ----
				listFavourites.setFont(new Font("SF Pro Text", Font.BOLD, 16));
				listFavourites.setFixedCellHeight(36);
				listFavourites.setModel(new AbstractListModel<String>() {
					String[] values = {
						"FM101 \u4e0a\u6d77 SHA to \u4e0a\u6d77 SHA - (\u9648\u4fca\u6f7c, Seat Class C)",
						"FM101 \u4e0a\u6d77 SHA to \u4e0a\u6d77 SHA - (\u9648\u4fca\u6f7c, Seat Class C)"
					};
					@Override
					public int getSize() { return values.length; }
					@Override
					public String getElementAt(int i) { return values[i]; }
				});
				scrollPane3.setViewportView(listFavourites);
			}
			panelHistory.add(scrollPane3);
			scrollPane3.setBounds(30, 65, 500, 340);

			//---- labHint ----
			labHint.setText("Hint text");
			labHint.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labHint);
			labHint.setBounds(30, 580, 670, 20);
			panelHistory.add(comboDate);
			comboDate.setBounds(185, 415, 345, 35);

			//---- labHint2 ----
			labHint2.setText("Select Departure Date:");
			labHint2.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labHint2);
			labHint2.setBounds(30, 425, 150, 20);

			//---- labHint3 ----
			labHint3.setText("Select Discount:");
			labHint3.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labHint3);
			labHint3.setBounds(30, 465, 110, 20);
			panelHistory.add(comboDate2);
			comboDate2.setBounds(185, 460, 345, 35);

			//---- labPrice ----
			labPrice.setText("\uffe51234");
			labPrice.setFont(new Font("SF Pro Text", Font.BOLD, 24));
			panelHistory.add(labPrice);
			labPrice.setBounds(1025, 465, 84, 29);

			//---- labUI9 ----
			labUI9.setText("Original Price:");
			labUI9.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			labUI9.setHorizontalAlignment(SwingConstants.RIGHT);
			panelHistory.add(labUI9);
			labUI9.setBounds(870, 440, 170, 16);

			//---- labOriginalPrice ----
			labOriginalPrice.setText("\uffe51023.23");
			labOriginalPrice.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			labOriginalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			panelHistory.add(labOriginalPrice);
			labOriginalPrice.setBounds(1035, 440, 75, 16);

			//---- labUI10 ----
			labUI10.setText("You'll need to pay:");
			labUI10.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			labUI10.setHorizontalAlignment(SwingConstants.TRAILING);
			panelHistory.add(labUI10);
			labUI10.setBounds(885, 475, 123, 16);

			//---- btnBuy2 ----
			btnBuy2.setText("Remove from Favourite");
			btnBuy2.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(btnBuy2);
			btnBuy2.setBounds(325, 510, 200, 36);

			{
				// compute preferred size
				Dimension preferredSize = new Dimension();
				for(int i = 0; i < panelHistory.getComponentCount(); i++) {
					Rectangle bounds = panelHistory.getComponent(i).getBounds();
					preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
					preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
				}
				Insets insets = panelHistory.getInsets();
				preferredSize.width += insets.right;
				preferredSize.height += insets.bottom;
				panelHistory.setMinimumSize(preferredSize);
				panelHistory.setPreferredSize(preferredSize);
			}
		}
		add(panelHistory);
		panelHistory.setBounds(0, 0, 1133, 631);

		setPreferredSize(new Dimension(1120, 610));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - unknown
	private JPanel panelHistory;
	private JScrollPane scrollPane2;
	private JTable tableDetail;
	private JButton btnBuy;
	private JScrollPane scrollPane3;
	private JList<String> listFavourites;
	private JLabel labHint;
	private JComboBox comboDate;
	private JLabel labHint2;
	private JLabel labHint3;
	private JComboBox comboDate2;
	private JLabel labPrice;
	private JLabel labUI9;
	private JLabel labOriginalPrice;
	private JButton btnBuy2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables



	public void refresh() {

	}

	private void addListeners() {

	}

	public void load() {

	}


}
