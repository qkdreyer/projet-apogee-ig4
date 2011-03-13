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
 * Cette classe définit les methodes de l'interface DAO pour le type ECUE
 * (POJO).
 *
 * @author Quentin
 */
public class DBECUE extends DB<ECUE> {

    public DBECUE(Connection conn) {
        super(conn);
    }

    /**
     * Methode permettant la création d'une ECUE
     *
     * @param obj l'ECUE qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(ECUE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Méthode modifiant les données de la base par rapport à l'ecue passée en
     * parametre. L'ECUE ecue est un POJO qui contient une liste d' EtudiantECUE.
     * La méthode va parcourir cette liste et executer un update dans la base de
     * de données sur la table vo_ecue. Cet update va donc modifier les notes des
     * étudiants.
     * La méthode délègue le travail aux méthodes updateNote1() et updateNote2()
     *
     * @param ecue l'ECUE correspondant à une ECUE de la base de données. Cette
     * ECUE sera modifiée. Afin de fonctionner correctement, il est impératif que
     * "ecue" ait été chargé à partir de la méthode find définit ci dessous.
     * @throws Exception
     * @see fr.GCAM.StudentManager.Persist.DB.DBECUE.find
     * @see fr.GCAM.StudentManager.Persist.DB.DBECUE.updateNote1
     * @see fr.GCAM.StudentManager.Persist.DB.DBECUE.updateNote2
     */
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

    /**
     * Méthode appelée par la méthode update. Cette méthode se contente de réaliser
     * un UPDATE(sql) sur la vue VO_UTILISATEUR de la base de données. Cette méthode
     * ne modifie que la note de la session 1.
     *
     * @param numEtud le numeroEtudiant(Primary Key, pk) de l'étudiant dont la note doit etre modifiée
     * @param codeMatiere le codeMatiere(Primary Key, pk) de l'ecue pour laquelle la note doit etre modifiée
     * @param noteSession1 la note qui sera insérée dans la base de données à la place de l'ancienne
     * @throws Exception
     */
    private void updateNote1(int numEtud, String codeMatiere, float noteSession1) throws Exception {
        this.conn.createStatement().executeUpdate("UPDATE VO_Ecue SET noteSession1 = " + noteSession1
                + " WHERE codeMatiere = '" + codeMatiere
                + "' and numEtudiant = " + numEtud);
    }

    /**
     * Méthode appelée par la méthode update. Cette méthode se contente de réaliser
     * un UPDATE(sql) sur la vue VO_UTILISATEUR de la base de données. Cette méthode
     * ne modifie que la note de la session 2.
     *
     * @param numEtud le numeroEtudiant(Primary Key, pk) de l'étudiant dont la note doit etre modifiée
     * @param codeMatiere le codeMatiere(Primary Key, pk) de l'ecue pour laquelle la note doit etre modifiée
     * @param noteSession2 la note qui sera insérée dans la base de données à la place de l'ancienne
     * @throws Exception
     */
    private void updateNote2(int numEtud, String codeMatiere, float noteSession2) throws Exception {
        this.conn.createStatement().executeUpdate("UPDATE VO_Ecue SET noteSession2 = " + noteSession2
                + " WHERE codeMatiere = '" + codeMatiere
                + "' and numEtudiant = " + numEtud);
    }

    /**
     * Méthode procédant à la suppression dans la base de données de l'ecue correspondant
     * a l'ECUE (POJO) passé en parametre.
     *
     * @param obj l'ECUE (POJO) qui correspond à une ecue de le base de données.
     * Il est impératif que "ecue" ait été construite a partir de la méthode find afin
     * d'assurer qu'elle existe dans la base de données.
     * @throws Exception
     */
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
            ecue.setCodeMatiere(result.getString("codeMatiere"));
            ecue.setLibelleECUE(result.getString("libelleECUE"));
            ecue.setNbHeures(result.getInt("nbHeures"));
            ecue.setResponsable(result.getString("prenomResponsable") + " " + result.getString("nomResponsable"));
            ecue.setCodeUE(result.getString("codeUE"));

            do {
                ecue.getListeEtud().add(new EtudiantECUE(
                        result.getInt("numEtudiant"),
                        result.getString("nom"),
                        result.getString("prenom"),
                        result.getFloat("noteSession1"),
                        result.getFloat("noteSession2")));
            } while (result.next());
        }
        return ecue;
    }

    /**
     *
     * @return L'ensemble des clés primaires (codeMatiere) des ECUE
     * @throws Exception
     */
    public String list() throws Exception {
        String str = "";
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT distinct codeMatiere from VO_ECUE");
        if (result.first()) {
            do {
                str = str + result.getString(1) + "\n";
            } while (result.next());
        }
        return str;
    }
}
