/*
 * Created by JFormDesigner on Tue Dec 22 18:40:57 CST 2020
 */

package cn.edu.ecnu.planereservation.View;

import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import cn.edu.ecnu.planereservation.Controller.AirportController;
import cn.edu.ecnu.planereservation.Controller.FlightController;
import cn.edu.ecnu.planereservation.Controller.FlightSystemFacade;
import cn.edu.ecnu.planereservation.Model.AirportModel;
import cn.edu.ecnu.planereservation.Model.Joined.FlightTableItem;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import cn.edu.ecnu.planereservation.Util.Shared;
import cn.edu.ecnu.planereservation.Util.SpringContextUtil;
import cn.edu.ecnu.planereservation.Util.Utils;
import cn.edu.ecnu.planereservation.View.Components.NotificationPanel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;

/**
 * @author unknown
 */
@Component
@Slf4j
public class MainPanel extends JPanel {

    public MainPanel() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - unknown
		this.labUsername = new JLabel();
		this.tabMain = new JTabbedPane();
		this.panelReservation = new JPanel();
		this.scrollPane1 = new JScrollPane();
		this.tableFlights = new JTable();
		var labelUI = new JLabel();
		var labelUI2 = new JLabel();
		this.comboDepartureAirport = new JComboBox<>();
		this.comboArrivalAirport = new JComboBox<>();
		var labelUI3 = new JLabel();
		this.labHint = new JLabel();
		this.btnReserve = new JButton();
		this.txtFlightNumber = new JTextField();
		var labelUI5 = new JLabel();
		var labelUI6 = new JLabel();
		this.btnSearch = new JButton();
		var labelUI8 = new JLabel();
		this.txtBeginDate = new JFormattedTextField();
		this.txtEndDate = new JFormattedTextField();
		this.btnAbout = new JButton();
		this.btnGithub = new JButton();
		this.btnLogOut = new JButton();
		this.btnRefresh = new JButton();

