/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.BusinessLayer;

import fr.GCAM.StudentManager.POJO.Etape;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantEtape;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class ManagerEtape extends AbstractManager {

    private Etape etape = null;

    public ManagerEtape(String s) throws Exception {
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

    public Object[][] getArrayOfEtudiantEtape() {
	ArrayList<EtudiantEtape> listeEtud = etape.getListeEtud();
	Object[][] arrayEtud = new Object[listeEtud.size()][3];
        arrayEtud[0][0] = "Nom";
        arrayEtud[0][1] = "Prenom";
        arrayEtud[0][2] = "Moyenne";
	int i = 1;
	for (EtudiantEtape e : listeEtud) {
	    arrayEtud[i][0] = e.getNom();
	    arrayEtud[i][1] = e.getPrenom();
	    arrayEtud[i][2] = etape.getMoyenne(e.getNumEtudiant());
	    i++;
	}
	return arrayEtud;
    }

    @Override
    public String toString() {
        return etape.toString();
    }
}
