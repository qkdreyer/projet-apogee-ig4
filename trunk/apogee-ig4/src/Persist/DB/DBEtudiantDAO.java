/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persist.DB;

import POJO.Etudiant;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class DBEtudiantDAO extends DBDAO<Etudiant> {

    public DBEtudiantDAO(Connection conn) {
	super(conn);
    }

    public void create(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public Etudiant find(Object id) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public ArrayList<Etudiant> load(Object parent) throws Exception { //TODO à refaire
	ArrayList<Etudiant> listeEtudiant = new ArrayList<Etudiant>();
	/*try {

	    Statement select = this.conn.createStatement();
	    ResultSet result = select.executeQuery("SELECT numEtudiant, Nom,"
		    + "Prenom, NoteSession1, NoteSession2 FROM VO_Ecue e, "
		    + "TABLE(e.ListeEtud) WHERE CodeMatiere = '" + (String) parent
		    + "'");

	    while (result.next()) {
		listeEtudiant.add(new Etudiant(result.getInt(1),
			result.getString(2), result.getString(3),
			result.getInt(4), result.getInt(5), (String) parent));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}*/
	return listeEtudiant;
    }
}
