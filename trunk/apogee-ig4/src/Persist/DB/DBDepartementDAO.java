/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist.DB;

import POJO.Departement;
import java.sql.Connection;

/**
 *
 * @author pierre
 */
public class DBDepartementDAO extends DBDAO<Departement> {

    public DBDepartementDAO(Connection conn) {
	super(conn);
    }

    public void create(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public Departement find(Object id) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
