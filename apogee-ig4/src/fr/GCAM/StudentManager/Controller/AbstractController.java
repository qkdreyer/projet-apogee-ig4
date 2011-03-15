/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Controller;

/**
 * Classe abstraite déclarant la méthode que chaque controlleur concret devra
 * définir : handleMessage.
 * @author Quentin
 */
public abstract class AbstractController { // Gestion controller

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
