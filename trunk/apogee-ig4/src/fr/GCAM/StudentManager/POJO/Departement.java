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
    private ArrayList<EtapeDepartement> listeEtape;

    public Departement() {
        listeEtape = new ArrayList<EtapeDepartement>();
    }

    public static class EtapeDepartement {

        private String codeEtape;
        private String versionEtape;

        public EtapeDepartement(String codeEtape, String versionEtape) {
            this.codeEtape = codeEtape;
            this.versionEtape = versionEtape;
        }

        public String getVersionEtape() {
            return versionEtape;
        }

        public void setVersionEtape(String versionEtape) {
            this.versionEtape = versionEtape;
        }

        public String getCodeEtape() {
            return codeEtape;
        }

        public void setCodeEtape(String codeEtape) {
            this.codeEtape = codeEtape;
        }

        public String toString() {
            return "Version etape : " + versionEtape + " - Code etape : " + codeEtape + "\n";
        }
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

    public ArrayList<EtapeDepartement> getListeEtape() {
        return listeEtape;
    }

    public void setListeEtape(ArrayList<EtapeDepartement> listeEtape) {
        this.listeEtape = listeEtape;
    }

    public String toString() {
        String str = "Version diplome : " + versionDiplome + "\n"
                + "Nom departement : " + nomDepartement
                + " (" + mnemo + ")\n";
        for (EtapeDepartement dept : listeEtape) {
            str += "\t" + dept.toString();
        }
        return str;
    }
}
