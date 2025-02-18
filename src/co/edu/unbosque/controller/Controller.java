package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import co.edu.unbosque.util.exception.EmptyInputException;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.view.PopUpWindow;
import co.edu.unbosque.view.Window;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Controller implements ActionListener {

	private Window window;
	private PopUpWindow pop;
	private float g = 9.81f;
	private ExceptionChecker exception = new ExceptionChecker();
	private Clip audio;

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

			if(!window.getMainPanel().getX_max().getText().isEmpty()){
				window.getMainPanel().getX_max().setText("");
				window.getMainPanel().getY_max().setText("");
				window.getMainPanel().getFly_time().setText("");
			}

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

				if(Integer.parseInt(window.getMainPanel().getInitial_speed().getText())<0){
					pop.negativeVel();
					return;
				}
				if (theta > 89||theta < 0) {
					pop.angle();
					return;
				}
				if (calcMaxReach(vo, theta) > 100) {
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

				if(Integer.parseInt(window.getMainPanel().getInitial_speed().getText())<0){
					pop.negativeVel();
					return;
				}

				if (theta > 89||theta < 0) {
					pop.angle();
					return;
				}
				if (calcMaxReach(vo, theta) > 100) {
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
				if(Integer.parseInt(window.getMainPanel().getInitial_speed().getText())<0){
					pop.negativeVel();
					return;
				}
				if (theta > 89||theta < 0) {
					pop.angle();
					return;
				}
				if (calcMaxReach(vo, theta) > 100) {
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
			boolean rot = rotate();
			if (rot==true) {

			} else {
				return;
			}
			window.getMainPanel().getBall().setVisible(true);
			position();


		}

		if (e.getSource() == window.getMainPanel().getRestart()) {
			window.getMainPanel().getFly_time().setText("");
			window.getMainPanel().getAngle().setText("");
			window.getMainPanel().getInitial_speed().setText("");
			window.getMainPanel().getX_max().setText("");
			window.getMainPanel().getY_max().setText("");
			window.getMainPanel().getBall().setVisible(false);
			window.getMainPanel().getAvatar().setVisible(false);

			window.getPanelCanonRotation().getAngle_txt().setText("0");
			window.getPanelCanonRotation().getBtnAngle().doClick();

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

	public boolean rotate(){
		if(!window.getMainPanel().getAngle().getText().equals("")){
			window.getPanelCanonRotation().getAngle_txt().setText(window.getMainPanel().getAngle().getText());
			window.getPanelCanonRotation().getBtnAngle().doClick();
			return true;
		}else {
			return false;
		}

			}
	public void position() {
		new Thread(() -> {
			try {
				float flyTime = Float.parseFloat(window.getMainPanel().getFly_time().getText());
				float vo = Float.parseFloat(window.getMainPanel().getInitial_speed().getText());
				float angle = (float) Math.toRadians(Float.parseFloat(window.getMainPanel().getAngle().getText()));
				float cos = (float) Math.cos(angle);
				float sin = (float) Math.sin(angle);
				float g = 9.81f;
				float scaleX = 9f;
				for (float i = 1; i <= flyTime; i += 0.1) {
					int pos_x = Math.round((vo * cos * i) * scaleX) + 250;
					int pos_y = (int) (Math.round(vo * sin * i) - Math.round((g * i * i) / 2)) * (-1) + 495;
					window.getMainPanel().getBall().setBounds(pos_x, pos_y, 70, 60);
					window.getMainPanel().getBall().repaint();
					Thread.sleep(10);
					window.getMainPanel().getBall().setBounds(pos_x, 560, 70, 60);

				}
				if(window.getMainPanel().getBall().getBounds().y==560){
					sound("assets/explosion.wav",true);
					window.getMainPanel().getBall().setVisible(false);
					window.getMainPanel().getAvatar().setVisible(true);

				}


			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();


	}

	public void sound(String nombreArchivo,boolean music) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreArchivo).getAbsoluteFile());
			audio = AudioSystem.getClip();
			audio.open(audioInputStream);
			audio.start();
			audioInputStream.close();
		}
		catch (Exception ex) {
			System.out.println("Error al reproducir la música= " + ex.getMessage());
		}
	}
}




