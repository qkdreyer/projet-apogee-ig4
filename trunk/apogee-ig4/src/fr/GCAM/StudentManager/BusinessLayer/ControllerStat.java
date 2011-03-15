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
public class ControllerStat extends AbstractController {

    private DAO<EtudiantECUE> etudDAO;

    public ControllerStat() {
        this.etudDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOEtudiantECUE();
    }

    @Override
    public AbstractController handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");

        if (msg[0].equals("#commande1")) {
            this.commande1();
        } else if (msg[0].equals("#commande2")) {
            this.commande2();
        } else if (msg[0].equals("#quit")) {
            System.exit(0);
        }
        return this;
    }

    private void commande1() throws Exception {
        for(EtudiantECUE e : etudDAO.list()) {
            //disp.display(Integer.toString(e.getScoreToeic()));
        }
    }

    private void commande2() {

    }

}
