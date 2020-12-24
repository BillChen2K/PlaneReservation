package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-23 23:47
 **/
@Component
@Getter
@Setter
public class PaymentModel {

    public enum PaymentMethod {
        WechatPay, AliPay, BankTransfer
    }

    long paymentId;
    PaymentMethod paymentMethod;
    double originalPrice;
    double realPrice;
    double orderNumber;
}

