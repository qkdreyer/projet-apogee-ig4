/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Controller.ControllerEtape;
import fr.GCAM.StudentManager.POJO.Etape;

/**
 * Classe de l'UI Console du departement
 *
 * @author Quentin
 */
public class ConsoleEtape extends Console<Etape> {

    public ControllerEtape contr;

    public ConsoleEtape(String s) {
        contr = new ControllerEtape(this, s);
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
