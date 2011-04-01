/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO.Business.Etudiant;

/**
 *
 * @author Quentin
 */
public class EtudiantUE extends AbstractEtudiant {

    private boolean vae = false;
    private boolean apdj = false;

    public EtudiantUE() {
    }

    
    public EtudiantUE(int numEtudiant, String numIne, String libelleProvenance, String libelleStatut, String libelleNationalite, String nom, String prenom, String mail, boolean vae, boolean apdj) {
	super(numEtudiant, numIne, libelleProvenance, libelleStatut, libelleNationalite, nom, prenom, mail);
	this.vae = vae;
	this.apdj = apdj;
    }
    
    public boolean isAPDJ() {
	return apdj;
    }

    public void setAPDJ(boolean APDJ) {
	this.apdj = APDJ;
    }

    public boolean isVAE() {
	return vae;
    }

    public void setVAE(boolean VAE) {
	this.vae = VAE;
    }

    @Override
    public String toString() {
	return super.toString()
		+ (isAPDJ() ? " (APDJ) " : "")
		+ (isVAE() ? " (VAE) " : "");
    }
}
