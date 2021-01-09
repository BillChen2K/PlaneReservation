package cn.edu.ecnu.planereservation;
import cn.edu.ecnu.planereservation.Util.SpringContextUtil;
import cn.edu.ecnu.planereservation.Util.Utils;
import cn.edu.ecnu.planereservation.View.PlaneReservationGUI;

import com.formdev.flatlaf.FlatLightLaf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

@SpringBootApplication
@EnableScheduling
public class PlanereservationApplication {


	public static void main(String[] args) {
		Utils.UIInitialize();
		SpringApplicationBuilder builder = new SpringApplicationBuilder(PlanereservationApplication.class);
		builder.headless(false);
		builder.run(args);
		PlaneReservationGUI app = SpringContextUtil.getBean(PlaneReservationGUI.class);
		app.launch();
	}

}
