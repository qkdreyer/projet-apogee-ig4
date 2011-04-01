/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business.Facade;

import fr.GCAM.StudentManager.Business.Manager.ManagerEtape;
import fr.GCAM.StudentManager.Business.POJO.UE;
import java.util.ArrayList;

/**
 *
 * @author Jojo
 */
public class FacadeEtape {

    /*
     * On doit connaitre
     * nom du dtp, année et semestre
     * la liste des etudiants (nom prenom et moyenne sur l'année)
     * nom du responsable
     * version de l'etape
     * ainsi que les infos des 2 semestres
     *      code semestre et libellé (on peut consulter ou modifier le semestre (bouton)
     *          liste des UE et ECUE avec possibilité d'acceder aux details de ces derniers
     */

    private ManagerEtape manEtape;

    public FacadeEtape(String s, String dao) throws Exception {
	manEtape = new ManagerEtape(s, dao);
    }

    public String getResponsable() {
	return manEtape.getResponsable();
    }

    public String getCodeEtape() {
	return manEtape.getCodeEtape();
    }

    public String getVersionEtape() {
	return manEtape.getVersionEtape();
    }

    public String getCodeSemestre(int i) {
        return manEtape.getCodeSemestre(i);
    }

    public String getLibelleSemestre(int i) {
        return manEtape.getLibelleSemestre(i);
    }

    public ArrayList<UE> getListeUE(int i) {
        return manEtape.getListeUE(i);
    }

    public Object[][] getArrayOfEtudiantSemestre(int n) {
	return manEtape.getArrayOfEtudiantSemestre(n);
    }

    public Object[][] getArrayOfEtudiantEtape() {
	return manEtape.getArrayOfEtudiantEtape();
    }

    @Override
    public String toString() {
        return manEtape.toString();
    }

    public void setPJSem(int numSem, int indexEtud, float pj) throws Exception {
        manEtape.setPJSem(numSem, indexEtud, pj);
    }

    public void setPJAnnee(int indexEtud, float pj) throws Exception {
        manEtape.setPJAnnne(indexEtud, pj);
    }
    
    public void setTOEIC(int indexEtud, int toeic) throws Exception {
        manEtape.setTOEIC(indexEtud, toeic);
    }
 
}
