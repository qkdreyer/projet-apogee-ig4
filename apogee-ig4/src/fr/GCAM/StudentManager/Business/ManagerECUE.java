/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Util.SSParser;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Cette classe implemente la partie Controlleur du MVC(Model View Controller).
 *
 * @author Quentin
 */
public class ManagerECUE extends AbstractManager {

    private ECUE ecue = null;

    public ManagerECUE(String s) throws Exception {
	ecue = AbstractDAOFactory.getDAOFactory(dao).getDAOECUE().find(s);
    }

    /**
     * La classe définit les traitements associés au message<br>
     * -#find<br>
     * -#update<br>
     * -#quit<br>
     * -#note1<br>
     * -#note2<br>
     * -#createSS<br>
     * -#loadSS<br>
     * -#help<br>
     *
     * @param message Le message qui sera traité, il doit faire parti de l'ensemble
     * défini ci dessus
     * @return
     * @throws Exception
     */

    public String getLibelleECUE() throws Exception {
	return ecue.getLibelleECUE();
    }

    public String getResponsable() throws Exception {
	return ecue.getResponsable();
    }

    public int getNbHeures() throws Exception {
	return ecue.getNbHeures();
    }

    public String getCodeMatiere() throws Exception {
	return ecue.getCodeMatiere();
    }

    /**
     * Methode permettant la modification de la note1 des etudiants d'une ECUE
     *
     * @param msg
     * @throws Exception
     */
    public void setNoteSession1(int indexEtud, int note) throws Exception {
	ecue.getListeEtud().get(indexEtud).modifyNoteSession1(note);
        AbstractDAOFactory.getDAOFactory(dao).getDAOECUE().update(ecue);
    }

    /**
     * Methode permettant la modification de la note1 des etudiants d'une ECUE
     *
     * @param msg
     * @throws Exception
     */
    public void setNoteSession2(int indexEtud, int note) throws Exception {
	ecue.getListeEtud().get(indexEtud).modifyNoteSession2(note);
        AbstractDAOFactory.getDAOFactory(dao).getDAOECUE().update(ecue);
    }

    public void createSS() throws IOException {
	SSParser.createSS(ecue);
    }

    public void loadSS(String s) throws Exception {
	SSParser.loadSS(ecue, s);
        AbstractDAOFactory.getDAOFactory(dao).getDAOECUE().update(ecue);
    }

    public Object[][] getArrayOfEtudiantECUE() {
	ArrayList<EtudiantECUE> listeEtud = ecue.getListeEtud();
	Object[][] arrayEtud = new Object[listeEtud.size()+1][4];
        arrayEtud[0][0] = "Nom";
        arrayEtud[0][1] = "Preom";
        arrayEtud[0][2] = "Note 1";
        arrayEtud[0][3] = "Note 2";
	int i = 1;
	for (EtudiantECUE e : listeEtud) {
	    arrayEtud[i][0] = e.getNom();
	    arrayEtud[i][1] = e.getPrenom();
	    arrayEtud[i][2] = e.getNoteSession1();
	    arrayEtud[i][3] = e.getNoteSession2();
	    i++;
	}
	return arrayEtud;
    }

    @Override
    public String toString() {
        return ecue.toString();
    }
}
