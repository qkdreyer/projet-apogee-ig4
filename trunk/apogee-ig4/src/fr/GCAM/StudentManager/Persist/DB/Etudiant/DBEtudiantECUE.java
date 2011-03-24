/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB.Etudiant;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.DB.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Etudiant
 * (POJO).
 *
 * @author Quentin
 */
public class DBEtudiantECUE extends DB<EtudiantECUE> {

    public DBEtudiantECUE(Connection conn) {
	super(conn);
    }

    /**
     * Methode permettant la création d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(EtudiantECUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(EtudiantECUE obj) throws Exception {

    }

    /**
     * Methode permettant la suppression d'un Etudiant
     *
     * @param obj le Departement qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(EtudiantECUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Etudiant, a partir de l'id passé en parametre.<br>
     *
     * @param id(int) L'idEtudiant de l'Etudiant que l'on souhaite charger
     * @return L'Etudiant correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public EtudiantECUE find(Object id) throws Exception {
	EtudiantECUE e = new EtudiantECUE();

	Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	System.out.println("id = " + id);
	ResultSet result = s.executeQuery("SELECT * from VO_EtudiantECUE where numetudiant = " + id);
	if (result.first()) {
	    e.setNumEtudiant(result.getInt("numEtudiant"));
	    e.setNumIne(result.getString("numIne"));
	    e.setLibelleProvenance(result.getString("libelleProvenance"));
	    e.setLibelleStatut(result.getString("libelleStatut"));
	    e.setLibelleNationalite(result.getString("libelleNationalite"));
	    e.setNom(result.getString("nom"));
	    e.setPrenom(result.getString("prenom"));
	    e.setMail(result.getString("mail"));
	    e.setNoteSession1(result.getFloat("noteSession1"));
	    e.setNoteSession2(result.getFloat("noteSession2"));
	}
	return e;
    }

    /**
     * Methode renvoyant l'ensemble des etudiants
     *
     * @return L'ensemble des etudiants
     * @throws Exception
     */
    public ArrayList<EtudiantECUE> list() throws Exception {
	return null;
    }

    /**
     * TODO javadoc
     * @param id
     * @return
     * @throws Exception
     */
    public ArrayList<EtudiantECUE> list(String id) throws Exception {
	ArrayList<EtudiantECUE> listeEtud = new ArrayList<EtudiantECUE>();
	Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	String req_lst = "SELECT * from VO_EtudiantECUE where codeMatiere = '" + id + "'";
	ResultSet result = s.executeQuery(req_lst);
	if (result.first()) {
	    do {
		listeEtud.add(new EtudiantECUE(
			result.getInt("numEtudiant"),
			result.getString("numIne"),
			result.getString("libelleProvenance"),
			result.getString("libelleStatut"),
			result.getString("libelleNationalite"),
			result.getString("nom"),
			result.getString("prenom"),
			result.getString("mail"),
			result.getFloat("noteSession1"),
			result.getFloat("noteSession2")));
	    } while (result.next());
	}
	return listeEtud;
    }
}
