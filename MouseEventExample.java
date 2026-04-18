package com.lab;

/*
5.d Develop a simple Swing program for illustrating mouse operations such as 
mouse down, mouse up, double click, single click with help of a button 
and display the output inside the JFrame.
*/



import javax.swing.*;
import java.awt.event.*;

public class MouseEventExample extends JFrame {

    JButton button;
    JLabel label;

    public MouseEventExample() {

        // Create button
        button = new JButton("Click Me");
        button.setBounds(100, 80, 120, 40);

        // Create label to display messages
        label = new JLabel("Perform Mouse Action", JLabel.CENTER);
        label.setBounds(50, 150, 250, 30);

        // Add mouse listener to button
        button.addMouseListener(new MouseAdapter() {

            // Mouse pressed
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Down Event");
            }

            // Mouse released
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Up Event");
            }

            // Mouse clicked
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    label.setText("Double Click Event");
                } else if (e.getClickCount() == 1) {
                    label.setText("Single Click Event");
                }
            }
        });

        // Add components to frame
        add(button);
        add(label);

        // Frame settings
        setTitle("Mouse Event Demo");
        setSize(350, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MouseEventExample();
    }
}
