package co.edu.unbosque.view;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {

	private MainPanel mainPanel;
	private PanelCanonRotation panelCanonRotation;

	public Window() {
		mainPanel = new MainPanel();
		panelCanonRotation = new PanelCanonRotation();

		setTitle("Projectile motion");
		setSize(1300, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1300, 700);
		layeredPane.setLayout(null);
		add(layeredPane);

		mainPanel.setBounds(0, 0, 1300, 700);
		layeredPane.add(mainPanel, Integer.valueOf(1));

		panelCanonRotation.setBounds(-20, 440, 300, 300);
		layeredPane.add(panelCanonRotation, Integer.valueOf(2));

		setVisible(true);
	}

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public PanelCanonRotation getPanelCanonRotation() {
		return panelCanonRotation;
	}

	public void setPanelCanonRotation(PanelCanonRotation panelCanonRotation) {
		this.panelCanonRotation = panelCanonRotation;
	}
}
