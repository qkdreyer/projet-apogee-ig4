/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.UE;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pierre
 */
public class DBUE extends DB<UE> {

    public DBUE(Connection conn) {
        super(conn);
    }

    public void create(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public UE find(Object id) throws Exception {
        UE ue = new UE();

        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_UE where codeUE = '" + (String) id + "'");
        if (result.first()) {
            ue.setCodeUE(result.getString("codeUE"));
            ue.setNbECTS(result.getInt("nbECTS"));
            ue.setLibelleUE(result.getString("libelleUE"));
            ue.setOptionnel(result.getBoolean("optionnel"));
            ue.setResponsable(result.getString("prenomResponsableUE") + " " + result.getString("nomResponsableUE"));
            ue.setCodeSemestre(result.getString("codeSemestre"));

            do {
                ue.getListeECUE().add(new UE.ECUEUE(
                        result.getString("codeMatiere"),
                        result.getString("libelleECUE"),
                        result.getString("prenomResponsableECUE") + " " + result.getString("nomResponsableECUE")));
            } while (result.next());
        }
        return ue;
    }

}
