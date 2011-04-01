/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantECUE;
import fr.GCAM.StudentManager.Business.POJO.*;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.sql.Connection;

/**
 * Cette classe est la fabrique concrete de DAO(Data Access Object) qui
 * interagissent avec la base de données.
 *
 * @author Quentin
 */
public class DBFactory extends AbstractDAOFactory {

    protected static final Connection conn = ConnectionDB.getConnection();
    
    /**
     * Méthode utilisée pour obtenir un objet DAO<ECUE>.
     *
     * @return Renvoie un DAOECUE qui est un DAO concret instancié avec le POJO
     * ECUE.
     */
    public DAO<ECUE> getDAOECUE() {
	return new DBECUE(conn);
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<Etudiant>.
     *
     * @return Renvoie un DAOEtudiant qui est un DAO concret instancié avec le POJO
     * Etudiant.
     */
    public DAO<EtudiantECUE> getDAOEtudiantECUE() {
	return new DBEtudiantECUE(conn);
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<Utilisateur>.
     *
     * @return Renvoie un DAOUtilisateur qui est un DAO concret instancié avec le POJO
     * Utilisateur.
     */
    public DAO<Utilisateur> getDAOUtilisateur() {
	return new DBUtilisateur(conn);
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<UE>.
     *
     * @return Renvoie un DAOUE qui est un DAO concret instancié avec le POJO
     * UE.
     */
    public DAO<UE> getDAOUE() {
        return new DBUE(conn);
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<ECUE>.
     *
     * @return Renvoie un DAOECUE qui est un DAO concret instancié avec le POJO
     * ECUE.
     */
    public DAO<Etape> getDAOEtape() {
        return new DBEtape(conn);
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<Departement>.
     *
     * @return Renvoie un DAODepartement qui est un DAO concret instancié avec le POJO
     * Departement.
     */
    public DAO<Departement> getDAODepartement() {
        return new DBDepartement(conn);
    }

}
