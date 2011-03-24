/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business.Facade;

import fr.GCAM.StudentManager.Business.Manager.ManagerUE;
import fr.GCAM.StudentManager.POJO.ECUE;
import java.util.ArrayList;

/**
 *
 * @author Jojo
 */
public class FacadeUE {

     /*
     * pour afficher la fenetre, j'ai besoin de:
     * nom de l'UE
     * nom du responsable
     * code UE
     * nombre d'ECTS
     * annee
     * departement
     * semestre
     * les ECUE de l'UE avec comme informations
     *          nom de l'UE, du responsable, les détails sur la matiere
      *
      * L'on doit aussi pouvoir switcher entre les années/semestre/UE
      * dont l'utilisateur est responsable (sinon boutons vérouillés)
     */

    private ManagerUE manUE;

    public FacadeUE(String s, String dao) throws Exception {
	manUE = new ManagerUE(s, dao);
    }

    public String getResponsable() {
	return manUE.getResponsable();
    }

    public String getCodeUE() {
	return manUE.getCodeUE();
    }

    public String getLibelleUE() {
	return manUE.getLibelleUE();
    }

    public int getECTS() {
	return manUE.getECTS();
    }

    public ArrayList<ECUE> getListeECUE() {
	return manUE.getListeECUE();
    }

    public Object[][] getArrayOfEtudiantUE() {
	return manUE.getArrayOfEtudiantUE();
    }

    public String getOptionnel() {
        return manUE.getOptionnel();
    }

    @Override
    public String toString() {
        return manUE.toString();
    }
}
