package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import view.FrmPersonView;
import view.factory.impl.AdvancedPersonViewFactory;
import view.factory.impl.Creator;
import view.factory.impl.SimplePersonViewFactory;

public class Client {

    Creator creator;

    public Client(Creator c) {
        creator = c;
    }

    void create() {
        creator.create();
    }

    public static void main(String[] args) {
        JFrame main = new JFrame();
        JPanel panel = new FrmPersonView();

        SimplePersonViewFactory spw = new SimplePersonViewFactory();
        Client client = new Client(spw);
        client.create();
        main.add(spw.getPanel());

        main.pack();
        main.setVisible(true);

//            AdvancedPersonViewFactory apv = new AdvancedPersonViewFactory();
//           client = new Client(apv);
//           client.create();
//            main.add(apv.getPanel());
//            main.pack();
//            main.setVisible(true);
    }

}
