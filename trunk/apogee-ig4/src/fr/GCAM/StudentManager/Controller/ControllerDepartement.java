/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.Departement;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.UI.UI;
import java.util.Observable;
import java.util.Observer;


/**
 *
 * @author Quentin
 */
public class ControllerDepartement implements Observer {


    private UI disp;
    private DAO<Departement> deptDAO;
    private Departement dept;

    public ControllerDepartement(UI disp, String s) {
        this.disp = disp;
        deptDAO = AbstractDAOFactory.getDAOFactory(s).getDAODepartement();
        dept = new Departement();
    }

    public void handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");

        if (msg[0].equals("#find") && msg.length == 2) { // #find pstia602
            this.find(msg);
        } else if (msg[0].equals("#update")) {
            this.update(msg);
        } else if (msg[0].equals("#quit")) {
            this.quit();
        }
    }

    public void find(String[] msg) throws Exception {
        dept = (Departement) deptDAO.find(msg[1]);
        disp.display(dept.toString());
    }

    public void update(String[] msg) throws Exception {
        deptDAO.update(dept);
    }

    public void quit() {
        System.exit(0);
    }

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
