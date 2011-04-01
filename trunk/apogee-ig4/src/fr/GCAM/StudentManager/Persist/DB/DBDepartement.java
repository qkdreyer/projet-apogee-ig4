/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.Business.POJO.Departement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
     * Methode permettant la création d'un Departement
     *
     * @param obj le Departement qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'un Departement
     *
     * @param obj le Departement qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Departement
     *
     * @param obj le Departement qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * REQUETE FAUSSE, La description concerne le fonctionnement théorique de la méthode
     *
     * La fonction, renvoie un POJO Departement, a partir de l'id passé en parametre.<br>
     * @param id (String) La versionDiplome du département que l'on souhaite charger
     * @return Le departement correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public Departement find(Object id) throws Exception {
	Departement dept = new Departement();

        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_Departement where versionDiplome = '" + (String) id + "'");
        if (result.first()) {
            dept.setVersionDiplome(result.getString("versionDiplome"));
            dept.setNomDepartement(result.getString("nomDepartement"));
            dept.setMnemo(result.getString("mnemo"));
	    dept.setListeEtape(new DBEtape(conn).list(result.getString("versionDiplome")));
        }
        s.close();
        return dept;
    }

    /**
     * Methode permettant de lister les departements
     * @return La liste des departements
     * @throws Exception
     */
    public ArrayList<Departement> list() throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
