package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.AirportModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Airport Mapper
 *
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 01:09
 **/
@Mapper
public interface AirportMapper {

	@Select("SELECT * FROM airport")
	ArrayList<AirportModel> selectAllAirports();

	@Select("SELECT * FROM airport WHERE airport_id=#{1}")
	AirportModel selectAirportByAirportId(long airport_id);

	@Select("SELECT * FROM airport WHERE code=#{1}")
	AirportModel selectAirportByCode(String code);


}
