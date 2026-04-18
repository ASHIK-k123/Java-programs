package com.lab;

/*5c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or
“Hour Glass is pressed” depending upon the Jbutton with image either Digital Clock
or Hour Glass is pressed by implementing the event handling mechanism with
addActionListener( ).*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonExample implements ActionListener {

    JLabel label;
    JButton btnClock, btnHourGlass;

    ImageButtonExample() {

        JFrame frame = new JFrame("Image Button Example");

        label = new JLabel();
        label.setBounds(50, 20, 400, 40);
        label.setFont(new Font("Arial", Font.BOLD, 16));

        ImageIcon clockIcon = new ImageIcon("src/com/lab/clock.png");
        ImageIcon hourGlassIcon = new ImageIcon("src/com/lab/hourglass.png");

        btnClock = new JButton(clockIcon);
        btnClock.setBounds(50, 80, 120, 120);

        btnHourGlass = new JButton(hourGlassIcon);
        btnHourGlass.setBounds(200, 80, 120, 120);

        btnClock.addActionListener(this);
        btnHourGlass.addActionListener(this);

        frame.add(btnClock);
        frame.add(btnHourGlass);
        frame.add(label);

        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClock) {
            label.setText("Digital Clock is pressed");
        } else if (e.getSource() == btnHourGlass) {
            label.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}
