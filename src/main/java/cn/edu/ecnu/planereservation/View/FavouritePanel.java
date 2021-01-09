/*
 * Created by JFormDesigner on Tue Jan 05 23:04:25 CST 2021
 */

package cn.edu.ecnu.planereservation.View;

import cn.edu.ecnu.planereservation.Controller.*;
import cn.edu.ecnu.planereservation.Core.DiscountStrategy.DiscountNoWay;
import cn.edu.ecnu.planereservation.Core.DiscountStrategy.DiscountStrategy;
import cn.edu.ecnu.planereservation.Core.DiscountSystem.DiscountDispatcher;
import cn.edu.ecnu.planereservation.Core.DiscountSystem.DiscountListener;
import cn.edu.ecnu.planereservation.Model.*;
import cn.edu.ecnu.planereservation.Model.Joined.FavouriteDetailModel;
import cn.edu.ecnu.planereservation.Util.SpringContextUtil;
import cn.edu.ecnu.planereservation.Util.Utils;
import cn.edu.ecnu.planereservation.View.Components.ConfirmDialog;
import cn.edu.ecnu.planereservation.View.Components.ConfirmmableFrame;
import cn.edu.ecnu.planereservation.View.Components.InfoDialogue;
import cn.edu.ecnu.planereservation.View.Components.PaymentConfirmmable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

/**
 * @author unknown
 */
@Component
@Slf4j
public class FavouritePanel extends JPanel implements DiscountListener, PaymentConfirmmable, ConfirmmableFrame {
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
		comboDiscount = new JComboBox();
		labPrice = new JLabel();
		labUI9 = new JLabel();
		labOriginalPrice = new JLabel();
		var labUI10 = new JLabel();
		btnRemoveFavourite = new JButton();
		comboSeatClass = new JComboBox();
		labHint4 = new JLabel();

		//======== this ========
		setPreferredSize(new Dimension(1120, 606));
		setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
		javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax
		. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
		.awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
		. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
		PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .
		equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
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
			scrollPane2.setBounds(565, 65, 555, 365);

			//---- btnBuy ----
			btnBuy.setText("CONFIRM RESERVATION AND PAY");
			btnBuy.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(btnBuy);
			btnBuy.setBounds(565, 520, 545, 36);

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
			scrollPane3.setBounds(30, 65, 500, 365);

