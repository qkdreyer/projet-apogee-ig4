/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Utilisateur;
import java.util.ArrayList;
import java.util.Iterator;
import org.jdom.input.SAXBuilder;
import org.jdom.*;

/**
 *
 * @author Quentin
 */
public class XMLUtilisateur extends XML<Utilisateur> {

    public void create(Utilisateur obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Utilisateur obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Utilisateur obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public Utilisateur find(Object id) throws Exception {
	Utilisateur util = new Utilisateur();
	Element courant;
	ArrayList<Utilisateur.Responsabilite> listeResp;

	Iterator i = new SAXBuilder().build("xml/Utilisateur.xml").getRootElement().getChildren("etudiant").iterator();
	while (i.hasNext()) {
	    courant = (Element) i.next();
	    System.out.println(courant.getChild("nom").getText());
	}

	return util;
    }
}
