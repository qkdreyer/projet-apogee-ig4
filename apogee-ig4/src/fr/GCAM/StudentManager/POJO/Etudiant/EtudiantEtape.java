/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO.Etudiant;

/**
 *
 * @author Quentin
 */
public class EtudiantEtape extends AbstractEtudiant {

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
