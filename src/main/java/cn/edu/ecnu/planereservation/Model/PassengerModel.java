package cn.edu.ecnu.planereservation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-22 2:16 下午
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PassengerModel {
    protected long passengerId;
    protected String name;
    protected String identityNumber;
    protected long uid;
    protected String phone;
}
