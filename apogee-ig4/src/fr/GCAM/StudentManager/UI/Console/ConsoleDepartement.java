/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.BusinessLayer.ControllerDepartement;
import fr.GCAM.StudentManager.POJO.Departement;

/**
 * Classe de l'UI Console du departement
 *
 * @author Quentin
 */
public class ConsoleDepartement extends Console<Departement> {

    public ControllerDepartement contr;
    
    public ConsoleDepartement(String s) {
        contr = new ControllerDepartement();
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
