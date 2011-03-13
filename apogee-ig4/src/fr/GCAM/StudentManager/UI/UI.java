/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI;

/**
 * Classe permettant l'abstraction de l'UI pour le controlleur. Ainsi afin d'afficher
 * un element, il suffit d'appeler la méthode display() qui sera redéfinit dans
 * les sous classes (Consoles et GUI).
 *
 * @author Quentin
 */
public interface UI<T> {

    /**
     * Méthode abstraite gerant l'affichage. Cette méthode est redéfinie dans les
     * sous classes de la classe UI (Console et GUI).
     *
     * @param msg
     */
    public abstract void display(String msg);
    
}
