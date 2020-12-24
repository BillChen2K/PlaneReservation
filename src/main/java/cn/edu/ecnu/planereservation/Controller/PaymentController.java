package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Core.Payment.Payment;
import cn.edu.ecnu.planereservation.Model.PaymentModel;
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

    @Setter
    private Payment payment;

    @Getter
    private PaymentModel paymentModel;

    /**
     * Confirm a payment.
     * @return 0 for a success payment. Will return success in any case.
     */
    public int confirmPayment() {
        try {
//            Thread.sleep(1000);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        int result = payment.confirmPayment();
        paymentModel = payment.getModel();
        return result;
    }
}
