/*
6.c Develop a Swing program in Java to add the countries 
USA, India, Vietnam, Canada, Denmark, France, Great Britain, 
Japan, Africa, Greenland, Singapore into a JList and display 
the capital of the countries on console whenever the countries 
are selected on the list.
*/

package Swings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListCountryCapital extends JFrame {

    private JList<String> countryList;

    public JListCountryCapital() {

        // Create list model and add countries
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

        // Create JList
        countryList = new JList<>(listModel);

        // Create a map to store country-capital pairs
        Map<String, String> capitalMap = new HashMap<>();

        capitalMap.put("USA", "Washington D.C.");
        capitalMap.put("India", "New Delhi");
        capitalMap.put("Vietnam", "Hanoi");
        capitalMap.put("Canada", "Ottawa");
        capitalMap.put("Denmark", "Copenhagen");
        capitalMap.put("France", "Paris");
        capitalMap.put("Great Britain", "London");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("Africa", "Addis Ababa"); // as per given output
        capitalMap.put("Greenland", "Nuuk");
        capitalMap.put("Singapore", "Singapore");

        // Add selection listener
        countryList.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {

                    // Get selected countries
                    List<String> selectedCountries = countryList.getSelectedValuesList();

                    // Display capital for each selected country
                    for (String country : selectedCountries) {
                        String capital = capitalMap.get(country);

                        if (capital != null) {
                            System.out.println("Capital of " + country + " is: " + capital);
                        }
                    }
                }
            }
        });

        // Add list to scroll pane
        add(new JScrollPane(countryList));

        // Frame settings
        setTitle("Country-Capital List");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new JListCountryCapital();
    }
}
