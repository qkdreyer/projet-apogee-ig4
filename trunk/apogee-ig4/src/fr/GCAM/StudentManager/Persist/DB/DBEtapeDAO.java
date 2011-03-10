/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Etape;
import java.sql.Connection;

/**
 *
 * @author pierre
 */
public class DBEtapeDAO extends DBDAO<Etape> {

    public DBEtapeDAO(Connection conn) {
	super(conn);
    }

    public void create(Etape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Etape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Etape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public Etape find(Object id) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
