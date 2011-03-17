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
     * TODO: Améliorer la fonction
     */
    public UE find(Object id) throws Exception {
        UE ue = new UE();

        //Creation des statements
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        Statement sListeEtud = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        Statement sAPDJ = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        Statement sVAE = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

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

            //Récupération de la liste des étudiants inscrit à l'UE
            ResultSet resultEtudiant = sListeEtud.executeQuery("SELECT numEtudiant FROM table(get_liste_etud_UE('PIGU51'))");
            if(resultEtudiant.first()){
                do{
                    //On crée un étudiant
                    EtudiantUE etudUE = new DBEtudiantUE(conn).find(resultEtudiant.getInt("numEtudiant"));

                    //on vérifie si il a un VAE pour cette UE
                    ResultSet resultVAE = sVAE.executeQuery("SELECT null FROM VAE"
                            + " WHERE numEtudiant = " + etudUE.getNumEtudiant()
                            + " AND codeUE = '" + (String)id + "'");

                    //On vérifie si il a une APDJ pour cette UE
                    ResultSet resultAPDJ = sAPDJ.executeQuery("SELECT null FROM APDJ"
                            + " WHERE numEtudiant = " + etudUE.getNumEtudiant()
                            + " AND codeUE = '" + (String)id + "'");

                    //Si l'étudiant a une VAE, on met la var à vrais, sinon faux
                    if (resultVAE.first()){
                        etudUE.setVAE(true);
                    }else{
                        etudUE.setVAE(false);
                    }
                    //Si l'étudiant a une APDJ, on met la var à vrais,
                    //sinon à faux
                    if (resultAPDJ.first()){
                        etudUE.setAPDJ(true);
                    }else{
                        etudUE.setAPDJ(false);
                    }

                    //On ajoute la liste de vars dans l'UE
                    ue.getListeEtud().add(etudUE);
                } while (resultEtudiant.next());
            }

            do {
                //On remplis la liste ECUE
                ue.getListeECUE().add(new DBECUE(conn).find(result.getString("codeMatiere")));
            } while (result.next());
        }
        return ue;
    }

    public ArrayList<UE> list() throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }
}
