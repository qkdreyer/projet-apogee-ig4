/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist.JDBC;

import java.sql.*;

/**
 *
 * @author Quentin
 */
public class ConnectDB {

    Connection conn = null;

    public ConnectDB (String arg) {
        try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@v240.ig.polytech.univ-montp2.fr:1521:ora10";
	    
            conn = DriverManager.getConnection(url, "pierre.nicolas", arg);
            System.out.println("Connection effective !");

            //Création d'un objet Statement
            Statement state = conn.createStatement();
            //L'objet ResultSet contient le résultat de la requête SQL
            ResultSet result = state.executeQuery("SELECT * FROM Etudiant;");
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
            state.close();

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
