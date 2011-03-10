/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Core.Displayable;

/**
 *
 * @author Quentin
 */
public class ControllerLogin {

    private Displayable disp;

    public ControllerLogin(Displayable disp) {
	this.disp = disp;
    }

    public void handleMessage(String msg) {
	String[] s = msg.split(" ");

	if (s[0].equals("#login") && s.length == 3) {

	}
    }

    public void logUser() {

    }


}
