/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import java.util.ArrayList;
import java.util.Iterator;
import org.jdom.input.SAXBuilder;
import org.jdom.*;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Utilisateur
 * (POJO).
 * Le fichier utilisé par cette classe est "xml/Utilisateur.xml"
 * 
 * @author pierre
 */
public class XMLUtilisateur extends XML<Utilisateur> {

    public XMLUtilisateur() {
    }

    /**
     * Methode permettant la création d'un Utilisateur
     *
     * @param obj le Departement qui doit être insérée dans le fichier XML.
     * @throws Exception
     */
    public void create(Utilisateur obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'un Utilisateur
     *
     * @param obj l'Utilisateur qui doit être modifiée dans le fichier XML.
     * @throws Exception
     */
    public void update(Utilisateur obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Utilisateur
     *
     * @param obj l'Utilisateur qui doit être supprimée dans le fichier XML.
     * @throws Exception
     */
    public void delete(Utilisateur obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Utilisateur, a partir de l'objet request
     * passé en parametre.<br>
     * Le parametre peut etre de deux types : <br>
     * - Soit un entier, afin de chercher l'utilisateur par son id
     * - Soit un ArrayList de String au format {Prenom, Nom, MDP}
     * La fonction delegue le travail en fonction du type de parametre
     *
     * @param id(int ou ArrayList<String>) L'id de l'Etape que l'on souhaite charger
     * @return L'Etape correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public Utilisateur find(Object request) throws Exception {
	if (request instanceof ArrayList) {
	    return this.findWithLogin((ArrayList) request);
	} else if (request instanceof Integer) {
	    return this.findWithID((Integer) request);
	} else {
	    return null;
	}
    }

    /**
     * Methode appelée par la méthode find dans le cas où l'Object était un ArrayList.
     *
     * @param a(ArrayList<String>) L'ArrayList contenant toutes les informations de l'utilisateur.
     * au format {Prenom, Nom, MDP}
     * @return Renvoie l'utilisateur correspondant ayant comme nom a[0], comme
     * Prenom a[1] et mot de passe [2].
     * @throws Exception
     */
    public Utilisateur findWithLogin(ArrayList a) throws Exception {
        Utilisateur util = new Utilisateur();
        Element courant;

        Iterator i = new SAXBuilder().build("xml/Utilisateur.xml").getRootElement().getChildren("Utilisateur").iterator();
        Iterator j;
        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("nom").getText().equals(((String) ((ArrayList) a).get(1)).toLowerCase())
                    && courant.getChild("prenom").getText().equals(((String) ((ArrayList) a).get(0)).toLowerCase())
                    && courant.getChild("mdp").getText().equals(((String) ((ArrayList) a).get(2)).toLowerCase())) {
                //util.setIdEnseignant(Integer.parseInt(courant.getChild("idEnseignant").getText()));
                util.setNom(courant.getChild("nom").getText());
                util.setPrenom(courant.getChild("prenom").getText());
                util.setMDP(courant.getChild("mdp").getText());
                util.setMail(courant.getChild("mail").getText());

                j = courant.getChild("listeResponsabilites").getChildren("responsabilite").iterator();
                while (j.hasNext()) {
                    courant = (Element) j.next();
                    util.getListeResponsabilites().add(new Responsabilite(
                            courant.getChild("codeResponsabilite").getText(),
                            courant.getChild("libelle").getText()));
                }
            }
        }
        return util;
    }

    /**
     * Methode appelée par la méthode find dans le cas où l'Object était un int.
     *
     * @param num(int) L'id de l'utilisateur à rechercher.
     * @return Renvoie l'utilisateur correspondant ayant comme id 'num'.
     * @throws Exception
     */
    public Utilisateur findWithID(Integer num) throws Exception {
        Utilisateur util = new Utilisateur();
        Element courant;

        Iterator i = new SAXBuilder().build("xml/Utilisateur.xml").getRootElement().getChildren("Utilisateur").iterator();
        Iterator j;
        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("idEnseignant").getText().equals(Integer.toString(num))) {
                //util.setIdEnseignant(Integer.parseInt(courant.getChild("idEnseignant").getText()));
                util.setNom(courant.getChild("nom").getText());
                util.setPrenom(courant.getChild("prenom").getText());
                util.setMDP(courant.getChild("mdp").getText());

                j = courant.getChild("listeResponsabilites").getChildren("responsabilite").iterator();
                while (j.hasNext()) {
                    courant = (Element) j.next();
                    util.getListeResponsabilites().add(new Responsabilite(
                            courant.getChild("codeResponsabilite").getText(),
                            courant.getChild("libelle").getText()));
                }
            }
        }
        return util;
    }

    /**
     * Methode renvoyant l'ensemble des clés primaires du fichier XML correspondant
     * (ici Utilsateur.xml)
     *
     * @return L'ensemble des clés primaires (prenom.nom) des Enseignants
     * @throws Exception
     */
    public String list() throws Exception {
        String str = "";
        Element courant;
        Iterator i = new SAXBuilder().build("xml/Utilisateur.xml").getRootElement().getChildren("Utilisateur").iterator();
        Iterator j;

        while (i.hasNext()) {
            courant = (Element) i.next();
            str = str + courant.getChild("prenom").getText() + "." + courant.getChild("nom").getText() + "\n";
        }
        return str;
    }
}
