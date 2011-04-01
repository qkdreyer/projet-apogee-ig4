/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML.Etudiant;

import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantEtape;
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

    /**
     * Methode permettant la création d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(EtudiantEtape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'un Etudiant
     *
     * @param obj l'Etudiant qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(EtudiantEtape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Etudiant
     *
     * @param obj le Departement qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(EtudiantEtape obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Etudiant, a partir de l'id passé en parametre.<br>
     *
     * @param id(int) L'idEtudiant de l'Etudiant que l'on souhaite charger
     * @return L'Etudiant correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public EtudiantEtape find(Object id) throws Exception { //TODO 1 findEtudEtape
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

    /**
     * Methode renvoyant l'ensemble des etudiants
     *
     * @return L'ensemble des etudiants
     * @throws Exception
     */
    public ArrayList<EtudiantEtape> list() throws Exception {
        //TODO 3 listEtudEtape
        return null;
    }


}
