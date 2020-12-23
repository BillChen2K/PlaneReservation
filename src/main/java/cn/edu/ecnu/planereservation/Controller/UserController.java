package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Mapper.UserMapper;
import cn.edu.ecnu.planereservation.Model.UserModel;
import cn.edu.ecnu.planereservation.Util.Shared;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:17
 **/
@Component
public class UserController extends UserModel {

	@Autowired
	UserMapper userMapper;

	@Getter @Setter
	private UserModel currentUser;

	public static final int LOGGED_OUT = 0;
	public static final int LOGGED_IN = 1;

	private int loginStatus;

	public UserController() {
		loginStatus = LOGGED_OUT;
	}
	/**
	 * 在设置了 User 中的用户名和密码后进行登录
	 * @return
	 */
	public int performLogIn() {
		UserModel queryUser = userMapper.selectUserByUsername(username);
		if (queryUser == null) {
			// 不存在
			return -2;
		}
		if (!queryUser.getPassword().equals(password)) {
			// 密码错误
			return -1;
		}
		else {
			loginStatus = LOGGED_IN;
			uid = queryUser.getUid();
			currentUser = queryUser;
			Shared.currentUser = queryUser;
			return 0;
		}
	}

	public void performLogOut() {
		loginStatus = LOGGED_OUT;
	}
}
