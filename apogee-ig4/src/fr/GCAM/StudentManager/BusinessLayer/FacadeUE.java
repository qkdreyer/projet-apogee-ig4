/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.BusinessLayer;

import fr.GCAM.StudentManager.POJO.UE;

/**
 *
 * @author Jojo
 */
public class FacadeUE {

    public UE ue;
     /*
     * pour afficher la fenetre, j'ai besoin de:
     * nom de l'UE
     * nom du responsable
     * code UE
     * nombre d'ECTS
     * annee
     * departement
     * semestre
     * les ECUE de l'UE avec comme informations
     *          nom de l'UE, du responsable, les détails sur la matiere
      *
      * L'on doit aussi pouvoir switcher entre les années/semestre/UE
      * dont l'utilisateur est responsable (sinon boutons vérouillés)
     */

    public String getLibelleUE(){
        String libue;
        libue = this.ue.getLibelleUE();
        return libue;
    }
    public String getPrenomNomRespo(){
        String nom;
        nom = this.ue.getPrenomResponsable() + " " + this.ue.getNomResponsable();
        return nom;
    }
    public String getCodeUE(){
        String codeue;
        codeue = this.ue.getCodeUE();
        return codeue;
    }
    public String getCodeSemestre(){
        String codes;
        codes = this.ue.getCodeSemestre();
        return codes;
    }
    public int getNbECTS(){
        int nb;
        nb = this.ue.getNbECTS();
        return nb;
    }





}
