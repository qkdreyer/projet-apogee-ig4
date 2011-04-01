/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO.Business.Etudiant;

/**
 *
 * @author Quentin
 */
public class EtudiantSemestre extends AbstractEtudiant {

    private float pointJurySemestre;
    private float moyEtranger = -1;
    private float moyRedoublant = -1;

    public EtudiantSemestre() {
    }

    public EtudiantSemestre(int numEtudiant, String numIne, String libelleProvenance, String libelleStatut, String libelleNationalite, String nom, String prenom, String mail, float pointJurySemestre, float moyEtranger, float moyRedoublant) {
	super(numEtudiant, numIne, libelleProvenance, libelleStatut, libelleNationalite, nom, prenom, mail);
	this.pointJurySemestre = pointJurySemestre;
	this.moyEtranger = moyEtranger;
	this.moyRedoublant = moyRedoublant;
    }

    public float getPointJurySemestre() {
	return pointJurySemestre;
    }

    public void setPointJurySemestre(float pointJurySemestre) {
	this.pointJurySemestre = pointJurySemestre;
    }

    public float getMoyEtranger() {
        return moyEtranger;
    }

    public void setMoyEtranger(int MoyEtranger) {
        this.moyEtranger = MoyEtranger;
    }

    public float getMoyRedoublant() {
        return moyRedoublant;
    }

    public void setMoyRedoublant(int MoyRedoublant) {
        this.moyRedoublant = MoyRedoublant;
    }

    @Override
    public String toString() {
	return super.toString() + " - "
		+ "Point Jury Semestre : " + getPointJurySemestre()
		+ (moyEtranger > 0 ? moyEtranger : "")
		+ (moyRedoublant > 0 ? moyRedoublant : "");
    }
}
