/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.Departement;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;


/**
 * Classe définissant la méthode handleMessage pour un Departement.
 *
 * @author Quentin
 */
public class ManagerDepartement {

    private Departement dept = null;
    private DAO<Departement> deptDAO = null;

    public ManagerDepartement(String s, String dao) throws Exception {
        deptDAO = AbstractDAOFactory.getDAOFactory(dao).getDAODepartement();
        dept = deptDAO.find(s);
    }

    public String getVersionDiplome() {
        return dept.getVersionDiplome();
    }

    public String getNomDepartement() {
        return dept.getNomDepartement();
    }

    public String getMnemo() {
        return dept.getMnemo();
    }

}
