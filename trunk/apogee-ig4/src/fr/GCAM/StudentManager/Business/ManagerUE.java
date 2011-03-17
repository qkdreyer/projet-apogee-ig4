/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.BusinessLayer;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantUE;
import fr.GCAM.StudentManager.POJO.UE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class ManagerUE extends AbstractManager {

    private UE ue = null;

    public ManagerUE(String s) throws Exception {
        ue = AbstractDAOFactory.getDAOFactory(dao).getDAOUE().find(s);
    }

    public String getLibelleUE() {
        return ue.getLibelleUE();
    }

    public String getResponsable() {
        return ue.getResponsable();
    }

    public String getCodeUE() {
        return ue.getCodeUE();
    }

    public int getECTS() {
        return ue.getNbECTS();
    }

    public Object[][] getArrayOfEtudiantUE() {
	ArrayList<EtudiantUE> listeEtud = ue.getListeEtud();
	Object[][] arrayEtud = new Object[listeEtud.size()][3];
        arrayEtud[0][0] = "Nom";
        arrayEtud[0][1] = "Prenom";
        arrayEtud[0][2] = "Moyenne";
	int i = 1;
	for (EtudiantUE e : listeEtud) {
	    arrayEtud[i][0] = e.getNom();
	    arrayEtud[i][1] = e.getPrenom();
	    arrayEtud[i][2] = (e.isAPDJ() ? "APDJ" : (e.isVAE() ? "VAE" : ue.getMoyenne(e.getNumEtudiant())));
	    i++;
	}
	return arrayEtud;
    }

    @Override
    public String toString() {
        return ue.toString();
    }
}
