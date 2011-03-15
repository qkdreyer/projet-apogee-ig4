/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.Etudiant;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.UI.UI;

/**
 *
 * @author Quentin
 */
public class ControllerStat extends AbstractController {

    private UI disp;
    private DAO<Etudiant> etudDAO;
    private String dao;

    public ControllerStat(UI disp, String s) {
        this.disp = disp;
        this.dao = s;
        this.etudDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOEtudiant();
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
        for(Etudiant e : etudDAO.list()) {
            disp.display(Integer.toString(e.getScoreToeic()));
        }
    }

    private void commande2() {

    }

}
