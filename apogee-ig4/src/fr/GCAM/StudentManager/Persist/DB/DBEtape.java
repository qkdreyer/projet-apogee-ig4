/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Etape;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantEtape;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantSemestre;
import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantEtape;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
     * TODO: Revoir amélioration possibles
     */
    public Etape find(Object id) throws Exception {
        Etape etape = new Etape();

        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        //recherche le contenu de l'étape
        ResultSet result = s.executeQuery("SELECT * from VO_Etape WHERE codeEtape = '"
                + (String) id
                + "'");
        //enregistrement des données récupérées
        if (result.first()) {
            etape.setCodeEtape(result.getString("codeEtape"));
            etape.setVersionEtape(result.getString("versionEtape"));
            etape.setVersionDiplome(result.getString("versionDiplome"));
            etape.setResponsable(result.getString("prenomResponsable") + " "
                    + result.getString("nomResponsable"));

            String codeSemestre1 = result.getString("codeSemestre");

            //Obtention de la liste des numEtudiants
            ResultSet resultEtudiant = s.executeQuery("SELECT numEtudiant FROM Etudiant"
                    + "WHERE codeEtape = '" + (String)id + "'");

            //Création des objets EtudiantEtape dans la listeEtud et insertion
            //des informations basiques
            if (resultEtudiant.first()){
                do {
                    etape.getListeEtud().add(new DBEtudiantEtape(conn).find(result.getString("codeEtudiant")));
                }while(resultEtudiant.next());
            }


            //Creation des deux semestres, et enregistrement de leurs données
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

                
                //recopie des informations de chaque étudiant dans la liste des
                //étudiants du semestre
                for (EtudiantEtape e : etape.getListeEtud()){

                    //Créer un EtudiantSemestre avec les infos de l'étudiant Etape
                    EtudiantSemestre etudSem = new EtudiantSemestre(
                            e.getNumEtudiant(),
                            e.getNumIne(),
                            e.getLibelleProvenance(),
                            e.getLibelleStatut(),
                            e.getLibelleNationalite(),
                            e.getNom(),
                            e.getPrenom(),
                            e.getMail(),
                            0, //Nombre de points jury par défaut
                            false, //Etranger par défaut
                            false); //Redoublant par défaut

                    //si l'étudiant a reçu des points jury
                    ResultSet resultEtudSemPJ = s.executeQuery("SELECT nbpoints FROM PointsJury"
                        + " WHERE codeSemestre = '" + semestre.getCodeSemestre() + "'"
                        + " AND numEtudiant = " + e.getNumEtudiant());
                    
                    //si l'étudiant passe son semestre à l'étranger
                    ResultSet resultEtudEtranger = s.executeQuery("SELECT moyenne FROM Etranger"
                            + " WHERE codeSemestre = '" + semestre.getCodeSemestre() +"'"
                            + " AND numEtudiant = " +e.getNumEtudiant());

                    //si l'étudiant a déjà une note en raison d'un redoublement
                    ResultSet resultEtudRedouble = s.executeQuery("SELECT moyenne FROM Redoublant"
                            + " WHERE codeSemestre = '" + semestre.getCodeSemestre() +"'"
                            + " AND numEtudiant = " +e.getNumEtudiant());
                    
                    //Ajout des information d'un étudiant

                    //Si l'étudiant a des points jury:
                    if (resultEtudSemPJ.first()){
                        etudSem.setPointJurySemestre(resultEtudSemPJ.getInt("nbpoints"));
                    }

                    //si l'étudiant passe un semestre à l'étranger
                    //on indique qu'il est à l'étranger
                    //on donne la moyenne qu'il a obtenut
                    if (resultEtudEtranger.first()){
                        etudSem.setEtranger(true);
                        etudSem.setMoyEtranger(resultEtudEtranger.getInt("moyenne"));
                    }

                    //Si l'étudiant est un redoublant
                    //on indique qu'il est redoublant
                    //on donne la moyenne qu'il a obtenut
                    if (resultEtudRedouble.first()){
                        etudSem.setRedoublant(true);
                        etudSem.setMoyRedoublant( resultEtudRedouble.getInt("moyenne"));
                    }

                    //Ajout de l'étudiant dans listeEtudiant du semestre
                    semestre.getListeEtud().add(etudSem);
                }

                

                //enregistremenet de la liste des UE dans le semestre
                semestre.getListeUE().add( new DBUE(conn).find(result.getString("codeUE")));
            } while (result.next());
        }

        return etape;
    }

    public ArrayList<Etape> list() throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
