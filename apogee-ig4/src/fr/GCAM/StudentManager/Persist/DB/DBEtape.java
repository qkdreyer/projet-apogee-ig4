/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Etape;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Etape (POJO).
 *
 * @author pierre
 */
public class DBEtape extends DB<Etape> {

    public DBEtape(Connection conn) {
        super(conn);
    }

    public void create(Etape obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Etape obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Etape obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Etape find(Object id) throws Exception {
        Etape etape = new Etape();

        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_Ecue where codeMatiere = '" + (String) id + "'");
        if (result.first()) {
            etape.setCodeEtape(result.getString("codeEtape"));
            etape.setVersionEtape(result.getString("versionEtape"));
            etape.setVersionDiplome(result.getString("versionDiplome"));
            etape.setResponsable(result.getString("prenomResponsable") + " " + result.getString("nomResponsable"));

            String codeSemestre1 = result.getString("codeSemestre");
            Etape.Semestre semestre;
            do {
                if (codeSemestre1.equals(result.getString("codeSemestre"))) {
                    semestre = etape.getSemestre(1);
                } else {
                    semestre = etape.getSemestre(2);
                }
                semestre.setCodeEtape(result.getString("codeEtape"));
                semestre.setCodeSemestre(result.getString("codeSemestre"));
                semestre.setNbUEFacultatives(result.getInt("nbUEFacultatives"));
                semestre.getListeUE().add(new Etape.Semestre.UESemestre(
                        result.getString("codeUE"),
                        result.getString("libelleUE")));
            } while (result.next());
        }
        return etape;
    }
}
