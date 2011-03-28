/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.GUI;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.POJO.Etudiant.AbstractEtudiant;
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
    public GUI<ECUE> getUIECUE(String dao, String id) throws Exception {
        return new GUIECUE(dao, id);
    }

    /**
     * Méthode permettant de créer une GUIUtilisateur
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Utilisateur(POJO)
     */
    public GUI<Utilisateur> getUIUtilisateur(String dao) throws Exception {
        return new GUILogin(dao);
    }

    /**
     * Méthode permettant de créer une GUIUE
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique UE(POJO)
     */
    public GUI<UE> getUIUE(String dao, String id) throws Exception {
        return new GUIUE(dao, id);
    }

    /**
     * Méthode permettant de créer une GUIEtape
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Etape(POJO)
     */
    public GUI<Etape> getUIEtape(String dao, String id) throws Exception {
            return new GUIEtape(dao, id);
    }

    /**
     * Méthode permettant de créer une GUIDepartement
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Departement(POJO)
     */
    public GUI<Departement> getUIDepartement(String dao, String id) throws Exception {
        return new GUIDepartement(dao, id);
    }

    /**
     * Méthode permettant de créer une GUIStat
     *
     * @param s La chaine contenant le type de persistence des données (db ou xml),
     * ainsi que la chaine contenant l'identité de l'utilisateur courrant
     * @return L'UI instancié avec le type spécifique Departement(POJO)
     */    
    public UI<AbstractEtudiant> getUIStat(String dao, String id) throws Exception {
        return new GUIStat(dao, id);
    }

    /**
     * TODO
     */
    public UI<Utilisateur> getUIAdmin(String dao) throws Exception {
        return new GUIAdmin(dao);
    }

}
