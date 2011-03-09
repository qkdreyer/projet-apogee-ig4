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

    protected static AbstractDAOFactory fact = null;
    public abstract DAO getECUEDAO();
    public abstract DAO getEleveDAO();

    public static AbstractDAOFactory getInstance(String s) {
	if (s.equals("db")) {
	    fact = new DBDAOFactory();
	} else if (s.equals("xml")) {
	    fact = new XMLDAOFactory();
	} else {
	    System.err.println("No factory declared");
	}
        return fact;
    }
}
