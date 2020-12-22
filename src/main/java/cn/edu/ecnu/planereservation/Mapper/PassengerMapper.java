package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.PassengerModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PassengerMapper {

    @Select("SELECT * FROM passenger WHERE username=#{1}")
    PassengerModel selectPassengerByname(String name);

}
