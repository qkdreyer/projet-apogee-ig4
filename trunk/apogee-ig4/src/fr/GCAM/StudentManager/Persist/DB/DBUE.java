/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.UE;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
     * @param id(String) L'id de l'UE que l'on souhaite charger
     * @return L'UE correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public UE find(Object id) throws Exception {
        UE ue = new UE();

        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_UE where codeUE = '" + (String) id + "'");
        if (result.first()) {
            ue.setCodeUE(result.getString("codeUE"));
            ue.setNbECTS(result.getInt("nbECTS"));
            ue.setLibelleUE(result.getString("libelleUE"));
            ue.setOptionnel(result.getString("optionnel").equals("t") ? true : false);
            ue.setResponsable(result.getString("prenomResponsable") + " " + result.getString("nomResponsable"));
            ue.setCodeSemestre(result.getString("codeSemestre"));

            do {
                //ue.getListeECUE().add(new UE.ECUEUE(
                ue.getListeECUE().add(new ECUE(
                        result.getString("codeMatiere"),
                        result.getString("libelleECUE")));
            } while (result.next());
        }
        return ue;
    }

    /**
     * Methode renvoyant l'ensemble des clés primaires de la vue correspondante
     * (ici vo_ue)
     *
     * @return L'ensemble des clés primaires (codeUE) des UE
     * @throws Exception
     * @deprecated 
     */
    public String list() throws Exception {
        String str = "";
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT distinct codeUE from VO_UE");
        if (result.first()) {
            do {
                str = str + result.getString(1) + "\n";
            } while (result.next());
        }
        return str;
    }
}
