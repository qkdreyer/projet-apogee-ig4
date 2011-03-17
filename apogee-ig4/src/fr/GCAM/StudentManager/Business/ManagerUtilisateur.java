/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.BusinessLayer;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class ManagerUtilisateur extends AbstractManager {

    private DAO<Utilisateur> userDAO;
    private Utilisateur user = null;

    public ManagerUtilisateur(String dao) {
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
    /*public String handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");
        ArrayList<String> userInformation = new ArrayList<String>();
        AbstractManager contr = this;

        if (msg[0].equals("#login") && msg.length == 3) {
            if (msg[1].split("\\.").length == 2) {
                userInformation.add(msg[1].split("\\.")[0]);
                userInformation.add(msg[1].split("\\.")[1]);
                userInformation.add(msg[2]);
                user = (Utilisateur) userDAO.find(userInformation);
            }
        } else if (msg[0].equals("#help")) {
            this.help();
        } else if (msg[0].equals("#quit")) {
            this.quit();
        } else if (msg[0].equals("#list")) {
            this.list();
        }
    }*/

    /**
     * Methode permettant le log d'un utilisateur.
     *
     * @return
     * @throws Exception
     */
    public AbstractManager login() throws Exception {
        if (user.getPrenom().equals("root")) {
            return loginAdmin();
        } else if (user.getListeResponsabilites().size() > 0) {
            return loginUser(user.getListeResponsabilites().get(user.getListeResponsabilites().size() - 1));
        } else {
            return null;
        }
    }

    private AbstractManager loginAdmin() {
        return new ManagerAdmin();
    }

    private AbstractManager loginUser(Responsabilite r) throws Exception {
        /*if (r.getLibelle().equals("ECUE")) {
            return new ManagerECUE().handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("UE")) {
            return new ManagerUE().handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("Etape")) {
            return new ManagerEtape().handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("Departement")) {
            return new ManagerDepartement().handleMessage("#find " + r.getCodeResponsabilite());
        } else {*/
            return null;
        //}
    }

    /**
     * Cette fonction affiche la liste des clés primaires (prenom.nom) des Enseignants
     */
    private void list() throws Exception {
        for (Utilisateur u : userDAO.list()) {
            
        }
    }

}
