/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.BusinessLayer;

import fr.GCAM.StudentManager.UI.AbstractUIFactory;
import fr.GCAM.StudentManager.UI.UI;

/**
 * Classe abstraite déclarant la méthode que chaque controlleur concret devra
 * définir : handleMessage.
 * @author Quentin
 */
public abstract class AbstractController { // Gestion controller

    protected UI disp;
    protected String dao;

    /*public AbstractController(String ui, String dao) {
        this.disp = AbstractUIFactory.getUIFactory(ui).getUIUtilisateur(dao);
        this.dao = dao;
    }*/



    /**
     * Cette méthode devra étre défini par chaque controlleur afin de définir
     * la facon dont il devra gerer les messages envoyer par l'UI
     *
     * @param message(String) Le message à traiter.
     * @return
     * @throws Exception
     */
    public abstract AbstractController handleMessage(String message) throws Exception;

}
