/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantUE;
import fr.GCAM.StudentManager.POJO.UE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class ManagerUE {

    private UE ue = null;
    private DAO<UE> ueDAO = null;

    public ManagerUE(String s, String dao) throws Exception {
        ueDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUE();
        ue = ueDAO.find(s);
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

    public String getOptionnel() {
        return (ue.isOptionnel() ? "Oui" : "Non");
    }

    public ArrayList<ECUE> getListeECUE() {
	return ue.getListeECUE();
    }

    public Object[][] getArrayOfEtudiantUE() {
	ArrayList<EtudiantUE> listeEtud = ue.getListeEtud();
	Object[][] arrayEtud = new Object[listeEtud.size()][3];
	int i = 0;
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
