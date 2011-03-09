/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persist.DB;

import POJO.Etudiant;
import java.sql.*;

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

}
