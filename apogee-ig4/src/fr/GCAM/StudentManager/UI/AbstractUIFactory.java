/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.UI;

import fr.GCAM.StudentManager.Business.POJO.*;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.AbstractEtudiant;
import fr.GCAM.StudentManager.UI.Console.ConsoleFactory;
import fr.GCAM.StudentManager.UI.GUI.GUIFactory;

/**
 * Cette classe représente la fabrique abstraite d'UI. La fabrique renvoie une
 * UI correspondant aux maquettes définies lors de la phase de conception.
 *
 * @author PIERRE
 */

public abstract class AbstractUIFactory { //TODO params

    protected static AbstractUIFactory fact = null;

    /**
     * Methode renvoyant une UI(User Interface) pour un Utilisateur
     *
     * @param dao Le type de dao (db ou xml)
     * @param id l'id de l'utilisateur
     * @return L'UI<utilisateur> associe a un DAO de type dao et pour l'utilsateur
     * d'identifiant id
     */
    public abstract UI<Utilisateur> getUIUtilisateur(String dao) throws Exception;

    /**
     * Methode renvoyant une UI(User Interface) pour une ECUE
     *
     * @param dao Le type de dao (db ou xml)
     * @param id l'id de l'ECUE
     * @return L'UI<ECUE> associe a un DAO de type dao et pour l'ECUE
     * d'identifiant id
     */
    public abstract UI<ECUE> getUIECUE(String dao, String id) throws Exception;

    /**
     * Methode renvoyant une UI(User Interface) pour une UE
     *
     * @param dao Le type de dao (db ou xml)
     * @param id l'id de l'UE
     * @return L'UI<UE> associe a un DAO de type dao et pour l'UE
     * d'identifiant id
     */
    public abstract UI<UE> getUIUE(String dao, String id) throws Exception;

    /**
     * Methode renvoyant une UI(User Interface) pour une Etape
     *
     * @param dao Le type de dao (db ou xml)
     * @param id l'id de l'Etape
     * @return L'UI<Etape> associe a un DAO de type dao et pour l'Etape
     * d'identifiant id
     */
    public abstract UI<Etape> getUIEtape(String dao, String id) throws Exception;

    /**
     * Methode renvoyant une UI(User Interface) pour un Departement
     *
     * @param dao Le type de dao (db ou xml)
     * @param id l'id du departement
     * @return L'UI<departement> associe a un DAO de type dao et pour le departement
     * d'identifiant id
     */
    public abstract UI<Departement> getUIDepartement(String dao, String id) throws Exception;

    /**
     * Methode renvoyant une UI(User Interface) pour un Etudiant
     * @param dao Le type de dao (db ou xml)
     * @param id l'id des stats
     * @return L'UI<Stats> associe a un DAO de type dao et pour les stats
     * d'identifiant id
     * @throws Exception
     */
    public abstract UI<AbstractEtudiant> getUIStat(String dao, String id) throws Exception;

    /**
     * Methode renvoyant une UI(User Interface) pour un Admin
     * @param dao Le type de dao (db ou xml)
     * @param id l'id de l'admin
     * @return L'UI<admin> associe a un DAO de type dao et pour l'admin
     * d'identifiant id
     */
    public abstract UI<Utilisateur> getUIAdmin(String dao) throws Exception;

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
