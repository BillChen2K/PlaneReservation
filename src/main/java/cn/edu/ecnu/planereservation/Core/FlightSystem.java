package cn.edu.ecnu.planereservation.Core;

import cn.edu.ecnu.planereservation.Core.Flight.Flight;
import cn.edu.ecnu.planereservation.Mapper.AirportMapper;
import cn.edu.ecnu.planereservation.Mapper.FlightDescriptionMapper;
import cn.edu.ecnu.planereservation.Mapper.ReservationMapper;
import cn.edu.ecnu.planereservation.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:16
 **/
@Component
public class FlightSystem {
    @Autowired
    ReservationMapper reservationMapper;
    @Autowired
    FlightDescriptionMapper flightDescriptionMapper;
    @Autowired
    AirportMapper airportMapper;
    @Autowired
    Flight flight;


    public ReservationModel searchPreviousReservation(UserModel user) {
        ReservationModel queryReservation = reservationMapper.selectReservationByPassengerId(user.getUid());
        return queryReservation;
    }

    public ArrayList<FlightDescriptionModel> searchAvailableFlight(AirportModel from, AirportModel to) {
        ArrayList<FlightDescriptionModel> queryFlight = flightDescriptionMapper.selectFlightByAirport(from.getAirportId(), to.getAirportId());
        return queryFlight;
    }

    public ArrayList<AirportModel> SearchAllAirport(){
        return airportMapper.selectAllAirports();
    }
}
