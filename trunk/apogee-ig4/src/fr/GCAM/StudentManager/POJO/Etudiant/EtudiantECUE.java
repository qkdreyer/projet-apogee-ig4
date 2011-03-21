/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO.Etudiant;

/**
 *
 * @author Quentin
 */
public class EtudiantECUE extends AbstractEtudiant {

    private float noteSession1;
    private float noteSession2;
    private boolean noteSession1Changed = false;
    private boolean noteSession2Changed = false;

    public EtudiantECUE() {
    }

    public EtudiantECUE(int numEtud, String numIne, String libProv, String libStat, String libNat, String nom, String Prenom, String mail, float noteSession1, float noteSession2) {
	super(numEtud, numIne, libProv, libStat, libNat, nom, Prenom, mail);
	this.noteSession1 = noteSession1;
	this.noteSession2 = noteSession2;
    }

    public boolean isNoteSession1Changed() {
	return noteSession1Changed;
    }

    public boolean isNoteSession2Changed() {
	return noteSession2Changed;
    }

    public float getNoteSession1() {
	return noteSession1;
    }

    /**
     * Si le but de la manipulation est de modifier les notes des eleves d'une
     * ECUE, cette ne methode NE DOIT PAS etre appelée, mais IL FAUT appeler la
     * methode, "modifyNoteSession1(float)"
     * @param noteSession1 float : La nouvelle note
     */
    public void setNoteSession1(float noteSession1) {
	this.noteSession1 = noteSession1;
    }

    public float getNoteSession2() {
	return noteSession2;
    }

    /**
     * Si le but de la manipulation est de modifier les notes des eleves d'une
     * ECUE, cette ne methode NE DOIT PAS etre appelée, mais IL FAUT appeler la
     * methode, "modifyNoteSession2(float)"
     * @param noteSession2 float : La nouvelle note
     */
    public void setNoteSession2(float noteSession2) {
	this.noteSession2 = noteSession2;
    }

    public void setNoteSession1Changed(boolean noteSession1Changed) {
	this.noteSession1Changed = noteSession1Changed;
    }

    public void setNoteSession2Changed(boolean noteSession2Changed) {
	this.noteSession2Changed = noteSession2Changed;
    }

    /**
     * Cette fonction DOIT etre utilisé à la place de la méthode set si le but
     * de la manipulation est de modifier les notes des etudiants d'une ecue.
     * @param ns1 float : La nouvelle note
     */
    public void modifyNoteSession1(float ns1) {
	this.noteSession1 = ns1;
	this.noteSession1Changed = true;
    }

    /**
     * Cette fonction DOIT etre utilisé à la place de la méthode set si le but
     * de la manipulation est de modifier les notes des etudiants d'une ecue.
     * @param ns2 float : La nouvelle note.
     */
    public void modifyNoteSession2(float ns2) {
	this.noteSession2 = ns2;
	this.noteSession2Changed = true;
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
