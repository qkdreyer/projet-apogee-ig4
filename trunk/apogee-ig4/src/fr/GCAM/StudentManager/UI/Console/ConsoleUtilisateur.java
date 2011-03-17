/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Business.FacadeDepartement;
import fr.GCAM.StudentManager.Business.FacadeECUE;
import fr.GCAM.StudentManager.Business.FacadeEtape;
import fr.GCAM.StudentManager.Business.FacadeUE;
import fr.GCAM.StudentManager.POJO.Utilisateur;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Classe de l'UI Console du departement
 *
 * @author Quentin
 */
public class ConsoleUtilisateur extends Console<Utilisateur> {
    
    public ConsoleUtilisateur(String dao) {
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
                System.out.println(handleMessage(message));
            }
        } catch (Exception ex) {
            System.out.println("Erreur : " + ex);
            ex.printStackTrace();
        }
    }

    private String handleMessage(String message) throws Exception {
        String[] msg = message.split(" ");

        if (msg[0].equals("#findECUE") && msg.length == 2) { // #find pstia602
            return new FacadeECUE(msg[1]).toString();
        } else if (msg[0].equals("#findUE") && msg.length == 2) {
            return new FacadeUE(msg[1]).toString();
        } else if (msg[0].equals("#findEtape") && msg.length == 2) {
            return new FacadeEtape(msg[1]).toString();
        } else if (msg[0].equals("#findDept") && msg.length == 2) {
            //return new FacadeDepartement(msg[1]).toString();
        } else if (msg[0].equals("#help")) {
            return this.help();
        } else if (msg[0].equals("#quit")) {
            this.quit();
        }
        return null;
    }

    private String help() {
        return "#findECUE 'ecue'"
                + "#findUE 'ue'"
                + "#findEtape 'etape'"
                + "#findDept 'dept'"
                + "#quit";
    }

    private void quit() {
        System.exit(1);
    }

}
