/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.Business.Facade.FacadeDepartement;
import fr.GCAM.StudentManager.Business.Facade.FacadeECUE;
import fr.GCAM.StudentManager.Business.Facade.FacadeEtape;
import fr.GCAM.StudentManager.Business.Facade.FacadeUE;
import fr.GCAM.StudentManager.Business.POJO.Utilisateur;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Classe de l'UI Console du departement
 *
 * @author Quentin
 */
public class ConsoleUtilisateur extends Console<Utilisateur> {
    
    public ConsoleUtilisateur(String dao) {
	this.accept(dao);
    }

    /**
     * This method waits for input from the console. Once it is received, it sends it to the client's message handler.
     * @param dao Le type de dao associe (db ou xml)
     */
    private void accept(String dao) {
        try {
            BufferedReader fromConsole = new BufferedReader(new InputStreamReader(System.in));
            String message;

            while (true) {
                message = fromConsole.readLine();
                System.out.println(handleMessage(message, dao));
            }
        } catch (Exception ex) {
            System.out.println("Erreur : " + ex);
            ex.printStackTrace();
        }
    }

    /**
     * Methode traitant les messages ecrits dans la console
     * @param message le message entre dans la console
     * @param dao le type de dao souhaite (db ou xml)
     * @return Renvoie la chaine de caractere correspondant au traitement associe
     * au type de message
     * @throws Exception
     */
    private String handleMessage(String message, String dao) throws Exception {
        String[] msg = message.split(" ");
        ArrayList<String> userInformation = new ArrayList<String>();

        if (msg[0].equals("#login") && msg.length == 3) {
            if (msg[1].split("\\.").length == 2) {
                userInformation.add(msg[1].split("\\.")[0]);
                userInformation.add(msg[1].split("\\.")[1]);
                userInformation.add(msg[2]);
                //user = (Utilisateur) userDAO.find(userInformation);
            }
        } else if (msg[0].equals("#findECUE") && msg.length == 2) { // #find pstia602
            return new FacadeECUE(msg[1], dao).toString();
        } else if (msg[0].equals("#findUE") && msg.length == 2) {
            return new FacadeUE(msg[1], dao).toString();
        } else if (msg[0].equals("#findEtape") && msg.length == 2) {
            return new FacadeEtape(msg[1], dao).toString();
        } else if (msg[0].equals("#findDept") && msg.length == 2) {
            return new FacadeDepartement(msg[1], dao).toString();
        } else if (msg[0].equals("#help")) {
            return this.help();
        } else if (msg[0].equals("#quit")) {
            this.quit();
        }
        return "";
    }

    /**
     * Methode affichant l'aide, la liste des commandes que l'on peut saisir dans
     * la console
     * @return la liste des commandes que l'on peut saisir dans la console
     */
    private String help() {
        return "#findECUE 'ecue'"
                + "#findUE 'ue'"
                + "#findEtape 'etape'"
                + "#findDept 'dept'"
                + "#quit";
    }

    /**
     * Methode mettant fin a l'execution de la console
     */
    private void quit() {
        System.exit(1);
    }

}
