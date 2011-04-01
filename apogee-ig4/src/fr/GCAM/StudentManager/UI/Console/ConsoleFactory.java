/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Business.POJO.*;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.AbstractEtudiant;
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
     * @param dao La chaine contenant le type de persistence des données (db ou xml)
     * @return L'UI instancié avec le type spécifique Utilisateur(POJO)
     */
    public UI<Utilisateur> getUIUtilisateur(String dao) {
	return new ConsoleUtilisateur(dao);
    }

    /**
     * Redefinition de la methode getUIECUE de AbsstractUIFactory
     */
    @Override
    public UI<ECUE> getUIECUE(String dao, String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Redefinition de la methode getUIUE de AbsstractUIFactory
     */
    @Override
    public UI<UE> getUIUE(String dao, String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Redefinition de la methode getUIEtape de AbsstractUIFactory
     */
    @Override
    public UI<Etape> getUIEtape(String dao, String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Redefinition de la methode getUIDepartement de AbsstractUIFactory
     */
    @Override
    public UI<Departement> getUIDepartement(String dao, String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Redefinition de la methode getUIStats de AbsstractUIFactory
     */
    @Override
    public UI<AbstractEtudiant> getUIStat(String dao, String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Redefinition de la methode getUIAdmin de AbsstractUIFactory
     */
    @Override
    public UI<Utilisateur> getUIAdmin(String dao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
