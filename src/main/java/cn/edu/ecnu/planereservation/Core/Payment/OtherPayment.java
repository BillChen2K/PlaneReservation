package cn.edu.ecnu.planereservation.Core.Payment;

import cn.edu.ecnu.planereservation.Core.Payment.Payment;
import cn.edu.ecnu.planereservation.Mapper.PaymentMapper;
import cn.edu.ecnu.planereservation.Model.PaymentModel;
import cn.edu.ecnu.planereservation.Util.Utils;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-25 13:14
 **/
@Component
@Accessors(chain = true)
public class OtherPayment implements Payment {

    @Setter
    private double amount;
    private PaymentModel pm;

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public int confirmPayment() {
        pm = new PaymentModel();
        pm.setPaymentMethod(PaymentModel.PaymentMethod.Other);
        pm.setRealPrice(amount);
        pm.setOrderNumber("OTHER" + Utils.getRandomNumberString(10));
        paymentMapper.insertPayment(pm);
        return 0;
    }

    @Override
    public PaymentModel getModel() {
        return pm;
    }
}
