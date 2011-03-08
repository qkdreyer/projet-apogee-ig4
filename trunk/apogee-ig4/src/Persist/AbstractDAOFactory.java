package Persist;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Persist.DB.DBDAOFactory;
import Persist.XML.XMLDAOFactory;
import java.util.Observable;

/**
 *
 * @author Quentin
 */
public abstract class AbstractDAOFactory extends Observable {

    public abstract DAO getECUEDAO();
    public abstract DAO getEleveDAO();

    public static AbstractDAOFactory getInstance(String s) {
	if (s.equals("db")) {
	    return new DBDAOFactory();
	} else if (s.equals("xml")) {
	    return new XMLDAOFactory();
	} else {
	    return null;
	}
    }
/*
    protected static AbstractDAOFactory data = null;
    public ArrayList<EntryStudentList> entriesStudentList = new ArrayList<EntryStudentList>();

    public void add(EntryStudentList entry) {
	entriesStudentList.add(entry);
	this.setChanged();
	this.notifyObservers();
    }

    public abstract void save() throws Exception;
    public abstract void load() throws Exception;


*/
	/*if (data == null) {
	    System.err.println("No Persist Kit declared"); //new Error();
	}
	return data;*/
    

}
