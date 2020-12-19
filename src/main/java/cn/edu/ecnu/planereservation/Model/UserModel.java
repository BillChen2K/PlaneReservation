package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 01:57
 **/
@Getter
@Setter
@Accessors(chain = true) // 可以连续设置属性
public class UserModel {
	/** 数据库对应字段 **/
	protected long uid;
	protected String username;
	protected String password;
}
