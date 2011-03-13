/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.POJO;

/**
 * Cette classe est un POJO(Plain Old Java Object), qui correspond à l'ensemble
 * des données nécessaires pour réaliser la maquette de l'étudiant.
 * L'ensemble de ses méthodes est donc composée uniquement d'accesseurs et de
 * mutateurs.
 *
 * @author pierre
 * @deprecated 
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