/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Departement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Departement
 * (POJO).
 *
 * @author pierre
 */
public class DBDepartement extends DB<Departement> {

    public DBDepartement(Connection conn) {
	super(conn);
    }

    /**
     *
     * @param obj
     * @throws Exception
     */
    public void create(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param obj
     * @throws Exception
     */
    public void update(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @param obj
     * @throws Exception
     */
    public void delete(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * 
     * @param id
     * @return
     * @throws Exception
     */
    public Departement find(Object id) throws Exception {
	Departement dept = new Departement();

        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_Ecue where codeMatiere = '" + (String) id + "'");
        if (result.first()) {
            dept.setVersionDiplome(result.getString("versionDiplome"));
            dept.setNomDepartement(result.getString("nomDepartement"));
            dept.setMnemo(result.getString("mnemo"));

            do {
                dept.getListeEtape().add(new Departement.EtapeDepartement(
                        result.getString("codeEtape"),
                        result.getString("libelleEtape")));
            } while (result.next());
        }
        return dept;
    }

}
