package cn.edu.ecnu.planereservation.Core.Payment.Impl;

import cn.edu.ecnu.planereservation.Core.Payment.Payment;

public class WechatPay implements Payment {

    private double amount;

    @Override
    public int confirmPayment() {
        return 0;
    }

    public WechatPay(double amount) {
        this.amount = amount;
    }
}
