package cn.edu.ecnu.planereservation.View;

import cn.edu.ecnu.planereservation.Core.User.User;
import cn.edu.ecnu.planereservation.Util.Shared;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	User currentUser;

	@Autowired
	MainPanel mainPanel;

	private JTextField txtUsername = new JTextField();
	private JTextField txtPassword = new JPasswordField();
	private JButton btnLogIn = new JButton("Log In");
	private JLabel labNotif = new JLabel("");

	@Getter @Setter
	private PlaneReservationGUI masterFrame;

	@Getter Boolean loggedIn = false;

	public LogInPanel() {
		txtUsername.setColumns(12);
		txtPassword.setColumns(12);
		btnLogIn.setPreferredSize(new Dimension(100, 28));
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

		btnLogIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				currentUser.setUsername(txtUsername.getText());
				currentUser.setPassword(txtPassword.getText());
				switch (currentUser.performLogIn()) {
					case (-2):
						log.warn("用户不存在");
						labNotif.setText("用户不存在");
						break;
					case (-1):
						log.warn("密码错误");
						labNotif.setText("密码不正确");
						break;
					default:
						log.info("登录成功。UID = " + currentUser.getUid());
						Shared.user = currentUser;
						loggedIn = true;
						masterFrame.performLoggedIn();
						labNotif.setText("登录成功。UID = " + currentUser.getUid());
				}
			}
		});

		this.setVisible(true);
	}

}
