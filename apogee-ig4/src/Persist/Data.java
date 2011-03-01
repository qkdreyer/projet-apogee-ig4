package Persist;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Core.Displayable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Quentin
 */
public abstract class Data extends Observable implements Serializable, Displayable {

    protected static Data data = null;
    public ArrayList<EntryStudentList> entriesStudentList = new ArrayList<EntryStudentList>();

    public void add(EntryStudentList entry) {
	entriesStudentList.add(entry);
	this.setChanged();
	this.notifyObservers();
    }

    public abstract void save() throws Exception;
    public abstract void load() throws Exception;

    public static Data getInstance() {
	if (data == null) {
	    System.err.println("No Persist Kit declared"); //new Error();
	}
	return data;
    }

    /*public Enumeration elements() {
	return entries.elements();
    }*/

}
