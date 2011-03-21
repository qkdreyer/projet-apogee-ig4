/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.Etape;
import fr.GCAM.StudentManager.POJO.Etape.Semestre;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantEtape;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantSemestre;
import fr.GCAM.StudentManager.POJO.UE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class ManagerEtape {

    private Etape etape = null;

    public ManagerEtape(String s, String dao) throws Exception {
        etape = AbstractDAOFactory.getDAOFactory(dao).getDAOEtape().find(s);
    }

    public String getCodeEtape() {
        return etape.getCodeEtape();
    }

    public String getResponsable() {
        return etape.getResponsable();
    }

    public String getVersionEtape() {
        return etape.getVersionEtape();
    }

    public String getLibelleSemestre(int i) {
        return etape.getSemestre(i).getLibelleSemestre();
    }

    public String getCodeSemestre(int i) {
        return etape.getSemestre(i).getCodeSemestre();
    }

    public String getNbUEFacultatives(int i) {
	return Integer.toString(etape.getSemestre(i).getNbUEFacultatives());
    }

    public Object[][] getArrayOfEtudiantSemestre(int n) {
        ArrayList<EtudiantSemestre> listeEtud = etape.getSemestre(n).getListeEtud();
        Object[][] arrayEtud = new Object[listeEtud.size()][4];
        int i = 0;
        for (EtudiantSemestre e : listeEtud) {
	    arrayEtud[i][0] = e.getNom();
	    arrayEtud[i][1] = e.getPrenom();
	    arrayEtud[i][2] = (e.getMoyEtranger() > 0 ? e.getMoyEtranger() :
                (e.getMoyRedoublant() > 0 ? e.getMoyRedoublant() : etape.getMoyenne(e.getNumEtudiant())));
            arrayEtud[i][3] = e.getPointJurySemestre();
        }
        return arrayEtud;
    }

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

    @Override
    public String toString() {
        return etape.toString();
    }

    public ArrayList<UE> getListeUE(int i) {
        return etape.getSemestre(i).getListeUE();
    }
}
