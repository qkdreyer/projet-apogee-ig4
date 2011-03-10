/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import UI.Console.ConsoleUIFactory;
import UI.GUI.GUIFactory;

/**
 *
 * @author PIERRE
 */
public abstract class AbstractUIFactory {

    protected static AbstractUIFactory fact = null;
    public abstract UI getECUEUI(String s);
    public abstract UI getEtudiantUI(String s);

    public static AbstractUIFactory getFactory(String s) {
	if (s.equals("c")) {
	    fact = new ConsoleUIFactory();
	} else if (s.equals("g")) {
	    fact = new GUIFactory();
	} else {
	    System.err.println("No UI declared");
	}
	return fact;
    }
}