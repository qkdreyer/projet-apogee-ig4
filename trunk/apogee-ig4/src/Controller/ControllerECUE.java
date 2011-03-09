/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Core.Displayable;
import POJO.ECUE;
import Persist.AbstractDAOFactory;
import Persist.DAO;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Quentin
 */
public class ControllerECUE implements Observer {

    private Displayable disp;
    private DAO ecueDAO;
    private ECUE ecue;

    public ControllerECUE(Displayable disp, String s) {
        this.disp = disp;
	ecueDAO = AbstractDAOFactory.getInstance(s).getECUEDAO();
        ecue = new ECUE();
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void handleMessage(String message) {
        String[] msg = message.split(" ");

        if (message.startsWith("#note1")) { // #note1 3 12.5
            if (ecue.isStudent(Integer.parseInt(msg[1]))) {
                ecue.getListeEtud().get(Integer.parseInt(msg[1])-1).setNoteSession1(Float.parseFloat(msg[2]));
                disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1])-1).toString());
		handleMessage("#update");
            }
        } else if (message.startsWith("#note2")) {
            if (ecue.isStudent(Integer.parseInt(msg[1]))) {
                ecue.getListeEtud().get(Integer.parseInt(msg[1])-1).setNoteSession2(Float.parseFloat(msg[2]));
                disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1])-1).toString());
		handleMessage("#update");
            }
        } else if (message.startsWith("#find")) {
            try {
		ecue = (ECUE) ecueDAO.find(msg[1]);
                disp.display(ecue.toString());
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
        } else if (message.equals("#update")) {
            try {
                ecueDAO.update(ecue);
                //disp.display("Sauvegarde des donnees effectuees.");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (message.equals("#quit")) {
            System.exit(0);
        }
    }
}
