/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Admin;
import java.sql.Connection;

/**
 *
 * @author Quentin
 */
public class DBAdmin extends DB<Admin> {

    public DBAdmin(Connection conn) {
        super(conn);
    }

    public void create(Admin obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Admin obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Admin obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Admin find(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
