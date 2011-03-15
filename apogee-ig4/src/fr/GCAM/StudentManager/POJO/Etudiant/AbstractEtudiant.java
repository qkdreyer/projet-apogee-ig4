/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO.Etudiant;

/**
 * Cette classe est un POJO(Plain Old Java Object), qui correspond à l'ensemble
 * des données nécessaires pour réaliser la maquette de l'étudiant.
 * L'ensemble de ses méthodes est donc composée uniquement d'accesseurs et de
 * mutateurs.
 *
 * @author pierre
 */
public abstract class AbstractEtudiant {

    private int numEtudiant;
    private String numIne;
    private String libelleProvenance;
    private String libelleStatut;
    private String libelleNationalite;
    private String nom;
    private String prenom;
    private String mail;

    public String getLibelleNationalite() {
	return libelleNationalite;
    }

    public void setLibelleNationalite(String libelleNationalite) {
	this.libelleNationalite = libelleNationalite;
    }

    public String getLibelleProvenance() {
	return libelleProvenance;
    }

    public void setLibelleProvenance(String libelleProvenance) {
	this.libelleProvenance = libelleProvenance;
    }

    public String getLibelleStatut() {
	return libelleStatut;
    }

    public void setLibelleStatut(String libelleStatut) {
	this.libelleStatut = libelleStatut;
    }

    public String getMail() {
	return mail;
    }

    public void setMail(String mail) {
	this.mail = mail;
    }

    public String getNom() {
	return nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public int getNumEtudiant() {
	return numEtudiant;
    }

    public void setNumEtudiant(int numEtud) {
	this.numEtudiant = numEtud;
    }

    public String getNumIne() {
	return numIne;
    }

    public void setNumIne(String numIne) {
	this.numIne = numIne;
    }

    public String getPrenom() {
	return prenom;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    @Override
    public String toString() {
	return getPrenom() + " " + getNom() + "(" + getNumEtudiant() + ")";
    }
}
