/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.ECUE.EtudiantECUE;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

/**
 *
 * @author Quentin
 */
public class DBECUE extends DB<ECUE> {

    public DBECUE(Connection conn) {
        super(conn);
    }

    public void create(ECUE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(ECUE ecue) throws Exception {
        EtudiantECUE etudiant;
        Iterator i = ecue.getListeEtud().iterator();
        while (i.hasNext()) {
            etudiant = (EtudiantECUE) i.next();
            if (etudiant.isNoteSession1Changed()) {
                updateNote1(etudiant.getNumEtud(), ecue.getCodeMatiere(), etudiant.getNoteSession1());
            } else if (etudiant.isNoteSession2Changed()) {
                updateNote2(etudiant.getNumEtud(), ecue.getCodeMatiere(), etudiant.getNoteSession2());
            }
        }
    }

    private void updateNote1(int numEtud, String codeMatiere, float noteSession1) throws Exception {
        this.conn.createStatement().executeUpdate("UPDATE VO_Ecue SET noteSession1 = " + noteSession1
                + " WHERE codeMatiere = '" + codeMatiere
                + "' and numEtudiant = " + numEtud);
    }

    private void updateNote2(int numEtud, String codeMatiere, float noteSession2) throws Exception {
        this.conn.createStatement().executeUpdate("UPDATE VO_Ecue SET noteSession2 = " + noteSession2
                + " WHERE codeMatiere = '" + codeMatiere
                + "' and numEtudiant = " + numEtud);
    }

    public void delete(ECUE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO ECUE, a partir de l'id passé en parametre.<br>
     * Require : <br>
     * Ensure : <br>
     * @param id L'id de l'ecue,
     * @return L'ECUE correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public ECUE find(Object id) throws Exception {
        ECUE ecue = new ECUE();

        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_Ecue where codeMatiere = '" + (String) id + "'");
        if (result.first()) {
            ecue.setCodeMatiere(result.getString(1));
            ecue.setLibelleECUE(result.getString(2));
            ecue.setNbHeures(result.getInt(3));
            ecue.setResponsable(result.getString(4) + " " + result.getString(5));
            ecue.setCodeUE(result.getString(6));

            do {
                ecue.getListeEtud().add(new EtudiantECUE(
                        result.getInt(7),
                        result.getString(8),
                        result.getString(9),
                        result.getFloat(10),
                        result.getFloat(11)));
            } while (result.next());
        }
        return ecue;
    }
}
