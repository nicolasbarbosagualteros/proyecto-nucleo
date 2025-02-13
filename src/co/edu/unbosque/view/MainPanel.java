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
	
	private JButton exit, restart, done;
	private JTextArea angle, initial_speed,fly_time;
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
		ImageIcon imageIconLblCanon = new ImageIcon(imageLblCanon.getScaledInstance(389, 223, Image.SCALE_SMOOTH));
		canon = new JLabel();
		canon.setIcon(imageIconLblCanon);
		canon.setBounds(-40, 470, 389, 223);
		add(canon);
	
		
		Image imageBtnExit = new ImageIcon(
				"assets/exit.png").getImage();
		ImageIcon imageIconBtnExit = new ImageIcon(imageBtnExit.getScaledInstance(46, 48, Image.SCALE_SMOOTH));
		exit = new JButton();
		exit.setIcon(imageIconBtnExit);
		exit.setToolTipText("Cerrar el aplicativo");
		exit.setBounds(1230, -70, 47, 212);
		exit.setContentAreaFilled(false);
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setVisible(true);
		add(exit);
		
		
		JLabel anglelbl = new JLabel("Ingrese el ángulo de inclinación (°)");
		anglelbl.setBounds(30,10,300,30);
		add(anglelbl);
		angle = new JTextArea();
		angle.setBounds(30, 40, 100, 40);
		angle.setBackground(new Color(231, 233, 234));
		add(angle);
		
		JLabel initspeedlbl = new JLabel("Ingrese la velocidad inicial (m/s)");
		initspeedlbl.setBounds(30,80,300,30);
		add(initspeedlbl);
		initial_speed = new JTextArea();
		initial_speed.setBounds(30, 110, 100, 40);
		initial_speed.setBackground(new Color(231, 233, 234));
		add(initial_speed);
		
		JLabel flyingtime = new JLabel("Ingrese el tiempo de vuelo (s)");
		flyingtime.setBounds(30,150,300,30);
		add(flyingtime);
		fly_time = new JTextArea();
		fly_time.setBounds(30, 180, 100, 40);
		fly_time.setBackground(new Color(231, 233, 234));
		add(fly_time);
		
		
		add(bg);
		
	}
}
