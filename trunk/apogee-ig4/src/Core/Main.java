package Core;

import UI.Console.ConsoleECUE;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quentin
 */
public class Main {

    public static String invalidArguments = "Arguments invalides (Format : c/g db/xml)";

    public static void main(String[] args) {
        if (args.length > 1) {
	    ConsoleECUE cmecue = new ConsoleECUE(args[1]);
            cmecue.accept();
        } else {
            System.err.println(invalidArguments);
        }    
    }

}
