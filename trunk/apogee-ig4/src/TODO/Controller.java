/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TODO;

import Core.Displayable;
import Persist.JDBC.DataJDBC;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Quentin
 */
public class Controller implements Observer {

    private Displayable disp;
    private DataJDBC data;

    public Controller(Displayable disp) {
        this.disp = disp;
        data = new DataJDBC();
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void handleMessage(String message) {
        String[] msg = message.split(" ");

        if (message.startsWith("#note1")) { // #note1 3 12.5
            data.setNoteSession1(Integer.parseInt(msg[1]), Float.parseFloat(msg[2]));
            disp.display("Note de " + data.getStudent(Integer.parseInt(msg[1])).getNom()
                    + " " + data.getStudent(Integer.parseInt(msg[1])).getPrenom()
                    + " : " + data.getStudent(Integer.parseInt(msg[1])).getNote1());
        } else if (message.startsWith("#note2")) {
            data.setNoteSession2(Integer.parseInt(msg[1]), Float.parseFloat(msg[2]));
            disp.display("Note de " + data.getStudent(Integer.parseInt(msg[1])).getNom()
                    + " " + data.getStudent(Integer.parseInt(msg[1])).getPrenom()
                    + " : " + data.getStudent(Integer.parseInt(msg[1])).getNote2());
        } else if (message.equals("#load")) {
            data.load();
            disp.display("Chargement des donnees effectuees.");
        } else if (message.equals("#save")) {
            data.save();
            disp.display("Sauvegarde des donnees effectuees.");
        }
    }
}
