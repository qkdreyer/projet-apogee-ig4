/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Controller.ControllerUE;
import fr.GCAM.StudentManager.POJO.UE;

/**
 *
 * @author Quentin
 */
public class ConsoleUE extends Console<UE> {

    public ControllerUE contr;

    public ConsoleUE(String s) {
        contr = new ControllerUE(this, s);
    }

    public void display(String msg) {
        System.out.println(msg);
    }
}
