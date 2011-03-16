/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.BusinessLayer.AbstractController;
import fr.GCAM.StudentManager.BusinessLayer.ManagerUtilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Classe de l'UI Console du departement
 *
 * @author Quentin
 */
public class ConsoleUtilisateur extends Console<Utilisateur> {

    private AbstractController contr;
    //private AbstractController parentController;
    
    public ConsoleUtilisateur(String dao) {
	this.contr = new ManagerUtilisateur(this, dao);
	this.accept();
    }

     /**
     * This method waits for input from the console. Once it is received, it sends it to the client's message handler.
     */
    private void accept() {
        try {
            BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
            String message;

            while (true) {
                message = fromConsole.readLine();
                contr = contr.handleMessage(message);
            }
        } catch (Exception ex) {
            System.out.println("Erreur : " + ex);
            ex.printStackTrace();
        }
    }

}
