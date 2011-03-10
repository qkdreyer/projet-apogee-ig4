/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.POJO;

/**
 *
 * @author pierre
 */
public class Departement {

    private String versionDiplome;
    private String mnemo;
    private int idEnseignant;

    public Departement(String versionDiplome, String mnemo, int idEnseignant) {
	this.versionDiplome = versionDiplome;
	this.mnemo = mnemo;
	this.idEnseignant = idEnseignant;
    }

    public int getIdEnseignant() {
	return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
	this.idEnseignant = idEnseignant;
    }

    public String getMnemo() {
	return mnemo;
    }

    public void setMnemo(String mnemo) {
	this.mnemo = mnemo;
    }

    public String getVersionDiplome() {
	return versionDiplome;
    }

    public void setVersionDiplome(String versionDiplome) {
	this.versionDiplome = versionDiplome;
    }

    

}
