/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.Departement;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;


/**
 * Classe définissant la méthode handleMessage pour un Departement.
 *
 * @author Quentin
 */
public class ControllerDepartement extends AbstractController {

    private DAO<Departement> deptDAO;
    private Departement dept = null;

    public ControllerDepartement() {
        deptDAO = AbstractDAOFactory.getDAOFactory(dao).getDAODepartement();
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
        } else if (msg[0].equals("#down") && msg.length == 2) {
            return new ControllerEtape().handleMessage("#find " + msg[1]);
        }
        return this;
    }


    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#find"
     *
     * @param msg(String) Le message contenant les informations à 'find'
     * @throws Exception
     */
    private void find(String[] msg) throws Exception {
        disp.display(deptDAO.find(msg[1]).toString());
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#update"
     *
     * @param msg(String) Le message contenant les informations à 'update'
     * @throws Exception
     */
    private void update(String[] msg) throws Exception {
        deptDAO.update(dept);
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
        disp.display("\t #find 'versionDiplome'");
        disp.display("\t #update");
        disp.display("\t #quit");
    }
}
