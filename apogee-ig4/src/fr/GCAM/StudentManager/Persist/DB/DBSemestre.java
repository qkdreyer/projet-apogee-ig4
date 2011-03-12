/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Semestre;
import java.sql.Connection;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Semestre
 * (POJO).
 *
 * @author pierre
 */
public class DBSemestre extends DB<Semestre> {

    public DBSemestre(Connection conn) {
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
