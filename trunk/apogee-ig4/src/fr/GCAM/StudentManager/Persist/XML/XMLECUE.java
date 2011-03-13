/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Etudiant;
import java.io.FileOutputStream;
import java.util.Iterator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type ECUE
 * (POJO).
 * Le fichier XML utilisé par cette classe est "xml/ECUE.xml"
 *
 * @author pierre
 */
public class XMLECUE extends XML<ECUE> {

    public XMLECUE() {
    }

    /**
     * Methode permettant la création d'une ECUE
     *
     * @param obj l'ECUE qui doit être insérée dans le fichier XML
     * @throws Exception
     */
    public void create(ECUE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Méthode modifiant les données du fichier XML par rapport à l'ecue passée en
     * parametre. L'ECUE ecue est un POJO qui contient une liste d' EtudiantECUE.
     * La méthode va parcourir cette liste et executer un update dans le fichier XML.
     * Cet update va donc modifier les notes des étudiants.
     * La méthode délègue le travail aux méthodes updateNote1() et updateNote2()
     *
     * @param ecue l'ECUE correspondant à une ECUE du fichier XML. Cette
     * ECUE sera modifiée. Afin de fonctionner correctement, il est impératif que
     * "ecue" ait été chargé à partir de la méthode find définit ci dessous.
     * @throws Exception
     * @see fr.GCAM.StudentManager.Persist.XML.XMLECUE.find
     * @see fr.GCAM.StudentManager.Persist.XML.XMLECUE.updateNote1
     * @see fr.GCAM.StudentManager.Persist.XML.XMLECUE.updateNote2
     */
    public void update(ECUE ecue) throws Exception {
        Etudiant etudiant;
        Iterator i = ecue.getListeEtud().iterator();
        while (i.hasNext()) {
            etudiant = (Etudiant) i.next();
            if (etudiant.isNoteSession1Changed()) {
                updateNote1(etudiant.getNumEtud(), ecue.getCodeMatiere(), etudiant.getNoteSession1());
            } else if (etudiant.isNoteSession2Changed()) {
                updateNote2(etudiant.getNumEtud(), ecue.getCodeMatiere(), etudiant.getNoteSession2());
            }
        }

    }

    /**
     * Méthode appelée par la méthode update. Cette méthode se contente de réaliser
     * une mise a jour des informations sur l'element du fichier XML ayant pour identifiant
     * d'étudiant numEtud et pour identifiant d'UE codeMatiere.
     * Cette méthode ne modifie que la note de la session 1.
     *
     * @param numEtud(int) le numeroEtudiant(Primary Key, pk) de l'étudiant dont la note doit etre modifiée
     * @param codeMatiere(String) le codeMatiere(Primary Key, pk) de l'ecue pour laquelle la note doit etre modifiée
     * @param noteSession1(float) la note qui sera insérée dans le fichier XML à la place de l'ancienne
     * @throws Exception
     */
    private void updateNote1(int numEtud, String codeMatiere, float noteSession1) throws Exception {
        Element courant;
        Document d = new SAXBuilder().build("xml/ECUE.xml");
        Iterator i = d.getRootElement().getChildren("ECUE").iterator();
        Iterator j;
        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("codeMatiere").getText().equals(codeMatiere)) {
                j = courant.getChild("listeEtud").getChildren("Etudiant").iterator();
                while (j.hasNext()) {
                    courant = (Element) j.next();
                    if (courant.getChild("numEtud").getText().equals(Integer.toString(numEtud))) {
                        courant.getChild("noteSession1").setText(Float.toString(noteSession1));
                    }
                }
            }
        }
        new XMLOutputter(Format.getPrettyFormat()).output(d, new FileOutputStream("xml/ECUE.xml"));
    }

    /**
     * Méthode appelée par la méthode update. Cette méthode se contente de réaliser
     * une mise a jour des informations sur l'element du fichier XML ayant pour identifiant
     * d'étudiant numEtud et pour identifiant d'UE codeMatiere.
     * Cette méthode ne modifie que la note de la session 2.
     *
     * @param numEtud(int) le numeroEtudiant(Primary Key, pk) de l'étudiant dont la note doit etre modifiée
     * @param codeMatiere(String) le codeMatiere(Primary Key, pk) de l'ecue pour laquelle la note doit etre modifiée
     * @param noteSession2(float) la note qui sera insérée dans le fichier XML à la place de l'ancienne
     * @throws Exception
     */
    private void updateNote2(int numEtud, String codeMatiere, float noteSession2) throws Exception {
        Element courant;
        Document d = new SAXBuilder().build("xml/ECUE.xml");
        Iterator i = d.getRootElement().getChildren("ECUE").iterator();
        Iterator j;
        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("codeMatiere").getText().equals(codeMatiere)) {
                j = courant.getChild("listeEtud").getChildren("Etudiant").iterator();
                while (j.hasNext()) {
                    courant = (Element) j.next();
                    if (courant.getChild("numEtud").getText().equals(Integer.toString(numEtud))) {
                        courant.getChild("noteSession2").setText(Float.toString(noteSession2));
                    }
                }
            }
        }
        new XMLOutputter(Format.getPrettyFormat()).output(d, new FileOutputStream("xml/ECUE.xml"));
    }

    /**
     * Méthode procédant à la suppression dans le fichier XML de l'ecue correspondant
     * a l'ECUE (POJO) passé en parametre.
     *
     * @param obj l'ECUE (POJO) qui correspond à une ecue du fichier XML.
     * Il est impératif que "ecue" ait été construite a partir de la méthode find afin
     * d'assurer qu'elle existe dans le fichier XML.
     * @throws Exception
     */
    public void delete(ECUE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * La fonction, renvoie un POJO ECUE, a partir de l'id passé en parametre.<br>
     * Require : <br>
     * Ensure : <br>
     * @param id(String) L'id de l'ecue que l'on souhaite charger
     * @return L'ECUE correspondant à l'élement trouvé dans le fichier XML a partir
     * de l'id : id
     * @throws Exception
     */
    public ECUE find(Object id) throws Exception {
        ECUE ecue = new ECUE();

        Element courant;
        Iterator i = new SAXBuilder().build("xml/ECUE.xml").getRootElement().getChildren("ECUE").iterator();
        Iterator j;

        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("codeMatiere").getText().equals((String) id)) {
                ecue.setCodeMatiere(courant.getChild("codeMatiere").getText());
                ecue.setLibelleECUE(courant.getChild("libelleECUE").getText());
                ecue.setNbHeures(Integer.parseInt(courant.getChild("nbHeures").getText()));
                ecue.setResponsable(courant.getChild("responsable").getText());
                ecue.setCodeUE(courant.getChild("codeUE").getText());

                j = courant.getChild("listeEtud").getChildren("Etudiant").iterator();
                while (j.hasNext()) {
                    courant = (Element) j.next();
                    ecue.getListeEtud().add(new Etudiant(
                            Integer.parseInt(courant.getChild("numEtud").getText()),
                            courant.getChild("nom").getText(),
                            courant.getChild("prenom").getText(),
                            Float.parseFloat(courant.getChild("noteSession1").getText()),
                            Float.parseFloat(courant.getChild("noteSession2").getText())));
                }
            }
        }
        return ecue;
    }

    /**
     * Methode renvoyant l'ensemble des clés primaires du fichier XML correspondant
     * (ici ECUE.xml)
     *
     * @return L'ensemble des clés primaires (codeMatiere) des ECUE
     * @throws Exception
     * @deprecated 
     */
    public String list() throws Exception {
        String str = "";
        Element courant;
        Iterator i = new SAXBuilder().build("xml/ECUE.xml").getRootElement().getChildren("ECUE").iterator();

        while (i.hasNext()) {
            courant = (Element) i.next();
            str = str + courant.getChild("codeMatiere").getText() + "\n";
        }
        return str;
    }
}
