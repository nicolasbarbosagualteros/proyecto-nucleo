package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chronometer extends JFrame {
    private JLabel lblTime;
    private Timer timer;
    private int seconds = 1;

    public Chronometer() {
        setTitle("Chronometer");
        setSize(300, 200);
        setResizable(false);
        lblTime = new JLabel(BorderLayout.CENTER);
        lblTime.setSize(250, 30);
        add(lblTime);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seconds++;
                timeCounter();

            }
        });

        timer.start();
        timeCounter();

        setVisible(true);

    }

    private void timeCounter() {
        int seconds_elapsed = seconds % 60;
        lblTime.setText(seconds_elapsed+" seconds");
    }

    public void validateTime(float n){
        if(seconds>n){
            stop();
        }
    }

    public void stop() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }

    public JLabel getLblTime() {
        return lblTime;
    }

    public void setLblTime(JLabel lblTime) {
        this.lblTime = lblTime;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}

