/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import fr.GCAM.StudentManager.UI.UI;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class ControllerUtilisateur {

    private UI disp;
    private DAO<Utilisateur> userDAO;
    private Utilisateur user;

    public ControllerUtilisateur(UI disp, String s) {
	this.disp = disp;
        userDAO = AbstractDAOFactory.getDAOFactory(s).getDAOUtilisateur();
        user = new Utilisateur();
    }

    public void handleMessage(String msg) {
	String[] s = msg.split(" ");
	ArrayList<String> userInformation = new ArrayList<String>();

	if (s[0].equals("#login") && s.length == 3) {
	    try {
                userInformation.add(s[1].split("\\.")[0]); //TODO syntaxe
                userInformation.add(s[1].split("\\.")[1]);
                userInformation.add(s[2]);
		user = (Utilisateur) userDAO.find(userInformation);
		//disp.display(user.toString());
		this.logUser();
	    } catch (Exception ex) {
		System.err.println("Erreur : " + ex);
		ex.printStackTrace();
	    }
	}
    }

    public void logUser() {
        Utilisateur.Responsabilite r = user.getListeResponsabilites().get(0);
	if (r.getLibelle().equals("ECUE")) {
            disp.display("-> getECUEUI #find " + r.getCodeResponsabilite());
	} else if (r.getLibelle().equals("UE")) {
            disp.display("-> getUEUI #find " + r.getCodeResponsabilite());
	} else if (r.getLibelle().equals("Etape")) {
            disp.display("-> getEtapeUI #find " + r.getCodeResponsabilite());
	} else if (r.getLibelle().equals("Departement")) {
            disp.display("-> getDepartementUI #find " + r.getCodeResponsabilite());
	}
    }
    
}
