/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.UI.UI;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class ControllerUtilisateur extends AbstractController {

    private DAO<Utilisateur> userDAO;
    private Utilisateur user = null;

    public ControllerUtilisateur(UI disp, String dao) {
        this.disp = disp;
        System.out.println("t:"+disp);
        this.dao = dao;
        this.userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
    }

    /**
     * La classe définit les traitements associés au message<br>
     * -#login<br>
     * -#list<br>
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
        ArrayList<String> userInformation = new ArrayList<String>();
        AbstractController contr = this;

        if (msg[0].equals("#login") && msg.length == 3) {
            if (msg[1].split("\\.").length == 2) {
                userInformation.add(msg[1].split("\\.")[0]);
                userInformation.add(msg[1].split("\\.")[1]);
                userInformation.add(msg[2]);
                user = (Utilisateur) userDAO.find(userInformation);
                contr = this.login();
            }
        } else if (msg[0].equals("#help")) {
            this.help();
        } else if (msg[0].equals("#quit")) {
            this.quit();
        } else if (msg[0].equals("#list")) {
            this.list();
        }
        return contr;
    }

    /**
     * Méthode appelé par handleMessage lorsque le message vaut "#help"
     *
     * @throws Exception
     */
    private void help() {
        disp.display("\t #login username password");
        disp.display("\t #list");
        disp.display("\t #quit");
    }

    /**
     * Methode permettant le log d'un utilisateur.
     *
     * @return
     * @throws Exception
     */
    public AbstractController login() throws Exception {
        if (user.getPrenom().equals("root")) {
            return loginAdmin();
        } else if (user.getListeResponsabilites().size() > 0) {
            return loginUser(user.getListeResponsabilites().get(user.getListeResponsabilites().size() - 1));
        } else {
            return null;
        }
    }

    private AbstractController loginAdmin() {
        return new ControllerAdmin();
    }

    private AbstractController loginUser(Responsabilite r) throws Exception {
        if (r.getLibelle().equals("ECUE")) {
            return new ControllerECUE().handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("UE")) {
            return new ControllerUE().handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("Etape")) {
            return new ControllerEtape().handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("Departement")) {
            return new ControllerDepartement().handleMessage("#find " + r.getCodeResponsabilite());
        } else {
            return null;
        }
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
     * Cette fonction affiche la liste des clés primaires (prenom.nom) des Enseignants
     */
    private void list() throws Exception {
        for (Utilisateur u : userDAO.list()) {
            disp.display(u.getPrenom() + "." + u.getNom());
        }
    }

}
