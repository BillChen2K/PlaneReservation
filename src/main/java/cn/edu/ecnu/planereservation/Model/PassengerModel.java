package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerModel {
    protected long passenger_id;
    protected String name;
    protected String identityNumber;
    protected long seat_id;
}
