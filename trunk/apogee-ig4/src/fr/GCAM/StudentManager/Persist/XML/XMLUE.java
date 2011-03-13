/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.UE;
import java.util.Iterator;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type UE
 * (POJO).
 *
 * @author pierre
 */
public class XMLUE extends XML<UE> {

    public XMLUE() {
    }    

    public void create(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void delete(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public UE find(Object id) throws Exception {
        UE ue = new UE();

        Element courant;
        Iterator i = new SAXBuilder().build("xml/UE.xml").getRootElement().getChildren("UE").iterator();
        Iterator j;

        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("codeUE").getText().equals((String) id)) {
                ue.setCodeUE(courant.getChild("codeUE").getText());
                ue.setNbECTS(Integer.parseInt(courant.getChild("nbECTS").getText()));
                ue.setLibelleUE(courant.getChild("libelleUE").getText());
                ue.setOptionnel(Boolean.parseBoolean(courant.getChild("optionnel").getText()));
                ue.setResponsable(courant.getChild("responsable").getText());
                ue.setCodeSemestre(courant.getChild("codeSemestre").getText());

                j = courant.getChild("listeECUE").getChildren("ECUE").iterator();
                while (j.hasNext()) {
                    courant = (Element) j.next();
                    ue.getListeECUE().add(new UE.ECUEUE(
                            courant.getChild("codeMatiere").getText(),
                            courant.getChild("libelleECUE").getText(),
                            courant.getChild("responsable").getText()));
                }
            }
        }
        return ue;
    }

}
