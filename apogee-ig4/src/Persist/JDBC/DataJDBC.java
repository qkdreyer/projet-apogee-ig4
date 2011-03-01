package Persist.JDBC;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Persist.Data;
import Persist.EntryStudentList;
import Persist.JDBC.ConnectDB.*;
import java.sql.*;
import java.util.Iterator;

/**
 *
 * @author Quentin
 */
public class DataJDBC extends Data {

    ConnectDB connDB;

    public DataJDBC(String arg) {
	connDB = new ConnectDB(arg);
	data = this; // singleton?
    }
    
    @Override
    public void save() {
	try {
	    Iterator i = entriesStudentList.iterator();
	    while (i.hasNext()) {
		EntryStudentList entry = (EntryStudentList)i.next();
		Statement s = connDB.getConnection().createStatement();
		s.executeUpdate("UPDATE Tetud_nt SET NoteSession1 = " +
			entry.getNote1() + ", NoteSession2 = " + entry.getNote2() +
			" WHERE numEtudiant = " + entry.getNumEtud() + ";");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    @Override
    public void load() {
        try {
	    Statement select = connDB.getConnection().createStatement();
	    ResultSet result = select.executeQuery("SELECT numEtudiant, Nom,"
		    + "Prenom, NoteSession1, NoteSession2 FROM ListEtud");

	    while (result.next()) {
		this.add(new EntryStudentList(result.getInt(1),
			result.getString(2), result.getString(3),
			result.getInt(4), result.getInt(5)));
	    }
	} catch  (Exception e) {
	    e.printStackTrace();
	}
    }

    public void display() {
	throw new UnsupportedOperationException("Not supported yet.");
    }
}
