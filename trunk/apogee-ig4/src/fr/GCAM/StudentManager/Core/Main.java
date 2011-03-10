package fr.GCAM.StudentManager.Core;

import fr.GCAM.StudentManager.UI.AbstractUIFactory;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Quentin, non en fait c'est ben
 */
public class Main {

    public static void main(String[] args) {
        if (args.length > 1) {
	    AbstractUIFactory.getUIFactory(args[0]).getUIUtilisateur(args[1]);
        } else {
            System.err.println("Arguments invalides (Format : c/g db/xml)");
        }    
    }

}
