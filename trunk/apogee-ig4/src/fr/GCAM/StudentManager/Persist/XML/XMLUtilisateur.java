/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.Util.JDOM;
import fr.GCAM.StudentManager.Util.SHA1;
import fr.GCAM.StudentManager.Business.POJO.Utilisateur;
import fr.GCAM.StudentManager.Business.POJO.Utilisateur.Responsabilite;
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
	Document d = new SAXBuilder().build("xml/Utilisateur.xml");
	Element util = new Element("Utilisateur"), resp;
	
	util.addContent(new Element("nom").setText(obj.getNom()));
	util.addContent(new Element("prenom").setText(obj.getPrenom()));
	util.addContent(new Element("mdp").setText(SHA1.getHash(obj.getMDP())));
	util.addContent(new Element("mail").setText(obj.getMail()));

	for (Responsabilite r : obj.getListeResponsabilites()) {
	    resp = new Element("responsabilite");
	    resp.addContent(new Element("codeResponsabilite").setText(r.getCodeResponsabilite()));
	    resp.addContent(new Element("libelle").setText(r.getLibelle()));
	    util.addContent(resp);
	}
	d.getRootElement().addContent(util);
	JDOM.save(d, "xml/Utilisateur.xml");
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
	Document d = new SAXBuilder().build("xml/Utilisateur.xml");
        Element courant;
        Iterator i = d.getRootElement().getChildren("Utilisateur").iterator();
        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChildText("idEnseignant").equals(Integer.toString(obj.getIdEnseignant()))) {
                d.getRootElement().getChildren("Utilisateur").remove(courant);
            }
        }
        JDOM.save(d, "xml/Utilisateur.xml");
    }

    /**
     * La fonction, renvoie un POJO Utilisateur, a partir de l'objet request
     * passé en parametre.<br>
     * Le parametre peut etre de deux types : <br>
     * - Soit un entier, afin de chercher l'utilisateur par son id
     * - Soit un ArrayList de String au format {Prenom, Nom, MDP}
     * La fonction delegue le travail en fonction du type de parametre
     *
     * @param id (int ou ArrayList<String>) L'id de l'Etape que l'on souhaite charger
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
    private Utilisateur findWithLogin(ArrayList a) throws Exception {
	Utilisateur util = new Utilisateur();
	Element courant;

	Iterator i = new SAXBuilder().build("xml/Utilisateur.xml").getRootElement().getChildren("Utilisateur").iterator();
	Iterator j;
	while (i.hasNext()) {
	    courant = (Element) i.next();
	    if (courant.getChild("nom").getText().equals(((String) a.get(1)).toLowerCase())
		    && courant.getChild("prenom").getText().equals(((String) a.get(0)).toLowerCase())
		    && courant.getChild("mdp").getText().equals(SHA1.getHash((String) a.get(2)))) {
		util.setIdEnseignant(Integer.parseInt(courant.getChild("idEnseignant").getText()));
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
    private Utilisateur findWithID(Integer num) throws Exception {
	Utilisateur util = new Utilisateur();
	Element courant;

	Iterator i = new SAXBuilder().build("xml/Utilisateur.xml").getRootElement().getChildren("Utilisateur").iterator();
	Iterator j;
	while (i.hasNext()) {
	    courant = (Element) i.next();
	    if (courant.getChild("idEnseignant").getText().equals(Integer.toString(num))) {
		util.setIdEnseignant(Integer.parseInt(courant.getChild("idEnseignant").getText()));
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
     * Methode ranvoyant la liste des Utilisateurs
     * @return la liste des Utilisateurs
     * @throws Exception
     */
    public ArrayList<Utilisateur> list() throws Exception {
	//TODO 3 listUtil
	return null;
    }
}
