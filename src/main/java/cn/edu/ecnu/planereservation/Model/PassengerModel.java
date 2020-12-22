package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-22 2:16 下午
 **/
@Getter
@Setter
public class PassengerModel {
    protected long passengerId;
    protected String name;
    protected String identityNumber;
    protected long uid;
}
