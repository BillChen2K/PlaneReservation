/*
 * Created by JFormDesigner on Tue Jan 05 22:21:39 CST 2021
 */

package cn.edu.ecnu.planereservation.View.Components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class ConfirmDialog extends JDialog {
	private ConfirmmableFrame confirmmableFrame;
	private int code;
	public ConfirmDialog(String msg, int code, ConfirmmableFrame masterFrame) {
		initComponents();
		labMessage.setText(msg);
		confirmmableFrame = masterFrame;
		this.code = code;
	}

	private void cancelButtonActionPerformed(ActionEvent e) {
		dispose();
	}

	private void okButtonActionPerformed(ActionEvent e) {
		confirmmableFrame.onComfirmed(code);
		dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - unknown
		dialogPane = new JPanel();
		contentPanel = new JPanel();
		labMessage = new JLabel();
		buttonBar = new JPanel();
		okButton = new JButton();
		cancelButton = new JButton();

		//======== this ========
		setTitle("Confirmation");
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== dialogPane ========
		{
			dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
			dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
			javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax
			. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
			.awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
			. Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans.
			PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .
			equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
			dialogPane.setLayout(new BorderLayout());

			//======== contentPanel ========
			{
				contentPanel.setLayout(new BorderLayout());

				//---- labMessage ----
				labMessage.setText("Do you confirm?");
				labMessage.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				contentPanel.add(labMessage, BorderLayout.NORTH);
			}
			dialogPane.add(contentPanel, BorderLayout.CENTER);

			//======== buttonBar ========
			{
				buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
				buttonBar.setLayout(new GridBagLayout());
				((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
				((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

				//---- okButton ----
				okButton.setText("OK");
				okButton.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				okButton.addActionListener(e -> okButtonActionPerformed(e));
				buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 5), 0, 0));

				//---- cancelButton ----
				cancelButton.setText("Cancel");
				cancelButton.setFont(new Font("SF Pro Display", Font.PLAIN, 14));
				cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
				buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
					GridBagConstraints.CENTER, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
			}
			dialogPane.add(buttonBar, BorderLayout.SOUTH);
		}
		contentPane.add(dialogPane, BorderLayout.CENTER);
		setSize(450, 180);
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - unknown
	private JPanel dialogPane;
	private JPanel contentPanel;
	private JLabel labMessage;
	private JPanel buttonBar;
	private JButton okButton;
	private JButton cancelButton;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
