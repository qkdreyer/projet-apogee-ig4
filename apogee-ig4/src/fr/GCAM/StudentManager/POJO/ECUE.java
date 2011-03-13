/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO;

import java.util.ArrayList;

/**
 * Cette classe est un POJO(Plain Old Java Object), qui correspond à l'ensemble
 * des données nécessaires pour réaliser la maquette de l'ECUE.
 * L'ensemble de ses méthodes est donc composée uniquement d'accesseurs et de
 * mutateurs.
 *
 * @author pierre
 */
public class ECUE {

    private String codeMatiere;
    private String libelleECUE;
    private int nbHeures;
    private String responsable;
    private String codeUE;
    private ArrayList<Etudiant> listeEtud;

    public ECUE() {
        listeEtud = new ArrayList<Etudiant>();
    }

    public ECUE(String codeMatiere, String libelleECUE) {
        this.codeMatiere = codeMatiere;
        this.libelleECUE = libelleECUE;
        listeEtud = new ArrayList<Etudiant>();
    }

    public boolean hasStudent(Integer i) {
        return (i > 0 && i <= listeEtud.size());
    }

    public String getCodeMatiere() {
	return codeMatiere;
    }

    public void setCodeMatiere(String codeMatiere) {
	this.codeMatiere = codeMatiere;
    }

    public String getCodeUE() {
	return codeUE;
    }

    public void setCodeUE(String codeUE) {
	this.codeUE = codeUE;
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

    public String getLibelleECUE() {
	return libelleECUE;
    }

    public void setLibelleECUE(String libelleECUE) {
	this.libelleECUE = libelleECUE;
    }

    public int getNbHeures() {
	return nbHeures;
    }

    public void setNbHeures(int nbHeures) {
	this.nbHeures = nbHeures;
    }

    public ArrayList<Etudiant> getListeEtud() {
	return listeEtud;
    }

    public void setListeEtud(ArrayList<Etudiant> listeEtud) {
	this.listeEtud = listeEtud;
    }

    @Override
    public String toString() {
        String str = "Code Matiere : " + this.getCodeMatiere() + "\n"
                + "Libelle ECUE : " + this.getLibelleECUE() + "\n"
                + "Responsable : " + this.getResponsable() + "\n"
                + "Code UE Parente : " + this.getCodeUE() + "\n"
                + "Nombre d'heures : " + this.getNbHeures() + "\n"
                + "Liste etudiants : \n";

        for(Etudiant e : this.getListeEtud()) {
            str += "\t" + e.toString();
        }
        return str;
    }

}