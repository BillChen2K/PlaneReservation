package cn.edu.ecnu.planereservation.Util;

/**
 * Utility class
 *
 * @author billchen
 * @version 1.0
 * @create 2020-12-23 1:27 上午
 **/
public class Utils {

    public static String minuteToHourFormatter(int minute) {
        if (minute < 60) {
            return String.format("%s min", minute);
        }
        else {
            int hour = minute / 60;
            int min = minute % 60;
            return String.format("%s h %s min", hour, min);
        }

    }
}
