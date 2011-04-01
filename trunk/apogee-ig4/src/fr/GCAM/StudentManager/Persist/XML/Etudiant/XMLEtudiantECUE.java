/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML.Etudiant;

import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantECUE;
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
public class XMLEtudiantECUE extends XML<EtudiantECUE> {

    /**
     * Methode permettant la création d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(EtudiantECUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(EtudiantECUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Etudiant
     *
     * @param obj le Departement qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(EtudiantECUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant de lister les EtudiantsECUE appartenant à la matiere id
     * @param id l'ECUE a laquelle sont inscrits les EtudiantsECUE
     * @return La liste des EtudiantECUE de l'ecue id
     * @throws Exception
     */
    public EtudiantECUE find(Object id) throws Exception {
	EtudiantECUE e = new EtudiantECUE();

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
                e.setNoteSession1(Float.parseFloat(courant.getChildText("noteSession1")));
                e.setNoteSession2(Float.parseFloat(courant.getChildText("noteSession2")));
            }
        }
        return e;
    }

    /**
     * Methode permettant de lister les EtudiantECUE
     * @return
     * @throws Exception
     */
    public ArrayList<EtudiantECUE> list() throws Exception { //TODO 3 listEtudECUE
        return null;
    }


}
