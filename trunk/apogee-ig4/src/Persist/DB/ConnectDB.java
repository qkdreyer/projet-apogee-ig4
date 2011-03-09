/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist.DB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author Quentin
 */
public class ConnectDB {

    private static Connection conn = null;
    private String url = "jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ora10";
    private String user = "joris.puechlong";

    public ConnectDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, user, getPassword());
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
            pwd = br.readLine();
        } catch (FileNotFoundException ex) {
            System.err.println("Fichier introuvable : " + ex);
        } catch (IOException ex) {
            System.err.println("Erreur de lecture/ecriture : " + ex);
        }
        return pwd;
    }

    public static Connection getConnection() {
        if (conn == null) {
            new ConnectDB();
        }
        return conn;
    }
}
