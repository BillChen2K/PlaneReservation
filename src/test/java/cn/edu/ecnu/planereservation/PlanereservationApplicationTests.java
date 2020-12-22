package cn.edu.ecnu.planereservation;

import cn.edu.ecnu.planereservation.Controller.User.User;
import cn.edu.ecnu.planereservation.Mapper.FlightDescriptionMapper;
import cn.edu.ecnu.planereservation.Mapper.UserMapper;
import cn.edu.ecnu.planereservation.Model.FlightDescriptionModel;
import cn.edu.ecnu.planereservation.Model.UserModel;
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

	@Test
	void contextLoads() {
		UserModel u = userMapper.selectUserByUsername("admin");
		User user = (User) u;
		System.out.println(user.getUid());
		ArrayList<FlightDescriptionModel> f = flightDescriptionMapper.selectFlightByAirport(10001, 10002);
		System.out.println("Finished");
		System.out.println(f.toString());
	}

}
