package cn.edu.ecnu.planereservation.Mapper;

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
	ArrayList<HashMap<String, String>> selectAllAirports();
}
