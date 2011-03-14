/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Etape;
import fr.GCAM.StudentManager.POJO.UE;
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

    /**
     * Methode permettant la création d'une Etape
     *
     * @param obj l'Etape qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(Etape obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'une Etape
     *
     * @param obj l'Etape qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(Etape obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'une Etape
     *
     * @param obj l'Etape qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(Etape obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Etape, a partir de l'id passé en parametre.<br>
     *
     * @param id(String) Le codeEtape de l'Etape que l'on souhaite charger
     * @return L'Etape correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public Etape find(Object id) throws Exception {
        Etape etape = new Etape();

        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_Etape where codeEtape = '" + (String) id + "'");
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
                //semestre.getListeUE().add(new Etape.Semestre.UESemestre(
                semestre.getListeUE().add( new DBUE(conn).find(result.getString("codeUE")));
            } while (result.next());
        }
        return etape;
    }

    /**
     * Methode renvoyant l'ensemble des clés primaires de la vue correspondante
     * (ici vo_etape)
     *
     * @return L'ensemble des clés primaires (codeEtape) des Etape
     * @throws Exception
     * @deprecated 
     */
    public String list() throws Exception {
        String str = "";
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT distinct codeEtape from VO_Etape");
        if (result.first()) {
            do {
                str = str + result.getString(1) + "\n";
            } while (result.next());
        }
        return str;
    }
}