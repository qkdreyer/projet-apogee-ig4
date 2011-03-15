/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO.Etudiant;

/**
 *
 * @author Quentin
 */
public class EtudiantUE extends AbstractEtudiant {

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
