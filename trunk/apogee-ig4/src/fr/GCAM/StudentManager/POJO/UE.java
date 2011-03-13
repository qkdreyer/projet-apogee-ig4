/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO;

import java.util.ArrayList;

/**
 * Cette classe est un POJO(Plain Old Java Object), qui correspond à l'ensemble
 * des données nécessaires pour réaliser la maquette de l'ue.
 * L'ensemble de ses méthodes est donc composée uniquement d'accesseurs et de
 * mutateurs.
 *
 * @author pierre
 */
public class UE {

    private String codeUE;
    private int nbECTS;
    private String libelleUE;
    private boolean optionnel;
    private String responsable;
    private String codeSemestre;
    private ArrayList<ECUEUE> listeECUE;

    public UE() {
        listeECUE = new ArrayList<ECUEUE>();
    }

    public static class ECUEUE {

        private String codeMatiere;
        private String libelleECUE;

        public ECUEUE(String codeMatiere, String libelleECUE) {
            this.codeMatiere = codeMatiere;
            this.libelleECUE = libelleECUE;
        }

        public String getCodeMatiere() {
            return codeMatiere;
        }

        public void setCodeMatiere(String codeMatiere) {
            this.codeMatiere = codeMatiere;
        }

        public String getLibelleECUE() {
            return libelleECUE;
        }

        public void setLibelleECUE(String libelleECUE) {
            this.libelleECUE = libelleECUE;
        }

        public String toString() {
            String str = this.getLibelleECUE() + " ("
                    + this.getCodeMatiere() + ")\n";
            return str;
        }
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getPrenomResponsable() {
        return responsable.split(" ")[0];
    }

    public String getNomResponsable() {
        return responsable.split(" ")[1];
    }

    public ArrayList<ECUEUE> getListeECUE() {
        return listeECUE;
    }

    public void setListeECUE(ArrayList<ECUEUE> listeECUE) {
        this.listeECUE = listeECUE;
    }

    public String toString() {
        String str = "Code UE : " + this.getCodeUE() + "\n"
                + "libelle UE : " + this.getLibelleUE() + "\n"
                + "Optionnel : " + this.isOptionnel() + "\n"
                + "Responsable : " + this.getResponsable() + "\n"
                + "Code Semestre Parent : " + this.getCodeSemestre() + "\n"
                + "Liste ECUE : \n";

        for (ECUEUE ecue : this.getListeECUE()) {
            str += "\t" + ecue.toString();
        }
        return str;
    }
}
