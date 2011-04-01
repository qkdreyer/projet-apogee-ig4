/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantUE;
import fr.GCAM.StudentManager.Business.POJO.UE;
import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantUE;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type UE
 * (POJO).
 *
 * @author pierre
 */
public class DBUE extends DB<UE> {

    public DBUE(Connection conn) {
        super(conn);
    }

    /**
     * Methode permettant la création d'une UE
     *
     * @param obj le Departement qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'une UE
     *
     * @param obj l'UI qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'une UE
     *
     * @param obj l'UE qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO UE, a partir de l'id passé en parametre.<br>
     *
     * @param id(String) Le codeUE de l'UE que l'on souhaite charger
     * @return L'UE correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public UE find(Object id) throws Exception {
        UE ue = new UE();

        //Creation des statements
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //Récupère l'UE correspondant au codeUE donné
        ResultSet result = s.executeQuery("SELECT * from VO_UE where codeUE = '" + (String) id + "'");

        //enregistrement des données trouvées
        if (result.first()) {
            ue.setCodeUE(result.getString("codeUE"));
            ue.setNbECTS(result.getInt("nbECTS"));
            ue.setLibelleUE(result.getString("libelleUE"));
            ue.setOptionnel(result.getString("optionnel").equals("t") ? true : false);
            ue.setResponsable(result.getString("prenomResponsable") + " " + result.getString("nomResponsable"));
            ue.setCodeSemestre(result.getString("codeSemestre"));
	    //ue.setListeECUE(new DBECUE(conn).list(result.getString("codeUE")));
	    ue.setListeECUE(new DBECUE(conn).list(result.getString("codeUE")));
	    ue.setListeEtud(new DBEtudiantUE(conn).list(result.getString("codeUE")));
        }
        s.close();
        return ue;
    }

    /**
     * Methode permettat de lister les UE
     * @return la liste des UE
     * @throws Exception
     */
    public ArrayList<UE> list() throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant de lister les UE ayant comme semestre parent id
     * @param id le semestre parent des ue qu'on veut selectionner
     * @return La liste des UE ayant pour semestre parent id
     * @throws Exception
     */
    public ArrayList<UE> list(String id) throws Exception {
	ArrayList<UE> list = new ArrayList<UE>();
	Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	ResultSet result = s.executeQuery("SELECT * from VO_UE where codeSemestre = '" + (String) id + "'");
	if (result.first()) {
	    do {
		list.add(new UE(result.getString("codeUE"),
			result.getString("libelleUE"),
			result.getString("prenomresponsable") + " " +
			result.getString("nomresponsable"),
                        result.getInt("nbECTS"),
                        new DBECUE(conn).list(result.getString("codeUE"))));
	    } while (result.next());
	}
        s.close();
	return list;
    }
}
