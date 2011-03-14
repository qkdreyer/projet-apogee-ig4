/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Quentin
 */
public class DBAdmin extends DB<Admin> {

    public DBAdmin(Connection conn) {
        super(conn);
    }

    public void create(Admin a) throws Exception {
        //TODO a.getListeUtil().add(new DBUtilisateur(conn).)
    }

    public void update(Admin obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Admin obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Admin.<br>
     * Require : <br>
     * Ensure : <br>
     * @param id null
     * @return La liste des utilisateurs
     * @throws Exception
     */
    public Admin find(Object id) throws Exception {
        Admin a = new Admin();

	Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("select distinct idenseignant from VO_Utilisateur");
        if (result.first()) {
            do {
                a.getListeUtil().add(new DBUtilisateur(conn).find(result.getInt("idEnseignant")));
            } while (result.next());
        }
	
	return a;
    }

    public String list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
