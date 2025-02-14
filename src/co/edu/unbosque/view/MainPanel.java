package co.edu.unbosque.view;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
public class MainPanel extends JPanel {
	
	private JButton exit, restart, accept;
	private JTextArea angle, initial_speed,fly_time,y_max,x_max;
	private JLabel bg,canon;
	
	public MainPanel(){
		
		setOpaque(true);
		setLayout(null);
		setPreferredSize(new Dimension(1300, 700));
		setBackground(new Color(135, 206, 235));
		
		
		Image imageLblBg = new ImageIcon(
				"assets/bg.png").getImage();
		ImageIcon imageIconLblBg = new ImageIcon(imageLblBg.getScaledInstance(1300, 700, Image.SCALE_SMOOTH));
		bg = new JLabel();
		bg.setIcon(imageIconLblBg);
		bg.setBounds(0, 0, 1300, 700);
		
		
		
		Image imageLblCanon = new ImageIcon(
				"assets/canon.png").getImage();
		ImageIcon imageIconLblCanon = new ImageIcon(imageLblCanon.getScaledInstance(300, 223, Image.SCALE_SMOOTH));
		canon = new JLabel();
		canon.setIcon(imageIconLblCanon);
		canon.setBounds(-40, 470, 300, 223);
		add(canon);
	
		
		Image imageBtnExit = new ImageIcon(
				"assets/exit.png").getImage();
		ImageIcon imageIconBtnExit = new ImageIcon(imageBtnExit.getScaledInstance(46, 48, Image.SCALE_SMOOTH));
		exit = new JButton();
		exit.setIcon(imageIconBtnExit);
		exit.setToolTipText("Close app");
		exit.setBounds(1230, -70, 47, 212);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setVisible(true);
		add(exit);
		
		Image imageBtnAceppt = new ImageIcon(
				"assets/btnaceptar.png").getImage();
		ImageIcon imageIconBtnAccept = new ImageIcon(imageBtnAceppt.getScaledInstance(130, 60, Image.SCALE_SMOOTH));
		accept = new JButton();
		accept.setIcon(imageIconBtnAccept);
		accept.setToolTipText("Confirm configuration");
		accept.setBounds(240, 165, 130, 60);
		accept.setContentAreaFilled(false);
		accept.setBorderPainted(false);
		accept.setFocusPainted(false);
		accept.setVisible(true);
		add(accept);
		
		
		Image imageBtnReset = new ImageIcon(
				"assets/restart.png").getImage();
		ImageIcon imageIconReset = new ImageIcon(imageBtnReset.getScaledInstance(170, 60, Image.SCALE_SMOOTH));
		restart = new JButton();
		restart.setIcon(imageIconReset);
		restart.setToolTipText("Reset inputs");
		restart.setBounds(1120, 600, 170, 60);
		restart.setContentAreaFilled(false);
		restart.setBorderPainted(false);
		restart.setFocusPainted(false);
		restart.setVisible(true);
		add(restart);
		
		
		JLabel anglelbl = new JLabel("Enter the tilt angle (°)");
		anglelbl.setBounds(30,10,300,30);
		add(anglelbl);
		angle = new JTextArea();
		angle.setBounds(30, 40, 100, 40);
		angle.setBackground(new Color(231, 233, 234));
		add(angle);
		
		JLabel initspeedlbl = new JLabel("Enter the initial velocity (m/s)");
		initspeedlbl.setBounds(30,80,300,30);
		add(initspeedlbl);
		initial_speed = new JTextArea();
		initial_speed.setBounds(30, 110, 100, 40);
		initial_speed.setBackground(new Color(231, 233, 234));
		add(initial_speed);
		
		JLabel flyingtime = new JLabel("Enter the flight time (s)");
		flyingtime.setBounds(30,150,300,30);
		add(flyingtime);
		fly_time = new JTextArea();
		fly_time.setBounds(30, 180, 100, 40);
		fly_time.setBackground(new Color(231, 233, 234));
		add(fly_time);
		

		JLabel y_speed = new JLabel("Enter the maximum height (m)");
		y_speed.setBounds(250,10,300,30);
		add(y_speed);
		y_max = new JTextArea();
		y_max.setBounds(250, 40, 100, 40);
		y_max.setBackground(new Color(231, 233, 234));
		add(y_max);	
		
		JLabel x_speed = new JLabel("Enter the final position of the ball (m)");
		x_speed.setBounds(250,80,300,30);
		add(x_speed);
		x_max = new JTextArea();
		x_max.setBounds(250, 110, 100, 40);
		x_max.setBackground(new Color(231, 233, 234));
		add(x_max);	
		
		add(bg);
		
	}

	public JButton getExit() {
		return exit;
	}

	public void setExit(JButton exit) {
		this.exit = exit;
	}

	public JButton getRestart() {
		return restart;
	}

	public void setRestart(JButton restart) {
		this.restart = restart;
	}

	public JButton getAccept() {
		return accept;
	}

	public void setAccept(JButton accept) {
		this.accept = accept;
	}

	public JTextArea getAngle() {
		return angle;
	}

	public void setAngle(JTextArea angle) {
		this.angle = angle;
	}

	public JTextArea getInitial_speed() {
		return initial_speed;
	}

	public void setInitial_speed(JTextArea initial_speed) {
		this.initial_speed = initial_speed;
	}

	public JTextArea getFly_time() {
		return fly_time;
	}

	public void setFly_time(JTextArea fly_time) {
		this.fly_time = fly_time;
	}

	public JTextArea getY_max() {
		return y_max;
	}

	public void setY_max(JTextArea y_max) {
		this.y_max = y_max;
	}

	public JTextArea getX_max() {
		return x_max;
	}

	public void setX_max(JTextArea x_max) {
		this.x_max = x_max;
	}

	public JLabel getBg() {
		return bg;
	}

	public void setBg(JLabel bg) {
		this.bg = bg;
	}

	public JLabel getCanon() {
		return canon;
	}

	public void setCanon(JLabel canon) {
		this.canon = canon;
	}
	
	
	
}
