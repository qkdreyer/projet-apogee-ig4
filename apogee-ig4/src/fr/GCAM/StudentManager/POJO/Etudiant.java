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
 */
public class Etudiant {

    private int numEtudiant;
    private int pointJuryAnnee;
    private String numIne;
    private int scoreToeic;
    private String libelleProvenance;
    private String libelleStatut;
    private String libelleNationalite;
    private String nom;
    private String prenom;
    private String mail;
    private float noteSession1;
    private float noteSession2;
    private boolean noteSession1Changed = false;
    private boolean noteSession2Changed = false;
    private boolean VAE = false; //TODO VAE APDJ PJsem PJannee choixUE redoubl etranger
    private boolean APDJ = false;

    public Etudiant(int numEtudiant, String nom, String prenom, Float noteSession1, Float noteSession2) {
        this.numEtudiant = numEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.noteSession1 = noteSession1;
        this.noteSession2 = noteSession2;
    }

    public Etudiant() {
    }

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

    public int getPointJuryAnnee() {
        return pointJuryAnnee;
    }

    public void setPointJuryAnnee(int pointJuryAnnee) {
        this.pointJuryAnnee = pointJuryAnnee;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getScoreToeic() {
        return scoreToeic;
    }

    public void setScoreToeic(int scoreToeic) {
        this.scoreToeic = scoreToeic;
    }

    public boolean isNoteSession1Changed() {
        return noteSession1Changed;
    }

    public boolean isNoteSession2Changed() {
        return noteSession2Changed;
    }

    public boolean isAPDJ() {
	return APDJ;
    }

    public void setAPDJ(boolean APDJ) {
	this.APDJ = APDJ;
    }

    public boolean isVAE() {
	return VAE;
    }

    public void setVAE(boolean VAE) {
	this.VAE = VAE;
    }

    public float getNoteSession1() {
	return noteSession1;
    }

    public void setNoteSession1(float noteSession1) {
	this.noteSession1 = noteSession1;
	noteSession1Changed = true;
    }

    public float getNoteSession2() {
	return noteSession2;
    }

    public void setNoteSession2(float noteSession2) {
	this.noteSession2 = noteSession2;
	noteSession2Changed = true;
    }

    public String toString() {
        return getPrenom() + " " + getNom() + "(" + getNumEtudiant() + ") : "
                + getNoteSession1() + (isNoteSession1Changed() ? " (changed) " : " ")
                + "| " + getNoteSession2() + (isNoteSession2Changed() ? " (changed) " : " ") + "\n";
    }
}
