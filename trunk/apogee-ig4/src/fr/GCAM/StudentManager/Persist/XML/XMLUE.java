/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.UE;
import java.util.Iterator;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type UE
 * (POJO).
 * Le fichier utilisé par cette classe est "xml/UE.xml"
 * @author pierre
 */
public class XMLUE extends XML<UE> {

    public XMLUE() {
    }    

    /**
     * Methode permettant la création d'une UE
     *
     * @param obj le Departement qui doit être insérée dans le fichier xml
     * @throws Exception
     */
    public void create(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'une UE
     *
     * @param obj l'UI qui doit être modifiée dans le fichier XML
     * @throws Exception
     */
    public void update(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'une UE
     *
     * @param obj l'UE qui doit être supprimée dans le fichier XML.
     * @throws Exception
     */
    public void delete(UE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO UE, a partir de l'id passé en parametre.<br>
     *
     * @param id(String) L'id de l'UE que l'on souhaite charger
     * @return L'UE correspondant à la ligne trouvé dans le fichier XML a partir de l'id
     * @throws Exception
     */
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
                    ue.getListeECUE().add(new ECUE(
                            courant.getChild("codeMatiere").getText(),
                            courant.getChild("libelleECUE").getText()));
                }
            }
        }
        return ue;
    }

    /**
     * Methode renvoyant l'ensemble des clés primaires du fichier XML correspondant
     * (ici UE.xml)
     *
     * @return L'ensemble des clés primaires (codeUE) des UE
     * @throws Exception
     * @deprecated
     */
    public String list() throws Exception {
        String str = "";
        Element courant;
        Iterator i = new SAXBuilder().build("xml/UE.xml").getRootElement().getChildren("UE").iterator();
        Iterator j;

        while (i.hasNext()) {
            courant = (Element) i.next();
            str = str + courant.getChild("codeUE").getText() + "\n";
        }
        return str;
    }
}
