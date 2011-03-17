/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business;

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

    public FacadeEtape(String s) throws Exception {
	manEtape = new ManagerEtape(s);
    }

    public String getResponsable() throws Exception {
	return manEtape.getResponsable();
    }

    public String getCodeEtape() throws Exception {
	return manEtape.getCodeEtape();
    }

    public String getVersionEtape() throws Exception {
	return manEtape.getVersionEtape();
    }

    public Object[][] getArrayOfEtudiantEtape() throws Exception {
	return manEtape.getArrayOfEtudiantEtape();
    }

    @Override
    public String toString() {
        return manEtape.toString();
    }

}
