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
	if (listeResponsabilites == null )
	    this.listeResponsabilites = new ArrayList<Responsabilite>();
	else
	    this.listeResponsabilites = listeResponsabilites;
    }

    public Utilisateur(int idEnseignant, String prenom, String nom, String mdp, String mail, ArrayList<Responsabilite> listeResponsabilites) {
	this.idEnseignant = idEnseignant;
	this.prenom = prenom;
	this.nom = nom;
	this.mdp = mdp;
	this.mail = mail;
	if (listeResponsabilites == null )
	    this.listeResponsabilites = new ArrayList<Responsabilite>();
	else
	    this.listeResponsabilites = listeResponsabilites;
    }



    public int compareTo(Object o) {
	System.out.println("Comparaison de 2 utils");
	if (this.idEnseignant == ((Utilisateur)o).getIdEnseignant() ) {
	    return 0;
	} else if ( this.idEnseignant < ((Utilisateur)o).getIdEnseignant() ) {
	    return 1;
	} else {
	    return -1;
	}
    }

    public static class Responsabilite implements Comparable {

	private String libelle;
	private String codeResponsabilite;

	public Responsabilite() {
	}

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

	public int compareTo(Object o) {
	    if (libelle.equals("Departement")) {
		if (((Responsabilite)o).libelle.equals("Departement")) {
		    return 0;
		} else if (((Responsabilite)o).libelle.equals("Etape")) {
		    return 1;
		} else if (((Responsabilite)o).libelle.equals("UE")) {
		    return 1;
		} else if (((Responsabilite)o).libelle.equals("ECUE")) {
		    return 1;
		} else
		    return 2;
	    } else if (libelle.equals("Etape")) {
		if (((Responsabilite)o).libelle.equals("Departement")) {
		    return -1;
		} else if (((Responsabilite)o).libelle.equals("Etape")) {
		    return 0;
		} else if (((Responsabilite)o).libelle.equals("UE")) {
		    return 1;
		} else if (((Responsabilite)o).libelle.equals("ECUE")) {
		    return 1;
		} else
		    return 2;
	    } else if (libelle.equals("UE")) {
		if (((Responsabilite)o).libelle.equals("Departement")) {
		    return -1;
		} else if (((Responsabilite)o).libelle.equals("Etape")) {
		    return -1;
		} else if (((Responsabilite)o).libelle.equals("UE")) {
		    return 0;
		} else if (((Responsabilite)o).libelle.equals("ECUE")) {
		    return 1;
		} else
		    return 2;
	    } else if (libelle.equals("ECUE")) {
		if (((Responsabilite)o).libelle.equals("Departement")) {
		    return -1;
		} else if (((Responsabilite)o).libelle.equals("Etape")) {
		    return -1;
		} else if (((Responsabilite)o).libelle.equals("UE")) {
		    return -1;
		} else if (((Responsabilite)o).libelle.equals("ECUE")) {
		    return 0;
		} else
		    return 2;
	    } else {
		return 2;
	    }
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

    public Responsabilite getTopResponsability() {
	Responsabilite topRes = new Responsabilite();
	if (listeResponsabilites != null) {

	    topRes = listeResponsabilites.get(0);
	    for (Responsabilite each : listeResponsabilites) {
		if (each.compareTo(topRes) == 1)
		    topRes = each;
	    }
	    return topRes;
	} else
	    return null;
    }
    
}
