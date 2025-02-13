package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.view.Window;

public class Controller implements ActionListener{
	
	private Window window;
	private float g = 9.8f;
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
		}
		
	}
	
	public float calcMaxHeight(float initial_velocity, double angle ) {
		
		
		float numerator = (float) (Math.pow(initial_velocity, 2)*Math.pow((Math.sin(angle)),2));
		float denominator = g*2;
		float y_max= numerator/denominator;
		
		return y_max;
	}
	
	
}


