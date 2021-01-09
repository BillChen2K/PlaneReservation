package cn.edu.ecnu.planereservation.View.Components;

/**
 * @author billchen
 * @version 1.0
 * @create 2021-01-05 22:35
 **/
public interface ConfirmmableFrame {
	public void onComfirmed(int confirmationCode);
	public default void onCanceled(int cancelCode) {
		return;
	}
}
