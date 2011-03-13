/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Departement;
import java.util.Iterator;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Departement
 * (POJO).
 *
 * @author pierre
 */
public class XMLDepartement extends XML<Departement> {

    public XMLDepartement() {
    }
    

    public void create(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Departement obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public Departement find(Object id) throws Exception {
        Departement dept = new Departement();

        Element courant;
        Iterator i = new SAXBuilder().build("xml/Departement.xml").getRootElement().getChildren("Departement").iterator();
        Iterator j;
        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("versionDiplome").getText().equals((String) id)) {
                dept.setVersionDiplome(courant.getChild("versionDiplome").getText());
                dept.setNomDepartement(courant.getChild("nomDepartement").getText());
                dept.setMnemo(courant.getChild("mNemo").getText());

                j = courant.getChild("listeEtape").getChildren("Etape").iterator();
                while (j.hasNext()) {
                    courant = (Element) j.next();
                    dept.getListeEtape().add(new Departement.EtapeDepartement(
                            courant.getChild("codeEtape").getText(),
                            courant.getChild("versionEtape").getText()));
                }
            }
        }
        return dept;
    }

    /**
     *
     * @return L'ensemble des clés primaires (versionDiplome) des Departement
     * @throws Exception
     * @deprecated 
     */
    public String list() throws Exception {
        String str = "";
        Element courant;
        Iterator i = new SAXBuilder().build("xml/Departement.xml").getRootElement().getChildren("Departement").iterator();

        while (i.hasNext()) {
            courant = (Element) i.next();
            str = str + courant.getChild("versionDiplome").getText() + "\n";
        }
        return str;
    }
}
