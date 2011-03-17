/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantUE;
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
    private ArrayList<ECUE> listeECUE;
    private ArrayList<EtudiantUE> listeEtud;


    public UE() {
        listeECUE = new ArrayList<ECUE>();
        listeEtud = new ArrayList<EtudiantUE>();
    }

    public UE(String codeUE, String libelleUE) {
        this.codeUE = codeUE;
        this.libelleUE = libelleUE;
        listeECUE = new ArrayList<ECUE>();
        listeEtud = new ArrayList<EtudiantUE>();
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

    public ArrayList<ECUE> getListeECUE() {
        return listeECUE;
    }

    public void setListeECUE(ArrayList<ECUE> listeECUE) {
        this.listeECUE = listeECUE;
    }
    
    
    public ArrayList<EtudiantUE> getListeEtud() {
        return listeEtud;
    }

    public void setListeEtud(ArrayList<EtudiantUE> listeEtud) {
        this.listeEtud = listeEtud;
    }

    @Override
    public String toString() {
        String str = "Code UE : " + this.getCodeUE() + "\n"
                + "libelle UE : " + this.getLibelleUE() + "\n"
                + "Optionnel : " + this.isOptionnel() + "\n"
                + "Responsable : " + this.getResponsable() + "\n"
                + "Code Semestre Parent : " + this.getCodeSemestre() + "\n"
                + "Liste ECUE : \n";

        for (ECUE ecue : this.getListeECUE()) {
            str += "\t" + ecue.toString();
        }
        return str;
    }
    
    public float getMoyenne(int numEtud) {
	float noteTotal = 0;
	float nbHeureTotal = 0;
	for (ECUE ecue : listeECUE) {
	    nbHeureTotal += ecue.getNbHeures();
	    noteTotal += ecue.getNote(numEtud)*ecue.getNbHeures();
	}
	return noteTotal/nbHeureTotal;
    }


}
