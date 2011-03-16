/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantUE;
import fr.GCAM.StudentManager.POJO.UE;
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
     * TODO: Appels sur base de donnée à améliorer. On doit pouvoir penser à
     * une manière de mettre la création des liens VAE et APDJ dans la classe
     * DBEtudiantUE.
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

            ResultSet resultEtudiant = s.executeQuery("SELECT numEtudiant FROM table(get_liste_etud_UE('PIGU51'))");
            if(resultEtudiant.first()){
                do{
                    EtudiantUE etudUE = new DBEtudiantUE(conn).find(resultEtudiant.getInt("numEtudiant"));

                    ResultSet resultVAE = s.executeQuery("SELECT null FROM VAE "
                            + "WHERE numEtudiant = " + etudUE.getNumEtudiant()
                            + "AND codeUE = '" + (String)id + "'");
                    
                    ResultSet resultAPDJ = s.executeQuery("SELECT null FROM APDJ"
                            + "WHERE numEtudiant = " + etudUE.getNumEtudiant()
                            + "AND codeUE = '" + (String)id + "'");

                    if (resultVAE.first()){
                        etudUE.setVAE(true);
                    }
                    if (resultAPDJ.first()){
                        etudUE.setAPDJ(true);
                    }
                    ue.getListeEtud().add(etudUE);
                } while (resultEtudiant.next());
            }

            do {
                ue.getListeECUE().add(new DBECUE(conn).find(result.getString("codeMatiere")));
            } while (result.next());
        }
        return ue;
    }

    public ArrayList<UE> list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
