/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Quentin
 */
public class ManagerUtilisateur {

    private DAO<Utilisateur> userDAO = null;
    private Utilisateur user = null;

    /*public ManagerUtilisateur(String s, String dao) throws Exception {
    userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
    user = userDAO.find(s);
    }*/
    public ManagerUtilisateur(String dao) {
	userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
    }

    /**
     * Cette fonction affiche la liste des clés primaires (prenom.nom) des Enseignants
     */
    public Object[] getListLogin() {
	ArrayList<Utilisateur> listeUtil = null;
	String l[] = null;
	int i = 0;
	try {
	    listeUtil = userDAO.list();
	    l = new String[listeUtil.size()];
	    for (Utilisateur u : listeUtil) {
		l[i] = u.getPrenom() + "." + u.getNom();
		i++;
	    }
	} catch (Exception ex) {
	}
	return l;
    }

    /**
     * TODO javadoc
     * @param nom
     * @param prenom
     * @param mdp
     * @return
     */
    public HashMap<String, String> login(String nom, String prenom, String mdp) {
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
	}

	if (user != null) {
	    response.put("nom", user.getNom());
	    response.put("prenom", user.getPrenom());
	    response.put("mail", user.getMail());
	    System.out.println("nom = " + response.get("nom"));
	    if (!user.getListeResponsabilites().isEmpty()) {
		response.put("topResponsability", user.getTopResponsability().getLibelle());
		response.put("codeResp", user.getTopResponsability().getCodeResponsabilite());
	    } else {
		System.out.println("NO RESPONSABILITY");
	    }
	    return response;
	} else {
	    System.out.println("no user");
	    return null;
	}
    }
}
