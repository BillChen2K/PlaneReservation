package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Core.DiscountStrategy.DiscountStrategy;
import cn.edu.ecnu.planereservation.Core.Payment.AlipayPayment;
import cn.edu.ecnu.planereservation.Core.Payment.BankTransferPayment;
import cn.edu.ecnu.planereservation.Core.Payment.OtherPayment;
import cn.edu.ecnu.planereservation.Core.Payment.WechatPayPayment;
import cn.edu.ecnu.planereservation.Core.Payment.Payment;
import cn.edu.ecnu.planereservation.Model.PaymentModel;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import cn.edu.ecnu.planereservation.Util.SpringContextUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-24 02:01
 **/
@Component
@Slf4j
public class PaymentController {

    private Payment payment;

    @Getter
    private PaymentModel paymentModel;

    @Setter
    private DiscountStrategy discountStrategy;

    /**
     * Confirm a payment.
     * @return 0 for a success payment. Will return success in any case.
     */
    public int confirmPayment() {
        int result = payment.confirmPayment();
        paymentModel = payment.getModel();
        return result;
    }

    public void createPayment(PaymentModel.PaymentMethod method, SeatModel seatToPay, DiscountStrategy ds) {
        discountStrategy = ds;
        switch (method) {
            case AliPay:
                payment =SpringContextUtil.getBean(AlipayPayment.class).setAmount(ds.getDiscountedPrice(seatToPay.getPrice()));
                break;
            case WechatPay:
                payment = SpringContextUtil.getBean(WechatPayPayment.class).setAmount(ds.getDiscountedPrice(seatToPay.getPrice()));
                break;
            case BankTransfer:
                payment = SpringContextUtil.getBean(BankTransferPayment.class).setAmount(ds.getDiscountedPrice(seatToPay.getPrice()));
                break;
            default:
                payment = SpringContextUtil.getBean(OtherPayment.class).setAmount(ds.getDiscountedPrice(seatToPay.getPrice()));
        }
    }
}
