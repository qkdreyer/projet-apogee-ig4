/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Controller.AbstractController;
import fr.GCAM.StudentManager.Controller.ControllerUtilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Classe de l'UI Console du departement
 *
 * @author Quentin
 */
public class ConsoleUtilisateur extends Console<Utilisateur> {

    public AbstractController contr;
    
    public ConsoleUtilisateur(String s) {
	this.contr = new ControllerUtilisateur(this, s);
	this.accept();
    }

    /**
     * La méthode se contente d'affichier via un sout le message 'msg' dans la
     * console
     *
     * @param msg La chaine de caractere à afficher
     */
    public void display(String msg) {
	System.out.println(msg);
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
                contr.handleMessage(message);
            }
        } catch (Exception ex) {
            System.out.println("Erreur : " + ex);
            ex.printStackTrace();
        }
    }


}
