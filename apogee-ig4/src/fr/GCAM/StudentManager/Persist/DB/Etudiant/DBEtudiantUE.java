/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB.Etudiant;

import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantUE;
import fr.GCAM.StudentManager.Persist.DB.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Etudiant
 * (POJO).
 *
 * @author Quentin
 */
public class DBEtudiantUE extends DB<EtudiantUE> {

    public DBEtudiantUE(Connection conn) {
	super(conn);
    }

    /**
     * Methode permettant la création d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(EtudiantUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(EtudiantUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Etudiant
     *
     * @param obj le Departement qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(EtudiantUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Etudiant, a partir de l'id passé en parametre.<br>
     *
     * @param id(int) L'idEtudiant de l'Etudiant que l'on souhaite charger
     * @return L'Etudiant correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     * 
     */
    public EtudiantUE find(Object id) throws Exception {
        EtudiantUE e = new EtudiantUE();

        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_EtudiantUE where codeUE = " + id);
        if (result.first()) {
	    e.setNumEtudiant(result.getInt("numEtudiant"));
	    e.setNumIne(result.getString("numIne"));
	    e.setLibelleProvenance(result.getString("libelleProvenance"));
	    e.setLibelleStatut(result.getString("libelleStatut"));
	    e.setLibelleNationalite(result.getString("libelleNationalite"));
	    e.setNom(result.getString("nom"));
	    e.setPrenom(result.getString("prenom"));
	    e.setMail(result.getString("mail"));
        }
        s.close();
        return e;
    }

    /**
     * Methode renvoyant l'ensemble des etudiants
     *
     * @return L'ensemble des etudiants
     * @throws Exception
     */
    public ArrayList<EtudiantUE> list() throws Exception {
        return null;
    }

    /**
     * Methode permettant de lister les EtudiantUE appartenant à l'UE id
     * @param id l'UE a laquelle sont inscrits les EtudiantsUE
     * @return La liste des EtudiantUE de l'ue id
     * @throws Exception
     */
    public ArrayList<EtudiantUE> list(String id) throws Exception {
	ArrayList<EtudiantUE> listeEtud = new ArrayList<EtudiantUE>();
	Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet result = s.executeQuery("SELECT * from VO_EtudiantUE where codeUE = '" + id + "'");
	if (result.first()) {
	    do {
		listeEtud.add(new EtudiantUE(
			result.getInt("numEtudiant"),
			result.getString("numIne"),
			result.getString("libelleProvenance"),
			result.getString("libelleStatut"),
			result.getString("libelleNationalite"),
			result.getString("nom"),
			result.getString("prenom"),
			result.getString("mail"),
			(result.getString("vae").equals("t") ? true : false),
			(result.getString("apdj").equals("t") ? true : false)));
	    } while (result.next());
	}
        s.close();
	return listeEtud;
    }

}
