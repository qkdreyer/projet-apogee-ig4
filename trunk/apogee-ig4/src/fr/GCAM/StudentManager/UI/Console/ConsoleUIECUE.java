/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Core.Displayable;
import fr.GCAM.StudentManager.Controller.ControllerECUE;
import fr.GCAM.StudentManager.Persist.DAO;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Quentin
 */
public class ConsoleUIECUE extends ConsoleUI implements Displayable {

    public ControllerECUE contr;

    public ConsoleUIECUE(String s) {
        contr = new ControllerECUE(this, s);
	this.accept();
    }

     /**
     * This method waits for input from the console. Once it is received, it sends it to the client's message handler.
     */
    public void accept() {
        try {
            BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
            String message;

            while (true) {
                message = fromConsole.readLine();
                contr.handleMessage(message);
            }
        } catch (Exception ex) {
            System.out.println("Unexpected error while reading from console!");
        }
    }

    public void display(String msg) {
        System.out.println(msg);
    }

}
