/*
6.b Develop a Swing program in Java to create a Tabbed Pane of RED, BLUE and GREEN 
and display the concerned color whenever the specific tab is selected in the Pane.
*/

package Swings;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneExample {

    JFrame f;

    // Constructor
    TabbedPaneExample() {

        // Create frame
        f = new JFrame("Tabbed Pane Example");

        // Create panels for each tab
        JPanel p1 = new JPanel(); // Blue panel
        JPanel p2 = new JPanel(); // Red panel
        JPanel p3 = new JPanel(); // Green panel

        // Set background colors
        p1.setBackground(Color.BLUE);
        p2.setBackground(Color.RED);
        p3.setBackground(Color.GREEN);

        // Create tabbed pane
        JTabbedPane tp = new JTabbedPane();

        // Add tabs with corresponding panels
        tp.add("BLUE", p1);
        tp.add("RED", p2);
        tp.add("GREEN", p3);

        // Add tabbed pane to frame
        f.add(tp);

        // Frame settings
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null); // center window
        f.setVisible(true);
    }

    public static void main(String[] args) {

        // Run the program
        new TabbedPaneExample();
    }
}
