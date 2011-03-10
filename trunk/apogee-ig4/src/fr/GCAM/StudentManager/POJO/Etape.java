/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.POJO;

/**
 *
 * @author pierre
 */
public class Etape {

/*    codeEtape varchar2(10),
	versionEtape varchar2(10), -- le chiffre de l'année ?
	idenseignant number,
	versionDiplome varchar2(10),

*/
    private String codeEtape;
    private int idEnseignant;
    private String versionDiplome;

    public String getCodeEtape() {
	return codeEtape;
    }

    public void setCodeEtape(String codeEtape) {
	this.codeEtape = codeEtape;
    }

    public int getIdEnseignant() {
	return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
	this.idEnseignant = idEnseignant;
    }

    public String getVersionDiplome() {
	return versionDiplome;
    }

    public void setVersionDiplome(String versionDiplome) {
	this.versionDiplome = versionDiplome;
    }



}
