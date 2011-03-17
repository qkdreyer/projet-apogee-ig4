/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;

/**
 *
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
