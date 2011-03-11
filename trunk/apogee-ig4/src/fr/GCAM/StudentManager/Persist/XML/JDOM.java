/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import fr.GCAM.StudentManager.Persist.DB.ConnectionDB;
import fr.GCAM.StudentManager.Persist.DB.DBUtilisateur;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jdom.*;
import org.jdom.output.*;

/**
 *
 * @author Quentin
 */
public class JDOM {

    static Element POJOUtilisateur = new Element("POJOUtilisateur");
    //On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
    static org.jdom.Document document = new Document(POJOUtilisateur);

    public static void main(String[] args) throws Exception {

	Connection conn = ConnectionDB.getConnection();

	// Elements composants la racine
	Element ECUE = new Element("ECUE");
	Element Utilisateur = new Element("Utilisateur");

	// Elements composant une ECUE :
        Element codeMatiere = new Element("codeMatiere");
        Element libelleECUE = new Element("libelleECUE");
	Element nbHeures = new Element("nbHeures");
	Element idEnseignant = new Element("idEnseignant");
	Element codeUE = new Element("codeUE");
	Element listeEtud = new Element("listeEtud");

	// Elements composant une listeEtud :
	Element numEtud = new Element("numEtud");
	Element nom = new Element("nom");
	Element prenom = new Element("prenom");
	Element noteSession1 = new Element("noteSession1");
	Element noteSession2 = new Element("noteSession2");

	// Elements composants un Utilisateur
	Element mdp = new Element("mdp");
	Element listeResponsabilites = new Element("listeResponsabilites");
	Element responsabilite;
	Element libelle = new Element("libelle");
	Element codeResponsabilite = new Element("codeResponsabilite");

	Utilisateur.addContent(idEnseignant);
	Utilisateur.addContent(nom);
	Utilisateur.addContent(prenom);
	Utilisateur.addContent(mdp);
	Utilisateur.addContent(listeResponsabilites);



	try {
	    ResultSet result = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT distinct idEnseignant from VO_Utilisateur");
	    DBUtilisateur utilDB = new DBUtilisateur(conn);
	    Utilisateur util;
	    System.out.println("Test");
    
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
		    System.out.println("resp.toString() = " + resp.toString());
		    
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
		
		POJOUtilisateur.addContent(Utilisateur);
	    }
	} catch (SQLException ex) {
	    
	}

        affiche();
        enregistre("utilisateur.xml");
    }

    //Ajouter ces deux méthodes à notre classe JDOM1
    static void affiche() {
        try {
            //On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(document, System.out);
        } catch (java.io.IOException e) {
        }
    }

    static void enregistre(String fichier) {
        try {
            //On utilise ici un affichage classique avec getPrettyFormat()
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            //Remarquez qu'il suffit simplement de créer une instance de FileOutputStream
            //avec en argument le nom du fichier pour effectuer la sérialisation.
            sortie.output(document, new FileOutputStream(fichier));
        } catch (java.io.IOException e) {
        }
    }
}
