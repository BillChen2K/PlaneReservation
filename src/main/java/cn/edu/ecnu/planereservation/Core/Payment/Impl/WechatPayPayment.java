package cn.edu.ecnu.planereservation.Core.Payment.Impl;

import cn.edu.ecnu.planereservation.Core.Payment.Payment;
import cn.edu.ecnu.planereservation.Mapper.PaymentMapper;
import cn.edu.ecnu.planereservation.Model.PaymentModel;
import cn.edu.ecnu.planereservation.Util.Utils;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Accessors(chain = true)
public class WechatPayPayment implements Payment {

    @Setter
    private double amount;
    private PaymentModel pm;

    @Autowired
    PaymentMapper paymentMapper;

    @Override
    public int confirmPayment() {
        pm = new PaymentModel();
        pm.setPaymentMethod(PaymentModel.PaymentMethod.WechatPay);
        pm.setRealPrice(amount);
        pm.setOrderNumber("WECHAT" + Utils.getRandomNumberString(10));
        paymentMapper.insertPayment(pm);
        return 0;
    }

    @Override
    public PaymentModel getModel() {
        return pm;
    }
}
