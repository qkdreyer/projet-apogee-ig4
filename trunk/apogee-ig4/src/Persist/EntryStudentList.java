/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist;

import java.io.Serializable;

/**
 *
 * @author Quentin
 */
public class EntryStudentList implements Serializable {

    private int numEtud;
    private String nom;
    private String prenom;
    private int note1;
    private int note2;

    public EntryStudentList(int numEtud, String nom, String prenom, int note1, int note2) {
	this.numEtud = numEtud;
	this.nom = nom;
	this.prenom = prenom;
	this.note1 = note1;
	this.note2 = note2;
    }

    public int getNumEtud() {
	return numEtud;
    }

    public String getNom() {
	return nom;
    }

    public String getPrenom() {
	return prenom;
    }

    public int getNote1() {
	return note1;
    }

    public int getNote2() {
	return note2;
    }

}
