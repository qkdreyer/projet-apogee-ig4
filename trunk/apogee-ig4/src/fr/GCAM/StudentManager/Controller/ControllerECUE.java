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

/**
 * Cette classe implemente la partie Controlleur du MVC(Model View Controller).
 *
 * @author Quentin
 */
public class ControllerECUE extends AbstractController {

    private UI disp;
    private DAO<ECUE> ecueDAO;
    private ECUE ecue = null;

    public ControllerECUE(UI disp, String s) {
        this.disp = disp;
        ecueDAO = AbstractDAOFactory.getDAOFactory(s).getDAOECUE();
    }

    /**
     * La classe définit les traitements associés au message<br>
     * -#find<br>
     * -#update<br>
     * -#quit<br>
     * -#note1<br>
     * -#note2<br>
     * -#createSS<br>
     * -#loadSS<br>
     * -#help<br>
     *
     * @param message Le message qui sera traité, il doit faire parti de l'ensemble
     * défini ci dessus
     * @return
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
     * Methode permettant la modification de la note1 des etudiants d'une ECUE
     *
     * @param msg
     * @throws Exception
     */
    private void note1(String[] msg) throws Exception {
        if (ecue.hasStudent(Integer.parseInt(msg[1]))) {
            ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).setNoteSession1(Float.parseFloat(msg[2]));
            disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).toString());
            handleMessage("#update");
        }
    }

    /**
     * Methode permettant la modification de la note1 des etudiants d'une ECUE
     *
     * @param msg
     * @throws Exception
     */
    private void note2(String[] msg) throws Exception {
        if (ecue.hasStudent(Integer.parseInt(msg[1]))) {
            ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).setNoteSession2(Float.parseFloat(msg[2]));
            disp.display(ecue.getListeEtud().get(Integer.parseInt(msg[1]) - 1).toString());
            handleMessage("#update");
        }
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#find"
     *
     * @param msg(String) Le message contenant les informations à 'find'
     * @throws Exception
     */
    private void find(String[] msg) throws Exception {
        ecue = (ECUE) ecueDAO.find(msg[1]);
        disp.display(ecue.toString());
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#update"
     *
     * @param msg(String) Le message contenant les informations à 'update'
     * @throws Exception
     */
    private void update(String[] msg) throws Exception {
        ecueDAO.update(ecue);
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#quit"
     *
     * @throws Exception
     */
    private void quit() {
        System.exit(0);
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#help"
     *
     * @throws Exception
     */
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
