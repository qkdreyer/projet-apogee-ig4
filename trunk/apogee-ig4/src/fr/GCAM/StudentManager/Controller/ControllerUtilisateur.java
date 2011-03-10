/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.Core.Displayable;
import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;
import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class ControllerUtilisateur {

    private Displayable disp;
    private DAO userDAO;
    private Utilisateur user;

    public ControllerUtilisateur(Displayable disp, String s) {
	this.disp = disp;
        userDAO = AbstractDAOFactory.getFactory(s).getECUEDAO();
        user = new Utilisateur();
    }

    public void handleMessage(String msg) {
	String[] s = msg.split(" ");
	ArrayList<String> userInformation = new ArrayList<String>();

	if (s[0].equals("#login") && s.length == 3) {
	    try {
                userInformation.add(s[1].split(".")[0]); //TODO syntaxe
                userInformation.add(s[1].split(".")[1]);
                userInformation.add(s[2]);
		user = (Utilisateur) userDAO.find(userInformation);
		disp.display(user.toString());
		this.logUser();
	    } catch (Exception ex) {
		System.err.println("Erreur : " + ex);
	    }
	}
    }

    public void logUser() {
	if (user.getListeResponsabilites().get(0).getLibelle().equals("ECUE")) {
            
	} else if (user.getListeResponsabilites().get(0).getLibelle().equals("UE")) {

	} else if (user.getListeResponsabilites().get(0).getLibelle().equals("Etape")) {

	} else if (user.getListeResponsabilites().get(0).getLibelle().equals("Departement")) {

	}
    }


}
