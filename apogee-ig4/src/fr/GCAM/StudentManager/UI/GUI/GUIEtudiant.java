/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.GUI;

import fr.GCAM.StudentManager.POJO.Etudiant;

/**
 * Classe de l'UI GUI de l'Etudiant
 *
 * @author Quentin
 */
public class GUIEtudiant extends GUI<Etudiant> {

    public GUIEtudiant(String s) {
    }

    /**
     * Fonction d'affichage
     *
     * @param msg La chaine contenant le message à afficher dans la GUI
     */
    public void display(String msg) {
        System.out.println(msg);
    }

}
