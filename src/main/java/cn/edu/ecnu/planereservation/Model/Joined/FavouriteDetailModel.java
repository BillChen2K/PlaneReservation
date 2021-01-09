package cn.edu.ecnu.planereservation.Model.Joined;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

/**
 * This class joined favourite, passenger and flight description.
 * @author billchen
 * @version 1.0
 * @create 2021-01-09 15:34
 **/
@Getter
@Setter
public class FavouriteDetailModel {
	protected long favouriteId;
	protected long uid;
	protected long flightDescriptionId;
	protected long passengerId;
	protected String name;
	protected String identityNumber;
	protected String phone;
	protected String flightNumber;
	protected String model;
	protected long flyToAirportId;
	protected long flyFromAirportId;
	protected Time departureTime;
	protected int flightDurationMinutes;
}
