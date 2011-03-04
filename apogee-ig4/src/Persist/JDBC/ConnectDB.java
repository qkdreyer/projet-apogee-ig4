/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist.JDBC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

/**
 *
 * @author Quentin
 */
public class ConnectDB {

    private Connection conn = null; //private/public?

    public ConnectDB () {
        try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ora10";
            BufferedReader br = null;

            try {
                br = new BufferedReader(new FileReader(".htaccess"));
                conn = DriverManager.getConnection(url, "pierre.nicolas", br.readLine());
                System.out.println("Connection effective !");
            } catch (FileNotFoundException ex) {
                System.err.println("Fichier introuvable : " + ex);
            } catch (IOException ex) {
                System.err.println("Erreur de lecture/ecriture : " + ex);
            }

            /*
            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery("Select * FROM VO_Ecue");
            //On récupère les MetaData
            ResultSetMetaData resultMeta = result.getMetaData();

            System.out.println("\n**********************************");
            //On affiche le nom des colonnes
            for(int i = 1; i <=  resultMeta.getColumnCount(); i++) {
                System.out.print("\t" + resultMeta.getColumnName(i).toUpperCase() + "\t *");
            }

            System.out.println("\n**********************************");
        
            while(result.next()) {
                for(int i = 1; i <=  resultMeta.getColumnCount(); i++) {
                    System.out.print("\t" + result.getObject(i).toString() + "\t |");
                }
                System.out.println("\n---------------------------------");
            }

            result.close();
            state.close();*/

        } catch (SQLException e1) {
            System.err.println("Erreur lors de la connexion : " + e1);
        } catch (ClassNotFoundException e2) {
            System.err.println("Erreur lors du chargement du driver " + e2);
        }
    }

    public Connection getConnection() {
	return conn;
    }
    
}
