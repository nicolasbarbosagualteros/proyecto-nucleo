package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame {

	private MainPanel mainPanel;
	
	public Window() {
		mainPanel = new MainPanel();
		setTitle("Tiro parabólico");
		setSize(1300, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		add(mainPanel);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}
	
	
}
