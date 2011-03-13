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

    public AbstractController handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");
        ArrayList<String> userInformation = new ArrayList<String>();
        AbstractController contr = this;

        if (msg[0].equals("#login") && msg.length == 3) {
            if (msg[1].split("\\.").length == 2) {
                userInformation.add(msg[1].split("\\.")[0]);
                userInformation.add(msg[1].split("\\.")[1]);
                userInformation.add(msg[2]);
                user = (Utilisateur) userDAO.find(userInformation);
                contr = this.logUser();
            }
        } else if (msg[0].equals("#help")) {
            this.help();
        } else if (msg[0].equals("#quit")) {
            System.exit(0);
        } else if (msg[0].equals("#list")) {
            this.list();
        }
        return contr;
    }

    public void help() {
        disp.display("\t #login username password");
        disp.display("\t #list");
        disp.display("\t #quit");
    }

    public AbstractController logUser() throws Exception {
        AbstractController contr = null;
        if (user.getListeResponsabilites().size() > 0) {
            Utilisateur.Responsabilite r = user.getListeResponsabilites().get(user.getListeResponsabilites().size()-1);
            if (r.getLibelle().equals("ECUE")) {
                contr = new ControllerECUE(disp, dao);
            } else if (r.getLibelle().equals("UE")) {
                contr = new ControllerUE(disp, dao);
            } else if (r.getLibelle().equals("Etape")) {
                contr = new ControllerEtape(disp, dao);
            } else if (r.getLibelle().equals("Departement")) {
                contr = new ControllerDepartement(disp, dao);
            }
            contr.handleMessage("#find " + r.getCodeResponsabilite());
            disp.display("get" + r.getLibelle() + "UI #find " + r.getCodeResponsabilite());
        }
        return contr;
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
