/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.POJO.Etudiant.AbstractEtudiant;
import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.UI.AbstractUIFactory;
import fr.GCAM.StudentManager.UI.UI;

/**
 * Cette classe est la fabrique concrete d'UI Console.
 *
 * @author Quentin
 */
public class ConsoleFactory extends AbstractUIFactory {

    /**
     * Méthode permettant de créer une ConsoleECUE
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique ECUE(POJO)
     */
    public UI<ECUE> getUIECUE(String s) {
	return new ConsoleECUE(s);
    }

    /**
     * Méthode permettant de créer une ConsoleEtudiant
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Etudiant(POJO)
     */
    public UI<AbstractEtudiant> getUIEtudiant(String s) {
	return new ConsoleEtudiant(s);
    }

    /**
     * Méthode permettant de créer une ConsoleUtilisateur
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Utilisateur(POJO)
     */
    public UI<Utilisateur> getUIUtilisateur(String s) {
        return new ConsoleUtilisateur(s);
    }

    /**
     * Méthode permettant de créer une ConsoleUE
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique UE(POJO)
     */
    public UI<UE> getUIUE(String s) {
        return new ConsoleUE(s);
    }

    /**
     * Méthode permettant de créer une ConsoleEtape
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Etape(POJO)
     */
    public UI<Etape> getUIEtape(String s) {
        return new ConsoleEtape(s);
    }

    /**
     * Méthode permettant de créer une ConsoleDepartement
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Departement(POJO)
     */
    public UI<Departement> getUIDepartement(String s) {
        return new ConsoleDepartement(s);
    }

    /*@Override
    public UI<Semestre> getUISemestre(String s) {
        return new ConsoleSemestre(s);
    }*/

}
