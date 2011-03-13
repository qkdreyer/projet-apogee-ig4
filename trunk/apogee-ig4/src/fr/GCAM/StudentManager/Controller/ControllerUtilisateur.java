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
    private String dao;

    public ControllerUtilisateur(UI disp, String s) {
        this.disp = disp;
        this.dao = s;
        this.userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
        this.user = new Utilisateur();
    }

    public void handleMessage(String msg) throws Exception {
        String[] s = msg.split(" ");
        ArrayList<String> userInformation = new ArrayList<String>();

        if (s[0].equals("#login") && s.length == 3) {
            userInformation.add(s[1].split("\\.")[0]);
            userInformation.add(s[1].split("\\.")[1]);
            userInformation.add(s[2]);
            user = (Utilisateur) userDAO.find(userInformation);
            this.logUser();
        } else if (s[0].equals("#help")) {
            this.help();
        } else if (s[0].equals("#quit")) {
            System.exit(0);
        }
    }

    public void help() {
        disp.display("\t #login username password");
        disp.display("\t #quit");
    }

    public void logUser() throws Exception {
        Utilisateur.Responsabilite r = user.getListeResponsabilites().get(0);
        if (r.getLibelle().equals("ECUE")) {
            new ControllerECUE(disp, dao).handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("UE")) {
            new ControllerUE(disp, dao).handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("Etape")) {
            new ControllerEtape(disp, dao).handleMessage("#find " + r.getCodeResponsabilite());
        } else if (r.getLibelle().equals("Departement")) {
            new ControllerDepartement(disp, dao).handleMessage("#find " + r.getCodeResponsabilite());
        }
        disp.display("-> get" + r.getLibelle() + "UI #find " + r.getCodeResponsabilite());
    }
}
