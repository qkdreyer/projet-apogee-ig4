/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business.Manager;

import fr.GCAM.StudentManager.POJO.Departement;
import fr.GCAM.StudentManager.POJO.Etape;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


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

    public ArrayList<Etape> getListeEtape() {
        return dept.getListeEtape();
    }

}
