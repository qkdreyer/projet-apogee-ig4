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
public class DBUtilisateurDAO extends DBDAO<Utilisateur> {

    public DBUtilisateurDAO(Connection conn) {
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
	Utilisateur util = new Utilisateur();
	ArrayList<Utilisateur.Responsabilite> listeResp;

	Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet result = s.executeQuery("SELECT * from VO_Utilisateur "
		+ "where nom = '" + ((ArrayList) request).get(1) + "' and"
		+ "prenom = '" + ((ArrayList) request).get(0) + "' and"
		+ "mdp = '" + ((ArrayList) request).get(2) + "'");
	if (result.first()) {
	    util.setIdEnseignant(result.getInt(1));
	    util.setPrenom(result.getString(2));
	    util.setNom(result.getString(3));
	    util.setPassword(result.getString(4));

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
