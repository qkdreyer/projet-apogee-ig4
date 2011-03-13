/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.Core.SSParser;
import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.UI.UI;
import java.util.Observable;
import java.util.Observer;

/**
 * Cette classe implemente la partie Controlleur du MVC(Model View Controller).
 *
 * @author Quentin
 */
public class ControllerECUE extends AbstractController implements Observer {

    private UI disp;
    private DAO<ECUE> ecueDAO;
    private ECUE ecue;

    public ControllerECUE(UI disp, String s) {
        this.disp = disp;
        ecueDAO = AbstractDAOFactory.getDAOFactory(s).getDAOECUE();
        ecue = new ECUE();
    }

    /**
     *
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param message
     * @throws Exception
     */
    public AbstractController handleMessage(String message) throws Exception {
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
        } else if (msg[0].equalsIgnoreCase("#createSS")) {
            SSParser.createSS(ecue);
        } else if (msg[0].equalsIgnoreCase("#loadSS") && msg.length == 2) {
            SSParser.loadSS(ecue, msg[1]);
        } else if (msg[0].equals("#help")) {
            this.help();
        }
        return this;
    }

    /**
     *
     * @param msg
     * @throws Exception
     */
    public void note1(String[] msg) throws Exception {
        if (ecue.hasStudent(Integer.parseInt(msg[1]))) {
            ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).setNoteSession1(Float.parseFloat(msg[2]));
            disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).toString());
            handleMessage("#update");
        }
    }

    /**
     *
     * @param msg
     * @throws Exception
     */
    public void note2(String[] msg) throws Exception {
        if (ecue.hasStudent(Integer.parseInt(msg[1]))) {
            ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).setNoteSession2(Float.parseFloat(msg[2]));
            disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).toString());
            handleMessage("#update");
        }
    }

    /**
     *
     * @param msg
     * @throws Exception
     */
    public void find(String[] msg) throws Exception {
        ecue = (ECUE) ecueDAO.find(msg[1]);
        disp.display(ecue.toString());
    }

    /**
     *
     * @param msg
     * @throws Exception
     */
    public void update(String[] msg) throws Exception {
        ecueDAO.update(ecue);
    }

    /**
     * Cette fonction met fin à l'execution du programme.
     */
    public void quit() {
        System.exit(0);
    }

    /**
     * Cette fonction affiche la liste des clés primaires (codeMatiere) des ECUE
     */
    public void list() throws Exception {
        disp.display(ecueDAO.list());
    }

    private void help() {
        disp.display("\t #find 'codeECUE'");
        disp.display("\t #update");
        disp.display("\t #note1 'etudiant' 'note'");
        disp.display("\t #note2 'etudiant' 'note'");
        disp.display("\t #createSS");
        disp.display("\t #loadSS 'fichier'");
        disp.display("\t #quit");
    }

}
