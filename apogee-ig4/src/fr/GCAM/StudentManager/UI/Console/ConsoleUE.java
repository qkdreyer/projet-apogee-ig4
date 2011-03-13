/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Controller.ControllerUE;
import fr.GCAM.StudentManager.POJO.UE;

/**
 * Classe de l'UI Console du departement
 *
 * @author Quentin
 */
public class ConsoleUE extends Console<UE> {

    public ControllerUE contr;

    public ConsoleUE(String s) {
        contr = new ControllerUE(this, s);
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
