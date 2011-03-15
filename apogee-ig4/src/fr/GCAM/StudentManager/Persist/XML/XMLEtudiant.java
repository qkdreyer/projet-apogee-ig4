/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Etudiant;
import java.util.ArrayList;
import java.util.Iterator;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Etudiant
 * (POJO).
 *
 * @author pierre
 */
public class XMLEtudiant extends XML<Etudiant> {

    public void create(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Etudiant obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public Etudiant find(Object id) throws Exception {
	Etudiant e = new Etudiant();

        Element courant;
        Iterator i = new SAXBuilder().build("xml/Etudiant.xml").getRootElement().getChildren("Etudiant").iterator();

        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("numEtudiant").getText().equals((String) id)) {
                e.setNumEtudiant(Integer.parseInt(courant.getChildText("numEtudiant")));
                e.setPointJuryAnnee(Integer.parseInt(courant.getChildText("pointJuryAnnee")));
                e.setNumIne(courant.getChildText("numIne"));
                e.setScoreToeic(Integer.parseInt(courant.getChildText("scoreToeic")));
                e.setLibelleProvenance(courant.getChildText("libelleProvenance"));
                e.setLibelleStatut(courant.getChildText("libelleStatut"));
                e.setLibelleNationalite(courant.getChildText("libelleNationalite"));
                e.setNom(courant.getChildText("nom"));
                e.setPrenom(courant.getChildText("prenom"));
                e.setMail(courant.getChildText("mail"));
                e.setNoteSession1(Float.parseFloat(courant.getChildText("noteSession1")));
                e.setNoteSession2(Float.parseFloat(courant.getChildText("noteSession2")));
            }
        }
        return e;
    }

    public ArrayList<Etudiant> list() throws Exception {
        //TODO listXMLEtud
        return null;
    }


}
