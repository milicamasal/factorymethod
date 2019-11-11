
package view.factory.impl;

import components.IValue;
import components.fields.PanelInputTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author student1
 */
public class SimplePersonViewFactory extends Creator {

    @Override
    public JPanel factoryMethod() {
        JPanel panelTemplate = new JPanel();
        panelTemplate.setLayout(new GridLayout(5, 1));
        panelFirstName = new PanelInputTextField();
        panelLastName = new PanelInputTextField();
        panelDate = new PanelInputTextField();
        panelGender = new PanelInputTextField();

        panelFirstName.setLabels("First name:", "");
        panelLastName.setLabels("Last name:", "");
        panelDate.setLabels("Date:", "Format must be: 31.12.2019");
        panelGender.setLabels("Gender:", "");

        panelTemplate.add((JPanel) panelFirstName);
        panelTemplate.add((JPanel) panelLastName);
        panelTemplate.add((JPanel) panelDate);
        panelTemplate.add((JPanel) panelGender);

        JButton btnSubmit = new JButton("Submit");
        panelTemplate.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                panelFirstName.setLabels("First name:", "");
                panelLastName.setLabels("Last name:", "");
                panelDate.setLabels("Date of birth:", "");
                panelGender.setLabels("Gender:", "");
                int f = 0;
                if (panelFirstName.getValue().toString().isEmpty()) {
                    f = 1;
                    panelFirstName.setLabels("First name: ", "Enter first name!");
                }

                if (panelLastName.getValue().toString().isEmpty()) {
                    f = 1;
                    panelLastName.setLabels("Last name", "Enter last name!");
                }
                if (!panelGender.getValue().equals("male") && !panelGender.getValue().equals("female")) {
                    panelGender.setLabels("Gender", "Gender must be male or female!");
                    f = 1;
                }

                String input = panelDate.getValue().toString();

                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

                java.util.Date textFieldAsDate = null;
                try {
                    if (input.length() != 10) {
                        f = 1;
                    }
                    if (!input.matches("[0-3][0-9].[01][0-9].[12][0-9][0-9][0-9]")) {
                        f = 1;
                    }
                    textFieldAsDate = sdf.parse(input);
                } catch (ParseException ex) {
                    panelDate.setLabels("Date of birth", "Format must be: 31.12.2019");
                    f = 1;
                }

                String personString = "";
                personString = " First name " + panelFirstName.getValue().toString() + " Last name " + panelLastName.getValue().toString() + " Gender " + panelGender.getValue().toString() + " Date " + panelDate.getValue().toString();
                
                if (f == 0) {
                    JOptionPane.showMessageDialog(null, personString);
                }

            }
        });

        return panelTemplate;
    }

}
