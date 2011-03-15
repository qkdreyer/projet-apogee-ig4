/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML.Etudiant;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantUE;
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
public class XMLEtudiantUE extends XML<EtudiantUE> {

    public void create(EtudiantUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(EtudiantUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(EtudiantUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public EtudiantUE find(Object id) throws Exception { //TODO 1 findEtudUE
	EtudiantUE e = new EtudiantUE();

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

    public ArrayList<EtudiantUE> list() throws Exception {
        //TODO 3 listEtudUE
        return null;
    }


}
