/*
6.d Develop a Swing program in Java to create a Tabbed Pane of 
Cyan, Magenta and Yellow and display the concerned color 
whenever the specific tab is selected in the Pane.
*/

package Swings;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedPaneCMY {

    JFrame frame;

    // Constructor
    TabbedPaneCMY() {

        // Create frame
        frame = new JFrame("Tabbed Pane - CMY Colors");

        // Create panels for each tab
        JPanel cyanPanel = new JPanel();
        JPanel magentaPanel = new JPanel();
        JPanel yellowPanel = new JPanel();

        // Set background colors
        cyanPanel.setBackground(Color.CYAN);
        magentaPanel.setBackground(Color.MAGENTA);
        yellowPanel.setBackground(Color.YELLOW);

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add tabs with corresponding panels
        tabbedPane.add("CYAN", cyanPanel);
        tabbedPane.add("MAGENTA", magentaPanel);
        tabbedPane.add("YELLOW", yellowPanel);

        // Add tabbed pane to frame
        frame.add(tabbedPane);

        // Frame settings
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // center window
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        // Run the program
        new TabbedPaneCMY();
    }
}
