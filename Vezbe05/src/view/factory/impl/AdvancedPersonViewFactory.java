package view.factory.impl;

import components.fields.PanelInputComboBox;
import components.fields.PanelInputDate;
import components.fields.PanelInputTextField;
import domain.Gender;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AdvancedPersonViewFactory extends Creator {

    @Override
    public JPanel factoryMethod() {
        {

            JPanel panelTemplate = new JPanel();
            panelTemplate.setLayout(new GridLayout(5, 1));
            panelFirstName = new PanelInputTextField();
            panelLastName = new PanelInputTextField();
            panelDate = new PanelInputDate();
            panelGender = new PanelInputComboBox();

            panelFirstName.setLabels("First name:", "");
            panelLastName.setLabels("Last name:", "");
            panelDate.setLabels("Date of birth", "");
            panelGender.setLabels("Gender:", "");

            List<Gender> genders = new ArrayList<>();
            genders.add(Gender.MALE);
            genders.add(Gender.FEMALE);
            panelGender.initialize(genders);

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
                    panelDate.setLabels("Date of birth", "");
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
}
