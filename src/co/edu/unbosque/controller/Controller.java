package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.Window;

public class Controller implements ActionListener{
	
	private Window window;
	private float g = 9.81f;
	public Controller() {
		
		window = new Window();
		window.getMainPanel().getExit().addActionListener(this);
		window.getMainPanel().getAccept().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==window.getMainPanel().getExit()) {
			System.exit(0);
		}
		
		if(e.getSource()==window.getMainPanel().getAccept()) {
			if (window.getMainPanel().getY_max().getText().equals("")) {
				float vo = Float.parseFloat( window.getMainPanel().getInitial_speed().getText());
				double theta = Double.parseDouble(window.getMainPanel().getAngle().getText());
				System.out.println(calcMaxHeight(vo, theta));
			}
			if (window.getMainPanel().getX_max().getText().equals("")) {
				float vo = Float.parseFloat( window.getMainPanel().getInitial_speed().getText());
				double theta = Double.parseDouble(window.getMainPanel().getAngle().getText());
				System.out.println(calcMaxReach(vo, theta));
			}
			if (window.getMainPanel().getFly_time().getText().equals("")) {
				float vo = Float.parseFloat( window.getMainPanel().getInitial_speed().getText());
				double theta = Double.parseDouble(window.getMainPanel().getAngle().getText());
				System.out.println(flightTIme(vo, theta));
			}
		}
		
	}
	
	public float calcMaxHeight(float initial_velocity, double angle) {
		
		angle = Math.toRadians(angle);
		float numerator = (float) ((initial_velocity)*(initial_velocity)*Math.sin(angle)*Math.sin(angle));
		float denominator = g*2;
		float y_max= numerator/denominator;
		
		return y_max;
	}
	
	
	public float calcMaxReach(float initial_velocity, double angle) {
		angle = 2*Math.toRadians(angle);
		float numerator = (float) (initial_velocity*initial_velocity*Math.sin(angle));
		float x_max = numerator/g;
		return x_max;
	}
	
	public float flightTIme(float initial_velocity, double angle) {
		angle = Math.toRadians(angle);
		float numerator = (float) (2*initial_velocity*Math.sin(angle));
		float x_max = numerator/g;
		return x_max;
	}
	
}


