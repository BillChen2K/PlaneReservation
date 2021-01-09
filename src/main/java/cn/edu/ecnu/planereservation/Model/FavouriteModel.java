package cn.edu.ecnu.planereservation.Model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-09 14:53
 **/
@Getter
@Setter
@Accessors(chain = true)
public class FavouriteModel {
	protected long favouriteId;
	protected long uid;
	protected long flightDescriptionId;
	protected long passengerId;
}
