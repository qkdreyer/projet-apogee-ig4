/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.Console;

import Core.Displayable;
import Core.Controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Quentin
 */
public class ConsoleManageECUE implements Displayable {

    public Controller contr;
    
    /**
     * This method waits for input from the console. Once it is received, it sends it to the client's message handler.
     */

    public ConsoleManageECUE() {
        contr = new Controller(this);
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
