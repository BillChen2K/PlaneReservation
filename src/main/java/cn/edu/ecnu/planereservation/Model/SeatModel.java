package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatModel {
    public enum SeatType{
        F, C, Y;
    }
    protected long seatId;
    protected SeatType type;
    protected double price;
    protected long availableCount;
    protected long flightId;

    public SeatModel(long ac) {
        availableCount = ac;
    }

    public SeatModel() {

    }
}
