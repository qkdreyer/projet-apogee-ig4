/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.BusinessLayer;

import fr.GCAM.StudentManager.POJO.Departement;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;


/**
 * Classe définissant la méthode handleMessage pour un Departement.
 *
 * @author Quentin
 */
public class ManagerDepartement extends AbstractManager {

    private Departement dept = null;

    public ManagerDepartement(String s) throws Exception {
        dept = AbstractDAOFactory.getDAOFactory(dao).getDAODepartement().find(s);
    }

}
