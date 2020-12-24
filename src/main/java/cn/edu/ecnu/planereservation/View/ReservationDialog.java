/*
 * Created by JFormDesigner on Wed Dec 23 03:24:47 CST 2020
 */

package cn.edu.ecnu.planereservation.View;

import javax.swing.event.*;
import javax.swing.table.*;

import cn.edu.ecnu.planereservation.Controller.AirportController;
import cn.edu.ecnu.planereservation.Controller.FlightSystemFacade;
import cn.edu.ecnu.planereservation.Controller.PassengerController;
import cn.edu.ecnu.planereservation.Controller.ReservationController;
import cn.edu.ecnu.planereservation.Model.Joined.FlightTableItem;
import cn.edu.ecnu.planereservation.Model.PassengerModel;
import cn.edu.ecnu.planereservation.Model.PaymentModel;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import cn.edu.ecnu.planereservation.Util.SpringContextUtil;
import cn.edu.ecnu.planereservation.Util.Utils;
import cn.edu.ecnu.planereservation.View.Components.InfoDialogue;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
@Component
@Slf4j
public class ReservationDialog extends JDialog {
    public ReservationDialog() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel4 = new JPanel();
        var labUI = new JLabel();
        scrollPane1 = new JScrollPane();
        tableSummary = new JTable();
        var labUI10 = new JLabel();
        labPrice = new JLabel();
        panel6 = new JPanel();
        panel3 = new JPanel();
        var labUI2 = new JLabel();
        tabPassenger = new JTabbedPane();
        panel1 = new JPanel();
        txtPassengerName = new JTextField();
        var labUI3 = new JLabel();
        var labUI4 = new JLabel();
        txtPassengerID = new JTextField();
        txtPassengerPhone = new JTextField();
        var labUI5 = new JLabel();
        labHintPassenger = new JLabel();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        tablePassenger = new JTable();
        panel5 = new JPanel();
        var labUI7 = new JLabel();
        comboSeatSelect = new JComboBox();
        labHintSeat = new JLabel();
        buttonBar = new JPanel();
        btnPay = new JButton();
        btnCancel = new JButton();

        //======== this ========
        setTitle("Reservation");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
            0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
            . BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
            red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
            beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                contentPanel.setLayout(new BorderLayout());

