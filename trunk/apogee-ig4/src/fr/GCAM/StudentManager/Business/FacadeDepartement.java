/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business;

/**
 *
 * @author Jojo
 */
public class FacadeDepartement {

    /*
     * L'on doit connaitre le departement et les années
     * dont l'utilisateur est responsable
     * Une fois sélectionné on redirige vers la fenetre d'etape correspondante
     */

    private ManagerDepartement manDept;

    public FacadeDepartement(String s, String dao) throws Exception {
	manDept = new ManagerDepartement(s, dao);
    }

    public String getVersionDiplome() throws Exception {
	return manDept.getVersionDiplome();
    }

    public String getNomDepartement() throws Exception {
	return manDept.getNomDepartement();
    }

    public String getMnemo() throws Exception {
	return manDept.getMnemo();
    }

    @Override
    public String toString() {
        return manDept.toString();
    }

}
