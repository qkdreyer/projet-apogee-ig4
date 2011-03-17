/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	//this.user = us;
    }

    public ManagerUtilisateur(String dao){
        userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
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

    HashMap<String, String> login(String nom, String prenom, String mdp) {
        //Créer un arraylist avec nom, prenom, mdp
        ArrayList<String> request = new ArrayList<String>();
        //ajoute chaque élément
        request.add(nom);
        request.add(prenom);
        request.add(mdp);

        HashMap<String, String> response = new HashMap<String, String>();

        try {//essaie de trouver l'utilisateur correspondant
            user = userDAO.find(request);
        } catch (Exception ex) {//si utilisateur non trouvé
            System.out.println("No user");
            Logger.getLogger(ManagerUtilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (user != null){
            response.put("nom", user.getNom());
            response.put("prenom", user.getPrenom());
            response.put("mail", user.getMail());

            if (!user.getListeResponsabilites().isEmpty()){
                response.put("topResponsability", user.getTopResponsability().getLibelle());
            }else{
                System.out.println("NO RESPONSABILITY");
            }
            return response;
        }else{
            return null;
        }
    }

}
