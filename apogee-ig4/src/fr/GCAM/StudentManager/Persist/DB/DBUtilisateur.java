/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.Core.SHA1;
import fr.GCAM.StudentManager.POJO.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Utilsateur
 * (POJO).
 *
 * @author Quentin
 */
public class DBUtilisateur extends DB<Utilisateur> {

    public DBUtilisateur(Connection conn) {
	super(conn);
    }

    /**
     * Methode permettant la création d'un Utilisateur
     *
     * @param obj le Departement qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(Utilisateur obj) throws Exception {
	
    }

    /**
     * Methode permettant la modification d'un Utilisateur
     *
     * @param obj l'Utilisateur qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(Utilisateur obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Utilisateur
     *
     * @param obj l'Utilisateur qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(Utilisateur obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Utilisateur, a partir de l'objet request
     * passé en parametre.<br>
     * Le parametre peut etre de deux types : <br>
     * - Soit un entier, afin de chercher l'utilisateur par son id
     * - Soit un ArrayList de String au format {Prenom, Nom, MDP}
     * La fonction delegue le travail en fonction du type de parametre
     *
     * @param id(int ou ArrayList<String>) L'id de l'Etape que l'on souhaite charger
     * @return L'Etape correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public Utilisateur find(Object request) throws Exception {
	System.out.println("request = " + request);
	if (request instanceof ArrayList) {
	    return this.findWithLogin((ArrayList) request);
	} else if (request instanceof Integer) {
	    return this.findWithID((Integer) request);
	} else {
	    return null;
	}
    }

    /**
     * Methode appelée par la méthode find dans le cas où l'Object était un int.
     *
     * @param num(int) L'id de l'utilisateur à rechercher.
     * @return Renvoie l'utilisateur correspondant ayant comme id 'num'.
     * @throws Exception
     */
    private Utilisateur findWithID(Integer num) throws Exception {
	Utilisateur util = new Utilisateur();
	ArrayList<Utilisateur.Responsabilite> listeResp;

	Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet result = s.executeQuery("SELECT * from VO_Utilisateur "
		+ "where idEnseignant = " + num);
	if (result.first()) {
	    util.setNom(result.getString("nom"));
	    util.setPrenom(result.getString("prenom"));
	    util.setMDP(result.getString("mdp"));
            util.setMail(result.getString("mail"));

	    listeResp = new ArrayList<Utilisateur.Responsabilite>();
	    do {
		listeResp.add(new Utilisateur.Responsabilite(
			result.getString("codeResponsabilite"),
			result.getString("libelle")));
	    } while (result.next());
	    util.setListeResponsabilites(listeResp);
	}
	return util;
    }

    /**
     * Methode appelée par la méthode find dans le cas où l'Object était un ArrayList.
     *
     * @param a(ArrayList<String>) L'ArrayList contenant toutes les informations de l'utilisateur.
     * au format {Prenom, Nom, MDP}
     * @return Renvoie l'utilisateur correspondant ayant comme nom a[0], comme
     * Prenom a[1] et mot de passe [2].
     * @throws Exception
     */
    private Utilisateur findWithLogin(ArrayList a) throws Exception {
	Utilisateur util = new Utilisateur();
	System.out.println("a.toString() = " + a.toString());
	Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	String str = "SELECT lower(nom) as nom, lower(prenom) as prenom, mdp, mail, coderesponsabilite, libelle from VO_Utilisateur "
		+ "where lower(nom) = '" + ((String) a.get(1)).toLowerCase() + "' and "
		+ "lower(prenom) = '" + ((String) a.get(0)).toLowerCase() + "' and "
		+ "mdp = getHash('" + (String) a.get(2) + "')";
	System.out.println("str = " + str);
	ResultSet result = s.executeQuery(str);

//	ResultSet result = s.executeQuery("SELECT * from VO_Utilisateur "
//		+ "where nom = 'testNom' and "
//		+ "prenom = 'testPrenom' and "
//		+ "mdp = getHash('testPass')");


	System.out.println("((String) a.get(1)).toLowerCase() = " + ((String) a.get(1)).toLowerCase());
	System.out.println("((String) a.get(0)).toLowerCase() = " + ((String) a.get(0)).toLowerCase());
	System.out.println("(String) a.get(2) = " + (String) a.get(2));
	if (result.first()) {
	    System.out.println("qd");
	    util.setNom(result.getString("nom"));
	    util.setPrenom(result.getString("prenom"));
	    util.setMDP(result.getString("mdp"));
            util.setMail(result.getString("mail"));

	    do {
		util.getListeResponsabilites().add(new Utilisateur.Responsabilite(
			result.getString("codeResponsabilite"),
			result.getString("libelle")));
	    } while (result.next());
	}
	return util;
    }

    /**
     * Methode renvoyant l'ensemble des clés primaires de la vue correspondante
     * (ici vo_Utilisateur)
     *
     * @return L'ensemble des clés primaires (prenom.nom) des Enseignants
     * @throws Exception
     */
    public String list() throws Exception {
        String str = "";
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT distinct prenom, nom from VO_Utilisateur");
        if (result.first()) {
            do {
                str = str + result.getString("prenom") + "." + result.getString("nom") + "\n";
            } while (result.next());
        }
        return str;
    }
}