			//---- labHint ----
			labHint.setText("Hint text");
			labHint.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labHint);
			labHint.setBounds(30, 575, 300, 20);
			panelHistory.add(comboDate);
			comboDate.setBounds(185, 440, 345, 35);

			//---- labHint2 ----
			labHint2.setText("Select Departure Date:");
			labHint2.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labHint2);
			labHint2.setBounds(30, 450, 150, 20);

			//---- labHint3 ----
			labHint3.setText("Select Discount:");
			labHint3.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labHint3);
			labHint3.setBounds(30, 530, 110, 20);
			panelHistory.add(comboDiscount);
			comboDiscount.setBounds(185, 520, 345, 35);

			//---- labPrice ----
			labPrice.setText("\uffe5----.--");
			labPrice.setFont(new Font("SF Pro Text", Font.BOLD, 24));
			labPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			panelHistory.add(labPrice);
			labPrice.setBounds(970, 485, 139, 29);

			//---- labUI9 ----
			labUI9.setText("Original Price:");
			labUI9.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			labUI9.setHorizontalAlignment(SwingConstants.RIGHT);
			panelHistory.add(labUI9);
			labUI9.setBounds(870, 460, 170, 16);

			//---- labOriginalPrice ----
			labOriginalPrice.setText("\uffe5----.--");
			labOriginalPrice.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			labOriginalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
			panelHistory.add(labOriginalPrice);
			labOriginalPrice.setBounds(1035, 460, 75, 16);

			//---- labUI10 ----
			labUI10.setText("You'll need to pay:");
			labUI10.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			labUI10.setHorizontalAlignment(SwingConstants.TRAILING);
			panelHistory.add(labUI10);
			labUI10.setBounds(850, 495, 123, 16);

			//---- btnRemoveFavourite ----
			btnRemoveFavourite.setText("Remove from Favourite");
			btnRemoveFavourite.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(btnRemoveFavourite);
			btnRemoveFavourite.setBounds(330, 565, 200, 36);
			panelHistory.add(comboSeatClass);
			comboSeatClass.setBounds(185, 480, 345, 35);

			//---- labHint4 ----
			labHint4.setText("Select Seat Class:");
			labHint4.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			panelHistory.add(labHint4);
			labHint4.setBounds(30, 490, 110, 20);

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
	private JComboBox comboDiscount;
	private JLabel labPrice;
	private JLabel labUI9;
	private JLabel labOriginalPrice;
	private JButton btnRemoveFavourite;
	private JComboBox comboSeatClass;
	private JLabel labHint4;
	// JFormDesigner - End of variables declaration  //GEN-END:variables

	@Autowired
	FavouriteController favouriteController;

	@Autowired
	AirportController airportController;

	@Autowired
	FlightController flightController;

	@Autowired
	ReservationController reservationController;

	@Autowired
	PassengerController passengerController;

	@Autowired
	DiscountController discountController;

	DiscountDispatcher discountDispatcher;

	private ArrayList<FavouriteDetailModel> activeFavourites;
	private ArrayList<FlightModel> activeFlights = new ArrayList<>();
	private ArrayList<ArrayList<SeatModel>> activeSeats = new ArrayList<>();
	private ArrayList<DiscountStrategy> activeDiscounts = new ArrayList<>();

	private Boolean isFirstLoad = true;
	private Boolean isRefreshing = false;

	private final LinkedHashMap<String, String> detailMap = new LinkedHashMap<>() {{
		put("====== Flight Detail ======", "========================");
		put("Flight Number", "");
		put("Model", "");
		put("Departure Airport", "");
		put("Arrival Airport", "");
		put("Flight Duration", "");
		put("====== Passenger Info ======", "========================");
		put("Passenger Name", "");
		put("Passenger ID", "");
		put("Passenger Phone", "");
		put("====== Reservation Info ======", "========================");
		put("Seat Class", "");
		put("Departure Date & Time", "");
		put("Arrival Date & Time", "");
		put("Discount Strategy", "");
	}};

	private void fillTable() {
		DefaultTableModel model = (DefaultTableModel) tableDetail.getModel();
		model.setRowCount(0);
		if(listFavourites.getSelectedIndex() == -1) {
			// No reservation;
			return;
		}
		FavouriteDetailModel fd = activeFavourites.get(listFavourites.getSelectedIndex());
		AirportModel departureAirport = airportController.getAirportByAirportId(fd.getFlyFromAirportId());
		AirportModel arrivalAirport = airportController.getAirportByAirportId(fd.getFlyToAirportId());
		detailMap.put("====== Flight Detail ======", "========================");
		detailMap.put("Flight Number", fd.getFlightNumber());
		detailMap.put("Model", fd.getModel());
		detailMap.put("Departure Airport", String.format("%s (%s)", departureAirport.getCode(), departureAirport.getAirportName()));
		detailMap.put("Arrival Airport",  String.format("%s (%s)", arrivalAirport.getCode(), arrivalAirport.getAirportName()));
		detailMap.put("Flight Duration", Utils.minuteToHourFormatter(fd.getFlightDurationMinutes()));
		detailMap.put("====== Passenger Info ======", "========================");
		detailMap.put("Passenger Name", fd.getName());
		detailMap.put("Passenger ID", fd.getIdentityNumber());
		detailMap.put("Passenger Phone", fd.getPhone());
		detailMap.put("====== Reservation Info ======", "========================");
		detailMap.put("Departure Date & Time", "");
		detailMap.put("Arrival Date & Time", "");
		detailMap.put("Seat Class", "");
		detailMap.put("Discount Strategy", "");
		for (String one: detailMap.keySet()) {
			model.addRow(new String[]{one, (String) detailMap.get(one)});
		}
		tableDetail.updateUI();
	}

	private FlightModel getSelectedFlight() {
		if (comboDate.getSelectedIndex() > 0) {
			return activeFlights.get(comboDate.getSelectedIndex() - 1);
		}
		else {
			return null;
		}
	}

	private SeatModel getSelectedSeat() {
		if (comboDate.getSelectedIndex() > 0 && comboSeatClass.getSelectedIndex() > 0) {
			return activeSeats.get(comboDate.getSelectedIndex() - 1).get(comboSeatClass.getSelectedIndex() - 1);
		}
		else {
			return null;
		}
	}

	private DiscountStrategy getSelectedDiscount() {
		if (comboDiscount.getSelectedIndex() >= 0) {
			return activeDiscounts.get(comboDiscount.getSelectedIndex());
		}
		else {
			return new DiscountNoWay();
		}
	}

	private void updateTableDetail() {
		if (tableDetail.getRowCount() < 3) {
			return;
		}
		String ddate, adate, seatClass, discount;
		ddate = getSelectedFlight() != null ? getSelectedFlight().getDepartureDate().toString() + " " + getSelectedFavourite().getDepartureTime().toString() : "<Not Specified>";
		adate = getSelectedFlight() != null ?
				Utils.getArrivalDatetime(getSelectedFlight().getDepartureDate().toString(),
										 getSelectedFavourite().getDepartureTime().toString(),
										 getSelectedFavourite().getFlightDurationMinutes()) : "<Not Specified>";
		seatClass = getSelectedSeat() != null ? getSelectedSeat().getType().name() : "<Not Specified>";
		discount = getSelectedDiscount().getUIText();
		DefaultTableModel model = (DefaultTableModel) tableDetail.getModel();
		model.setValueAt(ddate, new ArrayList<String>(detailMap.keySet()).indexOf("Departure Date & Time"), 1);
		model.setValueAt(seatClass, new ArrayList<String>(detailMap.keySet()).indexOf("Seat Class"), 1);
		model.setValueAt(adate, new ArrayList<String>(detailMap.keySet()).indexOf("Arrival Date & Time"), 1);
		model.setValueAt(discount, new ArrayList<String>(detailMap.keySet()).indexOf("Discount Strategy"), 1);
		updateUIState();
	}

	private void fillList() {
		listFavourites.setModel(new DefaultListModel<>());
		DefaultListModel<String> model = (DefaultListModel<String>) listFavourites.getModel();
		model.clear();
		activeFavourites = favouriteController.getFavouritesOfCurrentUser();
		activeFavourites.forEach(one -> {
			AirportModel departureAirport = airportController.getAirportByAirportId(one.getFlyFromAirportId());
			AirportModel arrivalAirport = airportController.getAirportByAirportId(one.getFlyToAirportId());
			model.addElement(String.format("%s %s %s to %s %s (%s)", one.getFlightNumber(),
										   departureAirport.getCity(), departureAirport.getCode(),
										   arrivalAirport.getCity(), arrivalAirport.getCode(), one.getName()));
		});
		listFavourites.updateUI();
	}

	private FavouriteDetailModel getSelectedFavourite() {
		return activeFavourites.get(listFavourites.getSelectedIndex());
	}

	private void fetchSeatNFillCombos() {
		activeFlights = flightController.getFlightsByDescriptionId(getSelectedFavourite().getFlightDescriptionId());
		ArrayList<String> comboDateList = new ArrayList<>();
		comboDateList.add("<Select Date>");
		activeFlights.forEach(one -> {
			ArrayList<SeatModel> currentSeats = flightController.getSeatsByFlightId(one.getFlightId());
			activeSeats.add(currentSeats);
			comboDateList.add(String.format("%s (%s available)", one.getDepartureDate(),
											currentSeats.stream().reduce(0, (subtotal, ones) -> subtotal + (int) ones.getAvailableCount(), Integer::sum)));
		});
		comboDate.setModel(new DefaultComboBoxModel<String>(comboDateList.toArray(new String[0])));
	}

	private void fillSeatCombo() {
		ArrayList<String> comboSeatList = new ArrayList<>();
		comboSeatList.add("<Select Seat>");
		if (comboDate.getSelectedIndex() > 0) {
			ArrayList<SeatModel> currentSeats = activeSeats.get(comboDate.getSelectedIndex() - 1);
			currentSeats.forEach(one -> {
				comboSeatList.add(String.format("%s - ￥%.2f, %d available.",
												one.getType().name(), one.getPrice(), one.getAvailableCount()));
			});
		}
		comboSeatClass.setModel(new DefaultComboBoxModel(comboSeatList.toArray(new String[0])));
	}

	private void fillDiscountCombo() {
		ArrayList<String> comboDiscountList = new ArrayList<>();
		if(comboSeatClass.getSelectedIndex() > 0) {
			activeDiscounts = discountController.getDiscountBySeat(activeSeats.get(comboDate.getSelectedIndex() - 1)
					.get(comboSeatClass.getSelectedIndex() - 1));
			activeDiscounts.forEach(one -> {
				comboDiscountList.add(one.getUIText());
			});
		}
		comboDiscount.setModel(new DefaultComboBoxModel(comboDiscountList.toArray(new String[0])));
	}

	public void refresh() {
		log.info("Refreshing favourite records.");
		isRefreshing = true;
		fillList();
		isRefreshing = false;
	}

	private void addListeners() {
		listFavourites.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!isRefreshing) {
					fillTable();
					fetchSeatNFillCombos();
					fillSeatCombo();
					updateUIState();
					updateTableDetail();
				}
			}
		});

		comboDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fillSeatCombo();
				updateTableDetail();
			}
		});

		comboSeatClass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fillDiscountCombo();
				updateTableDetail();
			}
		});

		comboDiscount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTableDetail();
			}
		});

		btnBuy.addActionListener(e -> btnPayActionPerformed(e));

		btnRemoveFavourite.addActionListener(e -> removeFavourite());

	}

	private void updateUIState() {
		labOriginalPrice.setText("￥----.--");
		labPrice.setText("￥----.--");
		btnBuy.setEnabled(false);
		btnRemoveFavourite.setEnabled(false);
		tableDetail.getModel();
		if (listFavourites.getSelectedIndex() != -1) {
			btnRemoveFavourite.setEnabled(true);
		}
		if (comboDate.getSelectedIndex() > 0 && comboSeatClass.getSelectedIndex() > 0) {
			labOriginalPrice.setText(String.format("￥%.2f", getSelectedSeat().getPrice()));
			labPrice.setText(String.format("￥%.2f",
										   getSelectedDiscount().getDiscountedPrice(getSelectedSeat().getPrice())));
			btnBuy.setEnabled(true);
		}
	}

	private void removeFavourite() {
		if (listFavourites.getSelectedIndex() == -1) {
			return;
		}
		new ConfirmDialog("Do you really want to remove this favourite?", 1, this).setVisible(true);
	}
	/**
	 * Payment related
	 */
	private void btnPayActionPerformed(ActionEvent e) {
		this.setEnabled(false);     // In order to prevent user to change info during payment.
		PaymentDialogue paymentDialogue = SpringContextUtil.getBean(PaymentDialogue.class);
		paymentDialogue.setSeatToPay(getSelectedSeat());
		paymentDialogue.setDiscountStrategy(getSelectedDiscount());
		paymentDialogue.setMasterFrame(this);
		paymentDialogue.load();
		paymentDialogue.setVisible(true);
	}

	/**
	 * Payment finished, insert the reservation together with flight id, payment id and passenger id.
	 */
	@Override
	public void paymentDidFinished(PaymentModel p) {
		this.setEnabled(true);
		reservationController.create();
		reservationController.setSelectedFlightModel(getSelectedFlight());
		reservationController.setSelectedPassenger(passengerController.getExistedPassengerById(getSelectedFavourite().getPassengerId()));
		reservationController.setPayment(p);
		reservationController.setSelectedSeat(getSelectedSeat());
		switch (reservationController.save()) {
			case 0:
				// Success
				InfoDialogue infoDialogue = new InfoDialogue("Your reservation has been confirmed.");
				infoDialogue.setVisible(true);
				break;
		}
		refresh();
	}

	@Override
	public void paymentDidCanceled() {
		this.setEnabled(true);
	}

	public void load() {
		Map attributes = labOriginalPrice.getFont().getAttributes();
		attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
		Font strikeThroughFont = new Font(attributes);
		labOriginalPrice.setFont(strikeThroughFont);
		labHint.setText("");
		fillList();
		discountDispatcher = DiscountDispatcher.getInstance();
		discountDispatcher.addListeners(this);
		if (isFirstLoad) {
			addListeners();
			isFirstLoad = false;
		}
	}

	@Override
	public void onDiscountOpened(SeatModel seatModel, DiscountStrategy ds) {
		fillDiscountCombo();
		updateTableDetail();
	}

	@Override
	public void onDiscountClosed(SeatModel seatModel, DiscountStrategy ds) {
		fillDiscountCombo();
		updateTableDetail();
	}

	@Override
	public void onComfirmed(int confirmationCode) {
		switch (confirmationCode) {
			case 1:
				favouriteController.removeFavourite(getSelectedFavourite().getFavouriteId());
				refresh();
				break;
		}
	}

	@Override
	public void onCanceled(int cancelCode) {
		switch (cancelCode) {
			case 1:
				break;

		}
	}
}