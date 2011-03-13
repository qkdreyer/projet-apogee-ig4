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
 * @deprecated 
 */
public class DBEtudiant extends DB<Etudiant> {

    public DBEtudiant(Connection conn) {
	super(conn);
    }

    /**
     * Methode permettant la création d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Etudiant
     *
     * @param obj le Departement qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Etudiant, a partir de l'id passé en parametre.<br>
     *
     * @param id(int) L'id de l'Etudiant que l'on souhaite charger
     * @return L'Etudiant correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public Etudiant find(Object id) throws Exception {
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
