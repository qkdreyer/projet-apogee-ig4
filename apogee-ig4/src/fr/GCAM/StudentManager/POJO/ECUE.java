/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO;

import java.util.ArrayList;

/**
 * Cette classe est un POJO(Plain Old Java Object), qui correspond à l'ensemble
 * des données nécessaires pour réaliser la maquette de l'ECUE.
 * L'ensemble de ses méthodes est donc composée uniquement d'accesseurs et de
 * mutateurs.
 *
 * @author pierre
 */
public class ECUE {

    private String codeMatiere;
    private String libelleECUE;
    private int nbHeures;
    private String responsable;
    private String codeUE;
    private ArrayList<EtudiantECUE> listeEtud;

    public ECUE() {
	listeEtud = new ArrayList<EtudiantECUE>();
    }

    public static class EtudiantECUE {

	public EtudiantECUE(int numEtud, String nom, String prenom, float noteSession1, float noteSession2) {
	    this.numEtud = numEtud;
	    this.nom = nom;
	    this.prenom = prenom;
	    this.noteSession1 = noteSession1;
	    this.noteSession2 = noteSession2;
	}

	private int numEtud;
	private String nom;
	private String prenom;
	private float noteSession1;
	private float noteSession2;

        private boolean noteSession1Changed = false;
        private boolean noteSession2Changed = false;

        public boolean isNoteSession1Changed() {
            return noteSession1Changed;
        }

        public boolean isNoteSession2Changed() {
            return noteSession2Changed;
        }

	public String getNom() {
	    return nom;
	}

	public float getNoteSession1() {
	    return noteSession1;
	}

	public void setNoteSession1(float note1) {
	    this.noteSession1 = note1;
            this.noteSession1Changed = true;
	}

	public float getNoteSession2() {
	    return noteSession2;
	}

	public void setNoteSession2(float note2) {
	    this.noteSession2 = note2;
            this.noteSession2Changed = true;
	}

	public int getNumEtud() {
	    return numEtud;
	}

	public String getPrenom() {
	    return prenom;
	}

        public String toString() {
            String str = getPrenom() + " " + getNom() + "(" + getNumEtud() + ") : " + getNoteSession1() + " | " + getNoteSession2() + "\n";
            return str;
        }
    }

    public boolean hasStudent(Integer i) {
        return (i > 0 && i <= listeEtud.size());
    }

    public String getCodeMatiere() {
	return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
	this.codeMatiere = codeMatiere;
    }

    public String getCodeUE() {
	return codeUE;
    }

    public void setCodeUE(String codeUE) {
	this.codeUE = codeUE;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getLibelleECUE() {
	return libelleECUE;
    }

    public void setLibelleECUE(String libelleECUE) {
	this.libelleECUE = libelleECUE;
    }

    public int getNbHeures() {
	return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
	this.nbHeures = nbHeures;
    }

    public ArrayList<EtudiantECUE> getListeEtud() {
	return listeEtud;
    }

    public void setListeEtud(ArrayList<EtudiantECUE> listeEtud) {
	this.listeEtud = listeEtud;
    }

    @Override
    public String toString() {
        String str = "Code Matiere : " + this.getCodeMatiere() + "\n"
                + "Libelle ECUE : " + this.getLibelleECUE() + "\n"
                + "Responsable : " + this.getResponsable() + "\n"
                + "Code UE Parente : " + this.getCodeUE() + "\n"
                + "Nombre d'heures : " + this.getNbHeures() + "\n"
                + "Liste etudiants : \n";

        for(EtudiantECUE e : this.getListeEtud()) {
            str += "\t" + e.toString();
        }
        return str;
    }

}