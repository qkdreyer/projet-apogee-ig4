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
 *
 * @author Quentin
 */
public class ConnectionDB {

    private static Connection conn = null;
    private String url = "jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ora10";

    public ConnectionDB() {
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

    private String getPassword() {
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

    public String getUser() {
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

    public static Connection getConnection() {
        if (conn == null) {
            new ConnectionDB();
        }
        return conn;
    }
}
