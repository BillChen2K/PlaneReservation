package cn.edu.ecnu.planereservation.Core.Payment;

public class BankTransferPaymeny implements Payment{

    private double amount;

    @Override
    public int confirmPayment() {
        return 0;
    }

    public BankTransferPaymeny(double amount) {
        this.amount = amount;
    }
}
