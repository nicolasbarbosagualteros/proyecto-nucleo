package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class PopUpWindow {

	private JOptionPane angle, empty,distance;
	
	public void angle() {
		angle.showMessageDialog(null,"Angle can not be greater than 89 ° nor smaller than 0 °");
	}
	
	public void empty() {
		empty.showMessageDialog(null,"Please, fill out angle and initial velocity blanks");
	}
	
	public void x_distance() {
		distance.showMessageDialog(null, "Distance can not be greater than 100 m");
	}
	public void negativeVel(){
		distance.showMessageDialog(null,"Initial velocity can not be negative");
	}
}

