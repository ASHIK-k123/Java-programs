package com.lab;
/*5a. Basic hello program of Swing displaying the message Hello! VI C , Welcome to
Swing Programming in Blue color plain font with font size of 32 using Jframe and
Jlabel*/

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

class SwingExample {

    SwingExample() {

        JFrame jfrm = new JFrame("A Simple Swing Application");

        jfrm.setSize(275, 100);

        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel jlab = new JLabel(" Hello! VI C , Welcome to Swing Programming!");

        jlab.setFont(new Font("Verdana", Font.PLAIN, 32));
        jlab.setForeground(new Color(0, 0, 255));

        jfrm.add(jlab);

        jfrm.setVisible(true);
    }

    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingExample();
            }
        });
    }
}
