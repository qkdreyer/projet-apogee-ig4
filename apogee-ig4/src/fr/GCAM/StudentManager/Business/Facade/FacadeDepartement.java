/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business.Facade;

import fr.GCAM.StudentManager.Business.Manager.ManagerDepartement;
import fr.GCAM.StudentManager.Business.POJO.Etape;
import java.util.ArrayList;

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

    public String getVersionDiplome() {
	return manDept.getVersionDiplome();
    }

    public String getNomDepartement() {
	return manDept.getNomDepartement();
    }

    public String getMnemo() {
	return manDept.getMnemo();
    }

    public ArrayList<Etape> getListeEtape() {
        return manDept.getListeEtape();
    }

    @Override
    public String toString() {
        return manDept.toString();
    }

}
