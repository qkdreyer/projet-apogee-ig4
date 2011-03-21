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

    public FacadeUtilisateur(String dao) {
        utilisateur = new ManagerUtilisateur(dao);
    }

    /**
     * methode login
     * Le HasMap renvoyé contient le nom, le prenom, la plus haute responsabilité
     * et le code de la plus haute responsabilité de l'utilisateur connecté.
     *
     */
    public HashMap< String, String > login(String nom, String prenom, String mdp){
        return utilisateur.login(nom, prenom, mdp);
    }

    public Object[] getListLogin() {
        return utilisateur.getListLogin();
    }

}
