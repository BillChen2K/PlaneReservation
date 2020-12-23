/*
 * Created by JFormDesigner on Wed Dec 23 03:24:47 CST 2020
 */

package cn.edu.ecnu.planereservation.View;

import javax.swing.table.*;
import org.springframework.stereotype.Component;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
@Component
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
        labUI = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        labUI9 = new JLabel();
        labUI10 = new JLabel();
        panel6 = new JPanel();
        panel3 = new JPanel();
        labUI2 = new JLabel();
        tabPassenger = new JTabbedPane();
        panel1 = new JPanel();
        textField1 = new JTextField();
        labUI3 = new JLabel();
        labUI4 = new JLabel();
        textField2 = new JTextField();
        textField3 = new JTextField();
        labUI5 = new JLabel();
        labUI6 = new JLabel();
        panel2 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        panel5 = new JPanel();
        labUI7 = new JLabel();
        comboSeatSelect = new JComboBox();
        buttonBar = new JPanel();
        btnConfirm = new JButton();
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
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
            border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER
            ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font
            .BOLD,12),java.awt.Color.red),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(
            new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r"
            .equals(e.getPropertyName()))throw new RuntimeException();}});
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

                        //---- table1 ----
                        table1.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null},
                                {"Flight Number", null},
                                {"Departure Date", null},
                            },
                            new String[] {
                                "Key", "Value"
                            }
                        ));
                        {
                            TableColumnModel cm = table1.getColumnModel();
                            cm.getColumn(0).setPreferredWidth(100);
                            cm.getColumn(1).setPreferredWidth(100);
                        }
                        table1.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                        scrollPane1.setViewportView(table1);
                    }
                    panel4.add(scrollPane1);
                    scrollPane1.setBounds(5, 35, 370, 280);

                    //---- labUI9 ----
                    labUI9.setText("You'll need to pay:");
                    labUI9.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                    labUI9.setHorizontalAlignment(SwingConstants.TRAILING);
                    panel4.add(labUI9);
                    labUI9.setBounds(245, 335, 123, 16);

                    //---- labUI10 ----
                    labUI10.setText("\uffe51023.23");
                    labUI10.setFont(new Font("SF Pro Rounded", Font.BOLD, 26));
                    labUI10.setHorizontalAlignment(SwingConstants.TRAILING);
                    panel4.add(labUI10);
                    labUI10.setBounds(215, 355, 155, 41);

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

                                //---- textField1 ----
                                textField1.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(textField1);
                                textField1.setBounds(95, 10, 255, 30);

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

                                //---- textField2 ----
                                textField2.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(textField2);
                                textField2.setBounds(95, 45, 255, 30);

                                //---- textField3 ----
                                textField3.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(textField3);
                                textField3.setBounds(95, 80, 255, 30);

                                //---- labUI5 ----
                                labUI5.setText("Phone:");
                                labUI5.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(labUI5);
                                labUI5.setBounds(15, 89, 90, 16);

                                //---- labUI6 ----
                                labUI6.setText("*All fields are required.");
                                labUI6.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                panel1.add(labUI6);
                                labUI6.setBounds(15, 130, 150, 16);

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

                                    //---- table2 ----
                                    table2.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                                    scrollPane2.setViewportView(table2);
                                }
                                panel2.add(scrollPane2);
                                scrollPane2.setBounds(0, 0, 375, 240);

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
                        tabPassenger.setBounds(10, 35, 375, 275);

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
                        labUI7.setBounds(new Rectangle(new Point(15, 10), labUI7.getPreferredSize()));

                        //---- comboSeatSelect ----
                        comboSeatSelect.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                        comboSeatSelect.setPreferredSize(new Dimension(85, 36));
                        panel5.add(comboSeatSelect);
                        comboSeatSelect.setBounds(150, 5, 225, comboSeatSelect.getPreferredSize().height);
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

                //---- btnConfirm ----
                btnConfirm.setText("Confirm Payment");
                btnConfirm.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
                buttonBar.add(btnConfirm, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
    private JLabel labUI;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel labUI9;
    private JLabel labUI10;
    private JPanel panel6;
    private JPanel panel3;
    private JLabel labUI2;
    private JTabbedPane tabPassenger;
    private JPanel panel1;
    private JTextField textField1;
    private JLabel labUI3;
    private JLabel labUI4;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel labUI5;
    private JLabel labUI6;
    private JPanel panel2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JPanel panel5;
    private JLabel labUI7;
    private JComboBox comboSeatSelect;
    private JPanel buttonBar;
    private JButton btnConfirm;
    private JButton btnCancel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
