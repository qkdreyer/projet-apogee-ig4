/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.UE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.UI.UI;

/**
 *
 * @author Quentin
 */
public class ControllerUE extends AbstractController {

    private UI disp;
    private DAO<UE> ueDAO;
    private UE ue = null;

    public ControllerUE(UI disp, String s) {
        this.disp = disp;
        ueDAO = AbstractDAOFactory.getDAOFactory(s).getDAOUE();
    }

    /**
     * La classe définit les traitements associés au message<br>
     * -#find<br>
     * -#update<br>
     * -#quit<br>
     * -#help<br>
     *
     * @param message Le message qui sera traité, il doit faire parti de l'ensemble
     * défini ci dessus
     * @return
     * @throws Exception
     */
    public AbstractController handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");

        if (msg[0].equals("#find") && msg.length == 2) { // #find pstia602
            this.find(msg);
        } else if (msg[0].equals("#update")) {
            this.update(msg);
        } else if (msg[0].equals("#quit")) {
            this.quit();
        } else if (msg[0].equals("#help")) {
            this.help();
        }
        return this;
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#find"
     *
     * @param msg(String) Le message contenant les informations à 'find'
     * @throws Exception
     */
    public void find(String[] msg) throws Exception {
        ue = (UE) ueDAO.find(msg[1]);
        disp.display(ue.toString());
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#update"
     *
     * @param msg(String) Le message contenant les informations à 'update'
     * @throws Exception
     */
    public void update(String[] msg) throws Exception {
        ueDAO.update(ue);
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#quit"
     *
     * @throws Exception
     */
    public void quit() {
        System.exit(0);
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#help"
     *
     * @throws Exception
     */
    private void help() {
        disp.display("\t #find 'codeUE'");
        disp.display("\t #update");
        disp.display("\t #quit");
    }
}
