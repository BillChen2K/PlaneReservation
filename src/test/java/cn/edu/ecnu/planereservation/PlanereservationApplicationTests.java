package cn.edu.ecnu.planereservation;

import cn.edu.ecnu.planereservation.Controller.FlightSystemFacade;
import cn.edu.ecnu.planereservation.Mapper.*;
import cn.edu.ecnu.planereservation.Model.*;
import cn.edu.ecnu.planereservation.Util.Utils;
import org.junit.Assert;
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
	FlightSystemFacade flightSystemFacade;

	@Autowired
	AirportMapper airportMapper;

	@Autowired
	SeatMapper seatMapper;

	@Autowired
	PassengerMapper passengerMapper;

	@Test
	void utilTest() {
		System.out.println(Utils.minuteToHourFormatter(100));
	}

	@Test
	void contextLoads() {
//		UserModel u = userMapper.selectUserByUsername("admin");
//		User user = (User) u;
//		System.out.println(user.getUid());
//		ArrayList<FlightDescriptionModel> f = flightDescriptionMapper.selectFlightByAirport(10001, 10002);
//		UserModel u = new UserModel();
//		u.setUid(10001);
//		ArrayList<ReservationModel> s =  flightSystemFacade.getPreviousReservation(u);
//		AirportModel a = airportMapper.selectAirportByAirportId(10001);
//		ArrayList<SeatModel> seatt = seatMapper.selectSeatsByFlightId(100001);
//		System.out.println();
//		System.out.println("Finished");
//		PassengerModel p = new PassengerModel();
//		p.setName("TEST").setIdentityNumber("1234567").setUid(10001).setPhone("18800263589");
//		passengerMapper.insertPassenger(p);
		System.out.println(Utils.getArrivalDatetime("2020-12-31", "23:23:21", 120));
		System.out.println("Finished");
	}

}
