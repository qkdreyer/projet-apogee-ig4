package fr.GCAM.StudentManager.UI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe principale du projet. C'est ici que l'on va regarder les deux arguments
 * obligatoires qui doivent etre passés pour l'éxecution du programme.
 * Le programme va ensuite lancer l'UI correspodant au premier argument.
 *
 * @author Quentin
 */
public class Main {
    public static void main(String[] args) {
        if (args.length > 1
                && (args[0].equals("c") || args[0].equals("g"))
                && (args[1].equals("db") || args[1].equals("xml"))) {
            try {
                AbstractUIFactory.getUIFactory(args[0]).getUIUtilisateur(args[1]);
            } catch (Exception ex) {
                System.err.println("Exception : " + ex);
		ex.printStackTrace();
            }
        } else {
	    try {
		//System.err.println("Arguments invalides (Format : c/g db/xml)");
		AbstractUIFactory.getUIFactory("g").getUIUtilisateur("db");
	    } catch (Exception ex) {
		System.err.println("Exception : " + ex);
		ex.printStackTrace();
	    }
        }
    }
}
