package Core;

import Persist.JDBC.*;
import Persist.XML.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quentin
 */
public class Main {

    public static String invalidArguments = "Arguments invalides (Format : c/g db/xml [passwd])";

    public static void main (String[] args) {
        if (args.length > 1) {
	    //if (args[0].equals("g"))
	    if (args[1].equals("db")) { // c/g db passwd
		if (args.length > 2) {
		    JDBCKit kit = new JDBCKit();
		    //DataJDBC d = new DataJDBC(args[2]);
		    System.out.println("Test");
		} else {
		    System.err.println("Mot de passe BD absent !");
		}
	    } else if (args[1].equals("xml")) { // c/g xml
		XMLKit kit = new XMLKit();
	    } else {
		System.err.println(invalidArguments);
	    }
        } else {
            System.err.println(invalidArguments);
        }
    }

}
