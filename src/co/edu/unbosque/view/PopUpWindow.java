package co.edu.unbosque.view;

import javax.swing.JOptionPane;

public class PopUpWindow {

	private JOptionPane angle, empty,distance, input, time;
	
	public void angle() {
		angle.showMessageDialog(null,"Angle can not be greater than 89 ° nor smaller than 0 °");
	}
	
	public void empty() {
		empty.showMessageDialog(null,"Please, fill out angle, time and distance blanks");
	}
	
	public void x_distance() {
		distance.showMessageDialog(null, "Distance can not be greater than 100 m nor smaller than 1 m");
	}
	public void negativeVel(){
		distance.showMessageDialog(null,"Initial velocity can not be negative");
	}

	public void invalidInput(){
		input.showMessageDialog(null,"Invalid input");
	}

	public void time(){
		time.showMessageDialog(null,"Flight can not last more than 20 seconds nor shorter than 1 seconds");
	}
}

