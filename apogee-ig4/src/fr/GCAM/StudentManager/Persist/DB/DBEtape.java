/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.Business.POJO.Etape;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantEtape;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantSemestre;
import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantEtape;
import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantSemestre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

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
    public void update(Etape etape) throws Exception {
        EtudiantEtape etudiant;
        Iterator i = etape.getListeEtud().iterator();
        while (i.hasNext()) {
            etudiant = (EtudiantEtape) i.next();
            this.conn.createStatement().executeUpdate("UPDATE VO_EtudiantEtape "
                    + "SET pointJuryAnnee = " + etudiant.getPointJuryAnnee()
                    + ", scoreTOEIC = " + etudiant.getScoreToeic()
                    + " WHERE codeEtape = '" + etape.getCodeEtape()
                    + "' and numEtudiant = " + etudiant.getNumEtudiant());
        }

        EtudiantSemestre etudiantSem;
        for (int j = 1; j <= 2; j++) {
            i = etape.getSemestre(j).getListeEtud().iterator();
            while (i.hasNext()) {
                etudiantSem = (EtudiantSemestre) i.next();
                this.conn.createStatement().executeUpdate("UPDATE VO_EtudiantSemestre "
                        + "SET pointJurySemestre = " + etudiantSem.getPointJurySemestre()
                        + " WHERE codeSemestre = '" + etape.getSemestre(j).getCodeSemestre()
                        + "' and numEtudiant = " + etudiantSem.getNumEtudiant());
            }
        }
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

        //Un statement pour chaque requètes
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        //recherche le contenu de l'étape
        ResultSet result = s.executeQuery("SELECT * from VO_Etape WHERE codeEtape = '"
                + (String) id + "'");
        //enregistrement des données récupérées
        if (result.first()) {
            etape.setCodeEtape(result.getString("codeEtape"));
            etape.setVersionEtape(result.getString("versionEtape"));
            etape.setVersionDiplome(result.getString("versionDiplome"));
            etape.setResponsable(result.getString("prenomResponsable")
                    + " " + result.getString("nomResponsable"));
            etape.setListeEtud(new DBEtudiantEtape(conn).list(result.getString("codeEtape")));

            String codeSemestre1 = result.getString("codeSemestre");
            int i;
            do {
                i = codeSemestre1.equals(result.getString("codeSemestre")) ? 1 : 2;
                etape.getSemestre(i).setCodeEtape(result.getString("codeEtape"));
                etape.getSemestre(i).setCodeSemestre(result.getString("codeSemestre"));
                etape.getSemestre(i).setLibelleSemestre(result.getString("libelleSemestre"));
                etape.getSemestre(i).setNbUEFacultatives(result.getInt("nbUEFacultatives"));
                etape.getSemestre(i).setListeUE(new DBUE(conn).list(result.getString("codeSemestre")));
                etape.getSemestre(i).setListeEtud(new DBEtudiantSemestre(conn).list(result.getString("codeSemestre")));
            } while (result.next());
        }
        s.close();
        return etape;
    }

    /**
     * Methode permettant de lister les Etapes
     * @return
     * @throws Exception
     */
    public ArrayList<Etape> list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant de lister les Etapes ayant pour Departement parent id
     * @param id le departement parent des etapes
     * @return La liste des etape ayant pour departement parent id
     * @throws Exception
     */
    ArrayList<Etape> list(String id) throws Exception {
        System.out.println("codeEtape = " + id);
        ArrayList<Etape> list = new ArrayList<Etape>();
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT distinct(codeEtape), versionEtape from VO_Etape where versionDiplome = '" + (String) id + "'");
        if (result.first()) {
            do {
                list.add(new Etape(result.getString("codeEtape"), result.getString("versionEtape")));
            } while (result.next());
        }
        s.close();
        return list;
    }
}
