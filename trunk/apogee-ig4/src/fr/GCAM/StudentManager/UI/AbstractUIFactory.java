/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.UI;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.UI.Console.ConsoleFactory;
import fr.GCAM.StudentManager.UI.GUI.GUIFactory;

/**
 *
 * @author PIERRE
 */

public abstract class AbstractUIFactory {

    protected static AbstractUIFactory fact = null;

    public abstract UI<Utilisateur> getUIUtilisateur(String s);
    public abstract UI<Etudiant> getUIEtudiant(String s);
    public abstract UI<ECUE> getUIECUE(String s);
    public abstract UI<UE> getUIUE(String s);
    public abstract UI<Etape> getUIEtape(String s);
    public abstract UI<Departement> getUIDepartement(String s);
    //public abstract UI<Etape.Semestre> getUISemestre(String s);

    public static AbstractUIFactory getUIFactory(String s) {
	if (fact == null) {
	    if (s.equals("c")) {
		fact = new ConsoleFactory();
	    } else if (s.equals("g")) {
		fact = new GUIFactory();
	    } else {
		System.err.println("No UI declared");
	    }
	}
	return fact;
    }
}
