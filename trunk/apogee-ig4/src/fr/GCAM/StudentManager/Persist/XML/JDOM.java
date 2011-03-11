/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.POJO.ECUE.EtudiantECUE;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import fr.GCAM.StudentManager.Persist.DB.ConnectionDB;
import fr.GCAM.StudentManager.Persist.DB.DBECUE;
import fr.GCAM.StudentManager.Persist.DB.DBUtilisateur;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import org.jdom.*;
import org.jdom.output.*;

/**
 *
 * @author Quentin
 */
public class JDOM {

    public static Connection conn = ConnectionDB.getConnection();

    public static void main(String[] args) {
	try {
	    createUtilisateurXML();
	    createECUEXML();
	} catch (Exception ex) {
	    System.err.println("Erreur : " + ex);
	    ex.printStackTrace();
	}
    }

    public static void createECUEXML() throws Exception {
	Element root = new Element("root");
	Document document = new Document(root);

	Element ECUE;
	Element codeMatiere;
	Element libelleECUE;
	Element nbHeures;
	Element idEnseignant;
	Element codeUE;
	Element listeEtud;
	Element Etudiant;
	Element numEtud;
	Element nom;
	Element prenom;
	Element noteSession1;
	Element noteSession2;

	numEtud = new Element("numEtud");
	noteSession1 = new Element("noteSession1");
	noteSession2 = new Element("noteSession2");

	ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct idEnseignant from VO_Utilisateur");
	DBECUE ecueDB = new DBECUE(conn);
	ECUE ecue;

	while (result.next()) {
	    ECUE = new Element("ECUE");
	    codeMatiere = new Element("codeMatiere");
	    libelleECUE = new Element("libelleECUE");
	    nbHeures = new Element("nbHeures");
	    idEnseignant = new Element("idEnseignant");
	    codeUE = new Element("codeUE");
	    listeEtud = new Element("listeEtud");

	    ecue = ecueDB.find(result.getInt(1));

	    codeMatiere.setText(ecue.getCodeMatiere());
	    libelleECUE.setText(ecue.getLibelleECUE());
	    nbHeures.setText(Integer.toString(ecue.getNbHeures()));
	    idEnseignant.setText(Integer.toString(ecue.getIdEnseignant()));
	    codeUE.setText(ecue.getCodeUE());

	    for (EtudiantECUE etud : ecue.getListeEtud()) {
		Etudiant = new Element("Etudiant");
		numEtud = new Element("numEtud");
		nom = new Element("nom");
		prenom = new Element("prenom");
		noteSession1 = new Element("noteSession1");
		noteSession2 = new Element("noteSession2");

		numEtud.setText(Integer.toString(etud.getNumEtud()));
		nom.setText(etud.getNom());
		prenom.setText(etud.getPrenom());
		noteSession1.setText(Float.toString(etud.getNoteSession1()));
		noteSession2.setText(Float.toString(etud.getNoteSession2()));

		Etudiant.addContent(numEtud);
		Etudiant.addContent(nom);
		Etudiant.addContent(prenom);
		Etudiant.addContent(noteSession1);
		Etudiant.addContent(noteSession2);
		listeEtud.addContent(Etudiant);
	    }

	    ECUE.addContent(codeMatiere);
	    ECUE.addContent(libelleECUE);
	    ECUE.addContent(nbHeures);
	    ECUE.addContent(idEnseignant);
	    ECUE.addContent(codeUE);
	    ECUE.addContent(listeEtud);
	    root.addContent(ECUE);
	}
	save(document, "xml/ECUE.xml");
    }

    public static void createUtilisateurXML() throws Exception {
	Element root = new Element("root");
	Document document = new Document(root);
	
	Element Utilisateur;
	Element idEnseignant;
	Element nom;
	Element prenom;
	Element mdp;
	Element listeResponsabilites;
	Element responsabilite;
	Element libelle;
	Element codeResponsabilite;

	ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct idEnseignant from VO_Utilisateur");
	DBUtilisateur utilDB = new DBUtilisateur(conn);
	Utilisateur util;

	while (result.next()) {
	    Utilisateur = new Element("Utilisateur");
	    idEnseignant = new Element("idEnseignant");
	    nom = new Element("nom");
	    prenom = new Element("prenom");
	    mdp = new Element("mdp");
	    listeResponsabilites = new Element("listeResponsabilites");

	    util = utilDB.find(result.getInt(1));

	    idEnseignant.setText(Integer.toString(util.getIdEnseignant()));
	    nom.setText(util.getNom());
	    prenom.setText(util.getPrenom());
	    mdp.setText(util.getMDP());

	    for (Responsabilite resp : util.getListeResponsabilites()) {
		responsabilite = new Element("responsabilite");
		libelle = new Element("libelle");
		codeResponsabilite = new Element("codeResponsabilite");

		libelle.setText(resp.getLibelle());
		codeResponsabilite.setText(resp.getCodeResponsabilite());

		responsabilite.addContent(libelle);
		responsabilite.addContent(codeResponsabilite);
		listeResponsabilites.addContent(responsabilite);
	    }

	    Utilisateur.addContent(idEnseignant);
	    Utilisateur.addContent(nom);
	    Utilisateur.addContent(prenom);
	    Utilisateur.addContent(mdp);
	    Utilisateur.addContent(listeResponsabilites);
	    root.addContent(Utilisateur);
	}
	save(document, "xml/Utilisateur.xml");
    }

    //Ajouter ces deux méthodes à notre classe JDOM1
    static void print(Document d) {
	try {
	    //On utilise ici un affichage classique avec getPrettyFormat()
	    XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
	    sortie.output(d, System.out);
	} catch (java.io.IOException e) {
	    System.err.println("Erreur d'entrée/sortie : " + e);
	}
    }

    static void save(Document d, String fichier) {
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
}
