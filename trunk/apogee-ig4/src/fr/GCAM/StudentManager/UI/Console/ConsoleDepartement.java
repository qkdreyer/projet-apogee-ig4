/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Controller.ControllerDepartement;
import fr.GCAM.StudentManager.POJO.Departement;

/**
 *
 * @author Quentin
 */
public class ConsoleDepartement extends Console<Departement> {

    public ControllerDepartement contr;
    
    public ConsoleDepartement(String s) {
        contr = new ControllerDepartement(this, s);
    }

    public void display(String msg) {
        System.out.println(msg);
    }

}
