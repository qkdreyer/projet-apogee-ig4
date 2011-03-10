/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POJO;

/**
 *
 * @author Quentin
 */
public class Etudiant {

    private int numEtud;
    private String nom;
    private String prenom;

    public Etudiant(int numEtud, String nom, String prenom) {
	this.numEtud = numEtud;
	this.nom = nom;
	this.prenom = prenom;
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

}