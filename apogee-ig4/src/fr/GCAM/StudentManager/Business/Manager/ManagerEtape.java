/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business.Manager;

import fr.GCAM.StudentManager.Business.POJO.Etape;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantEtape;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantSemestre;
import fr.GCAM.StudentManager.Business.POJO.UE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;

/**
 * Manager fournissant les informations d'une Etape
 * @author Quentin
 */
public class ManagerEtape {

    private DAO<Etape> etapeDAO = null;
    private Etape etape = null;

    public ManagerEtape(String s, String dao) throws Exception {
        etapeDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOEtape();
        etape = etapeDAO.find(s);
    }

    /**
     * Accesseur sur l'attribut etape de codeEtape
     * @return le codeEtape de etape
     */
    public String getCodeEtape() {
        return etape.getCodeEtape();
    }

    /**
     * Accesseur sur l'attribut Responsable de etape
     * @return le responsanble de etape
     */
    public String getResponsable() {
        return etape.getResponsable();
    }

    /**
     * Accesseur sur l'attribut versioEtape de etape
     * @return la versionEtape de etape
     */
    public String getVersionEtape() {
        return etape.getVersionEtape();
    }

    /**
     * Accesseur sur le libelleSemestre du semestre i
     * @param i le numero du semestre dont on veut le libelleSemestre
     * @return le libelleSemestre du semestre de numero i
     */
    public String getLibelleSemestre(int i) {
        return etape.getSemestre(i).getLibelleSemestre();
    }

    /**
     * Accesseur sur le codeSemestre du semestre i
     * @param i le numero du semestre dont on veut le codeSemestre
     * @return le libelleSemestre du semestre de numero i
     */
    public String getCodeSemestre(int i) {
        return etape.getSemestre(i).getCodeSemestre();
    }

    /**
     * Accesseur sur le nombre d'UE faculatives du semestre de numero i
     * @param i le numero du semestre dont on veut le nombre d'UE facultatives
     * @return le nombre d'UE facultatives
     */
    public String getNbUEFacultatives(int i) {
	return Integer.toString(etape.getSemestre(i).getNbUEFacultatives());
    }

    /**
     * Methode renvoyant un tableau d'EtudiantSemestre organise selon 4 colonnes :
     * Nom/Prenom/Moyenne/Points Jury
     * @param n Le numero du semestre dont on veut la liste d'etudiants
     * @return Le tableau a deux dimensions contenant tous les etudiants du semestre n
     */
    public Object[][] getArrayOfEtudiantSemestre(int n) {
        ArrayList<EtudiantSemestre> listeEtud = etape.getSemestre(n).getListeEtud();
        Object[][] arrayEtud = new Object[listeEtud.size()][4];
        int i = 0;
        for (EtudiantSemestre e : listeEtud) {
	    arrayEtud[i][0] = e.getNom();
	    arrayEtud[i][1] = e.getPrenom();
	    arrayEtud[i][2] = etape.getSemestre(n).getMoyenne(e.getNumEtudiant());
            arrayEtud[i][3] = e.getPointJurySemestre();
	    i++;
        }
        return arrayEtud;
    }

    /**
     * Methode renvoyant un tableau d'EtudiantEtape organise selon 4 colonnes :
     * Nom/Prenom/Moyenne/Points Jury
     * @return Le tableau a deux dimensions contenant tous les etudiants de l'etape
     */
    public Object[][] getArrayOfEtudiantEtape() {
	ArrayList<EtudiantEtape> listeEtud = etape.getListeEtud();
	Object[][] arrayEtud = new Object[listeEtud.size()][5];
	int i = 0;
	for (EtudiantEtape e : listeEtud) {
	    arrayEtud[i][0] = e.getNom();
	    arrayEtud[i][1] = e.getPrenom();
	    arrayEtud[i][2] = etape.getMoyenne(e.getNumEtudiant());
            arrayEtud[i][3] = e.getPointJuryAnnee();
            arrayEtud[i][4] = e.getScoreToeic();
	    i++;
	}
	return arrayEtud;
    }

    /**
     * Redefinition de la methode toString()
     * @return l'objet sous forme de chaine de caractere
     */
    @Override
    public String toString() {
        return etape.toString();
    }

    /**
     * Accesseur sur l'attribut listeUE du semestre i
     * @param i le semestre dont on veut la liste d'UE
     * @return la liste d'UE du semestre i
     */
    public ArrayList<UE> getListeUE(int i) {
        return etape.getSemestre(i).getListeUE();
    }

    /**
     * Mutateur de l'attribut PointsJury Semestre pour un etudiant du semestre
     * @param numSem le numero du semestre pour lequel on veut attribuer des points Jury
     * @param indexEtud l'index de l'etudiant pour lequel on veut attribuer des points Jury
     * @param pj le nombre de points jury
     * @throws Exception
     */
    public void setPJSem(int numSem, int indexEtud, float pj) throws Exception {
	etape.getSemestre(numSem).getListeEtud().get(indexEtud).setPointJurySemestre(pj);
        etapeDAO.update(etape);
    }

    /**
     * Mutateur de l'attribut PointsJury Etape pour un etudiant de l'etape
     * @param indexEtud l'index de l'etudiant pour lequel on veut attribuer des points Jury
     * @param pj le nombre de points jury
     * @throws Exception
     */
    public void setPJAnnne(int indexEtud, float pj) throws Exception {
        etape.getListeEtud().get(indexEtud).setPointJuryAnnee(pj);
        etapeDAO.update(etape);
    }

    /**
     * Mutateur de l'attribut TOEIC pour un etudiant de l'etape
     * @param indexEtud l'index de l'etudiant pour lequel on veut attribuer une note TOEIC
     * @param toeic la note TOEIC (0<= toeic <= 990)
     * @throws Exception
     */
    public void setTOEIC(int indexEtud, int toeic) throws Exception {
        etape.getListeEtud().get(indexEtud).setScoreToeic(toeic);
        etapeDAO.update(etape);
    }
}
