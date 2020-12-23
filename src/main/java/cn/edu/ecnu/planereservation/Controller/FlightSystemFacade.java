package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Mapper.*;
import cn.edu.ecnu.planereservation.Model.*;
import cn.edu.ecnu.planereservation.Model.Joined.FlightTableItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:16
 **/
@Component
public class FlightSystemFacade {
    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    FlightDescriptionMapper flightDescriptionMapper;
    @Autowired
    FlightMapper flightMapper;
    @Autowired
    AirportMapper airportMapper;

    @Autowired
    FlightController flightController;


    public ArrayList<ReservationModel> getPreviousReservation(UserModel user) {
        ArrayList<ReservationModel> queryReservation = reservationMapper.selectReservationByUid(user.getUid());
        return queryReservation;
    }

    public ArrayList<FlightTableItem> getAvailableFlightByAiports(AirportModel from, AirportModel to) {
        ArrayList<FlightDescriptionModel> queryFlightDescriptions = flightDescriptionMapper.selectFlightByAirport(from.getAirportId(), to.getAirportId());
        ArrayList<FlightTableItem> queryFlight = new ArrayList<>();
        queryFlightDescriptions.forEach(one -> {
            queryFlight.addAll(flightMapper.selectFlightDetailsByDescriptionId(one.getFlightDescriptionId()));
        });
        return queryFlight;
    }
}
