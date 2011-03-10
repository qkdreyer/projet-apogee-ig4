/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Semestre;
import java.sql.Connection;

/**
 *
 * @author pierre
 */
public class DBSemestreDAO extends DBDAO<Semestre> {

    public DBSemestreDAO(Connection conn) {
	super(conn);
    }
    

    public void create(Semestre obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Semestre obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Semestre obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public Semestre find(Object id) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
