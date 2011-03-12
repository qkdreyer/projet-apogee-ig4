/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Controller.ControllerECUE;
import fr.GCAM.StudentManager.POJO.ECUE;

/**
 *
 * @author Quentin
 */
public class ConsoleECUE extends Console<ECUE> {

    public ControllerECUE contr;

    public ConsoleECUE(String s) {
        contr = new ControllerECUE(this, s);
    }

    public void display(String msg) {
        System.out.println(msg);
    }

}
