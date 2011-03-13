/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.GUI;

import fr.GCAM.StudentManager.POJO.Utilisateur;

/**
 * Classe de l'UI GUI de l'ECUE
 *
 * @author Quentin
 */
public class GUIUtilisateur extends GUI<Utilisateur> {

    public GUIUtilisateur(String s) {
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
