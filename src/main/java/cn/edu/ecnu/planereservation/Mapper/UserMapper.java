package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * User Mapper
 *
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 01:55
 **/
@Mapper
public interface UserMapper {

	/**
	 * Select query, will inject automatically into UserModel class.
	 * @param username
	 * @return
	 */
	@Select("SELECT * FROM user WHERE username=#{1}")
	UserModel selectUserByUsername(String username);
}
