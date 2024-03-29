/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB.Etudiant;

import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantEtape;
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
public class DBEtudiantEtape extends DB<EtudiantEtape> {

    public DBEtudiantEtape(Connection conn) {
	super(conn);
    }

    /**
     * Methode permettant la création d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(EtudiantEtape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(EtudiantEtape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Etudiant
     *
     * @param obj le Departement qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(EtudiantEtape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Etudiant, a partir de l'id passé en parametre.<br>
     *
     * @param id(int) L'idEtudiant de l'Etudiant que l'on souhaite charger
     * @return L'Etudiant correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public EtudiantEtape find(Object id) throws Exception {
        EtudiantEtape e = new EtudiantEtape();

        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_EtudiantEtape where codeEtape = " + id);
        if (result.first()) {
	    e.setNumEtudiant(result.getInt("numEtudiant"));
	    e.setNumIne(result.getString("numIne"));
	    e.setLibelleProvenance(result.getString("libelleProvenance"));
	    e.setLibelleStatut(result.getString("libelleStatut"));
	    e.setLibelleNationalite(result.getString("libelleNationalite"));
	    e.setNom(result.getString("nom"));
	    e.setPrenom(result.getString("prenom"));
	    e.setMail(result.getString("mail"));
	    e.setPointJuryAnnee(result.getInt("pointJuryAnnee"));
            e.setScoreToeic(result.getInt("scoreToeic"));
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
    public ArrayList<EtudiantEtape> list() throws Exception {
        return null;
    }

    /**
     * Methode permettant de lister les EtudiantsEtape appartenant à l'etape id
     * @param id l'etape a laquelle sont inscrits les EtudiantsEtape
     * @return La liste des EtudiantEtape de l'etape id
     * @throws Exception
     */
    public ArrayList<EtudiantEtape> list(String id) throws Exception {
	ArrayList<EtudiantEtape> listeEtud = new ArrayList<EtudiantEtape>();
	Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet result = s.executeQuery("SELECT * from VO_EtudiantEtape where codeEtape = '" + id + "'");
	if (result.first()) {
	    do {
		listeEtud.add(new EtudiantEtape(
			result.getInt("numEtudiant"),
			result.getString("numIne"),
			result.getString("libelleProvenance"),
			result.getString("libelleStatut"),
			result.getString("libelleNationalite"),
			result.getString("nom"),
			result.getString("prenom"),
			result.getString("mail"),
			result.getInt("scoreToeic"),
			result.getFloat("pointJuryAnnee")));
	    } while (result.next());
	}
        s.close();
	return listeEtud;
    }

}
