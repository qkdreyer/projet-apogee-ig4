/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.ECUE;

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

    public String getResponsable() throws Exception {
	return manECUE.getResponsable();
    }

    public String getCodeMatiere() throws Exception {
	return manECUE.getCodeMatiere();
    }

    public String getLibelleECUE() throws Exception {
        return manECUE.getLibelleECUE();
    }

    public int getNbHeures() throws Exception {
	return manECUE.getNbHeures();
    }

    public void setNoteSession1(int i, float note) throws Exception {
        manECUE.setNoteSession1(i, note);
    }

    public void setNoteSession2(int i, float note) throws Exception {
        manECUE.setNoteSession2(i, note);
    }

    public Object[][] getArrayOfEtudiantECUE() throws Exception {
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
