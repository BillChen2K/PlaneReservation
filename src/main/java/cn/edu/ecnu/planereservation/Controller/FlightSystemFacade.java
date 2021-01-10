package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Core.Exception.UserNotLoggedInException;
import cn.edu.ecnu.planereservation.Mapper.*;
import cn.edu.ecnu.planereservation.Model.*;
import cn.edu.ecnu.planereservation.Model.Joined.FlightTableItem;
import cn.edu.ecnu.planereservation.Model.Joined.ReservationDetailModel;
import cn.edu.ecnu.planereservation.Util.Shared;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:16
 **/
@Component
@Slf4j
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
    PassengerMapper passengerMapper;

    @Autowired
    FlightController flightController;


    public ArrayList<ReservationDetailModel> getPreviousReservationDetails() {
        ArrayList<ReservationDetailModel> r = reservationMapper.selectReservationDetailsByUid(Shared.currentUser.getUid());
        return r;
    }

    public ArrayList<FlightTableItem> getAvailableFlightsByAirports(AirportModel from, AirportModel to) {
        ArrayList<FlightDescriptionModel> queryFlightDescriptions = flightDescriptionMapper.selectFlightByAirport(from.getAirportId(), to.getAirportId());
        ArrayList<FlightTableItem> queryFlight = new ArrayList<>();
        queryFlightDescriptions.forEach(one -> {
            queryFlight.addAll(flightMapper.selectFlightDetailsByDescriptionId(one.getFlightDescriptionId()));
        });
        return queryFlight;
    }

    public ArrayList<PassengerModel> getPreviousPassengerUnderUser() {
        try {
            if (Shared.currentUser == null) {
                throw new UserNotLoggedInException();
            }
            else {
                return passengerMapper.selectPassengersByUid(Shared.currentUser.getUid());
            }
        } catch (UserNotLoggedInException e) {
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }
}
