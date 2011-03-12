/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Etudiant;
import java.sql.*;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Etudiant
 * (POJO).
 *
 * @author Quentin
 */
public class DBEtudiant extends DB<Etudiant> {

    public DBEtudiant(Connection conn) {
	super(conn);
    }

    public void create(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public Etudiant find(Object id) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
