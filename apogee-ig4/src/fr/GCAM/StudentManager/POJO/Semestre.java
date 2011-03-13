/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.POJO;

/**
 * Cette classe est un POJO(Plain Old Java Object), qui correspond à l'ensemble
 * des données nécessaires pour réaliser la maquette du semestre.
 * L'ensemble de ses méthodes est donc composée uniquement d'accesseurs et de
 * mutateurs.
 *
 * @author pierre
 * @deprecated 
 */
public class Semestre {
  
    private String codeSemestre;
    private int nbUEFacultatives;
    private String codeEtape;

    public String getCodeEtape() {
	return codeEtape;
    }

    public void setCodeEtape(String codeEtape) {
	this.codeEtape = codeEtape;
    }

    public String getCodeSemestre() {
	return codeSemestre;
    }

    public void setCodeSemestre(String codeSemestre) {
	this.codeSemestre = codeSemestre;
    }

    public int getNbUEFacultatives() {
	return nbUEFacultatives;
    }

    public void setNbUEFacultatives(int nbUEFacultatives) {
	this.nbUEFacultatives = nbUEFacultatives;
    }

}
