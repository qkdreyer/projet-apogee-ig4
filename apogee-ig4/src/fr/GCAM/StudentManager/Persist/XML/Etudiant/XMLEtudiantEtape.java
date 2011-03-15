/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML.Etudiant;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantEtape;
import fr.GCAM.StudentManager.Persist.XML.XML;
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
public class XMLEtudiantEtape extends XML<EtudiantEtape> {

    public void create(EtudiantEtape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(EtudiantEtape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(EtudiantEtape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public EtudiantEtape find(Object id) throws Exception { //TODO findEtEtape
	EtudiantEtape e = new EtudiantEtape();

        Element courant;
        Iterator i = new SAXBuilder().build("xml/Etudiant.xml").getRootElement().getChildren("Etudiant").iterator();

        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("numEtudiant").getText().equals((String) id)) {
                e.setNumEtudiant(Integer.parseInt(courant.getChildText("numEtudiant")));
                e.setNumIne(courant.getChildText("numIne"));
                e.setLibelleProvenance(courant.getChildText("libelleProvenance"));
                e.setLibelleStatut(courant.getChildText("libelleStatut"));
                e.setLibelleNationalite(courant.getChildText("libelleNationalite"));
                e.setNom(courant.getChildText("nom"));
                e.setPrenom(courant.getChildText("prenom"));
                e.setMail(courant.getChildText("mail"));
            }
        }
        return e;
    }

    public ArrayList<EtudiantEtape> list() throws Exception {
        //TODO listXMLEtudEtape
        return null;
    }


}
