/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.BusinessLayer;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;

/**
 *
 * @author Quentin
 */
public class ManagerStat extends AbstractManager {

    private DAO<EtudiantECUE> etudDAO;

    public ManagerStat() {
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
