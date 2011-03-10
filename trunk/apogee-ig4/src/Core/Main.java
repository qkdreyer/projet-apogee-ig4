package Core;

import UI.AbstractUIFactory;
import UI.UI;

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
	    UI ui = AbstractUIFactory.getFactory(args[0]).getECUEUI(args[1]);
        } else {
            System.err.println("Arguments invalides (Format : c/g db/xml)");
        }    
    }

}
