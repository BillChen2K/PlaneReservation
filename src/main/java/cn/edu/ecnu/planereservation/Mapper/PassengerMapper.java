package cn.edu.ecnu.planereservation.Mapper;

import cn.edu.ecnu.planereservation.Model.PassengerModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface PassengerMapper {

    @Select("SELECT * FROM passenger WHERE username=#{1}")
    PassengerModel selectPassengerByname(String name);

    @Select("SELECT * FROM passenger WHERE uid=#{1}")
    ArrayList<PassengerModel> selectPassengersByUid(long uid);

    /**
     * Insert a new passenger. The inserted passenger id will be saved back to the model.
     * @param passengerModel
     * @return The count of successfully inserted rows.
     */
    @Insert("INSERT INTO passenger (name, identity_number, uid, phone) VALUES ( #{name}, #{identityNumber}, #{uid}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "passengerId")
    int insertPassenger(PassengerModel passengerModel);
}
