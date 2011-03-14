/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Etape;
import fr.GCAM.StudentManager.POJO.UE;
import java.util.Iterator;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Etape
 * (POJO).
 * Le fichier utilisé par cette classe est "xml/Etape.xml"
 * @author pierre
 */
public class XMLEtape extends XML<Etape> {

    public XMLEtape() {
    }

    /**
     * Methode permettant la création d'une Etape
     *
     * @param obj l'Etape qui doit être insérée dans le fichier XML
     * @throws Exception
     */
    public void create(Etape obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la modification d'une Etape
     *
     * @param obj l'Etape qui doit être modifiée dans le fichier XML
     * @throws Exception
     */
    public void update(Etape obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'une Etape
     *
     * @param obj l'Etape qui doit être supprimée dans le fichier XML
     * @throws Exception
     */
    public void delete(Etape obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO Etape, a partir de l'id passé en parametre.<br>
     *
     * @param id(String) L'id de l'Etape que l'on souhaite charger
     * @return L'Etape correspondant à la ligne trouvé dans le fichier XML a partir de l'id
     * @throws Exception
     */
    public Etape find(Object id) throws Exception {
        Etape etape = new Etape();

        Element courant;
        Iterator i = new SAXBuilder().build("xml/Etape.xml").getRootElement().getChildren("Etape").iterator();
        Iterator j;

        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("codeEtape").getText().equals((String) id)) {
                etape.setCodeEtape(courant.getChild("codeEtape").getText());
                etape.setVersionEtape(courant.getChild("versionEtape").getText());
                etape.setResponsable(courant.getChild("responsable").getText());
                etape.setVersionDiplome(courant.getChild("versionDiplome").getText());

                for (int numSem = 1; numSem <= 2; numSem++) {
                    etape.getSemestre(numSem).setCodeSemestre(courant.getChild("codeSemestre").getText());
                    etape.getSemestre(numSem).setNbUEFacultatives(Integer.parseInt(courant.getChild("nbUEFacultatives").getText()));
                    etape.getSemestre(numSem).setCodeEtape(courant.getChild("codeEtape").getText());
                    j = courant.getChild("listeUE").getChildren("UE").iterator();
                    while (j.hasNext()) {
                        courant = (Element) j.next();
                        etape.getSemestre(numSem).getListeUE().add(new UE(
                                courant.getChild("codeMatiere").getText(),
                                courant.getChild("responsable").getText()));
                    }
                }
            }
        }
        return etape;
    }

    /**
     * Methode renvoyant l'ensemble des clés primaires du fichier XML correspondant
     * (ici Etape.xml)
     *
     * @return L'ensemble des clés primaires (codeEtape) des Etape
     * @throws Exception
     * @deprecated 
     */
    public String list() throws Exception {
        String str = "";
        Element courant;
        Iterator i = new SAXBuilder().build("xml/Etape.xml").getRootElement().getChildren("Etape").iterator();

        while (i.hasNext()) {
            courant = (Element) i.next();
            str = str + courant.getChild("codeEtape").getText() + "\n";
        }
        return str;
    }
}