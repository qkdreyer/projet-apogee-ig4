/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UI.Console;

import Controller.ControllerLogin;
import Core.Displayable;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Quentin
 */
public class ConsoleUIUtilisateur implements Displayable {

    public ConsoleUIUtilisateur(ControllerLogin contr) {
	this.contr = contr;
	this.accept();
    }

    public ControllerLogin contr;

    public void display(String msg) {
	System.out.println(msg);
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


}
