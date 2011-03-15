/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO;

import java.util.ArrayList;

/**
 * Cette classe est un POJO(Plain Old Java Object), qui correspond à l'ensemble
 * des données nécessaires pour réaliser la maquette de l'utilisateur.
 * L'ensemble de ses méthodes est donc composée uniquement d'accesseurs et de
 * mutateurs.
 *
 * @author pierre
 */
public class Utilisateur implements Comparable {

    private int idEnseignant;
    private String prenom;
    private String nom;
    private String mdp;
    private String mail;
    private ArrayList<Responsabilite> listeResponsabilites;

    public Utilisateur() {
        listeResponsabilites = new ArrayList<Responsabilite>();
    }

    public Utilisateur(int idEnseignant, String prenom, String nom, String mdp, ArrayList<Responsabilite> listeResponsabilites) {
	this.idEnseignant = idEnseignant;
	this.prenom = prenom;
	this.nom = nom;
	this.mdp = mdp;
	this.listeResponsabilites = listeResponsabilites;
    }

    public int compareTo(Object o) {
	if (this.idEnseignant == ((Utilisateur)o).getIdEnseignant() ) {
	    return 0;
	} else if ( this.idEnseignant < ((Utilisateur)o).getIdEnseignant() ) {
	    return 1;
	} else {
	    return -1;
	}
    }

    public static class Responsabilite {

	private String libelle;
	private String codeResponsabilite;

	public Responsabilite(String codeResponsabilite, String libelle) {
	    this.codeResponsabilite = codeResponsabilite;
	    this.libelle = libelle;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
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

    public void setMDP(String mdp) {
	this.mdp = mdp;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    public String toString() {
	String str = "(id:" + this.getIdEnseignant() + ") " + this.getPrenom() + "." + this.getNom()
                + " (" + this.getMDP() + ")\n"
                + mail + "\n";
	for (Responsabilite r : this.getListeResponsabilites()) {
	    str += "\t" + r.toString();
	}

	return str;
    }
    
}
