/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO.Etudiant;

/**
 *
 * @author Quentin
 */
public class EtudiantSemestre extends AbstractEtudiant {

    private int pointJurySemestre;
    private int MoyEtranger = 0;
    private int MoyRedoublant = 0;
    private boolean etranger;
    private boolean redoublant;

    public EtudiantSemestre() {
    }

    public EtudiantSemestre(int numEtudiant, String numIne, String libelleProvenance, String libelleStatut, String libelleNationalite, String nom, String prenom, String mail, int pointJurySemestre, boolean etranger, boolean redoublant) {
	super(numEtudiant, numIne, libelleProvenance, libelleStatut, libelleNationalite, nom, prenom, mail);
	this.pointJurySemestre = pointJurySemestre;
	this.etranger = etranger;
	this.redoublant = redoublant;
    }

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

    public int getMoyEtranger() {
        return MoyEtranger;
    }

    public void setMoyEtranger(int MoyEtranger) {
        this.MoyEtranger = MoyEtranger;
    }

    public int getMoyRedoublant() {
        return MoyRedoublant;
    }

    public void setMoyRedoublant(int MoyRedoublant) {
        this.MoyRedoublant = MoyRedoublant;
    }

    @Override
    public String toString() {
	return super.toString() + " - "
		+ "Point Jury Semestre : " + getPointJurySemestre()
		+ (isEtranger() ? " (Etranger) " : "")
		+ (isRedoublant() ? " (Redoublant) " : "");
    }
}