		//======== this ========
		setPreferredSize(new Dimension(1200, 800));
		setMinimumSize(new Dimension(1200, 800));
		setFont(new Font("SF Pro Display", Font.PLAIN, 14));
		setName("this");
		setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
		.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder
		.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.
		awt.Font.BOLD,12),java.awt.Color.red), getBorder()))
		; addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
		){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}})
		;
		setLayout(null);

		//---- labUsername ----
		this.labUsername.setText("HI! You have logged in as: #{username}");
		this.labUsername.setFont(new Font("SF Pro Display", Font.BOLD, 14));
		this.labUsername.setName("labUsername");
		add(this.labUsername);
		this.labUsername.setBounds(new Rectangle(new Point(35, 25), this.labUsername.getPreferredSize()));

		//======== tabMain ========
		{
			this.tabMain.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
			this.tabMain.setDoubleBuffered(true);
			this.tabMain.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));
			this.tabMain.setName("tabMain");

			//======== panelReservation ========
			{
				this.panelReservation.setFont(new Font("SF Pro Display", Font.PLAIN, 12));
				this.panelReservation.setBorder(null);
				this.panelReservation.setName("panelReservation");
				this.panelReservation.setLayout(null);

				//======== scrollPane1 ========
				{
					this.scrollPane1.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
					this.scrollPane1.setName("scrollPane1");

					//---- tableFlights ----
					this.tableFlights.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"Flight Number", "Model", "Departure Airport", "Arrival Airport", "Departure Date", "Departure Time", "Duration", "C", "F", "Y"
						}
					) {
						boolean[] columnEditable = new boolean[] {
							false, false, false, false, false, false, false, false, false, false
						};
						@Override
						public boolean isCellEditable(int rowIndex, int columnIndex) {
							return this.columnEditable[columnIndex];
						}
					});
					{
						TableColumnModel cm = this.tableFlights.getColumnModel();
						cm.getColumn(0).setPreferredWidth(85);
						cm.getColumn(1).setPreferredWidth(50);
						cm.getColumn(2).setPreferredWidth(90);
						cm.getColumn(3).setPreferredWidth(90);
						cm.getColumn(4).setPreferredWidth(100);
						cm.getColumn(5).setPreferredWidth(90);
						cm.getColumn(6).setPreferredWidth(60);
						cm.getColumn(7).setPreferredWidth(50);
						cm.getColumn(8).setPreferredWidth(50);
						cm.getColumn(9).setPreferredWidth(50);
					}
					this.tableFlights.setFont(new Font("SF Pro Display", Font.PLAIN, 12));
					this.tableFlights.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					this.tableFlights.setRowHeight(24);
					this.tableFlights.setName("tableFlights");
					this.scrollPane1.setViewportView(this.tableFlights);
				}
				this.panelReservation.add(this.scrollPane1);
				this.scrollPane1.setBounds(20, 105, 1105, 455);

				//---- labelUI ----
				labelUI.setText("Departure Airport:");
				labelUI.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				labelUI.setName("labelUI");
				this.panelReservation.add(labelUI);
				labelUI.setBounds(20, 70, 120, 18);

				//---- labelUI2 ----
				labelUI2.setText("Arrival Airport:");
				labelUI2.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				labelUI2.setName("labelUI2");
				this.panelReservation.add(labelUI2);
				labelUI2.setBounds(415, 70, 120, 18);

				//---- comboDepartureAirport ----
				this.comboDepartureAirport.setModel(new DefaultComboBoxModel<>(new String[] {
					"HK",
					"R"
				}));
				this.comboDepartureAirport.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				this.comboDepartureAirport.setPreferredSize(new Dimension(70, 30));
				this.comboDepartureAirport.setName("comboDepartureAirport");
				this.panelReservation.add(this.comboDepartureAirport);
				this.comboDepartureAirport.setBounds(140, 65, 260, 30);

				//---- comboArrivalAirport ----
				this.comboArrivalAirport.setModel(new DefaultComboBoxModel<>(new String[] {
					"HK",
					"R"
				}));
				this.comboArrivalAirport.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				this.comboArrivalAirport.setPreferredSize(new Dimension(70, 30));
				this.comboArrivalAirport.setName("comboArrivalAirport");
				this.panelReservation.add(this.comboArrivalAirport);
				this.comboArrivalAirport.setBounds(510, 65, 260, 30);

				//---- labelUI3 ----
				labelUI3.setText("Flight Number:");
				labelUI3.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				labelUI3.setName("labelUI3");
				this.panelReservation.add(labelUI3);
				labelUI3.setBounds(20, 31, 120, 18);

				//---- labHint ----
				this.labHint.setText("Select a flight to make your reservation.");
				this.labHint.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				this.labHint.setHorizontalAlignment(SwingConstants.TRAILING);
				this.labHint.setName("labHint");
				this.panelReservation.add(this.labHint);
				this.labHint.setBounds(545, 580, 320, 18);

				//---- btnReserve ----
				this.btnReserve.setText("Make Reservation");
				this.btnReserve.setEnabled(false);
				this.btnReserve.setName("btnReserve");
				this.panelReservation.add(this.btnReserve);
				this.btnReserve.setBounds(880, 572, 245, 35);

				//---- txtFlightNumber ----
				this.txtFlightNumber.setPreferredSize(new Dimension(70, 30));
				this.txtFlightNumber.setName("txtFlightNumber");
				this.panelReservation.add(this.txtFlightNumber);
				this.txtFlightNumber.setBounds(140, 25, 260, 30);

				//---- labelUI5 ----
				labelUI5.setText("Date Range:");
				labelUI5.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				labelUI5.setName("labelUI5");
				this.panelReservation.add(labelUI5);
				labelUI5.setBounds(415, 31, 120, 18);

				//---- labelUI6 ----
				labelUI6.setText("To");
				labelUI6.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				labelUI6.setName("labelUI6");
				this.panelReservation.add(labelUI6);
				labelUI6.setBounds(805, 31, 25, 18);

				//---- btnSearch ----
				this.btnSearch.setText("Search Now");
				this.btnSearch.setPreferredSize(new Dimension(70, 30));
				this.btnSearch.setName("btnSearch");
				this.panelReservation.add(this.btnSearch);
				this.btnSearch.setBounds(855, 65, 260, 30);

				//---- labelUI8 ----
				labelUI8.setText("C, F, Y indicating different classes of seat and the number beneath is the available seats.");
				labelUI8.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				labelUI8.setName("labelUI8");
				this.panelReservation.add(labelUI8);
				labelUI8.setBounds(25, 580, 530, 18);

				//---- txtBeginDate ----
				this.txtBeginDate.setName("txtBeginDate");
				this.panelReservation.add(this.txtBeginDate);
				this.txtBeginDate.setBounds(510, 25, 260, 30);

				//---- txtEndDate ----
				this.txtEndDate.setName("txtEndDate");
				this.panelReservation.add(this.txtEndDate);
				this.txtEndDate.setBounds(855, 25, 260, 30);

				{
					// compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < this.panelReservation.getComponentCount(); i++) {
						Rectangle bounds = this.panelReservation.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = this.panelReservation.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					this.panelReservation.setMinimumSize(preferredSize);
					this.panelReservation.setPreferredSize(preferredSize);
				}
			}
			this.tabMain.addTab("Make Reservations", this.panelReservation);
		}
		add(this.tabMain);
		this.tabMain.setBounds(25, 55, 1135, 665);

		//---- btnAbout ----
		this.btnAbout.setText("About");
		this.btnAbout.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
		this.btnAbout.setName("btnAbout");
		add(this.btnAbout);
		this.btnAbout.setBounds(1060, 730, 98, 30);

		//---- btnGithub ----
		this.btnGithub.setText("GitHub");
		this.btnGithub.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
		this.btnGithub.setName("btnGithub");
		add(this.btnGithub);
		this.btnGithub.setBounds(950, 730, 98, 30);

		//---- btnLogOut ----
		this.btnLogOut.setText("Switch User");
		this.btnLogOut.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
		this.btnLogOut.setAlignmentX(0.5F);
		this.btnLogOut.setName("btnLogOut");
		add(this.btnLogOut);
		this.btnLogOut.setBounds(935, 15, 217, 30);

		//---- btnRefresh ----
		this.btnRefresh.setIcon(new ImageIcon(getClass().getResource("/image/refresh-16.png")));
		this.btnRefresh.setName("btnRefresh");
		add(this.btnRefresh);
		this.btnRefresh.setBounds(895, 15, 30, 30);

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
	private JLabel labUsername;
	private JTabbedPane tabMain;
	private JPanel panelReservation;
	private JScrollPane scrollPane1;
	private JTable tableFlights;
	private JComboBox<String> comboDepartureAirport;
	private JComboBox<String> comboArrivalAirport;
	private JLabel labHint;
	private JButton btnReserve;
	private JTextField txtFlightNumber;
	private JButton btnSearch;
	private JFormattedTextField txtBeginDate;
	private JFormattedTextField txtEndDate;
	private JButton btnAbout;
	private JButton btnGithub;
	private JButton btnLogOut;
	private JButton btnRefresh;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    ///////////////////////

    @Autowired
    FlightSystemFacade systemFacade;

    @Autowired
    AirportController airportController;

    @Autowired
    FlightController flightController;

    @Autowired
    ReservationHistoryPanel historyPanel;

    @Autowired
	FavouritePanel favouritePanel;

    @Autowired
	NotificationPanel notificationPanel;

    private ReservationDialog reservationDialog;
    @Setter
    private PlaneReservationGUI masterFrame;

    private ArrayList<AirportModel> airports;
    private ArrayList<FlightTableItem> activeFlights;

    private Boolean isFirstLoad = true;

    private void fillTableWithFlightIds() {
        DefaultTableModel tableModel = (DefaultTableModel) tableFlights.getModel();
        tableModel.setRowCount(0);
        tableFlights.clearSelection();
        activeFlights.forEach(oneFlight -> {
            ArrayList<SeatModel> seats = flightController.getSeatsByFlightId(oneFlight.getFlightId());
            oneFlight.setSeats(seats);
            for (SeatModel.SeatType oneEnum : SeatModel.SeatType.values()) {
                if (seats.stream().filter(one -> one.getType() == oneEnum).findFirst().isEmpty()) {
                    seats.add(new SeatModel(0, oneEnum));
                }
            }
//            long availableSeatC = seats.stream().filter(one -> one.getType() == SeatModel.SeatType.C).findFirst()
//                    .orElse(new SeatModel(0, SeatModel.SeatType.C)).getAvailableCount();
//            long availableSeatF = seats.stream().filter(one -> one.getType() == SeatModel.SeatType.F).findFirst()
//                    .orElse(new SeatModel(0, SeatModel.SeatType.F)).getAvailableCount();
//            long availableSeatY = seats.stream().filter(one -> one.getType() == SeatModel.SeatType.Y).findFirst()
//                    .orElse(new SeatModel(0, SeatModel.SeatType.Y)).getAvailableCount();
            seats.sort(new Comparator<SeatModel>() {
                @Override
                public int compare(SeatModel seatModel, SeatModel t1) {
                    return seatModel.getType().name().compareTo(t1.getType().name());
                }
            });
            AirportModel departureAirport = airportController.getAirportByAirportId((Long)oneFlight.getFlyFromAirportId());
            AirportModel arrivalAirport = airportController.getAirportByAirportId((Long) oneFlight.getFlyToAirportId());
            Object[] newFlightRow = new Object[]{
                    oneFlight.getFlightNumber(),
                    oneFlight.getModel(),
                    String.format("%s (%s)", departureAirport.getCode(), departureAirport.getCity()),
                    String.format("%s (%s)", arrivalAirport.getCode(), arrivalAirport.getCity()),
                    oneFlight.getDepartureDate(),
                    oneFlight.getDepartureTime(),
                    Utils.minuteToHourFormatter((Integer) oneFlight.getFlightDurationMinutes()),
                    oneFlight.getSeats().get(0).getAvailableCount(),
                    oneFlight.getSeats().get(1).getAvailableCount(),
                    oneFlight.getSeats().get(2).getAvailableCount()
            };
            log.info("Loaded flight: " + oneFlight.toString());
            tableModel.addRow(newFlightRow);
        });
        tableFlights.repaint();
    }

    private void updateBtnReservationAndHintStatus() {
        btnReserve.setEnabled(false);
        if (tableFlights.getSelectedRowCount() > 0) {
            log.info("Selection Updated: " + activeFlights.get(tableFlights.getSelectedRow()).getFlightId());
            if(activeFlights.get(tableFlights.getSelectedRow()).getSeats().stream()
                    .mapToInt(one -> (int) one.getAvailableCount()).sum() == 0) {
                // No available seats
                labHint.setText("No available seats on selected flight.");
            }
            else {
                labHint.setText("");
                btnReserve.setEnabled(true);
            }
        }
        else {
            labHint.setText("Select a flight to make your reservation.");
        }
    }
    public void btnSearchActionPerformed(ActionEvent e) {
        var flights = systemFacade.getAvailableFlightByAiports(
                airportController.getAirportByCode(comboDepartureAirport.getSelectedItem().toString().substring(0, 3)),
                airportController.getAirportByCode(comboArrivalAirport.getSelectedItem().toString().substring(0, 3)));
        activeFlights = flights;
        activeFlights.sort(new Comparator<FlightTableItem>() {
            @Override
            public int compare(FlightTableItem t0, FlightTableItem t1) {
                return - t0.getDepartureDate().compareTo(t1.getDepartureDate());
            }
        });
        fillTableWithFlightIds();
        updateBtnReservationAndHintStatus();
    }

    public void btnReserveActionPerformed(ActionEvent e) {
        SpringContextUtil.destroyBean(ReservationDialog.class);
        reservationDialog = SpringContextUtil.getBean(ReservationDialog.class);
        reservationDialog.setFlightDetail(activeFlights.get(tableFlights.getSelectedRow()));
        reservationDialog.setMainPanel(this);
        reservationDialog.load();
        reservationDialog.setVisible(true);
    }

    public void refresh() {
        btnSearchActionPerformed(null);
        log.info("Main panel refreshed.");
    }


    public void addListeners() {
        btnSearch.addActionListener(e -> btnSearchActionPerformed(e));

        /// Misc
        btnGithub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Desktop.getDesktop().browse(new URL("https://github.com/BillChen2K/PlaneReservation").toURI());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AboutDialog aboutDialog = new AboutDialog((Window) getRootPane().getParent());
                aboutDialog.setVisible(true);
            }
        });

        btnReserve.addActionListener(e -> btnReserveActionPerformed(e));

        tableFlights.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                updateBtnReservationAndHintStatus();
            }
        });

        btnRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                btnSearchActionPerformed(null);
                historyPanel.refresh();
            }
        });

        btnLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                masterFrame.performLoggOut();
            }
        });

        tabMain.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if (tabMain.getSelectedIndex() == 1) {
                    historyPanel.refresh();
                }

                if (tabMain.getSelectedIndex() == 2) {
                	favouritePanel.refresh();
				}
            }
        });
    }

    public void load() {
        labUsername.setText("HI! You have logged in as: " + Shared.currentUser.getUsername() + ".");

        // Initialize airports
        airports = airportController.searchAllAirports();
        ArrayList<String> airportStrings = new ArrayList<>();
        airports.forEach(one -> {
            airportStrings.add(String.format("%s (%s)", one.getCode(), one.getAirportName()));
        });
        comboDepartureAirport.setModel(new DefaultComboBoxModel<String>(airportStrings.toArray(new String[0])));
        comboArrivalAirport.setModel(new DefaultComboBoxModel<>(airportStrings.toArray(new String[0])));
        comboArrivalAirport.setSelectedIndex(1);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        txtBeginDate.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(df)));
        txtEndDate.setFormatterFactory(new DefaultFormatterFactory(new DateFormatter(df)));

        historyPanel.load();
        tabMain.addTab("Reservation History", historyPanel);

		favouritePanel.load();
		tabMain.addTab("Buy Tickets in One Click", favouritePanel);

		notificationPanel.setBounds(30, 735,875 ,25);
		this.add(notificationPanel);
		notificationPanel.load();
		notificationPanel.setVisible(true);

        if(isFirstLoad) {
            addListeners();
        }

    }
}
