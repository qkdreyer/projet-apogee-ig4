/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business.Facade;

import fr.GCAM.StudentManager.Business.Manager.ManagerECUE;
import fr.GCAM.StudentManager.Business.POJO.ECUE;

/**
 *
 * @author Jojo
 *
 * Le business Layer (facade) sert de mommunication entre notre UI et le reste
 * du programme
 * 
 */
public class FacadeECUE {

    /**
     * 
     * pour afficher la fenetre, j'ai besoin de:
     * nom de l'ECUE
     * nom du responsable
     * code ECUE
     * nombre d'heures
     * liste des etudiants de l'ECUE (nom, prenom, note session 1 & 2
     *
     * Si l'utilisateur rentre des notes dans le tableau, une fois validées
     * elles sont mises a jour dans la BD (et vérifiées)
     * on peut aussi telecharger le fichier csv qui sera aussi chargé dans la base
     */

    private ManagerECUE manECUE;

    public FacadeECUE(String s, String dao) throws Exception {
	manECUE = new ManagerECUE(s, dao);
    }

    public ECUE getECUE() {
        return manECUE.getECUE();
    }

    public String getResponsable() {
	return manECUE.getResponsable();
    }

    public String getCodeMatiere() {
	return manECUE.getCodeMatiere();
    }

    public String getLibelleECUE() {
        return manECUE.getLibelleECUE();
    }

    public int getNbHeures() {
	return manECUE.getNbHeures();
    }

    public void setNoteSession1(int i, float note) throws Exception {
        manECUE.setNoteSession1(i, note);
    }

    public void setNoteSession2(int i, float note) throws Exception {
        manECUE.setNoteSession2(i, note);
    }

    public Object[][] getArrayOfEtudiantECUE() {
	return manECUE.getArrayOfEtudiantECUE();
    }

    public void update() throws Exception {
        manECUE.update();
    }

    @Override
    public String toString() {
        return manECUE.toString();
    }

}
