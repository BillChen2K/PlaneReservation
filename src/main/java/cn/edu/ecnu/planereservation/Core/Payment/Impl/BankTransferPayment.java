package cn.edu.ecnu.planereservation.Core.Payment.Impl;

import cn.edu.ecnu.planereservation.Core.Payment.Payment;
import cn.edu.ecnu.planereservation.Model.PaymentModel;

public class BankTransferPayment implements Payment {

    private double amount;

    @Override
    public int confirmPayment() {
        return 0;
    }

    @Override
    public PaymentModel getModel() {
        return new PaymentModel();
    }

    public BankTransferPayment(double amount) {
        this.amount = amount;
    }
}
