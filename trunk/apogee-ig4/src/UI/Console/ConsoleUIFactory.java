/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UI.Console;

import UI.AbstractUIFactory;
import UI.UI;

/**
 *
 * @author Quentin
 */
public class ConsoleUIFactory extends AbstractUIFactory {

    @Override
    public UI getECUEUI(String s) {
	return new ConsoleUIECUE(s);
    }

    @Override
    public UI getEtudiantUI(String s) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
