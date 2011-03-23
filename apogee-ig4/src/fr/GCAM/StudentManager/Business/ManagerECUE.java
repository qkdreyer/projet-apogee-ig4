/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO; 
import java.util.ArrayList;

/**
 * Cette classe implemente la partie Controlleur du MVC(Model View Controller).
 *
 * @author Quentin
 */
public class ManagerECUE {

    private ECUE ecue = null;
    private DAO<ECUE> ecueDAO = null;


    public ManagerECUE(String s, String dao) throws Exception {
        ecueDAO = AbstractDAOFactory.getDAOFactory(dao).getDAOECUE();
	ecue = ecueDAO.find(s);
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

    public ECUE getECUE() {
        return ecue;
    }

    public String getLibelleECUE() {
	return ecue.getLibelleECUE();
    }

    public String getResponsable() {
	return ecue.getResponsable();
    }

    public int getNbHeures() {
	return ecue.getNbHeures();
    }

    public String getCodeMatiere() {
	return ecue.getCodeMatiere();
    }

    /**
     * Methode permettant la modification de la note1 des etudiants d'une ECUE
     *
     * @param msg
     * @throws Exception
     */
    public void setNoteSession1(int indexEtud, float note) throws Exception {
	ecue.getListeEtud().get(indexEtud).modifyNoteSession1(note);
        ecueDAO.update(ecue);
    }

    /**
     * Methode permettant la modification de la note1 des etudiants d'une ECUE
     *
     * @param msg
     * @throws Exception
     */
    public void setNoteSession2(int indexEtud, float note) throws Exception {
	ecue.getListeEtud().get(indexEtud).modifyNoteSession2(note);
        ecueDAO.update(ecue);
    }

    /**
     * Methode
     */
    public Object[][] getArrayOfEtudiantECUE() {
	ArrayList<EtudiantECUE> listeEtud = ecue.getListeEtud();
	Object[][] arrayEtud = new Object[listeEtud.size()][4];
	int i = 0;
	for (EtudiantECUE e : listeEtud) {
	    arrayEtud[i][0] = e.getNom();
	    arrayEtud[i][1] = e.getPrenom();
	    arrayEtud[i][2] = e.getNoteSession1();
	    arrayEtud[i][3] = e.getNoteSession2();
	    i++;
	}
	return arrayEtud;
    }

    public void update() throws Exception {
        ecueDAO.update(ecue);
    }

    @Override
    public String toString() {
        return ecue.toString();
    }
}
