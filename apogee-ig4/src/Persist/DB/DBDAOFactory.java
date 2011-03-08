/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist.DB;

import Persist.AbstractDAOFactory;
import Persist.DAO;
import java.sql.Connection;

/**
 *
 * @author Quentin
 */
public class DBDAOFactory extends AbstractDAOFactory {

    protected static final Connection conn = ConnectDB.getConnection();
    @Override
    public DAO getECUEDAO() {
	return new DBECUEDAO(conn);
    }

    @Override
    public DAO getEleveDAO() {
	return new DBEtudiantDAO(conn);
    }

}
