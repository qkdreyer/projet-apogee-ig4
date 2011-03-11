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
public class Utilisateur {

    private int idEnseignant;
    private String prenom;
    private String nom;
    private String mdp;
    private ArrayList<Responsabilite> listeResponsabilites;

    public Utilisateur() {
    }

    public Utilisateur(int idEnseignant, String prenom, String nom, String mdp, ArrayList<Responsabilite> listeResponsabilites) {
	this.idEnseignant = idEnseignant;
	this.prenom = prenom;
	this.nom = nom;
	this.mdp = mdp;
	this.listeResponsabilites = listeResponsabilites;
    }

    public static class Responsabilite {

	private String libelle;
	private String codeResponsabilite;

	public Responsabilite(String codeResponsabilite, String libelle) {
	    this.libelle = libelle;
	    this.codeResponsabilite = codeResponsabilite;
	}

	public String getCodeResponsabilite() {
	    return codeResponsabilite;
	}

	public String getLibelle() {
	    return libelle;
	}

	@Override
	public String toString() {
	    String str = this.getLibelle() + " (" + this.getCodeResponsabilite() + ")\n";
	    return str;
	}
    }

    public int getIdEnseignant() {
	return idEnseignant;
    }

    public String getNom() {
	return nom;
    }

    public String getMDP() {
	return mdp;
    }

    public String getPrenom() {
	return prenom;
    }

    public ArrayList<Responsabilite> getListeResponsabilites() {
	return listeResponsabilites;
    }

    public void setIdEnseignant(int idEnseignant) {
	this.idEnseignant = idEnseignant;
    }

    public void setListeResponsabilites(ArrayList<Responsabilite> listeResponsabilites) {
	this.listeResponsabilites = listeResponsabilites;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public void setPassword(String password) {
	this.mdp = password;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    @Override
    public String toString() {
	String str = this.getPrenom() + "." + this.getNom() + " (" + this.getIdEnseignant() + ")\n";

	for (Responsabilite r : this.getListeResponsabilites()) {
	    str += "\t" + r.toString();
	}

	return str;
    }
}
