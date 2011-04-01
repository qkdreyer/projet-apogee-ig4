/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business.Manager;

import fr.GCAM.StudentManager.Business.POJO.Departement;
import fr.GCAM.StudentManager.Business.POJO.Etape;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Manager fournissant les informations d'un Departement
 * @author Quentin
 */
public class ManagerDepartement {

    private Departement dept = null;
    private DAO<Departement> deptDAO = null;

    public ManagerDepartement(String s, String dao) throws Exception {
        deptDAO = AbstractDAOFactory.getDAOFactory(dao).getDAODepartement();
        dept = deptDAO.find(s);
    }

    /**
     * Accessseur sur l'attribut versionDiplome du departement dept
     * @return La version diplome de dept
     */
    public String getVersionDiplome() {
        return dept.getVersionDiplome();
    }

    /**
     * Accesseur sur l'attrbiut NomDepartement du departement Dept
     * @return le nomDepartement de dept
     */
    public String getNomDepartement() {
        return dept.getNomDepartement();
    }

    /**
     * Accesseur sur l'attribut Mnemo du departement
     * @return le mnemo de dept
     */
    public String getMnemo() {
        return dept.getMnemo();
    }

    /**
     * Accesseur sur l'attribut listeEtape de dept
     * @return la liste d'etape de dept
     */
    public ArrayList<Etape> getListeEtape() {
        return dept.getListeEtape();
    }

}
