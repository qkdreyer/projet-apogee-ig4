/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business;

import java.util.HashMap;

/**
 *
 * @author ben
 */
public class FacadeUtilisateur {

    ManagerUtilisateur utilisateur;

    public FacadeUtilisateur() {
        utilisateur = new ManagerUtilisateur(null);
    }

    /**
     * methode login
     *
     */
    public HashMap< String, String > login(String nom, String prenom, String mdp){
        return utilisateur.login(nom, prenom, mdp);
    }

}
