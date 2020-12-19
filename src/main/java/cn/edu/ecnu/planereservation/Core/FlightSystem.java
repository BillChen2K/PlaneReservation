package cn.edu.ecnu.planereservation.Core;

import cn.edu.ecnu.planereservation.Core.Flight.Flight;
import cn.edu.ecnu.planereservation.Mapper.AirportMapper;
import cn.edu.ecnu.planereservation.Mapper.FlightMapper;
import cn.edu.ecnu.planereservation.Mapper.ReservationMapper;
import cn.edu.ecnu.planereservation.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
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
    FlightMapper flightMapper;
    @Autowired
    AirportMapper airportMapper;
    @Autowired
    Flight flight;


    public ReservationModel searchPreviousReservation(UserModel user) {
        ReservationModel queryReservation = reservationMapper.selectReservationByPassengerId(user.getUid());
        return queryReservation;
    }

    public ArrayList<FlightModel> searchAvailableFlight(AirportModel from, AirportModel to) {
        ArrayList<FlightModel> queryFlight = flightMapper.selectFlightByAirport(from.getAirport_id(), to.getAirport_id());
        return queryFlight;
    }

    public ArrayList<AirportModel> SearchAllAirport(){
        return airportMapper.selectAllAirports();
    }
}
