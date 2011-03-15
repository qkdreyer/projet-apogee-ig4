/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO.Etudiant;

/**
 *
 * @author Quentin
 */
public class EtudiantECUE extends Etudiant {

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
