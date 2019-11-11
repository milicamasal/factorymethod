package view.factory.impl;

import components.IValue;
import javax.swing.JPanel;

public abstract class Creator {

    JPanel panel;
    IValue panelFirstName;
    IValue panelLastName;
    IValue panelDate;
    IValue panelGender;

    public void create() {
        panel = factoryMethod();
    }

    public abstract JPanel factoryMethod();

    public JPanel getPanel() {
        return panel;
    }

}
