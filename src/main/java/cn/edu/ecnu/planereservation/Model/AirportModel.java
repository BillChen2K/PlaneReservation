package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:12
 **/
@Getter
@Setter
public class AirportModel {
	protected long airport_id;
	protected String city;
	protected String code;
}
