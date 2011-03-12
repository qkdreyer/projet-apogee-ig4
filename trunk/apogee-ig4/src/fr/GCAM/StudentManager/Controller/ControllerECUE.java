/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.UI.UI;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Quentin
 */
public class ControllerECUE implements Observer {

    private UI disp;
    private DAO<ECUE> ecueDAO;
    private ECUE ecue;

    public ControllerECUE(UI disp, String s) {
        this.disp = disp;
        ecueDAO = AbstractDAOFactory.getDAOFactory(s).getDAOECUE();
        ecue = new ECUE();
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");

        if (msg[0].equals("#note1") && msg.length == 3) { // #note1 3 12.5
            this.note1(msg);
        } else if (msg[0].equals("#note2") && msg.length == 3) { // #note1 3 12.5
            this.note2(msg);
        } else if (msg[0].equals("#find") && msg.length == 2) { // #find pstia602
            this.find(msg);
        } else if (msg[0].equals("#update")) {
            this.update(msg);
        } else if (msg[0].equals("#quit")) {
            this.quit();
        } else if (msg[0].equals("#createSpreadsheet")) {
            //createSpreadsheet();
        } else if (msg[0].equals("#loadSpreadsheet")) {
            //loadSpreadsheet();
        }
    }

    public void note1(String[] msg) throws Exception {
        if (ecue.hasStudent(Integer.parseInt(msg[1]))) {
            ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).setNoteSession1(Float.parseFloat(msg[2]));
            disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).toString());
            handleMessage("#update");
        }
    }

    public void note2(String[] msg) throws Exception {
        if (ecue.hasStudent(Integer.parseInt(msg[1]))) {
            ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).setNoteSession2(Float.parseFloat(msg[2]));
            disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).toString());
            handleMessage("#update");
        }
    }

    public void find(String[] msg) throws Exception {
        ecue = (ECUE) ecueDAO.find(msg[1]);
        disp.display(ecue.toString());
    }

    public void update(String[] msg) throws Exception {
        ecueDAO.update(ecue);
    }

    public void quit() {
        System.exit(0);
    }
}
