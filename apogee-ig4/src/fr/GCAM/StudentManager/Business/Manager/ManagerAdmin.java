/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Business.Manager;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;

/**
 *
 * @author Quentin
 */
public class ManagerAdmin {

    private DAO<Utilisateur> userDAO;
    private Utilisateur user = null;

    public ManagerAdmin(String dao) {
        userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
    }

    private void add(String[] msg) throws Exception { // #add Prenom Nom MDP mail codeResp1 libelle1 codeResN libelleN
        user = new Utilisateur();
        user.setPrenom(msg[1]);
        user.setNom(msg[2]);
        user.setMDP(msg[3]);
        user.setMail(msg[4]);
        for(int i = 5; i < (msg.length-5)/2; i++) {
            user.getListeResponsabilites().add(new Responsabilite(msg[i], msg[i+1]));
        }
        userDAO.create(user);
    }

    private void delete(String[] msg) throws Exception {
        user = new Utilisateur();
        user.setPrenom(msg[1]);
        user.setNom(msg[2]);
        userDAO.delete(user);
    }

    private void list() throws Exception {
        for(Utilisateur u : userDAO.list()) {
            
        }
    }
}
