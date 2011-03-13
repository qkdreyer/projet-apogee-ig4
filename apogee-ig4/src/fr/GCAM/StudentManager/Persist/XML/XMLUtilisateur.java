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
 *
 * @author pierre
 */
public class XMLUtilisateur extends XML<Utilisateur> {

    public XMLUtilisateur() {
    }

    public void create(Utilisateur obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Utilisateur obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Utilisateur obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Utilisateur find(Object request) throws Exception {
	if (request instanceof ArrayList) {
	    return this.findWithLogin((ArrayList) request);
	} else if (request instanceof Integer) {
	    return this.findWithID((Integer) request);
	} else {
	    return null;
	}
    }

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

    public Utilisateur findWithID(Integer num) throws Exception {
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
}
