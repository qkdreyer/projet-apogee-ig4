/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.ECUE.EtudiantECUE;
import java.util.Iterator;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 *
 * @author Quentin
 */
public class XMLECUE extends XML<ECUE> {

    public XMLECUE() {
    }

    /**
     *
     * @param obj
     * @throws Exception
     */
    public void create(ECUE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(ECUE ecue) throws Exception {
        EtudiantECUE etudiant;
        Iterator i = ecue.getListeEtud().iterator();
        while (i.hasNext()) {
            etudiant = (EtudiantECUE) i.next();
            if (etudiant.isNoteSession1Changed()) {
                updateNote1(etudiant.getNumEtud(), ecue.getCodeMatiere(), etudiant.getNoteSession1());
            } else if (etudiant.isNoteSession2Changed()) {
                updateNote2(etudiant.getNumEtud(), ecue.getCodeMatiere(), etudiant.getNoteSession2());
            }
        }
    }

    private void updateNote1(int numEtud, String codeMatiere, float noteSession1) throws Exception {
        Element courant;
        Iterator i = new SAXBuilder().build("xml/ECUE.xml").getRootElement().getChildren("ECUE").iterator();
        Iterator j;
        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("codeMatiere").getText().equals(codeMatiere)) {
                j = courant.getChild("listeEtud").getChildren("Etudiant").iterator();
                while (j.hasNext()) {
                    if (courant.getChild("numEtud").getText().equals(Integer.toString(numEtud))) {
                        courant.getChild("noteSession1").setText(Float.toString(noteSession1));
                    }
                }
            }
        }
    }

    private void updateNote2(int numEtud, String codeMatiere, float noteSession2) throws Exception {
        Element courant;
        Iterator i = new SAXBuilder().build("xml/ECUE.xml").getRootElement().getChildren("ECUE").iterator();
        Iterator j;
        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("codeMatiere").getText().equals(codeMatiere)) {
                j = courant.getChild("listeEtud").getChildren("Etudiant").iterator();
                while (j.hasNext()) {
                    if (courant.getChild("numEtud").getText().equals(Integer.toString(numEtud))) {
                        courant.getChild("noteSession2").setText(Float.toString(noteSession2));
                    }
                }
            }
        }
    }

    public void delete(ECUE obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

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
                ecue.setIdEnseignant(Integer.parseInt(courant.getChild("idEnseignant").getText()));
                ecue.setCodeUE(courant.getChild("codeUE").getText());

                j = courant.getChild("listeEtud").getChildren("Etudiant").iterator();
                while (j.hasNext()) {
                    courant = (Element) j.next();
                    ecue.getListeEtud().add(new EtudiantECUE(
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
}
