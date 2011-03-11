/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class DBUtilisateur extends DB<Utilisateur> {

    public DBUtilisateur(Connection conn) {
	super(conn);
    }

    public void create(Utilisateur obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Utilisateur obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Utilisateur obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public Utilisateur find(Object request) throws Exception {
	if (request instanceof ArrayList) {
	    return this.findWithLogin((ArrayList) request);
	} else if (request instanceof Integer) {
	    return this.findWithID((Integer) request);
	} else {
	    return null;
	}
    }

    public Utilisateur findWithID(Integer num) throws Exception {
	Utilisateur util = new Utilisateur();
	ArrayList<Utilisateur.Responsabilite> listeResp;

	Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet result = s.executeQuery("SELECT * from VO_Utilisateur "
		+ "where idEnseignant = " + num);
	if (result.first()) {
	    util.setIdEnseignant(result.getInt(1));
	    util.setNom(result.getString(2));
	    util.setPrenom(result.getString(3));
	    util.setMDP(result.getString(4));

	    listeResp = new ArrayList<Utilisateur.Responsabilite>();
	    do {
		listeResp.add(new Utilisateur.Responsabilite(
			result.getString(5),
			result.getString(6)));
	    } while (result.next());
	    util.setListeResponsabilites(listeResp);
	}
	return util;
    }

    public Utilisateur findWithLogin(ArrayList a) throws Exception {
	Utilisateur util = new Utilisateur();
	ArrayList<Utilisateur.Responsabilite> listeResp;

	Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet result = s.executeQuery("SELECT * from VO_Utilisateur "
		+ "where nom = '" + ((String) ((ArrayList) a).get(1)).toLowerCase() + "' and "
		+ "prenom = '" + ((String) ((ArrayList) a).get(0)).toLowerCase() + "' and "
		+ "mdp = '" + ((String) ((ArrayList) a).get(2)).toLowerCase() + "'");
	if (result.first()) {
	    util.setIdEnseignant(result.getInt(1));
	    util.setNom(result.getString(2));
	    util.setPrenom(result.getString(3));
	    util.setMDP(result.getString(4));

	    listeResp = new ArrayList<Utilisateur.Responsabilite>();
	    do {
		listeResp.add(new Utilisateur.Responsabilite(
			result.getString(5),
			result.getString(6)));
	    } while (result.next());
	    util.setListeResponsabilites(listeResp);
	}
	return util;
    }
}
