/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package UI.GUI;

import UI.AbstractUIFactory;
import UI.UI;

/**
 *
 * @author Quentin
 */
public class GUIFactory extends AbstractUIFactory {

    @Override
    public UI getECUEUI(String s) {
	return new GUIECUE(s);
    }

    @Override
    public UI getEtudiantUI(String s) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
