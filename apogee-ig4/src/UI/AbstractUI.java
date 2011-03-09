/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

/**
 *
 * @author PIERRE
 */
public abstract class AbstractUI {

    protected static AbstractUI ui = null;

     public static AbstractUI getInstance(String s) {
	if (s.equals("c")) {
	    //ui = new DBDAOFactory();
	} else if (s.equals("g")) {
	    //ui = new XMLDAOFactory();
	} else {
	    System.err.println("No UI declared");
	}
        return ui;
    }
}
