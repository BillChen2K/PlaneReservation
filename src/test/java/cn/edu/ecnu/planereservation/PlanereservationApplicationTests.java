package cn.edu.ecnu.planereservation;

import cn.edu.ecnu.planereservation.Core.User.User;
import cn.edu.ecnu.planereservation.Mapper.UserMapper;
import cn.edu.ecnu.planereservation.Model.UserModel;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class PlanereservationApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	void contextLoads() {
		System.setProperty("java.awt.headless", "false");
		UserModel u = userMapper.selectUserByUsername("admin");
		User user = (User) u;
		System.out.println(user.getUid());
	}

}
