/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Util;

import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantECUE;
import fr.GCAM.StudentManager.Business.POJO.*;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantECUE;
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
	    createEtudiantECUEXML("EtudiantECUE");
	} catch (Exception ex) {
	    System.err.println("Erreur : " + ex);
	    ex.printStackTrace();
	}
    }

    /**
     * methode permettant la sauvagarde du document en tant que fichier XML
     * @param d le document xml a sauvegarder
     * @param fichier le fichier qui accueillera le document XML d
     */
    public static void save(Document d, String fichier) throws Exception {
	new XMLOutputter(Format.getPrettyFormat()).output(d, new FileOutputStream(fichier));
    }

    /**
     * Methode creant un fichier ecue.xml contenant l'ensemble des informations
     * des ecue de la base de données. La methode recupere aussi la liste d'etudiants
     * de l'ecue.
     * @param s le nom du fichier a creer
     * @throws Exception
     */
    private static void createECUEXML(String s) throws Exception {
	Element root = new Element("root");
	Document document = new Document(root);
	Element ECUE, listeEtud, Etudiant;
	ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct codeMatiere from VO_" + s);
	ECUE ecue;

	while (result.next()) {
	    ECUE = new Element(s);
            listeEtud = new Element("listeEtud");
	    ecue = new DBECUE(conn).find(result.getString(1));

	    ECUE.addContent(new Element("codeMatiere").setText(ecue.getCodeMatiere()));
	    ECUE.addContent(new Element("libelleECUE").setText(ecue.getLibelleECUE()));
	    ECUE.addContent(new Element("nbHeures").setText(Integer.toString(ecue.getNbHeures())));
	    ECUE.addContent(new Element("responsable").setText(ecue.getResponsable()));
	    ECUE.addContent(new Element("codeUE").setText(ecue.getCodeUE()));            
	    for (EtudiantECUE etud : ecue.getListeEtud()) {
		Etudiant = new Element("Etudiant");
		Etudiant.addContent(new Element("numEtudiant").setText(Integer.toString(etud.getNumEtudiant())));
		Etudiant.addContent(new Element("nom").setText(etud.getNom()));
		Etudiant.addContent(new Element("prenom").setText(etud.getPrenom()));
                if (etud.getNoteSession1() == 0.0) {
                    Etudiant.addContent(new Element("noteSession1"));
                } else {
                    Etudiant.addContent(new Element("noteSession1").setText(Float.toString(etud.getNoteSession1())));
                }
                if (etud.getNoteSession1() == 0.0) {
                    Etudiant.addContent(new Element("noteSession2"));
                } else {
                    Etudiant.addContent(new Element("noteSession2").setText(Float.toString(etud.getNoteSession2())));
                }
		listeEtud.addContent(Etudiant);
	    }
	    ECUE.addContent(listeEtud);
	    root.addContent(ECUE);
	}
	save(document, "xml/" + s + ".xml");
    }

    /**
     * Methode creant un fichier Utilisateur.xml contenant l'ensemble des informations
     * des utilisateurs de la base de données. 
     * @param s le nom du fichier a creer
     * @throws Exception
     */
    private static void createUtilisateurXML(String s) throws Exception {
	Element root = new Element("root");
	Document document = new Document(root);
	Element Utilisateur, listeResponsabilites, responsabilite;
	ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct idEnseignant from VO_" + s);
	Utilisateur util;

	while (result.next()) {
	    Utilisateur = new Element(s);
            listeResponsabilites = new Element("listeResponsabilites");
	    util = new DBUtilisateur(conn).find(result.getInt(1));

	    Utilisateur.addContent(new Element("idEnseignant").setText(Integer.toString(util.getIdEnseignant())));
            Utilisateur.addContent(new Element("nom").setText(util.getNom()));
	    Utilisateur.addContent(new Element("prenom").setText(util.getPrenom()));
	    Utilisateur.addContent(new Element("mdp").setText(util.getMDP()));
	    Utilisateur.addContent(new Element("mail").setText(util.getMail()));
	    for (Utilisateur.Responsabilite resp : util.getListeResponsabilites()) {
		responsabilite = new Element("responsabilite");
		responsabilite.addContent(new Element("libelle").setText(resp.getLibelle()));
		responsabilite.addContent(new Element("codeResponsabilite").setText(resp.getCodeResponsabilite()));
		listeResponsabilites.addContent(responsabilite);
	    }
	    Utilisateur.addContent(listeResponsabilites);
	    root.addContent(Utilisateur);
	}
	save(document, "xml/" + s + ".xml");
    }

    /**
     * Methode creant un fichier ue.xml contenant l'ensemble des informations
     * des ue de la base de données. La methode recupere aussi la liste d'etudiants
     * de l'ue.
     * @param s le nom du fichier a creer
     * @throws Exception
     */
    private static void createUEXML(String s) throws Exception {
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
     * Methode creant un fichier Etape.xml contenant l'ensemble des informations
     * des etapes de la base de données. La methode recupere aussi la liste d'etudiants
     * de l'etape.
     * @param s le nom du fichier a creer
     * @throws Exception
     */
    private static void createEtapeXML(String s) throws Exception {
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
     * Methode creant un fichier departement.xml contenant l'ensemble des informations
     * des departements de la base de données. La methode recupere aussi la liste d'etudiants
     * du departement.
     * @param s le nom du fichier a creer
     * @throws Exception
     */
    private static void createDepartementXML(String s) throws Exception {
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

    /**
     * Methode creant un fichier Etudiant.xml contenant l'ensemble des informations
     * des etudiants de la base de données. 
     * @param s le nom du fichier a creer
     * @throws Exception
     */
    private static void createEtudiantECUEXML(String s) throws Exception {
	Element root = new Element("root");
	Document document = new Document(root);
	Element Etudiant;
	ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct numEtudiant from VO_" + s);
	EtudiantECUE etud;

	while (result.next()) {
	    Etudiant = new Element(s);
	    etud = new DBEtudiantECUE(conn).find(result.getString(1));

	    Etudiant.addContent(new Element("numEtudiant").setText(Integer.toString(etud.getNumEtudiant())));
	    Etudiant.addContent(new Element("numIne").setText(etud.getNumIne()));
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
