/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.BusinessLayer;

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

    public FacadeECUE(String s) throws Exception {
	manECUE = new ManagerECUE(s);
    }

    public String getNomResponsable() throws Exception {
	return manECUE.getNomResponsable();
    }

    public String getPrenomResponsable() throws Exception {
	return manECUE.getPrenomResponsable();
    }

    public String getCodeMatiere() throws Exception {
	return manECUE.getCodeMatiere();
    }

    public int getNbHeures() throws Exception {
	return manECUE.getNbHeures();
    }

    public Object[][] getArrayOfEtud() throws Exception {
	return manECUE.getArrayOfEtud();
    }



}
