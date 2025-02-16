package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanelCanonRotation extends JPanel implements ActionListener {
    private BufferedImage img_canon;
    private JButton btnAngle;
    private JTextArea  angle_txt;
    public PanelCanonRotation() {

        setOpaque(false);
        setLayout(null);
        setPreferredSize(new Dimension(300, 223));

       btnAngle = new JButton("Accept");
        btnAngle.addActionListener(this);
       btnAngle.setBounds(10, 10, 100, 30);
       btnAngle.setVisible(false);
       add(btnAngle);

       angle_txt = new JTextArea();
       angle_txt.setEditable(true);
       angle_txt.setBounds(10, 40, 100, 30);
       angle_txt.setVisible(false);
         add(angle_txt);
        try {
            img_canon = ImageIO.read(new File("assets/canon.png"));
        } catch (IOException e) {
            System.out.println("Canon image not found");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D grp = (Graphics2D) g;
        if (img_canon != null) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            AffineTransform originalTransform = grp.getTransform();
            int theta = 0;
            if(!angle_txt.getText().isEmpty()){
                theta = Integer.parseInt(angle_txt.getText())*(-1);

            }
            grp.rotate(Math.toRadians(theta), centerX, centerY);
            grp.drawImage(img_canon, (getWidth() - 300) / 2, (getHeight() - 223) / 2, 300, 223, this);
            grp.setTransform(originalTransform);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnAngle){
            repaint();
        }
    }

    public JTextArea getAngle_txt() {
        return angle_txt;
    }

    public void setAngle_txt(JTextArea angle_txt) {
        this.angle_txt = angle_txt;
    }

    public JButton getBtnAngle() {
        return btnAngle;
    }

    public void setBtnAngle(JButton btnAngle) {
        this.btnAngle = btnAngle;
    }
}
