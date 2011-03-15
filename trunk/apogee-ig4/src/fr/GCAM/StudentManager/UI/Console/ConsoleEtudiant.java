/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.POJO.Etudiant.AbstractEtudiant;

/**
 * Classe de l'UI Console du departement
 *
 * @author Quentin
 */
public class ConsoleEtudiant extends Console<AbstractEtudiant> {

    public ConsoleEtudiant(String s) {
    }

    /**
     * La méthode se contente d'affichier via un sout le message 'msg' dans la
     * console
     *
     * @param msg La chaine de caractere à afficher
     */
    public void display(String msg) {
        System.out.println(msg);
    }
}
