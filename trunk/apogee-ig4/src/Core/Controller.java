/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import POJO.ECUE;
import Persist.AbstractDAOFactory;
import Persist.DAO;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quentin
 */
public class Controller implements Observer {

    private Displayable disp;
    private DAO ecueDAO;

    public Controller(Displayable disp, String s) {
        this.disp = disp;
	ecueDAO = AbstractDAOFactory.getInstance(s).getECUEDAO();
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void handleMessage(String message) {
        String[] msg = message.split(" ");

        if (message.startsWith("#note1")) { // #note1 3 12.5
            if (msg[1]data.isStudent(Integer.parseInt(msg[1]))) {
                data.setNoteSession1(Integer.parseInt(msg[1]), Float.parseFloat(msg[2]));
                disp.display("Note de " + data.getStudent(Integer.parseInt(msg[1])).getNom()
                        + " " + data.getStudent(Integer.parseInt(msg[1])).getPrenom()
                        + " : " + data.getStudent(Integer.parseInt(msg[1])).getNote1());
            }
        } else if (message.startsWith("#note2")) {
            if (data.isStudent(Integer.parseInt(msg[1]))) {
                data.setNoteSession2(Integer.parseInt(msg[1]), Float.parseFloat(msg[2]));
                disp.display("Note de " + data.getStudent(Integer.parseInt(msg[1])).getNom()
                        + " " + data.getStudent(Integer.parseInt(msg[1])).getPrenom()
                        + " : " + data.getStudent(Integer.parseInt(msg[1])).getNote2());
            }
        } else if (message.startsWith("#find")) {
	    ECUE ec = new ECUE();
            try {
		ec = (ECUE) ecueDAO.find(msg[1]);
                System.out.println("On echeck les resultats");
                System.out.println(ec.toString());
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
            disp.display("Chargement des donnees effectuees.");
        }/* else if (message.equals("#save")) {
            data.save();
            disp.display("Sauvegarde des donnees effectuees.");
        } else if (message.startsWith("#get")) {
            if (data.isStudent(Integer.parseInt(msg[1]))) {
                disp.display("Note de " + data.getStudent(Integer.parseInt(msg[1])).getNom()
                        + " " + data.getStudent(Integer.parseInt(msg[1])).getPrenom()
                        + " : " + data.getStudent(Integer.parseInt(msg[1])).getNote1()
                        + " / " + data.getStudent(Integer.parseInt(msg[1])).getNote2());
            }
        } */else if (message.equals("#quit")) {
            System.exit(0);
        }
    }
}
