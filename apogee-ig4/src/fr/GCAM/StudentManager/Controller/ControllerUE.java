/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.UE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.UI.UI;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Quentin
 */
public class ControllerUE implements Observer {

    private UI disp;
    private DAO<UE> ueDAO;
    private UE ue;

    public ControllerUE(UI disp, String s) {
        this.disp = disp;
        ueDAO = AbstractDAOFactory.getDAOFactory(s).getDAOUE();
        ue = new UE();
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");

        if (msg[0].equals("#find") && msg.length == 2) { // #find pstia602
            this.find(msg);
        } else if (msg[0].equals("#update")) {
            this.update(msg);
        } else if (msg[0].equals("#quit")) {
            this.quit();
        } else if (msg[0].equals("#list")) {
            this.list();
        } else if (msg[0].equals("#help")) {
            this.help();
        }
    }

    public void find(String[] msg) throws Exception {
        ue = (UE) ueDAO.find(msg[1]);
        disp.display(ue.toString());
    }

    public void update(String[] msg) throws Exception {
        ueDAO.update(ue);
    }

    public void quit() {
        System.exit(0);
    }

    /**
     * Cette fonction affiche la liste des clés primaires (codeUE) des UE
     */
    public void list() throws Exception {
        disp.display(ueDAO.list());
    }

    private void help() {
        disp.display("\t #find 'codeUE'");
        disp.display("\t #list");
        disp.display("\t #update");
        disp.display("\t #quit");
    }
}
