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
     * Méthode permettant de créer une ConsoleUtilisateur
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Utilisateur(POJO)
     */
    public UI<Utilisateur> getUIUtilisateur(String s) {
        return new ConsoleUtilisateur(s);
    }

}
