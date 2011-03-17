/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;

/**
 *
 * @author Quentin
 */
public class ManagerUtilisateur {

    private DAO<Utilisateur> userDAO = null;
    private Utilisateur user = null;

    public ManagerUtilisateur(String s, String dao) throws Exception {
        userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
        user = userDAO.find(s);
    }

    /**
     * Methode permettant le log d'un utilisateur.
     *
     * @return
     * @throws Exception
     */
    public void login() throws Exception {
        if (user.getPrenom().equals("root")) {
            //loginAdmin();
        } else if (user.getListeResponsabilites().size() > 0) {
            loginUser(user.getListeResponsabilites().get(user.getListeResponsabilites().size() - 1));
        }
    }

    private void loginUser(Responsabilite r) throws Exception {
        if (r.getLibelle().equals("ECUE")) {
            //new ManagerECUE().handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("UE")) {
            //new ManagerUE().handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("Etape")) {
            //new ManagerEtape().handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("Departement")) {
            //new ManagerDepartement().handleMessage("#find " + r.getCodeResponsabilite());
        }
    }

    /**
     * Cette fonction affiche la liste des clés primaires (prenom.nom) des Enseignants
     */
    private void list() throws Exception {
        for (Utilisateur u : userDAO.list()) {
            
        }
    }

}