                //======== panel4 ========
                {
                    panel4.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                    panel4.setLayout(null);

                    //---- labUI ----
                    labUI.setText("Reservation Infomation:");
                    labUI.setFont(new Font("SF Pro Display", Font.BOLD, 14));
                    panel4.add(labUI);
                    labUI.setBounds(new Rectangle(new Point(5, 5), labUI.getPreferredSize()));

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setFont(new Font("SF Pro Display", Font.PLAIN, 14));

                        //---- tableSummary ----
                        tableSummary.setModel(new DefaultTableModel(
                            new Object[][] {
                            },
                            new String[] {
                                "Key", "Value"
                            }
                        ) {
                            boolean[] columnEditable = new boolean[] {
                                false, true
                            };
                            @Override
                            public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return columnEditable[columnIndex];
                            }
                        });
                        {
                            TableColumnModel cm = tableSummary.getColumnModel();
                            cm.getColumn(0).setPreferredWidth(80);
                            cm.getColumn(1).setPreferredWidth(100);
                        }
                        tableSummary.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                        tableSummary.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                        scrollPane1.setViewportView(tableSummary);
                    }
                    panel4.add(scrollPane1);
                    scrollPane1.setBounds(5, 35, 370, 280);

                    //---- labUI10 ----
                    labUI10.setText("You'll need to pay:");
                    labUI10.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                    labUI10.setHorizontalAlignment(SwingConstants.TRAILING);
                    panel4.add(labUI10);
                    labUI10.setBounds(245, 335, 123, 16);

                    //---- labPrice ----
                    labPrice.setText("\uffe51023.23");
                    labPrice.setFont(new Font("SF Pro Text", Font.BOLD, 26));
                    labPrice.setHorizontalAlignment(SwingConstants.TRAILING);
                    panel4.add(labPrice);
                    labPrice.setBounds(215, 360, 155, 41);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel4.getComponentCount(); i++) {
                            Rectangle bounds = panel4.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel4.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel4.setMinimumSize(preferredSize);
                        panel4.setPreferredSize(preferredSize);
                    }
                }
                contentPanel.add(panel4, BorderLayout.EAST);

                //======== panel6 ========
                {
                    panel6.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                    panel6.setLayout(new BorderLayout());

                    //======== panel3 ========
                    {
                        panel3.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                        panel3.setLayout(null);

                        //---- labUI2 ----
                        labUI2.setText("Passenger Infomation:");
                        labUI2.setFont(new Font("SF Pro Display", Font.BOLD, 14));
                        panel3.add(labUI2);
                        labUI2.setBounds(15, 5, 150, 16);

                        //======== tabPassenger ========
                        {
                            tabPassenger.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                            tabPassenger.setBorder(new MatteBorder(1, 1, 1, 1, Color.lightGray));

                            //======== panel1 ========
                            {
                                panel1.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.setLayout(null);

                                //---- txtPassengerName ----
                                txtPassengerName.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(txtPassengerName);
                                txtPassengerName.setBounds(95, 10, 255, 30);

                                //---- labUI3 ----
                                labUI3.setText("Name:");
                                labUI3.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(labUI3);
                                labUI3.setBounds(15, 20, 90, 16);

                                //---- labUI4 ----
                                labUI4.setText("ID Number:");
                                labUI4.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(labUI4);
                                labUI4.setBounds(15, 52, 90, 16);

                                //---- txtPassengerID ----
                                txtPassengerID.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(txtPassengerID);
                                txtPassengerID.setBounds(95, 45, 255, 30);

                                //---- txtPassengerPhone ----
                                txtPassengerPhone.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(txtPassengerPhone);
                                txtPassengerPhone.setBounds(95, 80, 255, 30);

                                //---- labUI5 ----
                                labUI5.setText("Phone:");
                                labUI5.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(labUI5);
                                labUI5.setBounds(15, 89, 90, 16);

                                //---- labHintPassenger ----
                                labHintPassenger.setText("*All fields are required.");
                                labHintPassenger.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                labHintPassenger.setForeground(new Color(204, 0, 51));
                                labHintPassenger.setVerticalAlignment(SwingConstants.TOP);
                                panel1.add(labHintPassenger);
                                labHintPassenger.setBounds(15, 130, 330, 100);

                                {
                                    // compute preferred size
                                    Dimension preferredSize = new Dimension();
                                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                                        Rectangle bounds = panel1.getComponent(i).getBounds();
                                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                    }
                                    Insets insets = panel1.getInsets();
                                    preferredSize.width += insets.right;
                                    preferredSize.height += insets.bottom;
                                    panel1.setMinimumSize(preferredSize);
                                    panel1.setPreferredSize(preferredSize);
                                }
                            }
                            tabPassenger.addTab("New Passenger", panel1);

                            //======== panel2 ========
                            {
                                panel2.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel2.setLayout(null);

                                //======== scrollPane2 ========
                                {
                                    scrollPane2.setFont(new Font("SF Pro Display", Font.PLAIN, 14));

                                    //---- tablePassenger ----
                                    tablePassenger.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                    tablePassenger.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                                    tablePassenger.setModel(new DefaultTableModel(
                                        new Object[][] {
                                            {"\u9648\u67d0\u67d0", "510402000000008888", "18888888888"},
                                            {null, null, null},
                                        },
                                        new String[] {
                                            "Name", "Identity ID", "Phone"
                                        }
                                    ) {
                                        boolean[] columnEditable = new boolean[] {
                                            false, true, true
                                        };
                                        @Override
                                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                            return columnEditable[columnIndex];
                                        }
                                    });
                                    {
                                        TableColumnModel cm = tablePassenger.getColumnModel();
                                        cm.getColumn(0).setPreferredWidth(50);
                                        cm.getColumn(1).setPreferredWidth(150);
                                        cm.getColumn(2).setPreferredWidth(100);
                                    }
                                    scrollPane2.setViewportView(tablePassenger);
                                }
                                panel2.add(scrollPane2);
                                scrollPane2.setBounds(0, 0, 375, 245);

                                {
                                    // compute preferred size
                                    Dimension preferredSize = new Dimension();
                                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                                        Rectangle bounds = panel2.getComponent(i).getBounds();
                                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                                    }
                                    Insets insets = panel2.getInsets();
                                    preferredSize.width += insets.right;
                                    preferredSize.height += insets.bottom;
                                    panel2.setMinimumSize(preferredSize);
                                    panel2.setPreferredSize(preferredSize);
                                }
                            }
                            tabPassenger.addTab("Previous Passenger", panel2);
                        }
                        panel3.add(tabPassenger);
                        tabPassenger.setBounds(10, 35, 375, 280);

                        {
                            // compute preferred size
                            Dimension preferredSize = new Dimension();
                            for(int i = 0; i < panel3.getComponentCount(); i++) {
                                Rectangle bounds = panel3.getComponent(i).getBounds();
                                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                            }
                            Insets insets = panel3.getInsets();
                            preferredSize.width += insets.right;
                            preferredSize.height += insets.bottom;
                            panel3.setMinimumSize(preferredSize);
                            panel3.setPreferredSize(preferredSize);
                        }
                    }
                    panel6.add(panel3, BorderLayout.CENTER);

                    //======== panel5 ========
                    {
                        panel5.setPreferredSize(new Dimension(0, 80));
                        panel5.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                        panel5.setLayout(null);

                        //---- labUI7 ----
                        labUI7.setText("Select Seat Class:");
                        labUI7.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                        panel5.add(labUI7);
                        labUI7.setBounds(new Rectangle(new Point(15, 15), labUI7.getPreferredSize()));

                        //---- comboSeatSelect ----
                        comboSeatSelect.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                        comboSeatSelect.setPreferredSize(new Dimension(85, 36));
                        panel5.add(comboSeatSelect);
                        comboSeatSelect.setBounds(140, 5, 245, comboSeatSelect.getPreferredSize().height);

                        //---- labHintSeat ----
                        labHintSeat.setText("Current seat is unavailable. Please select another one.");
                        labHintSeat.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                        panel5.add(labHintSeat);
                        labHintSeat.setBounds(15, 50, 360, 18);
                    }
                    panel6.add(panel5, BorderLayout.SOUTH);
                }
                contentPanel.add(panel6, BorderLayout.WEST);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- btnPay ----
                btnPay.setText("Confirm Payment");
                btnPay.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                buttonBar.add(btnPay, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- btnCancel ----
                btnCancel.setText("Cancel");
                btnCancel.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                buttonBar.add(btnCancel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.PAGE_END);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(800, 500);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel4;
    private JScrollPane scrollPane1;
    private JTable tableSummary;
    private JLabel labPrice;
    private JPanel panel6;
    private JPanel panel3;
    private JTabbedPane tabPassenger;
    private JPanel panel1;
    private JTextField txtPassengerName;
    private JTextField txtPassengerID;
    private JTextField txtPassengerPhone;
    private JLabel labHintPassenger;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JTable tablePassenger;
    private JPanel panel5;
    private JComboBox comboSeatSelect;
    private JLabel labHintSeat;
    private JPanel buttonBar;
    private JButton btnPay;
    private JButton btnCancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Boolean firstLoad = true;

    @Autowired
    PassengerController passengerController;

    @Autowired
    ReservationController reservationController;

    @Autowired
    AirportController airportController;

    @Autowired
    FlightSystemFacade flightSystemFacade;

    @Setter
    @Getter
    private FlightTableItem flightDetail;

    private ArrayList<PassengerModel> previousPassengers = new ArrayList<>();

    private Boolean eligible;

    @Setter
    private MainPanel mainPanel;

    private LinkedHashMap<String, String> summaryMap = new LinkedHashMap<>() {{
        put("Flight Number", "");
        put("Model", "");
        put("Departure Airport", "");
        put("Arrival Airport", "");
        put("Departure Date & Time", "");
        put("Flight Duration", "");
        put("Arrival Date & Time", "");
        put("Seat Class", "");
        put("Passenger Name", "");
        put("Passenger ID", "");
        put("Passenger Phone", "");
    }};

    /**
     * For new passenger: This operation will insert to database;
     * For old passenger: This operation will return the selectedPassengerModel.
      * @return
     */
    private PassengerModel getOrSaveSelectedPassenger() {
        if (tabPassenger.getSelectedIndex() == 0) {
            passengerController.setNewPassenger(txtPassengerName.getText(), txtPassengerID.getText(), txtPassengerPhone.getText());
            return passengerController.saveAndGetPassenger();
        }
        else {
            return previousPassengers.get(tablePassenger.getSelectedRow());
        }
    }

    private SeatModel getSelectedSeat() {
        return flightDetail.getSeats().get(comboSeatSelect.getSelectedIndex());
    }

    private void updateSummaryTable() {
        DefaultTableModel model = (DefaultTableModel) tableSummary.getModel();
        model.setValueAt(getSelectedSeat().getType().name(),
                new ArrayList<String>(summaryMap.keySet()).indexOf("Seat Class"), 1);
        String name, id, phone;
        if (tabPassenger.getSelectedIndex() == 0) {
            name = txtPassengerName.getText();
            id = txtPassengerID.getText();
            phone = txtPassengerPhone.getText();
        }
        else {
            //todo
            name = id = phone = "";
            if (tablePassenger.getSelectedRowCount() == 1) {
                PassengerModel p = previousPassengers.get(tablePassenger.getSelectedRow());
                name = p.getName();
                id = p.getIdentityNumber();
                phone = p.getPhone();
            }
        }
        model.setValueAt(name, new ArrayList<String>(summaryMap.keySet()).indexOf("Passenger Name"), 1);
        model.setValueAt(id, new ArrayList<String>(summaryMap.keySet()).indexOf("Passenger ID"), 1);
        model.setValueAt(phone, new ArrayList<String>(summaryMap.keySet()).indexOf("Passenger Phone"), 1);
    }

    /**
     * This method will determine if the given info is eligible and then update summary.
     */
    private void checkEligibilityNUpdateSummary() {
        labPrice.setText("¥ ----.--");
        eligible = true;
        btnPay.setEnabled(false);
        labHintSeat.setVisible(false);
        labHintPassenger.setVisible(true);
        String passengerHint = "<html>";
        if (getSelectedSeat().getAvailableCount() <= 0) {
            labHintSeat.setVisible(true);
            eligible = false;
        }
        if (tabPassenger.getSelectedIndex() == 0) {
            // New passenger
            if (txtPassengerName.getText().length() < 3) {
                passengerHint += "Check the passenger name. <br>";
                eligible = false;
            }
            if (txtPassengerID.getText().length() != 18) {
                passengerHint += "Length of the identity number must be 18. <br>";
                eligible = false;
            }
            if (txtPassengerPhone.getText().length() < 10) {
                passengerHint += "Check the passenger phone. <br>";
                eligible = false;
            }
            passengerHint += "</html>";
        }
        
        if (eligible) {
            labPrice.setText("¥" + getSelectedSeat().getPrice());
            labHintPassenger.setVisible(false);
            btnPay.setEnabled(true);
        }
        else {
            labHintPassenger.setText(passengerHint);
            labHintPassenger.setVisible(true);
        }
        updateSummaryTable();
    }

    private void btnPayActionPerformed(ActionEvent e) {
        this.setEnabled(false);     // In order to prevent user to change info during payment.
        PaymentDialogue paymentDialogue = SpringContextUtil.getBean(PaymentDialogue.class);
        paymentDialogue.setSeatToPay(getSelectedSeat());
        paymentDialogue.setReservationDialog(this);
        paymentDialogue.load();
        paymentDialogue.setVisible(true);
    }

    /**
     * Payment finished, insert the reservation together with flight id, payment id and passenger id.
     */
    public void paymentDidFinished(PaymentModel p) {
        this.setEnabled(true);
        reservationController.create();
        reservationController.setSelectedFlightDetail(flightDetail);
        reservationController.setSelectedPassenger(getOrSaveSelectedPassenger());
        reservationController.setPayment(p);
        reservationController.setSelectedSeat(getSelectedSeat());
        switch (reservationController.save()) {
            case 0:
                // Success
                InfoDialogue infoDialogue = new InfoDialogue("Your reservation has been confirmed.");
                infoDialogue.setVisible(true);
                mainPanel.refresh();
                dispose();
                break;
        }
    }

    public void paymentDidCanceled() {
        this.setEnabled(true);
    }

    private void fetchPreviousPassenger() {
        DefaultTableModel model = (DefaultTableModel) tablePassenger.getModel();
        model.setRowCount(0);
        previousPassengers = flightSystemFacade.getPreviousPassengerUnderUser();
        previousPassengers.forEach(one -> {
            model.addRow(new String[] {one.getName(), one.getIdentityNumber(), one.getPhone()});
        });
        log.info("Filled previous passenger table.");
    }

    private void addListeners() {
        firstLoad = false;
        for (var oneTextFiled: new JTextField[]{txtPassengerPhone, txtPassengerName, txtPassengerID}) {
            oneTextFiled.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent documentEvent) {
                    checkEligibilityNUpdateSummary();
                }

                @Override
                public void removeUpdate(DocumentEvent documentEvent) {
                    checkEligibilityNUpdateSummary();
                }

                @Override
                public void changedUpdate(DocumentEvent documentEvent) {
                    checkEligibilityNUpdateSummary();
                }
            });
        }

        comboSeatSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                checkEligibilityNUpdateSummary();
            }
        });

        tablePassenger.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tableModelEvent) {
                checkEligibilityNUpdateSummary();
            }
        });

        tabPassenger.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                checkEligibilityNUpdateSummary();
            }
        });

        btnPay.addActionListener(e -> btnPayActionPerformed(e));

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
            }
        });

        tabPassenger.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if (tabPassenger.getSelectedIndex() == 1) {
                    // Fetch previous passenger;
                    fetchPreviousPassenger();
                }
            }
        });

        tablePassenger.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                checkEligibilityNUpdateSummary();
            }
        });
    }

    public void load() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Fill seats
        ArrayList<SeatModel> flightSeats = flightDetail.getSeats();
        List<String> flightSeatComboModel = flightSeats.stream().map(one -> String.format("%s - ￥%.2f, %d available.",
                one.getType().name(), one.getPrice(), one.getAvailableCount())).collect(Collectors.toList());
        comboSeatSelect.setModel(new DefaultComboBoxModel(flightSeatComboModel.toArray()));
        summaryMap.put("Flight Number", flightDetail.getFlightNumber());
        summaryMap.put("Model", flightDetail.getModel());
        summaryMap.put("Departure Airport", airportController.getAirportByAirportId(flightDetail.getFlyFromAirportId()).getAirportName());
        summaryMap.put("Arrival Airport", airportController.getAirportByAirportId(flightDetail.getFlyToAirportId()).getAirportName());
        summaryMap.put("Departure Date & Time", flightDetail.getDepartureDate() + " " + flightDetail.getDepartureTime());
        summaryMap.put("Flight Duration", Utils.minuteToHourFormatter(flightDetail.getFlightDurationMinutes()));
        summaryMap.put("Arrival Date & Time", Utils.getArrivalDatetime(flightDetail.getDepartureDate().toString(),
                                                            flightDetail.getDepartureTime().toString(),
                                                            flightDetail.getFlightDurationMinutes()));

        DefaultTableModel model = (DefaultTableModel) tableSummary.getModel();
        model.setRowCount(0);
        for (String one: summaryMap.keySet()) {
            model.addRow(new String[]{one, summaryMap.get(one)});
        }

        checkEligibilityNUpdateSummary();

        if (firstLoad) {
            addListeners();
        }
    }
}
