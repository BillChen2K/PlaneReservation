package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Mapper.AirportMapper;
import cn.edu.ecnu.planereservation.Model.AirportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-22 11:27 下午
 **/
@Component
public class AirportController {

    @Autowired
    AirportMapper airportMapper;

    /**
     * Cache the result of airports.
     */
    private ArrayList<AirportModel> cachedAirports = new ArrayList<>();

    public ArrayList<AirportModel> searchAllAirports(){
        if(cachedAirports.size() == 0) {
            cachedAirports = airportMapper.selectAllAirports();
        }
        return cachedAirports;
    }

    public AirportModel getAirportByCode(String code) {
        if(cachedAirports.size() == 0) {
            cachedAirports = airportMapper.selectAllAirports();
        }
        return cachedAirports.stream()
                .filter(one -> one.getCode().equals(code))
                .findFirst().orElse(null);
    }

    public AirportModel getAirportByAirportId(long airport_id) {
        if(cachedAirports.size() == 0) {
            cachedAirports = airportMapper.selectAllAirports();
        }
        return cachedAirports.stream().filter(one -> one.getAirportId() == airport_id)
                .findFirst().orElse(null);
    }

}
