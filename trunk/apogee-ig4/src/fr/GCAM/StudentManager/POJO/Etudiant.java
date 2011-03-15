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
public abstract class Etudiant {

    private int numEtudiant;
    private String numIne;
    private String libelleProvenance;
    private String libelleStatut;
    private String libelleNationalite;
    private String nom;
    private String prenom;
    private String mail;

    public static class EtudiantECUE extends Etudiant {

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

	public float getNoteSession1() {
	    return noteSession1;
	}

	public void setNoteSession1(float noteSession1) {
	    this.noteSession1 = noteSession1;
	}

	public float getNoteSession2() {
	    return noteSession2;
	}

	public void setNoteSession2(float noteSession2) {
	    this.noteSession2 = noteSession2;
	}

	public void setNoteSession1Changed(boolean noteSession1Changed) {
	    this.noteSession1Changed = noteSession1Changed;
	}

	public void setNoteSession2Changed(boolean noteSession2Changed) {
	    this.noteSession2Changed = noteSession2Changed;
	}

	@Override
	public String toString() {
	    return super.toString() + " - "
		    + "Note1 : " + getNoteSession1()
		    + (isNoteSession1Changed() ? " (changed) " : " ") + " - "
		    + "Note2 : " + getNoteSession2()
		    + (isNoteSession2Changed() ? " (changed) " : " ") + "\n";
	}
    }

    public static class EtudiantUE extends Etudiant {

	private boolean VAE = false;
	private boolean APDJ = false;

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

	@Override
	public String toString() {
	    return super.toString()
		    + (isAPDJ() ? " (APDJ) " : "")
		    + (isVAE() ? " (VAE) " : "");
	}
    }

    public static class EtudiantSemestre extends Etudiant {

	private int pointJurySemestre;
	private boolean etranger;
	private boolean redoublant;

	public boolean isEtranger() {
	    return etranger;
	}

	public void setEtranger(boolean etranger) {
	    this.etranger = etranger;
	}

	public int getPointJurySemestre() {
	    return pointJurySemestre;
	}

	public void setPointJurySemestre(int pointJurySemestre) {
	    this.pointJurySemestre = pointJurySemestre;
	}

	public boolean isRedoublant() {
	    return redoublant;
	}

	public void setRedoublant(boolean redoublant) {
	    this.redoublant = redoublant;
	}

	@Override
	public String toString() {
	    return super.toString() + " - "
		    + "Point Jury Semestre : " + getPointJurySemestre()
		    + (isEtranger() ? " (Etranger) " : "")
		    + (isRedoublant() ? " (Redoublant) " : "");
	}

    }

    public static class EtudiantEtape {

	private int scoreToeic;
	private float pointJuryAnnee;

	public float getPointJuryAnnee() {
	    return pointJuryAnnee;
	}

	public void setPointJuryAnnee(float pointJuryAnnee) {
	    this.pointJuryAnnee = pointJuryAnnee;
	}

	public int getScoreToeic() {
	    return scoreToeic;
	}

	public void setScoreToeic(int scoreToeic) {
	    this.scoreToeic = scoreToeic;
	}

	@Override
	public String toString() {
	    return super.toString() + " - "
		    + "Score TOEIC : " + getScoreToeic()
		    + "Point Jury Annee : " + getPointJuryAnnee();
	}

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

    public String getPrenom() {
	return prenom;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    public String toString() {
	return getPrenom() + " " + getNom() + "(" + getNumEtudiant() + ")";
    }
}
