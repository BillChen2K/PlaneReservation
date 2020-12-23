package cn.edu.ecnu.planereservation;
import cn.edu.ecnu.planereservation.Util.SpringContextUtil;
import cn.edu.ecnu.planereservation.View.PlaneReservationGUI;

import com.formdev.flatlaf.FlatLightLaf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

@SpringBootApplication
@Slf4j
public class PlanereservationApplication {


	public static void main(String[] args) {
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
		}
		catch (Exception e) {
			log.error(e.toString());
		}
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PlanereservationApplication.class);
		builder.headless(false);
		builder.run(args);
		PlaneReservationGUI app = SpringContextUtil.getBean(PlaneReservationGUI.class);
		app.launch();
	}

}
