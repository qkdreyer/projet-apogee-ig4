/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business.Manager;

import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;

/**
 * Manager associe aux statistiques d'un EtudiantECUE
 * @author Quentin
 */
public class ManagerStat {

    private DAO<EtudiantECUE> etudDAO;

    public ManagerStat(String dao) {
        this.etudDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOEtudiantECUE();
    }

    private void commande1() throws Exception {
        for(EtudiantECUE e : etudDAO.list()) {
            //disp.display(Integer.toString(e.getScoreToeic()));
        }
    }

    private void commande2() {

    }

}