/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.UI.AbstractUIFactory;
import fr.GCAM.StudentManager.UI.UI;

/**
 *
 * @author Quentin
 */
public class ConsoleFactory extends AbstractUIFactory {

    @Override
    public UI<ECUE> getUIECUE(String s) {
	return new ConsoleECUE(s);
    }

    @Override
    public UI<Etudiant> getUIEtudiant(String s) {
	return new ConsoleEtudiant(s);
    }

    @Override
    public UI<Utilisateur> getUIUtilisateur(String s) {
        return new ConsoleUtilisateur(s);
    }

    @Override
    public UI<UE> getUIUE(String s) {
        return new ConsoleUE(s);
    }

    @Override
    public UI<Etape> getUIEtape(String s) {
        return new ConsoleEtape(s);
    }

    @Override
    public UI<Departement> getUIDepartement(String s) {
        return new ConsoleDepartement(s);
    }

    @Override
    public UI<Semestre> getUISemestre(String s) {
        return new ConsoleSemestre(s);
    }

}
