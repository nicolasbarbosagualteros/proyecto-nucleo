package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.InputMismatchException;

import co.edu.unbosque.util.exception.EmptyInputException;
import co.edu.unbosque.util.exception.ExceptionChecker;
import co.edu.unbosque.util.exception.InputNotValidException;
import co.edu.unbosque.view.Chronometer;
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
	private Chronometer chronometer;

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

			try {
				String fly = window.getMainPanel().getFly_time().getText();
				String theta_string = window.getMainPanel().getAngle().getText();
				String d = window.getMainPanel().getX_max().getText();
				exception.validateInput(fly);
				exception.validateInput(theta_string);
				exception.validateInput(d);

			} catch (EmptyInputException em) {
				pop.empty();
				return;
			}

			if (Integer.parseInt(window.getMainPanel().getAngle().getText()) > 89||Integer.parseInt(window.getMainPanel().getAngle().getText())  < 1) {
				pop.angle();
				return;
			}

			if (Integer.parseInt(window.getMainPanel().getX_max().getText())> 100||Integer.parseInt(window.getMainPanel().getX_max().getText())< 1) {
				pop.x_distance();
				return;
			}

			if (Integer.parseInt(window.getMainPanel().getFly_time().getText()) > 20||Integer.parseInt(window.getMainPanel().getFly_time().getText())< 1) {
				pop.time();
				return;
			}


			if (window.getMainPanel().getY_max().getText().equals("")) {
				exception.validateNumber(window.getMainPanel().getX_max().getText());
                exception.validateNumber(window.getMainPanel().getFly_time().getText());
                exception.validateNumber(window.getMainPanel().getAngle().getText());

				double theta = Double.parseDouble(window.getMainPanel().getAngle().getText());
				float time = Float.parseFloat(window.getMainPanel().getFly_time().getText());
				float vonum = Float.parseFloat(window.getMainPanel().getX_max().getText());
				float voden = (float) ((Math.cos(Math.toRadians(theta)))*time);
				float vo = calcInitialSpeed(theta,time,vonum,voden);


				window.getMainPanel().getY_max().setText(String.valueOf(calcMaxHeight(vo, theta)));
			}
			rotate();
			window.getMainPanel().getBall().setVisible(true);
			position();

			chronometer = new Chronometer();
			if(window.getMainPanel().getBall().getBounds().getHeight()>570){
				System.out.println("LIMITE");
			}


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

		chronometer.setDefaultCloseOperation(0);

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

	public float calcInitialSpeed(double theta, float time, float vonum, float voden) {
		theta = Double.parseDouble(window.getMainPanel().getAngle().getText());
		time = Float.parseFloat(window.getMainPanel().getFly_time().getText());
		vonum = Float.parseFloat(window.getMainPanel().getX_max().getText());
		voden = (float) ((Math.cos(Math.toRadians(theta)))*time);
		float vo = vonum/voden;
		return vo;
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
				float angle = (float) Math.toRadians(Float.parseFloat(window.getMainPanel().getAngle().getText()));
				float time = Float.parseFloat(window.getMainPanel().getFly_time().getText());
				float vonum = Float.parseFloat(window.getMainPanel().getX_max().getText());
				float voden = (float) ((Math.cos(Math.toRadians(angle)))*time);
				float vo = calcInitialSpeed(angle,time,vonum,voden);
				float cos = (float) Math.cos(angle);
				float sin = (float) Math.sin(angle);
				float g = 9.81f;
				float scaleX = 9f;
				for (float i = 1; i <= time; i += 0.01) {
					int pos_x = Math.round((vo * cos * i) * scaleX) + 250;
					int pos_y = (int) ((int) (Math.round(vo * sin * i) - Math.round((g * i * i) / 2)) * (-1)+ 495);
					if(window.getMainPanel().getBall().getBounds().y>590){
						chronometer.stop();
						pop.notPosible();
						return;
					}
					window.getMainPanel().getBall().setBounds(pos_x, pos_y, 70, 60);
					window.getMainPanel().getBall().repaint();
					Thread.sleep(10);

				}
				chronometer.stop();
				chronometer.validateTime(time);
					sound("assets/explosion.wav",true);
					window.getMainPanel().getBall().setVisible(false);
					window.getMainPanel().getAvatar().setBounds(window.getMainPanel().getBall().getBounds().x,window.getMainPanel().getBall().getBounds().y,144,133);
					window.getMainPanel().getAvatar().setVisible(true);


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
			System.out.println("Error al reproducir sonido de explosión" + ex.getMessage());
		}
	}
}




