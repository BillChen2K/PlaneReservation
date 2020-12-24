package cn.edu.ecnu.planereservation.View;

import cn.edu.ecnu.planereservation.Mapper.AirportMapper;
import cn.edu.ecnu.planereservation.Model.AirportModel;
import cn.edu.ecnu.planereservation.Model.UserModel;
import cn.edu.ecnu.planereservation.Util.SpringContextUtil;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.util.ArrayList;

/**
 * Main GUI Class
 *
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 01:12
 **/
@Component
@Slf4j // For logging
public class PlaneReservationGUI extends JFrame {

	@Autowired
	AirportMapper airportMapper;

	@Autowired
	LogInPanel logInPanel;

	MainPanel mainPanel;

	private JLabel lableLoading;
	public PlaneReservationGUI() {
		this.setSize(new Dimension(1200, 800));
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setTitle("Airplane Reservation System || ECNU @BillChen2K & @xiejiadong");
		this.lableLoading = new JLabel("Loading...");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void launch() {
		getContentPane().add(logInPanel);
		logInPanel.setMasterFrame(this);
		this.setVisible(true);
		log.info("Application started.");
	}

	public void performLoggedIn() {
		mainPanel = SpringContextUtil.getBean(MainPanel.class);
		logInPanel.setVisible(false);
		mainPanel.load();
		this.add(mainPanel);
	}
}
