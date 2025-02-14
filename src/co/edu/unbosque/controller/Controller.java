package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.util.exception.EmptyInputException;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.view.PopUpWindow;
import co.edu.unbosque.view.Window;

public class Controller implements ActionListener{
	
	private Window window;
	private PopUpWindow pop;
	private float g = 9.81f;
	private ExceptionChecker exception = new ExceptionChecker();
	
	public Controller() {
		
		window = new Window();
		pop = new PopUpWindow();
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
				float vo = Float.parseFloat(window.getMainPanel().getInitial_speed().getText());
				double theta = Double.parseDouble(window.getMainPanel().getAngle().getText());
				try {
					String double_string = Double.toString(theta);
					float double_float = Float.parseFloat(double_string);
					exception.validateInput(double_float);
					exception.validateInput(vo);
				} catch (EmptyInputException em) {
					em.getMessage();
				}
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
				System.out.println(calcFlightTIme(vo, theta));
			}if (window.getMainPanel().getAngle().getText().equals("")) {
				pop.angle();
			}
		}}
		
	
	
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
	
	public float calcFlightTIme(float initial_velocity, double angle) {
		angle = Math.toRadians(angle);
		float numerator = (float) (2*initial_velocity*Math.sin(angle));
		float x_max = numerator/g;
		return x_max;
	}
	

	
	
}


