package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.FavouriteModel;
import cn.edu.ecnu.planereservation.Model.Joined.FavouriteDetailModel;
import cn.edu.ecnu.planereservation.Model.ReservationModel;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-09 15:00
 **/
@Mapper
public interface FavouriteMapper {

	@Select("SELECT * FROM favourite")
	ArrayList<FavouriteModel> selectFavouritesByUid(long uid);

	@Select("SELECT * FROM favourite NATURAL JOIN flight_description NATURAL JOIN passenger WHERE favourite_id=#{1};")
	FavouriteDetailModel selectFavouriteDetailByFavouriteId(long favouriteId);

	@Select("SELECT * FROM favourite NATURAL JOIN flight_description NATURAL JOIN passenger WHERE uid=#{1};")
	ArrayList<FavouriteDetailModel> selectFavouriteDetailsByUid(long uid);

	@Insert("INSERT INTO favourite (uid, flight_description_id, passenger_id) " +
			"VALUES ( #{uid}, #{flightDescriptionId}, #{passengerId})")
	@Options(useGeneratedKeys = true, keyProperty = "favouriteId")
	int insetFavourite(FavouriteModel reservationModel);

	@Delete("DELETE FROM favourite WHERE favourite_id=#{1}")
	int deleteFavouriteById(long favouriteId);
}
