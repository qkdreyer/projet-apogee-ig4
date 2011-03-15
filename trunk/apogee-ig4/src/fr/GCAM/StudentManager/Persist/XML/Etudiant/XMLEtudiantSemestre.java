/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML.Etudiant;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantSemestre;
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
public class XMLEtudiantSemestre extends XML<EtudiantSemestre> {

    public void create(EtudiantSemestre obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(EtudiantSemestre obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(EtudiantSemestre obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public EtudiantSemestre find(Object id) throws Exception { //TODO findEtSem
	EtudiantSemestre e = new EtudiantSemestre();

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

    public ArrayList<EtudiantSemestre> list() throws Exception {
        //TODO listXMLEtudSem
        return null;
    }


}
