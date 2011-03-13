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
 * @deprecated
 * @see DBEtape
 * @author pierre
 */
public class DBSemestre extends DB<Semestre> {

    public DBSemestre(Connection conn) {
	super(conn);
    }
    
    /**
     * Methode permettant la création d'un Semestre
     *
     * @param obj le Semestre qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(Semestre obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'un Semestre
     *
     * @param obj le Semestre qui doit être modifié dans la base de données
     * @throws Exception
     */
    public void update(Semestre obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Semestre
     *
     * @param obj le Semestre qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(Semestre obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Semestre, a partir de l'id passé en parametre.<br>
     *
     * @param id(String) L'id du semestre que l'on souhaite charger
     * @return Le semestre correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public Semestre find(Object id) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode renvoyant l'ensemble des clés primaires de la vue correspondante
     *
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
