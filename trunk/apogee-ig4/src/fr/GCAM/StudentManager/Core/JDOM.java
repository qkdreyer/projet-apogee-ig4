/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Core;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.Persist.DB.*;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import org.jdom.*;
import org.jdom.output.*;

/**
 * Classe qui permet la création des fichiers XML. On utilise JDOM afin de 
 * transformet nos données stocker dans la DB dans des fichiers XML
 * basés sur les POJO.
 *
 * @author Quentin
 */
public class JDOM {

    public static Connection conn = ConnectionDB.getConnection();

    public static void main(String[] args) {
        try {
            createUtilisateurXML("Utilisateur");
            createECUEXML("ECUE");
            createUEXML("UE");
            createEtapeXML("Etape");
            createDepartementXML("Departement");
            createEtudiantXML("Etudiant");
        } catch (Exception ex) {
            System.err.println("Erreur : " + ex);
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param s
     * @throws Exception
     */
    public static void createECUEXML(String s) throws Exception {
        Element root = new Element("root");
        Document document = new Document(root);
        Element ECUE, listeEtud, Etudiant;
        ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct codeMatiere from VO_" + s);
        ECUE ecue;

        while (result.next()) {
            ECUE = new Element(s);
            ecue = new DBECUE(conn).find(result.getString(1));

            listeEtud = new Element("listeEtud");
            for (Etudiant etud : ecue.getListeEtud()) {
                Etudiant = new Element("Etudiant");
                Etudiant.addContent(new Element("numEtudiant").setText(Integer.toString(etud.getNumEtudiant())));
                Etudiant.addContent(new Element("nom").setText(etud.getNom()));
                Etudiant.addContent(new Element("prenom").setText(etud.getPrenom()));
                Etudiant.addContent(new Element("noteSession1").setText(Float.toString(etud.getNoteSession1())));
                Etudiant.addContent(new Element("noteSession2").setText(Float.toString(etud.getNoteSession2())));
                listeEtud.addContent(Etudiant);
            }

            ECUE.addContent(new Element("codeMatiere").setText(ecue.getCodeMatiere()));
            ECUE.addContent(new Element("libelleECUE").setText(ecue.getLibelleECUE()));
            ECUE.addContent(new Element("nbHeures").setText(Integer.toString(ecue.getNbHeures())));
            ECUE.addContent(new Element("responsable").setText(ecue.getResponsable()));
            ECUE.addContent(new Element("codeUE").setText(ecue.getCodeUE()));
            ECUE.addContent(listeEtud);
            root.addContent(ECUE);
        }
        save(document, "xml/" + s + ".xml");
    }

    /**
     *
     * @param s
     * @throws Exception
     */
    public static void createUtilisateurXML(String s) throws Exception {
        Element root = new Element("root");
        Document document = new Document(root);
        Element Utilisateur, listeResponsabilites, responsabilite;
        ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct idEnseignant from VO_" + s);
        Utilisateur util;

        while (result.next()) {
            Utilisateur = new Element(s);
            util = new DBUtilisateur(conn).find(result.getInt(1));

            listeResponsabilites = new Element("listeResponsabilites");
            for (Utilisateur.Responsabilite resp : util.getListeResponsabilites()) {
                responsabilite = new Element("responsabilite");
                responsabilite.addContent(new Element("libelle").setText(resp.getLibelle()));
                responsabilite.addContent(new Element("codeResponsabilite").setText(resp.getCodeResponsabilite()));
                listeResponsabilites.addContent(responsabilite);
            }

            Utilisateur.addContent(new Element("nom").setText(util.getNom()));
            Utilisateur.addContent(new Element("prenom").setText(util.getPrenom()));
            //Utilisateur.addContent(new Element("mdp").setText(util.getMDP()));
            Utilisateur.addContent(new Element("mdp").setText(MD5.getHash(util.getMDP())));
            Utilisateur.addContent(new Element("mail").setText(util.getMail()));
            Utilisateur.addContent(listeResponsabilites);
            root.addContent(Utilisateur);
        }
        save(document, "xml/" + s + ".xml");
    }

    /**
     *
     * @param d
     */
    //Ajouter ces deux méthodes à notre classe JDOM1
    public static void print(Document d) {
        try {
            //On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(d, System.out);
        } catch (java.io.IOException e) {
            System.err.println("Erreur d'entrée/sortie : " + e);
        }
    }

    /**
     *
     * @param d
     * @param fichier
     */
    public static void save(Document d, String fichier) {
        try {
            //On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
            //avec en argument le nom du fichier pour effectuer la sérialisation.
            sortie.output(d, new FileOutputStream(fichier));
        } catch (java.io.IOException e) {
            System.err.println("Erreur d'entrée/sortie : " + e);
        }
    }

    /**
     *
     * @param s
     * @throws Exception
     */
    public static void createUEXML(String s) throws Exception {
        Element root = new Element("root");
        Document document = new Document(root);
        Element UE, listeECUE, ECUE;
        ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct codeUE from VO_" + s);
        UE ue;

        while (result.next()) {
            UE = new Element(s);
            ue = new DBUE(conn).find(result.getString(1));

            listeECUE = new Element("listeECUE");
            for (ECUE ecue : ue.getListeECUE()) {
                ECUE = new Element("ECUE");
                ECUE.addContent(new Element("codeMatiere").setText(ecue.getCodeMatiere()));
                ECUE.addContent(new Element("libelleECUE").setText(ecue.getLibelleECUE()));
                listeECUE.addContent(ECUE);
            }

            UE.addContent(new Element("codeUE").setText(ue.getCodeUE()));
            UE.addContent(new Element("nbECTS").setText(Integer.toString(ue.getNbECTS())));
            UE.addContent(new Element("libelleUE").setText(ue.getLibelleUE()));
            UE.addContent(new Element("optionnel").setText(Boolean.toString(ue.isOptionnel())));
            UE.addContent(new Element("responsable").setText(ue.getResponsable()));
            UE.addContent(new Element("codeSemestre").setText(ue.getCodeSemestre()));
            UE.addContent(listeECUE);
            root.addContent(UE);
        }
        save(document, "xml/" + s + ".xml");
    }

    /**
     *
     * @param s
     * @throws Exception
     */
    public static void createEtapeXML(String s) throws Exception {
        Element root = new Element("root");
        Document document = new Document(root);
        Element Etape, Semestre, listeUE, UE;
        ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct codeEtape from VO_" + s);
        Etape etape;

        while (result.next()) {
            Etape = new Element(s);
            etape = new DBEtape(conn).find(result.getString(1));

            Etape.addContent(new Element("codeEtape").setText(etape.getCodeEtape()));
            Etape.addContent(new Element("versionEtape").setText(etape.getVersionEtape()));
            Etape.addContent(new Element("versionDiplome").setText(etape.getVersionDiplome()));
            Etape.addContent(new Element("responsable").setText(etape.getResponsable()));
            for (int numSem = 1; numSem <= 2; numSem++) {
                Semestre = new Element("semestre" + numSem);
                listeUE = new Element("listeUE");

                for (UE ue : etape.getSemestre(numSem).getListeUE()) {
                    UE = new Element("UE");
                    UE.addContent(new Element("codeUE").setText(ue.getCodeUE()));
                    UE.addContent(new Element("libelleUE").setText(ue.getLibelleUE()));
                    listeUE.addContent(UE);
                }

                Semestre.addContent(new Element("codeSemestre").setText(etape.getSemestre(numSem).getCodeSemestre()));
                Semestre.addContent(new Element("nbUEFacultatives").setText(Integer.toString(etape.getSemestre(numSem).getNbUEFacultatives())));
                Semestre.addContent(new Element("codeEtape").setText(etape.getSemestre(numSem).getCodeEtape()));
                Semestre.addContent(listeUE);
                Etape.addContent(Semestre);
            }
            root.addContent(Etape);
        }
        save(document, "xml/" + s + ".xml");
    }

    /**
     * 
     * @param s
     * @throws Exception
     */
    public static void createDepartementXML(String s) throws Exception {
        Element root = new Element("root");
        Document document = new Document(root);
        Element Departement, listeEtape, Etape;
        ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct versionDiplome from VO_" + s);
        Departement dept;

        while (result.next()) {
            Departement = new Element(s);
            dept = new DBDepartement(conn).find(result.getString(1));

            listeEtape = new Element("listeEtape");
            for (Etape etape : dept.getListeEtape()) {
                Etape = new Element("Etape");
                Etape.addContent(new Element("codeEtape").setText(etape.getCodeEtape()));
                Etape.addContent(new Element("versionEtape").setText(etape.getVersionEtape()));
                listeEtape.addContent(Etape);
            }

            Departement.addContent(new Element("versionDiplome").setText(dept.getVersionDiplome()));
            Departement.addContent(new Element("nomDepartement").setText(dept.getNomDepartement()));
            Departement.addContent(new Element("mNemo").setText(dept.getMnemo()));
            Departement.addContent(listeEtape);
            root.addContent(Departement);
        }
        save(document, "xml/" + s + ".xml");
    }

    public static void createEtudiantXML(String s) throws Exception {
        Element root = new Element("root");
        Document document = new Document(root);
        Element Etudiant;
        ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct numEtudiant from VO_" + s);
        Etudiant etud;

        while (result.next()) {
            Etudiant = new Element(s);
            etud = new DBEtudiant(conn).find(result.getString(1));

            Etudiant.addContent(new Element("numEtudiant").setText(Integer.toString(etud.getNumEtudiant())));
            Etudiant.addContent(new Element("pointJuryAnnee").setText(Integer.toString(etud.getPointJuryAnnee())));
            Etudiant.addContent(new Element("numIne").setText(etud.getNumIne()));
            Etudiant.addContent(new Element("scoreToeic").setText(Integer.toString(etud.getScoreToeic())));
            Etudiant.addContent(new Element("libelleProvenance").setText(etud.getLibelleProvenance()));
            Etudiant.addContent(new Element("libelleStatut").setText(etud.getLibelleStatut()));
            Etudiant.addContent(new Element("libelleNationalite").setText(etud.getLibelleNationalite()));
            Etudiant.addContent(new Element("nom").setText(etud.getNom()));
            Etudiant.addContent(new Element("prenom").setText(etud.getPrenom()));
            Etudiant.addContent(new Element("mail").setText(etud.getMail()));
            Etudiant.addContent(new Element("noteSession1").setText(Float.toString(etud.getNoteSession1())));
            Etudiant.addContent(new Element("noteSession2").setText(Float.toString(etud.getNoteSession2())));
            root.addContent(Etudiant);
        }
        save(document, "xml/" + s + ".xml");
    }
}
