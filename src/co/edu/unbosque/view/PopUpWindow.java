package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class PopUpWindow {

	private JOptionPane angle, empty,distance;
	
	public void angle() {
		angle.showMessageDialog(null,"Angle can not be grater than 89 °");
	}
	
	public void empty() {
		empty.showMessageDialog(null,"Please, fill out blanks");
	}
	
	public void x_distance() {
		distance.showMessageDialog(null, "Distance can not be grather than 100 m");
	}
}
