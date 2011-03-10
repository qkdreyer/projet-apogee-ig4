/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POJO;

/**
 *
 * @author pierre
 */
public class UE {

    private String codeUE;
    private int nbECTS;
    private String libelleUE;
    private boolean optionnel;
    private int idEnseignant;
    private String codeSemestre;

    public UE() {
    }

    public UE(String codeUE, int nbECTS, String libelleUE, boolean optionnel, int idEnseignant, String codeSemestre) {
        this.codeUE = codeUE;
        this.nbECTS = nbECTS;
        this.libelleUE = libelleUE;
        this.optionnel = optionnel;
        this.idEnseignant = idEnseignant;
        this.codeSemestre = codeSemestre;
    }

    public String getCodeSemestre() {
        return codeSemestre;
    }

    public void setCodeSemestre(String codeSemestre) {
        this.codeSemestre = codeSemestre;
    }

    public String getCodeUE() {
        return codeUE;
    }

    public void setCodeUE(String codeUE) {
        this.codeUE = codeUE;
    }

    public int getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(int idEnseignant) {
        this.idEnseignant = idEnseignant;
    }

    public String getLibelleUE() {
        return libelleUE;
    }

    public void setLibelleUE(String libelleUE) {
        this.libelleUE = libelleUE;
    }

    public int getNbECTS() {
        return nbECTS;
    }

    public void setNbECTS(int nbECTS) {
        this.nbECTS = nbECTS;
    }

    public boolean isOptionnel() {
        return optionnel;
    }

    public void setOptionnel(boolean optionnel) {
        this.optionnel = optionnel;
    }



}
