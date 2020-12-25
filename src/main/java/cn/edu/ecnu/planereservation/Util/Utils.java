package cn.edu.ecnu.planereservation.Util;

import com.formdev.flatlaf.FlatLightLaf;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Utility class
 *
 * @author billchen
 * @version 1.0
 * @create 2020-12-23 1:27 上午
 **/
@Slf4j
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

    /**
     * Get arrival datetime by offset duration.
     * @param ddate Departure date string.
     * @param dtime Departure time string.
     * @param duration The flight duration in minutes.
     * @return The formatted arrival datetime string.
     */
    public static String getArrivalDatetime(String ddate, String dtime, int duration) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date departure = new Date();
        try {
            departure = df.parse(ddate + " " + dtime);
        }
        catch (Exception e){
            log.error(Arrays.toString(e.getStackTrace()));
        }
        Calendar offset = Calendar.getInstance();
        offset.setTime(departure);
        offset.add(Calendar.MINUTE, duration);
        return df.format(offset.getTime());
    }

    public static void UIInitialize() {
        // Set font globally
        FontUIResource fontRes = new FontUIResource(new Font("SF Pro Display", Font.PLAIN, 14));
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
//            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        }
        catch (Exception e) {
            log.error(e.toString());
        }
    }

    public static String getRandomNumberString(int length) {
        Random rd = new Random();
        String result = "";
        for (int i = 0; i < length; i++) {
            result += String.valueOf(rd.nextInt(9));
        }
        return result;
    }
}
