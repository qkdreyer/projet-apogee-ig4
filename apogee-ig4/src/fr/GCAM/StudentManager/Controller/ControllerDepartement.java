/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.Departement;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.UI.UI;
import java.util.Observable;
import java.util.Observer;


/**
 * Classe définissant la méthode handleMessage pour un Departement.
 *
 * @author Quentin
 */
public class ControllerDepartement extends AbstractController implements Observer {


    private UI disp;
    private DAO<Departement> deptDAO;
    private Departement dept;

    public ControllerDepartement(UI disp, String s) {
        this.disp = disp;
        deptDAO = AbstractDAOFactory.getDAOFactory(s).getDAODepartement();
        dept = new Departement();
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
    private void find(String[] msg) throws Exception {
        dept = (Departement) deptDAO.find(msg[1]);
        disp.display(dept.toString());
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
     * Methodé de l'interface Observer
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Cette fonction affiche la liste des clés primaires (versionDiplome) des Departement
     * @deprecated 
     */
    private void list() throws Exception {
        disp.display(deptDAO.list());
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
