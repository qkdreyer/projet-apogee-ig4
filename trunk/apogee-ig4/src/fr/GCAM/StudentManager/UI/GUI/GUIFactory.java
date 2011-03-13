/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.GUI;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.UI.AbstractUIFactory;
import fr.GCAM.StudentManager.UI.UI;

/**
 * Cette classe est la fabrique concrete d'UI.
 *
 * @author Quentin
 */
public class GUIFactory extends AbstractUIFactory {

    /**
     * Méthode permettant de créer une GUIECUE
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique ECUE(POJO)
     */
    public UI<ECUE> getUIECUE(String s) {
	return new GUIECUE(s);
    }

    /**
     * Méthode permettant de créer une GUIEtudiant
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Etudiant(POJO)
     */
    public UI<Etudiant> getUIEtudiant(String s) {
	return new GUIEtudiant(s);
    }

    /**
     * Méthode permettant de créer une GUIUtilisateur
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Utilisateur(POJO)
     */
    public UI<Utilisateur> getUIUtilisateur(String s) {
        return new GUIUtilisateur(s);
    }

    /**
     * Méthode permettant de créer une GUIUE
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique UE(POJO)
     */
    public UI<UE> getUIUE(String s) {
        return new GUIUE(s);
    }

    /**
     * Méthode permettant de créer une GUIEtape
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Etape(POJO)
     */
    public UI<Etape> getUIEtape(String s) {
        return new GUIEtape(s);
    }

    /**
     * Méthode permettant de créer une GUIDepartement
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Departement(POJO)
     */
    public UI<Departement> getUIDepartement(String s) {
        return new GUIDepartement(s);
    }

    /*@Override
    public UI<Semestre> getUISemestre(String s) {
        return new GUISemestre(s);
    }*/

}
