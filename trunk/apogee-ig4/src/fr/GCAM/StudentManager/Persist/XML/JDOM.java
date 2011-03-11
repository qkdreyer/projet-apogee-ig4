/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.XML;

import java.io.FileOutputStream;
import org.jdom.*;
import org.jdom.output.*;

/**
 *
 * @author Quentin
 */
public class JDOM {

    static Element racine = new Element("StudentManager");
    //On crée un nouveau Document JDOM basé sur la racine que l'on vient de créer
    static org.jdom.Document document = new Document(racine);

    /*public static void main(String[] args) {
        //On crée un nouvel Element etudiant et on l'ajoute
        //en tant qu'Element de racine

        Element etud = new Element("Etudiant");
        Element ecue = new Element("ECUE");
        Element ue = new Element("UE");
        Element sem = new Element("Semestre");
        Element etape = new Element("Etape");
        Element dept = new Element("Departement");

        racine.addContent(ecue);
        racine.addContent(ue);
        racine.addContent(sem);
        racine.addContent(etape);
        racine.addContent(dept);

        Element codeMatiere = new Element("codeMatiere");
        Element libelleECUE = new Element("libelleECUE");
    /*private int nbHeures;
    private int idEnseignant;
    private String codeUE;
    private ArrayList<EtudiantECUE> listeEtud;

        //On crée un nouvel Attribut classe et on l'ajoute à etudiant
        //grâce à la méthode setAttribute
        Attribute classe = new Attribute("classe", "P2");
        ecue.setAttribute(classe);

        //On crée un nouvel Element nom, on lui assigne du texte
        //et on l'ajoute en tant qu'Element de etudiant
        Element nom = new Element("nom");
        nom.setText("CynO");
        ecue.addContent(nom);

        //Les deux méthodes qui suivent seront définies plus loin dans l'article
        affiche();
        enregistre("Exercice1.xml");
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
    }*/
}
