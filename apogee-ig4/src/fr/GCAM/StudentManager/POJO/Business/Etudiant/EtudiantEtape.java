/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO.Business.Etudiant;

/**
 *
 * @author Quentin
 */
public class EtudiantEtape extends AbstractEtudiant {

    private int scoreToeic;
    private float pointJuryAnnee;

    public EtudiantEtape() {
    }
    

    public EtudiantEtape(int numEtudiant, String numIne, String libelleProvenance, String libelleStatut, String libelleNationalite, String nom, String prenom, String mail, int scoreToeic, float pointJuryAnnee) {
	super(numEtudiant, numIne, libelleProvenance, libelleStatut, libelleNationalite, nom, prenom, mail);
	this.scoreToeic = scoreToeic;
	this.pointJuryAnnee = pointJuryAnnee;
    }

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
