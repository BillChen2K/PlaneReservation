package cn.edu.ecnu.planereservation.View;

import cn.edu.ecnu.planereservation.Mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

/**
 * Main panel
 *
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:27
 **/
@Component
public class MainPanel extends JPanel {
	@Autowired
    FlightDescriptionMapper flightDescriptionMapper;

	@Autowired
    AirportMapper airportMapper;

	@Autowired
    PassengerMapper passengerMapper;

	@Autowired
    SeatMapper seatMapper;

	@Autowired
    ReservationMapper reservationMapper;

	public MainPanel() {
        add(new JLabel("MAIN PANEL"));
        setVisible(true);
    }

    public void activate() {
        setVisible(true);
    }
}
