/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.Core.Displayable;
import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Quentin
 */
public class ControllerECUE implements Observer {

    private Displayable disp;
    private DAO<ECUE> ecueDAO;
    private ECUE ecue;

    public ControllerECUE(Displayable disp, String s) {
        this.disp = disp;
	ecueDAO = AbstractDAOFactory.getDAOFactory(s).getDAOECUE();
        ecue = new ECUE();
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void handleMessage(String message) {
        String[] msg = message.split(" ");

        if (msg[0].equals("#note1") && msg.length == 3) { // #note1 3 12.5
            note1(msg);
        } else if (msg[0].equals("#note2") && msg.length == 3) { // #note1 3 12.5
            note2(msg);
        } else if (msg[0].equals("#find") && msg.length == 2) { // #find pstia602
            find(msg);
        } else if (msg[0].equals("#update")) {
            update(msg);
        } else if (msg[0].equals("#quit")) {
            quit();
        }
    }

    public void note1(String[] msg) {
	if (ecue.hasStudent(Integer.parseInt(msg[1]))) {
            ecue.getListeEtud().get(Integer.parseInt(msg[1])-1).setNoteSession1(Float.parseFloat(msg[2]));
            disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1])-1).toString());
	    handleMessage("#update");
        }
    }

    public void note2(String[] msg) {
	if (ecue.hasStudent(Integer.parseInt(msg[1]))) {
            ecue.getListeEtud().get(Integer.parseInt(msg[1])-1).setNoteSession2(Float.parseFloat(msg[2]));
	    disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1])-1).toString());
	    handleMessage("#update");
	}
    }

    public void find(String[] msg) {
	try {
	    ecue = (ECUE) ecueDAO.find(msg[1]);
            disp.display(ecue.toString());
	} catch (Exception ex) {
	    System.err.println("Erreur : " + ex);
	}
    }

    public void update(String[] msg) {
	try {
	    ecueDAO.update(ecue);
        } catch (Exception ex) {
            System.err.println("Erreur : " + ex);
        }
    }
	
    public void quit() {
	System.exit(0);
    }

}
