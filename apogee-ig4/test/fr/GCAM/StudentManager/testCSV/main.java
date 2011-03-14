/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.testCSV;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.ParserCSV.CreateCSV;
import fr.GCAM.StudentManager.Persist.DB.ConnectionDB;
import fr.GCAM.StudentManager.Persist.DB.DBECUE;
import java.io.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jojo
 */
public class main {
	public static void main(String[] args) {
            System.out.println("bienvenue");
        File t;
        t = CreateCSV.CreateEmptyFile();
        ECUE ecue;
        Connection con = ConnectionDB.getConnection();
        System.out.println("0");
        DBECUE dbecue = new DBECUE(con);
        System.out.println("1");
        try {
            ecue = dbecue.find("PSTIA602");
            System.out.println("2");
            t = CreateCSV.CompleteFile(t, ecue);
            System.out.println("3");
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        }


}
