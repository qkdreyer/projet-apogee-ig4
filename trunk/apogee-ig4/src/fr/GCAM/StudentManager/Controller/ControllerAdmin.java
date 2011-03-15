/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Controller;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;

/**
 *
 * @author Quentin
 */
public class ControllerAdmin extends AbstractController<Utilisateur> {

    private DAO<Utilisateur> userDAO;
    private Utilisateur user = null;

    public ControllerAdmin() {
        this.userDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOUtilisateur();
    }

    @Override
    public AbstractController handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");
        if (msg[0].equals("#add") && msg.length >= 5) {
            this.add(msg);
        } else if (msg[0].equals("#delete") && msg.length == 3) {
            this.delete(msg);
        } else if (msg[0].equals("#list")) {
            this.list();
        }
        return this;
    }

    private void add(String[] msg) throws Exception {
        user = new Utilisateur();
        user.setPrenom(msg[1]);
        user.setNom(msg[2]);
        user.setMDP(msg[3]);
        user.setMail(msg[4]);

	user.getListeResponsabilites().add(new Utilisateur.Responsabilite("???", "???")); //TODO add Respons
        userDAO.create(user);
    }

    private void delete(String[] msg) throws Exception {
        user = new Utilisateur();
        user.setPrenom(msg[1]);
        user.setNom(msg[2]);
        userDAO.delete(user);
    }

    private void list() throws Exception {
        for(Utilisateur u : userDAO.list()) {
            
        }
    }
}
