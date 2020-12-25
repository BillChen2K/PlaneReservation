/*
 * Created by JFormDesigner on Wed Dec 23 13:25:25 CST 2020
 */

package cn.edu.ecnu.planereservation.View;

import cn.edu.ecnu.planereservation.Controller.PaymentController;
import cn.edu.ecnu.planereservation.Core.DiscountStrategy.DiscountStrategy;
import cn.edu.ecnu.planereservation.Core.Payment.Impl.AlipayPayment;
import cn.edu.ecnu.planereservation.Core.Payment.Impl.BankTransferPayment;
import cn.edu.ecnu.planereservation.Core.Payment.Impl.WechatPayPayment;
import cn.edu.ecnu.planereservation.Model.PaymentModel;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
@Component
public class PaymentDialogue extends JDialog {
    public PaymentDialogue() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        tabPayment = new JTabbedPane();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        buttonBar = new JPanel();
        btnPay = new JButton();
        btnCancel = new JButton();
        panel4 = new JPanel();
        labPrice = new JLabel();
        var labUI = new JLabel();

        //======== this ========
        setTitle("Payment Pending...");
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
            javax.swing.border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax
            .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
            .awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt
            .Color.red),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.
            PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("bord\u0065r".
            equals(e.getPropertyName()))throw new RuntimeException();}});
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new BorderLayout());

                //======== tabPayment ========
                {

                    //======== panel1 ========
                    {
                        panel1.setLayout(new BorderLayout());
                    }
                    tabPayment.addTab("Alipay", panel1);

                    //======== panel2 ========
                    {
                        panel2.setLayout(new BorderLayout());
                    }
                    tabPayment.addTab("WeChat Pay", panel2);

                    //======== panel3 ========
                    {
                        panel3.setLayout(new BorderLayout());
                    }
                    tabPayment.addTab("Bank Transfer", panel3);
                }
                contentPanel.add(tabPayment, BorderLayout.CENTER);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- btnPay ----
                btnPay.setText("Pay Now");
                buttonBar.add(btnPay, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- btnCancel ----
                btnCancel.setText("Cancel");
                buttonBar.add(btnCancel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== panel4 ========
            {
                panel4.setLayout(new BorderLayout());

                //---- labPrice ----
                labPrice.setText("\uffe51234");
                labPrice.setFont(new Font("SF Pro Text", Font.BOLD, 24));
                panel4.add(labPrice, BorderLayout.LINE_END);

                //---- labUI ----
                labUI.setText("Choose your payment method:");
                panel4.add(labUI, BorderLayout.CENTER);
            }
            dialogPane.add(panel4, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(400, 300);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTabbedPane tabPayment;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel buttonBar;
    private JButton btnPay;
    private JButton btnCancel;
    private JPanel panel4;
    private JLabel labPrice;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Boolean firstLoad = true;

    @Autowired
    PaymentController paymentController;

    @Setter
    private ReservationDialog reservationDialog;

    @Setter
    private SeatModel seatToPay;

    @Setter
    private DiscountStrategy discountStrategy;

    private void addListeners() {
        firstLoad = false;
        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (tabPayment.getSelectedIndex()) {
                    case 0:
                        paymentController.createPayment(PaymentModel.PaymentMethod.AliPay, seatToPay, discountStrategy);
                        break;
                    case 1:
                        paymentController.createPayment(PaymentModel.PaymentMethod.WechatPay, seatToPay, discountStrategy);
                        break;
                    case 2:
                        paymentController.createPayment(PaymentModel.PaymentMethod.BankTransfer, seatToPay, discountStrategy);
                        break;
                }
                switch (paymentController.confirmPayment()) {
                    case 0:
                        // Case for success.
                        reservationDialog.paymentDidFinished(paymentController.getPaymentModel());
                        dispose();
                        break;
                    default:
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                reservationDialog.paymentDidCanceled();
                dispose();
            }
        });
    }

    public void load() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        labPrice.setText("￥" + String.valueOf(seatToPay.getPrice()));
        if (firstLoad) {
            addListeners();
        }
    }

}
