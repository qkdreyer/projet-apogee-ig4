/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist.DB;

import POJO.UE;
import java.sql.Connection;

/**
 *
 * @author pierre
 */
public class DBUEDAO extends DBDAO<UE> {

    public DBUEDAO(Connection conn) {
        super(conn);
    }

    public void create(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public UE find(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
