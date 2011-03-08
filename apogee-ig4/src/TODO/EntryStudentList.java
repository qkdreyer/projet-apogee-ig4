/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TODO;

import java.io.Serializable;

/**
 *
 * @author Quentin
 */
public class EntryStudentList implements Serializable {

    private int numEtud;
    private String nom;
    private String prenom;
    private float note1;
    private float note2;

    public EntryStudentList(int numEtud, String nom, String prenom, float note1, float note2) {
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

    public float getNote1() {
	return note1;
    }

    public float getNote2() {
	return note2;
    }

    public void setNote1(float f) {
        note1 = f;
    }

    public void setNote2(float f) {
        note2 = f;
    }

}
