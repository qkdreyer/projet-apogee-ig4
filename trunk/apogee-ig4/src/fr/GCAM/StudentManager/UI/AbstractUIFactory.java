/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.UI;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.POJO.Etudiant.AbstractEtudiant;
import fr.GCAM.StudentManager.UI.Console.ConsoleFactory;
import fr.GCAM.StudentManager.UI.GUI.GUIFactory;

/**
 * Cette classe représente la fabrique abstraite d'UI. La fabrique renvoie une
 * UI correspondant aux maquettes définies lors de la phase de conception.
 *
 * @author PIERRE
 */

public abstract class AbstractUIFactory {

    protected static AbstractUIFactory fact = null;

    /**
     * Methode renvoyant une UI(User Interface) pour un Utilisateur
     *
     * @param s La chaine contient le type de stockage des données (db ou xml)
     * @return Renvoie l'UI Utilisateur, connecté au stockage des données définies
     * par s.
     */
    public abstract UI<Utilisateur> getUIUtilisateur(String s);

    /**
     * Methode renvoyant une UI(User Interface) pour une ECUE
     *
     * @param s La chaine contient le type de stockage des données (db ou xml)
     * @return Renvoie l'UI ECUE, connecté au stockage des données définies
     * par s.
     */
    public abstract UI<ECUE> getUIECUE(String s);

    /**
     * Methode renvoyant une UI(User Interface) pour une UE
     *
     * @param s La chaine contient le type de stockage des données (db ou xml)
     * @return Renvoie l'UI UE, connecté au stockage des données définies
     * par s.
     */
    public abstract UI<UE> getUIUE(String s);

    /**
     * Methode renvoyant une UI(User Interface) pour une Etape
     *
     * @param s La chaine contient le type de stockage des données (db ou xml)
     * @return Renvoie l'UI Etape, connecté au stockage des données définies
     * par s.
     */
    public abstract UI<Etape> getUIEtape(String s);

    /**
     * Methode renvoyant une UI(User Interface) pour un Departement
     *
     * @param s La chaine contient le type de stockage des données (db ou xml)
     * @return Renvoie l'UI Departement, connecté au stockage des données définies
     * par s.
     */
    public abstract UI<Departement> getUIDepartement(String s);

    /**
     * TODO
     * @param s
     * @return
     */
    public abstract UI<AbstractEtudiant> getUIStat(String s);

    /**
     * Methode renvoyant l'UI (Console ou GUI) associée à la chaine passée
     * en parametre.
     *
     * @param s Chaine contenant le type de d'UI à instancier c(Console) ou
     * g(GUI)
     * @return L'AbstractUIFactory retournée est en fait une des sous classes :
     * ConsoleFactory ou GUIFactory.
     */
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
