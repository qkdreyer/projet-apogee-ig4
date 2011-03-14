/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Admin;
import java.util.Iterator;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Quentin
 */
public class XMLAdmin extends XML<Admin> {

    public void create(Admin obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(Admin obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(Admin obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Admin.<br>
     * Require : <br>
     * Ensure : <br>
     * @param id null
     * @return La liste des utilisateurs
     * @throws Exception
     */
    public Admin find(Object id) throws Exception {
        Admin a = new Admin();

        Element courant;
        Iterator i = new SAXBuilder().build("xml/Utilisateur.xml").getRootElement().getChildren("Admin").iterator();
        while (i.hasNext()) {
            courant = (Element) i.next();
            a.getListeUtil().add(new XMLUtilisateur().find(courant.getChildText("idEnseignant")));
        }
	return a;
    }

    public String list() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
