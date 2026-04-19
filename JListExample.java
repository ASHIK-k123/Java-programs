/*
6.a Develop a Swing program in Java to add the countries 
USA, India, Vietnam, Canada, Denmark, France, Great Britain, 
Japan, Africa, Greenland, Singapore into a JList and display 
them on console whenever the countries are selected on the list.
*/

package Swings;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListExample extends JFrame {

    // JList to display countries
    private JList<String> countryList;

    public JListExample() {

        // Create list model and add country elements
        DefaultListModel<String> listModel = new DefaultListModel<>();

        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("Africa");
        listModel.addElement("Greenland");
        listModel.addElement("Singapore");

        // Create JList using model
        countryList = new JList<>(listModel);

        // Add listener to detect selection
        countryList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                // Ensure event is final (not adjusting)
                if (!e.getValueIsAdjusting()) {

                    // Get selected values
                    List<String> selectedValues = countryList.getSelectedValuesList();

                    // Print selected countries to console
                    System.out.println( selectedValues);
                }
            }
        });

        // Add scroll pane to frame
        add(new JScrollPane(countryList));

        // Frame settings
        setTitle("JList Example");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center the window
        setVisible(true);
    }

    public static void main(String[] args) {

        // Run the program
        new JListExample();
    }
}
