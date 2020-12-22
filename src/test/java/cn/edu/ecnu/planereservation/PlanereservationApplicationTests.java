package cn.edu.ecnu.planereservation;

import cn.edu.ecnu.planereservation.Controller.FlightSystem;
import cn.edu.ecnu.planereservation.Mapper.AirportMapper;
import cn.edu.ecnu.planereservation.Mapper.FlightDescriptionMapper;
import cn.edu.ecnu.planereservation.Mapper.SeatMapper;
import cn.edu.ecnu.planereservation.Mapper.UserMapper;
import cn.edu.ecnu.planereservation.Model.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlanereservationApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Autowired
	FlightDescriptionMapper flightDescriptionMapper;

	@Autowired
	FlightSystem flightSystem;

	@Autowired
	AirportMapper airportMapper;

	@Autowired
	SeatMapper seatMapper;
	@Test
	void contextLoads() {
//		UserModel u = userMapper.selectUserByUsername("admin");
//		User user = (User) u;
//		System.out.println(user.getUid());
		ArrayList<FlightDescriptionModel> f = flightDescriptionMapper.selectFlightByAirport(10001, 10002);
		UserModel u = new UserModel();
		u.setUid(10001);
		ArrayList<ReservationModel> s =  flightSystem.searchPreviousReservation(u);
		AirportModel a = airportMapper.selectAirportByAirportId(10001);
		ArrayList<SeatModel> seatt = seatMapper.selectSeatByFlight(100001);
		System.out.println();
		System.out.println("Finished");
		System.out.println(f.toString());
	}

}
