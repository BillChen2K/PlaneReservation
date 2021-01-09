package cn.edu.ecnu.planereservation.Core.Exception;

/**
 * @author billchen
 * @version 1.0
 * @create 2020-12-24 01:00
 **/
public class UserNotLoggedInException extends Exception{
    public UserNotLoggedInException() {
        super("User not logged in");
    }
}
