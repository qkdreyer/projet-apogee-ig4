/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO;

import java.util.ArrayList;

/**
 * Cette classe est un POJO(Plain Old Java Object), qui correspond à l'ensemble
 * des données nécessaires pour réaliser la maquette du département.
 * L'ensemble de ses méthodes est donc composée uniquement d'accesseurs et de 
 * mutateurs.
 *
 * @author pierre
 */
public class Departement {

    private String versionDiplome;
    private String nomDepartement;
    private String mnemo;
    private ArrayList<Etape> listeEtape;

    public Departement() {
        listeEtape = new ArrayList<Etape>();
    }

    public Departement(String versionDiplome, String nomDepartement, String mnemo, ArrayList<Etape> listeEtape) {
	this.versionDiplome = versionDiplome;
	this.nomDepartement = nomDepartement;
	this.mnemo = mnemo;
	this.listeEtape = listeEtape;
    }
    
 
    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
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

    public ArrayList<Etape> getListeEtape() {
        return listeEtape;
    }

    public void setListeEtape(ArrayList<Etape> listeEtape) {
        this.listeEtape = listeEtape;
    }

    public String toString() {
        String str = "Version diplome : " + versionDiplome + "\n"
                + "Nom departement : " + nomDepartement
                + " (" + mnemo + ")\n";
        for (Etape e : listeEtape) {
            str += "\t" + e.toString();
        }
        return str;
    }
}
