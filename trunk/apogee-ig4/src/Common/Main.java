package Common;

import DB.ConnectDB;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Quentin
 */
public class Main {

    public static void main (String[] args) {

        if (args.length > 0) {
            ConnectDB bd = new ConnectDB(args[0]);
        } else {
            System.err.println("Mot de passe absent ! " + args.length);
        }
        //System.out.println("Test");
    }

}
