/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Business.Manager;

import fr.GCAM.StudentManager.POJO.Departement;
import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.Persist.DB.ConnectionDB;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Quentin
 */
public class ManagerUtilisateur {

    private DAO<Utilisateur> userDAO = null;
    private Utilisateur user = null;
    private String dao;

    /*public ManagerUtilisateur(String s, String dao) throws Exception {
    userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
    user = userDAO.find(s);
    }*/
    public ManagerUtilisateur(String dao) {
        this.dao = dao;
	userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
    }

    /**
     * Cette fonction affiche la liste des clés primaires (prenom.nom) des Enseignants
     */
    public Utilisateur[] getListLogin() throws Exception {
	ArrayList<Utilisateur> listeUtil = userDAO.list();
	//Utilisateur l[] = null;
	/*int i = 0;
	try {
	    listeUtil = userDAO.list();
	    l = new Utilisateur[listeUtil.size()];
	    for (Utilisateur u : listeUtil) {
		l[i] = u;
		i++;
	    }
	} catch (Exception ex) {
	}
	return l;*/
        return listeUtil.toArray(new Utilisateur[listeUtil.size()]);
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
	    if (user.getNom().equals("root")) {
                response.put("topResponsability", "root");
            } else if (!user.getListeResponsabilites().isEmpty()) {
		response.put("topResponsability", user.getTopResponsability().getLibelle());
		response.put("codeResp", user.getTopResponsability().getCodeResponsabilite());
	    }
	    return response;
	} else {
	    System.out.println("no user");
	    return null;
	}
    }
    
    public void create(Utilisateur u) throws Exception {
        userDAO.create(u);
    }
    
    public void delete(Utilisateur u) throws Exception {
        userDAO.delete(u);
    }
    
    public ArrayList<Responsabilite> getListRespDispo() throws Exception {
        ArrayList<Responsabilite> listeRespDispo = new ArrayList<Responsabilite>();
        Statement s = ConnectionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("select * from table(get_liste_resp(null))");
        if (r.first()) {
            do {
                listeRespDispo.add(new Responsabilite(r.getString("codeResponsabilite"),
                        r.getString("libelle")));
            } while (r.next());
        }
        s.close();
        return listeRespDispo;
    }

    public void update(Utilisateur u) throws Exception {
        userDAO.update(u);
    }

}
