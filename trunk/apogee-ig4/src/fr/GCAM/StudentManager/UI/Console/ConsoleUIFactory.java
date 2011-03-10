/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.UI.Console;

import fr.GCAM.StudentManager.UI.AbstractUIFactory;
import fr.GCAM.StudentManager.UI.UI;

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
