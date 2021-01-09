package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Core.PricingStrategy.DefaultPricingStrategy;
import cn.edu.ecnu.planereservation.Core.PricingStrategy.PricingStrategy;
import cn.edu.ecnu.planereservation.Mapper.FlightDescriptionMapper;
import cn.edu.ecnu.planereservation.Mapper.FlightMapper;
import cn.edu.ecnu.planereservation.Mapper.SeatMapper;
import cn.edu.ecnu.planereservation.Model.FlightDescriptionModel;
import cn.edu.ecnu.planereservation.Model.FlightModel;
import cn.edu.ecnu.planereservation.Model.Joined.FlightTableItem;
import cn.edu.ecnu.planereservation.Model.SeatModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-22 11:31 下午
 **/
@Component
@Slf4j
public class FlightController {

    @Autowired
    SeatMapper seatMapper;

    @Autowired
    FlightDescriptionMapper flightDescriptionMapper;

    @Autowired
    FlightMapper flightMapper;

    /**
     * Updated!
     * Now price will vary with available seat count and time.
     * @param flight_id
     * @return
     */
    public ArrayList<SeatModel> getSeatsByFlightId(long flight_id) {
        ArrayList<SeatModel> seats = seatMapper.selectSeatsByFlightId(flight_id);
        seats.stream().map(one -> {
            PricingStrategy ps = new DefaultPricingStrategy(10, 100,
                                                         DefaultPricingStrategy.TimeVariationStrategy.RaiseAtEvenMinute);
            log.info(String.format("Primitive Price: %.2f, Price: %.2f, Pricing Strategy: %s",
                                   one.getPrice(), ps.getPricing(one), ps.toString()));
            one.setPrice(ps.getPricing(one));
            return one;
        }).collect(Collectors.toList());
        return seats;
    }

    public ArrayList<FlightModel> getFlightsByDescriptionId(long descriptionId) {
        return flightMapper.selectFlightsByDescriptionId(descriptionId);
    }

}
