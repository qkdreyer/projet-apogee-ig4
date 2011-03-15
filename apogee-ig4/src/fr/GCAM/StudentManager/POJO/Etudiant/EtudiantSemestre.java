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
