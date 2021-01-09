package cn.edu.ecnu.planereservation.Controller;

import cn.edu.ecnu.planereservation.Core.Exception.UserNotLoggedInException;
import cn.edu.ecnu.planereservation.Mapper.FavouriteMapper;
import cn.edu.ecnu.planereservation.Mapper.FlightMapper;
import cn.edu.ecnu.planereservation.Model.FavouriteModel;
import cn.edu.ecnu.planereservation.Model.FlightDescriptionModel;
import cn.edu.ecnu.planereservation.Model.Joined.FavouriteDetailModel;
import cn.edu.ecnu.planereservation.Model.Joined.FlightTableItem;
import cn.edu.ecnu.planereservation.Util.Shared;
import cn.edu.ecnu.planereservation.View.FavouritePanel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-09 15:09
 **/
@Component
@Slf4j
public class FavouriteController {

	@Autowired
	FavouriteMapper favouriteMapper;

	@Autowired
	FavouritePanel favouritePanel;

	@Autowired
	FlightMapper flightMapper;

	public ArrayList<FavouriteDetailModel> getFavouritesOfCurrentUser() {
		try {
			if (Shared.currentUser == null) {
				throw new UserNotLoggedInException();
			}
			else {
				return favouriteMapper.selectFavouriteDetailsByUid(Shared.currentUser.getUid());
			}
		} catch (UserNotLoggedInException e) {
			log.error(e.getMessage());
		}
		return null;
	}

	public ArrayList<FlightTableItem> getFlightsByDescriptionId(FlightDescriptionModel fdm) {
		return flightMapper.selectFlightDetailsByDescriptionId(fdm.getFlightDescriptionId());
	}

	public void registerFavourite(long flightDescriptionId, long passengerId) {
		FavouriteModel favouriteModel = new FavouriteModel();
		favouriteModel.setFlightDescriptionId(flightDescriptionId).setPassengerId(passengerId)
			.setUid(Shared.currentUser.getUid());
		favouriteMapper.insetFavourite(favouriteModel);
	}

	public void removeFavourite(long favouriteId) {
		favouriteMapper.deleteFavouriteById(favouriteId);
	}
}
