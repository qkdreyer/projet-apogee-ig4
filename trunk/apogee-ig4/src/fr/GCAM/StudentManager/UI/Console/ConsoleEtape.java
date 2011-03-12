/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Controller.ControllerEtape;
import fr.GCAM.StudentManager.POJO.Etape;

/**
 *
 * @author Quentin
 */
public class ConsoleEtape extends Console<Etape> {

    public ControllerEtape contr;

    public ConsoleEtape(String s) {
        contr = new ControllerEtape(this, s);
    }

    public void display(String msg) {
	System.out.println(msg);
    }
}
