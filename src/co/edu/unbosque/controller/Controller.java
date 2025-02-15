package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.util.exception.EmptyInputException;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.view.PopUpWindow;
import co.edu.unbosque.view.Window;

public class Controller implements ActionListener {

	private Window window;
	private PopUpWindow pop;
	private float g = 9.81f;
	private ExceptionChecker exception = new ExceptionChecker();

	public Controller() {

		window = new Window();
		pop = new PopUpWindow();
		window.getMainPanel().getExit().addActionListener(this);
		window.getMainPanel().getAccept().addActionListener(this);
		window.getMainPanel().getRestart().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == window.getMainPanel().getExit()) {
			System.exit(0);
		}

		if (e.getSource() == window.getMainPanel().getAccept()) {

			if (window.getMainPanel().getY_max().getText().equals("")) {

				try {
					String vo_string = window.getMainPanel().getInitial_speed().getText();
					String theta_string = window.getMainPanel().getAngle().getText();
					exception.validateInput(vo_string);
					exception.validateInput(theta_string);

				} catch (EmptyInputException em) {
					pop.empty();
					return;
				}
				float vo = Float.parseFloat(window.getMainPanel().getInitial_speed().getText());
				double theta = Double.parseDouble(window.getMainPanel().getAngle().getText());
				if (theta > 89) {
					pop.angle();
					return;
				}
				if (calcMaxHeight(vo, theta) > 100) {
					pop.x_distance();
					return;
				}

				window.getMainPanel().getY_max().setEditable(false);
				window.getMainPanel().getY_max().setText(String.valueOf(calcMaxHeight(vo, theta)));

			}
			if (window.getMainPanel().getX_max().getText().equals("")) {

				try {

					String vo_string = window.getMainPanel().getInitial_speed().getText();
					String theta_string = window.getMainPanel().getAngle().getText();
					exception.validateInput(vo_string);
					exception.validateInput(theta_string);
				} catch (EmptyInputException em) {
					pop.empty();
					return;
				}
				float vo = Float.parseFloat(window.getMainPanel().getInitial_speed().getText());
				double theta = Double.parseDouble(window.getMainPanel().getAngle().getText());

				if (theta > 100) {
					pop.angle();
					return;
				}
				if (calcMaxHeight(vo, theta) > 100) {
					pop.x_distance();
					return;
				} else {
					window.getMainPanel().getX_max().setEditable(false);
					window.getMainPanel().getX_max().setText(String.valueOf(calcMaxReach(vo, theta)));
				}

			}
			if (window.getMainPanel().getFly_time().getText().equals("")) {

				try {

					String vo_string = window.getMainPanel().getInitial_speed().getText();
					String theta_string = window.getMainPanel().getAngle().getText();
					exception.validateInput(vo_string);
					exception.validateInput(theta_string);
				} catch (EmptyInputException e1) {
					pop.empty();
					return;
				}
				float vo = Float.parseFloat(window.getMainPanel().getInitial_speed().getText());
				double theta = Double.parseDouble(window.getMainPanel().getAngle().getText());
				if (theta > 100) {
					pop.angle();
					return;
				}
				if (calcMaxHeight(vo, theta) > 100) {
					pop.x_distance();
					return;
				} else {
					window.getMainPanel().getFly_time().setEditable(false);
					window.getMainPanel().getFly_time().setText(String.valueOf(calcFlightTIme(vo, theta)));
				}
			}
			if (window.getMainPanel().getAngle().getText().equals("")) {
				pop.empty();
			}
		}
		if (e.getSource() == window.getMainPanel().getRestart()) {
			window.getMainPanel().getAngle().setText("");
			window.getMainPanel().getFly_time().setText("");
			window.getMainPanel().getY_max().setText("");
			window.getMainPanel().getX_max().setText("");
			window.getMainPanel().getInitial_speed().setText("");
			window.revalidate();
			window.repaint();
		}

	}

	public float calcMaxHeight(float initial_velocity, double angle) {

		angle = Math.toRadians(angle);
		float numerator = (float) ((initial_velocity) * (initial_velocity) * Math.sin(angle) * Math.sin(angle));
		float denominator = g * 2;
		float y_max = numerator / denominator;

		return y_max;
	}

	public float calcMaxReach(float initial_velocity, double angle) {
		angle = 2 * Math.toRadians(angle);
		float numerator = (float) (initial_velocity * initial_velocity * Math.sin(angle));
		float x_max = numerator / g;
		return x_max;
	}

	public float calcFlightTIme(float initial_velocity, double angle) {
		angle = Math.toRadians(angle);
		float numerator = (float) (2 * initial_velocity * Math.sin(angle));
		float x_max = numerator / g;
		return x_max;
	}

}
