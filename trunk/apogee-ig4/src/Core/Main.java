package Core;

import Persist.AbstractDAOFactory;
import UI.AbstractUIFactory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quentin
 */
public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
	    AbstractUIFactory.getFactory(args[0]).getECUEUI(args[1]);
        } else {
            System.err.println("Arguments invalides (Format : c/g db/xml)");
        }    
    }

}
