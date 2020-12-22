/*
 * Created by JFormDesigner on Tue Dec 22 18:40:57 CST 2020
 */

package cn.edu.ecnu.planereservation.View;

import javax.swing.table.*;
import org.springframework.stereotype.Component;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
@Component
public class MainPanel extends JPanel {

    public MainPanel() {
        initComponents();
        load();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        var labUsername = new JLabel();
        this.tabMain = new JTabbedPane();
        this.panelReservation = new JPanel();
        this.scrollPane1 = new JScrollPane();
        this.tableFlights = new JTable();
        var labelUI = new JLabel();
        var labelUI2 = new JLabel();
        this.comboDepartureAirport = new JComboBox<>();
        this.comboArrivalAirport = new JComboBox<>();
        var labelUI3 = new JLabel();
        var labelUI4 = new JLabel();
        this.button1 = new JButton();
        this.txtBeginDate = new JTextField();
        var labelUI5 = new JLabel();
        this.texBeginDate = new JTextField();
        var labelUI6 = new JLabel();
        this.textEndDate = new JTextField();
        this.btnSearch = new JButton();
        this.panelHistory = new JPanel();
        var labelUI7 = new JLabel();
        this.scrollPane2 = new JScrollPane();
        this.table1 = new JTable();
        this.btnGithub2 = new JButton();
        this.btnGithub3 = new JButton();
        this.btnAbout = new JButton();
        this.btnGithub = new JButton();

        //======== this ========
        setPreferredSize(new Dimension(1200, 800));
        setMinimumSize(new Dimension(1200, 800));
        setFont(new Font("SF Pro Display", Font.PLAIN, 14));
        setName("this");
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
        0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
        .BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.
        red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
        beans.PropertyChangeEvent e){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(null);

        //---- labUsername ----
        labUsername.setText("HI! You have logged in as: #{username}");
        labUsername.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
        labUsername.setName("labUsername");
        add(labUsername);
        labUsername.setBounds(new Rectangle(new Point(35, 25), labUsername.getPreferredSize()));

        //======== tabMain ========
        {
            this.tabMain.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
            this.tabMain.setDoubleBuffered(true);
            this.tabMain.setName("tabMain");

            //======== panelReservation ========
            {
                this.panelReservation.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                this.panelReservation.setName("panelReservation");
                this.panelReservation.setLayout(null);

                //======== scrollPane1 ========
                {
                    this.scrollPane1.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                    this.scrollPane1.setName("scrollPane1");

                    //---- tableFlights ----
                    this.tableFlights.setModel(new DefaultTableModel(
                        new Object[][] {
                            {null, null, null, null, null, null, null, null, null},
                            {null, null, null, null, null, null, null, null, null},
                        },
                        new String[] {
                            "Flight Number", "Model", "Departure Airport", "Arrival Airport", "Departure Date", "Departure Time", "F", "C", "Y"
                        }
                    ));
                    {
                        TableColumnModel cm = this.tableFlights.getColumnModel();
                        cm.getColumn(0).setPreferredWidth(110);
                        cm.getColumn(1).setPreferredWidth(70);
                        cm.getColumn(2).setPreferredWidth(120);
                        cm.getColumn(3).setPreferredWidth(120);
                        cm.getColumn(4).setPreferredWidth(120);
                        cm.getColumn(5).setPreferredWidth(120);
                        cm.getColumn(6).setPreferredWidth(30);
                        cm.getColumn(7).setPreferredWidth(30);
                        cm.getColumn(8).setPreferredWidth(30);
                    }
                    this.tableFlights.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                    this.tableFlights.setName("tableFlights");
                    this.scrollPane1.setViewportView(this.tableFlights);
                }
                this.panelReservation.add(this.scrollPane1);
                this.scrollPane1.setBounds(20, 105, 1105, 460);

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
                labelUI2.setBounds(405, 70, 120, 18);

                //---- comboDepartureAirport ----
                this.comboDepartureAirport.setModel(new DefaultComboBoxModel<>(new String[] {
                    "HK",
                    "R"
                }));
                this.comboDepartureAirport.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                this.comboDepartureAirport.setName("comboDepartureAirport");
                this.panelReservation.add(this.comboDepartureAirport);
                this.comboDepartureAirport.setBounds(140, 65, 230, this.comboDepartureAirport.getPreferredSize().height);

                //---- comboArrivalAirport ----
                this.comboArrivalAirport.setModel(new DefaultComboBoxModel<>(new String[] {
                    "HK",
                    "R"
                }));
                this.comboArrivalAirport.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                this.comboArrivalAirport.setName("comboArrivalAirport");
                this.panelReservation.add(this.comboArrivalAirport);
                this.comboArrivalAirport.setBounds(500, 65, 265, 30);

                //---- labelUI3 ----
                labelUI3.setText("Flight Number:");
                labelUI3.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                labelUI3.setName("labelUI3");
                this.panelReservation.add(labelUI3);
                labelUI3.setBounds(20, 30, 120, 18);

                //---- labelUI4 ----
                labelUI4.setText("Select a flight to make your reservation.");
                labelUI4.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                labelUI4.setName("labelUI4");
                this.panelReservation.add(labelUI4);
                labelUI4.setBounds(625, 580, 250, 18);

                //---- button1 ----
                this.button1.setText("Make Reservation");
                this.button1.setName("button1");
                this.panelReservation.add(this.button1);
                this.button1.setBounds(880, 575, 245, 30);

                //---- txtBeginDate ----
                this.txtBeginDate.setName("txtBeginDate");
                this.panelReservation.add(this.txtBeginDate);
                this.txtBeginDate.setBounds(140, 25, 230, 31);

                //---- labelUI5 ----
                labelUI5.setText("Date Range:");
                labelUI5.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                labelUI5.setName("labelUI5");
                this.panelReservation.add(labelUI5);
                labelUI5.setBounds(405, 35, 120, 18);

                //---- texBeginDate ----
                this.texBeginDate.setName("texBeginDate");
                this.panelReservation.add(this.texBeginDate);
                this.texBeginDate.setBounds(500, 25, 265, 31);

                //---- labelUI6 ----
                labelUI6.setText("To");
                labelUI6.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                labelUI6.setName("labelUI6");
                this.panelReservation.add(labelUI6);
                labelUI6.setBounds(790, 35, 25, 18);

                //---- textEndDate ----
                this.textEndDate.setName("textEndDate");
                this.panelReservation.add(this.textEndDate);
                this.textEndDate.setBounds(835, 25, 280, 31);

                //---- btnSearch ----
                this.btnSearch.setText("Search Now");
                this.btnSearch.setName("btnSearch");
                this.panelReservation.add(this.btnSearch);
                this.btnSearch.setBounds(830, 60, 285, 30);

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

            //======== panelHistory ========
            {
                this.panelHistory.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                this.panelHistory.setName("panelHistory");
                this.panelHistory.setLayout(null);

                //---- labelUI7 ----
                labelUI7.setText("Here's the reservations you made before. You can select one to cancel or rearrange it.");
                labelUI7.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                labelUI7.setName("labelUI7");
                this.panelHistory.add(labelUI7);
                labelUI7.setBounds(30, 25, 505, 18);

                //======== scrollPane2 ========
                {
                    this.scrollPane2.setName("scrollPane2");

                    //---- table1 ----
                    this.table1.setName("table1");
                    this.scrollPane2.setViewportView(this.table1);
                }
                this.panelHistory.add(this.scrollPane2);
                this.scrollPane2.setBounds(15, 60, 1105, 500);

                //---- btnGithub2 ----
                this.btnGithub2.setText("Cancel Reservation");
                this.btnGithub2.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                this.btnGithub2.setName("btnGithub2");
                this.panelHistory.add(this.btnGithub2);
                this.btnGithub2.setBounds(920, 570, 198, 36);

                //---- btnGithub3 ----
                this.btnGithub3.setText("Rearrange");
                this.btnGithub3.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                this.btnGithub3.setName("btnGithub3");
                this.panelHistory.add(this.btnGithub3);
                this.btnGithub3.setBounds(710, 570, 198, 36);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < this.panelHistory.getComponentCount(); i++) {
                        Rectangle bounds = this.panelHistory.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = this.panelHistory.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    this.panelHistory.setMinimumSize(preferredSize);
                    this.panelHistory.setPreferredSize(preferredSize);
                }
            }
            this.tabMain.addTab("My Reservation", this.panelHistory);
        }
        add(this.tabMain);
        this.tabMain.setBounds(25, 55, 1155, 665);

        //---- btnAbout ----
        this.btnAbout.setText("About");
        this.btnAbout.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
        this.btnAbout.setName("btnAbout");
        add(this.btnAbout);
        this.btnAbout.setBounds(1080, 730, 92, 30);

        //---- btnGithub ----
        this.btnGithub.setText("GitHub");
        this.btnGithub.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
        this.btnGithub.setName("btnGithub");
        add(this.btnGithub);
        this.btnGithub.setBounds(970, 730, 98, 30);

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
    private JTabbedPane tabMain;
    private JPanel panelReservation;
    private JScrollPane scrollPane1;
    private JTable tableFlights;
    private JComboBox<String> comboDepartureAirport;
    private JComboBox<String> comboArrivalAirport;
    private JButton button1;
    private JTextField txtBeginDate;
    private JTextField texBeginDate;
    private JTextField textEndDate;
    private JButton btnSearch;
    private JPanel panelHistory;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JButton btnGithub2;
    private JButton btnGithub3;
    private JButton btnAbout;
    private JButton btnGithub;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void load() {

    }
}
