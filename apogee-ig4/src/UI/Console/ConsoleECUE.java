/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Console;

import Core.Displayable;
import Controller.ControllerECUE;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Quentin
 */
public class ConsoleECUE implements Displayable {

    public ControllerECUE contr;
    
    /**
     * This method waits for input from the console. Once it is received, it sends it to the client's message handler.
     */

    public ConsoleECUE(String s) {
        contr = new ControllerECUE(this, s);
    }

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
