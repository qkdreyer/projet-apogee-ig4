/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


/**
 * Cette classe implémente la connection à la base de données oracle de v240.
 *
 * @author Quentin
 */
public class ConnectionDB {

    
    private static Connection conn = null;
    private String url = "jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ora10";

    /**
     * Constructeur par défaut
     *
     */
    private ConnectionDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, getUser(), getPassword());
            System.out.println("Connection effective !");
        } catch (SQLException ex) {
            System.err.println("Erreur lors de la connexion : " + ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Erreur lors du chargement du driver " + ex);
        }
    }

    /**
     * La fonction récupere le mot de passe qui est stocké dans un fichier local
     * @return Le mot de passe lu dans le fichier est renvoyé.
     */
    private static String getPassword() {
        BufferedReader br = null;
        String pwd = null;
        try {
            br = new BufferedReader(new FileReader(".htaccess"));
            br.readLine();
            pwd = br.readLine();
        } catch (FileNotFoundException ex) {
            System.err.println("Fichier introuvable : " + ex);
        } catch (IOException ex) {
            System.err.println("Erreur de lecture/ecriture : " + ex);
        }
        return pwd;
    }

    /**
     * Fonction qui lit le fichier .htaccess afin d'y trouver le nom de l'utilisateur
     * de la base de données.
     *
     * @return La chaine renvoyée contient le mot de passe écrit dans le fichier
     * .htaccess
     */
    public static String getUser() {
        BufferedReader br = null;
        String usr = null;
        try {
            br = new BufferedReader(new FileReader(".htaccess"));
            usr = br.readLine();
        } catch (FileNotFoundException ex) {
            System.err.println("Fichier introuvable : " + ex);
        } catch (IOException ex) {
            System.err.println("Erreur de lecture/ecriture : " + ex);
        }
        return usr;
    }

    /**
     * La fonction ets utilisée pour récuperer une connection à la base de
     * données.
     * @return La Connection (java.sql.Connection) est renvoyé.
     */
    public static Connection getConnection() {
        if (conn == null) {
            new ConnectionDB();
        }
        return conn;
    }
}
