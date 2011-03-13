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
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Quentin
 */
public class ControllerUtilisateur extends AbstractController implements Observer {

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

    public void handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");
        ArrayList<String> userInformation = new ArrayList<String>();

        if (msg[0].equals("#login") && msg.length == 3) {
            userInformation.add(msg[1].split("\\.")[0]);
            userInformation.add(msg[1].split("\\.")[1]);
            userInformation.add(msg[2]);
            user = (Utilisateur) userDAO.find(userInformation);
            this.logUser();
        } else if (msg[0].equals("#help")) {
            this.help();
        } else if (msg[0].equals("#quit")) {
            System.exit(0);
        } else if (msg[0].equals("#list")) {
            this.list();
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

    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Cette fonction affiche la liste des clés primaires (prenom.nom) des Enseignants
     */
    public void list() throws Exception {
        disp.display(userDAO.list());
    }
}
