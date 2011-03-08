/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist.DB;

import Persist.DAO;
import java.sql.Connection;

/**
 *
 * @author Quentin
 */
public abstract class DBDAO<T> implements DAO<T> {

    protected Connection conn = null;

    public DBDAO(Connection conn) {
	this.conn = conn;
    }

}
