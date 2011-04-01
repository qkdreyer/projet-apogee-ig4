/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business.Manager;

import fr.GCAM.StudentManager.Business.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantUE;
import fr.GCAM.StudentManager.Business.POJO.UE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;

/**
 * Manager fournissant les informations d'une UE
 * @author Quentin
 */
public class ManagerUE {

    private UE ue = null;
    private DAO<UE> ueDAO = null;

    public ManagerUE(String s, String dao) throws Exception {
        ueDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUE();
        ue = ueDAO.find(s);
    }

    /**
     * Accesseur sur l'attribut libelleUE de ue
     * @return le libelleUE de l'ue
     */
    public String getLibelleUE() {
        return ue.getLibelleUE();
    }

    /**
     * Accesseur sur l'attribut responsable de ue
     * @return le responsable de ue
     */
    public String getResponsable() {
        return ue.getResponsable();
    }

    /**
     * Accesseur sur l'attribut codeUE de ue
     * @return le codeUE de ue
     */
    public String getCodeUE() {
        return ue.getCodeUE();
    }

    /**
     * Acceseur sur l'attribut nombre d'ECTS de ue
     * @return le nombre d'ECTS d'ue
     */
    public int getECTS() {
        return ue.getNbECTS();
    }

    /**
     * Accesseur sur l'attribut optionnel de ue
     * @return 'Oui' si ue est optionnel, 'Non' sinon
     */
    public String getOptionnel() {
        return (ue.isOptionnel() ? "Oui" : "Non");
    }

    /**
     * Accesseur sur l'attribut listeECUE de ue
     * @return la listeECUE de l'ue
     */
    public ArrayList<ECUE> getListeECUE() {
	return ue.getListeECUE();
    }

    /**
     * Methode renvoyant un tableau d'EtudiantUE organise selon 4 colonnes :
     * Nom/Prenom/Moyenne/Points Jury
     * @return Le tableau a deux dimensions contenant tous les etudiants de l'ue
     */
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

    /**
     * Redefinition de la methode toString()
     * @return l'objet sous forme de chaine de caractere
     */
    @Override
    public String toString() {
        return ue.toString();
    }
}
