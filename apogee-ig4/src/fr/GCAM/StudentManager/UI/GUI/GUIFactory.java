/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.GUI;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.UI.AbstractUIFactory;
import fr.GCAM.StudentManager.UI.UI;

/**
 *
 * @author Quentin
 */
public class GUIFactory extends AbstractUIFactory {

    @Override
    public UI<ECUE> getUIECUE(String s) {
	return new GUIECUE(s);
    }

    @Override
    public UI<Etudiant> getUIEtudiant(String s) {
	return new GUIEtudiant(s);
    }

    @Override
    public UI<Utilisateur> getUIUtilisateur(String s) {
        return new GUIUtilisateur(s);
    }

    @Override
    public UI<UE> getUIUE(String s) {
        return new GUIUE(s);
    }

    @Override
    public UI<Etape> getUIEtape(String s) {
        return new GUIEtape(s);
    }

    @Override
    public UI<Departement> getUIDepartement(String s) {
        return new GUIDepartement(s);
    }

    /*@Override
    public UI<Semestre> getUISemestre(String s) {
        return new GUISemestre(s);
    }*/

}
