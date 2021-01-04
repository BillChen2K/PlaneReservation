package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.PassengerModel;
import cn.edu.ecnu.planereservation.Model.PaymentModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-24 21:24
 **/
@Mapper
public interface PaymentMapper {

    @Insert("INSERT INTO payment (payment_method, real_price, order_number, discount_strategy) VALUES " +
            "( #{paymentMethod}, #{realPrice}, #{orderNumber}, #{discountStrategy})")
    @Options(useGeneratedKeys = true, keyProperty = "paymentId")
    int insertPayment(PaymentModel paymentModel);

    @Select("SELECT * FROM payment WHERE payment_id=#{1}")
    PaymentModel selectPaymentById(long id);

}
