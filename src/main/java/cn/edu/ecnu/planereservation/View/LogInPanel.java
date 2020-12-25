package cn.edu.ecnu.planereservation.View;

import cn.edu.ecnu.planereservation.Controller.UserController;
import cn.edu.ecnu.planereservation.Util.Shared;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Log in Panel
 *
 * @author billchen
 * @version 1.0
 * @create 2020-12-19 02:27
 **/
@Component
@Slf4j
public class LogInPanel extends JPanel{

	@Autowired
	UserController currentUser;

	private JTextField txtUsername = new JTextField();
	private JTextField txtPassword = new JPasswordField();
	private JButton btnLogIn = new JButton("Log In");
	private JLabel labNotif = new JLabel("");

	@Getter @Setter
	private PlaneReservationGUI masterFrame;

	@Getter Boolean loggedIn = false;

	private void tryLogIn(ActionEvent e) {
		currentUser.setUsername(txtUsername.getText());
		currentUser.setPassword(txtPassword.getText());
		labNotif.setVisible(true);
		switch (currentUser.performLogIn()) {
			case (-3):
				log.error("Network error.");
				labNotif.setText("Network error.");
				break;
			case (-2):
				log.warn("User doesn't exist.");
				labNotif.setText("User doesn't exist.");
				break;
			case (-1):
				log.warn("Password is incorrect.");
				labNotif.setText("Password is incorrect.");
				break;
			default:
				log.info("Log in success, UID = " + currentUser.getUid());
				loggedIn = true;
				masterFrame.performLoggedIn();
				labNotif.setVisible(false);
		}
	}

	public LogInPanel() {
		txtUsername.setPreferredSize(new Dimension(200,32));
		txtPassword.setPreferredSize(new Dimension(200, 32));
		btnLogIn.setPreferredSize(new Dimension(120, 32));
		labNotif.setForeground(Color.RED);
		JPanel blank = new JPanel();
		blank.setPreferredSize(new Dimension(1200, 300));
		this.add(blank);

		JPanel pusername = new JPanel();
		pusername.add(new JLabel("Username:"));
		pusername.add(txtUsername);
		pusername.setPreferredSize(new Dimension(1200, 50));

		JPanel ppassword= new JPanel();
		ppassword.add(new JLabel("Password:"));
		ppassword.add(txtPassword);
		ppassword.setPreferredSize(new Dimension(1200, 50));

		JPanel pnotif = new JPanel();
		pnotif.setPreferredSize(new Dimension(1200, 30));
		pnotif.add(labNotif);

		this.add(pusername);
		this.add(ppassword);
		this.add(btnLogIn);
		this.add(pnotif);

		btnLogIn.addActionListener(e -> tryLogIn(e));

		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(e.getKeyCode());
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					tryLogIn(null);
				}
				super.keyReleased(e);
			}
		});

		this.setVisible(true);
	}

}
