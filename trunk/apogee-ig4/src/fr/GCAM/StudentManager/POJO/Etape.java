/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.POJO;

import java.util.ArrayList;

/**
 * Cette classe est un POJO(Plain Old Java Object), qui correspond à l'ensemble
 * des données nécessaires pour réaliser la maquette de l'Etape.
 * L'ensemble de ses méthodes est donc composée uniquement d'accesseurs et de
 * mutateurs.
 *
 * @author pierre
 */
public class Etape {

    private String codeEtape;
    private String versionEtape;
    private String responsable;
    private String versionDiplome;
    private Semestre semestre1;
    private Semestre semestre2;

    public Etape() {
        semestre1 = new Semestre();
        semestre2 = new Semestre();
    }

    public static class Semestre {

        private String codeSemestre;
        private int nbUEFacultatives;
        private String codeEtape;
        private ArrayList<UESemestre> listeUE;

        public Semestre() {
            listeUE = new ArrayList<UESemestre>();
        }

        public static class UESemestre {

            private String codeUE;
            private String libelleUE;

            public UESemestre(String codeUE, String libelleUE) {
                this.codeUE = codeUE;
                this.libelleUE = libelleUE;
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

            public String toString() {
                return getLibelleUE() + "\n";
            }
        }

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

        public ArrayList<UESemestre> getListeUE() {
            return listeUE;
        }

        public void setListeUE(ArrayList<UESemestre> listeUE) {
            this.listeUE = listeUE;
        }

        public int getNbUEFacultatives() {
            return nbUEFacultatives;
        }

        public void setNbUEFacultatives(int nbUEFacultatives) {
            this.nbUEFacultatives = nbUEFacultatives;
        }

        public String toString() {
            String str = "Code Semestre : " + this.getCodeSemestre() + "\n"
                    + "Nombre d'UE facultatives : " + this.getNbUEFacultatives() + "\n"
                    + "Code Etape Parente " + this.getCodeEtape() + "\n";

            for (UESemestre ue : this.getListeUE()) {
                str += "\t" + ue.toString();
            }
            return str;
        }
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

    public String getVersionDiplome() {
        return versionDiplome;
    }

    public void setVersionDiplome(String versionDiplome) {
        this.versionDiplome = versionDiplome;
    }

    public Semestre getSemestre(int i) {
        if (i == 1) {
            return semestre1;
        } else if (i == 2) {
            return semestre2;
        } else {
            return null;
        }
    }

    public String toString() {
        return "Code Etape : " + this.getCodeEtape() + "\n"
                + "Version etape : " + this.getVersionEtape() + "\n"
                + "Responsable : " + this.getResponsable() + "\n"
                + "Version diplome : " + this.getVersionDiplome() + "\n"
                + "Semestre 1 : " + semestre1.toString() + "\n"
                + "Semestre 2 : " + semestre2.toString() + "\n";
    }
}
