package Core;

import UI.Console.ConsoleManageECUE;
import Persist.AbstractDAOFactory;

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
	    AbstractDAOFactory d = AbstractDAOFactory.getInstance(args[1]);
            /*if (args[0].equals("g")) {
                if (args[1].equals("db")) { // g db
                    //TODO
                } else if (args[1].equals("xml")) { // g xml
                    //TODO
                } else {
                    System.err.println(invalidArguments);
                }
            } else if (args[0].equals("c")) {
                if (args[1].equals("db")) { // c db
                    ConsoleManageECUE cmecue = new ConsoleManageECUE();
                    cmecue.accept();
                } else if (args[1].equals("xml")) { // c xml
                    //TODO
                } else {
                    System.err.println(invalidArguments);
                }
            } else {
                System.err.println(invalidArguments);
            }*/
        } else {
            System.err.println(invalidArguments);
        }
        
    }
}
