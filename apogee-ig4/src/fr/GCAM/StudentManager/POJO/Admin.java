/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.POJO;

import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public class Admin {

    ArrayList<Utilisateur> listeUtil;

    public Admin() {
	listeUtil = new ArrayList<Utilisateur>();
    }

    public ArrayList<Utilisateur> getListeUtil() {
	return listeUtil;
    }

    public void setListeUtil(ArrayList<Utilisateur> listeUtil) {
	this.listeUtil = listeUtil;
    }

}
