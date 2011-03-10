/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.sql.Connection;

/**
 *
 * @author Quentin
 */
public class DBFactory extends AbstractDAOFactory {

    protected static final Connection conn = ConnectionDB.getConnection();
    
    @Override
    public DAO<ECUE> getDAOECUE() {
	return new DBECUE(conn);
    }

    @Override
    public DAO<Etudiant> getDAOEtudiant() {
	return new DBEtudiant(conn);
    }

    @Override
    public DAO<Utilisateur> getDAOUtilisateur() {
	return new DBUtilisateur(conn);
    }

    @Override
    public DAO<UE> getDAOUE(String s) {
        return new DBUE(conn);
    }

    @Override
    public DAO<Etape> getDAOEtape(String s) {
        return new DBEtape(conn);
    }

    @Override
    public DAO<Departement> getDAODepartement(String s) {
        return new DBDepartement(conn);
    }

    @Override
    public DAO<Semestre> getDAOSemestre(String s) {
        return new DBSemestre(conn);
    }

}
