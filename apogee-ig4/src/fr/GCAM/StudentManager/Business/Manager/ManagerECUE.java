/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Business.Manager;

import fr.GCAM.StudentManager.Business.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO; 
import java.util.ArrayList;

/**
 * Manager fournissant les informations d'une ECUE
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
     * Accesseur sur la variable ecue de la classe
     * @return la variable ecue(ECUE) de la classe
     */
    public ECUE getECUE() {
        return ecue;
    }

    /**
     * Accesseur sur l'attribut libelle de ecue
     * @return le libelle de ecue
     */
    public String getLibelleECUE() {
	return ecue.getLibelleECUE();
    }

    /**
     * Accesseur sur l'attribut responsable de ecue
     * @return le responsable de ecue
     */
    public String getResponsable() {
	return ecue.getResponsable();
    }

    /**
     * Accesseur sur l'attribut nbHeure de ecue
     * @return le nbheure d'ecue
     */
    public int getNbHeures() {
	return ecue.getNbHeures();
    }

    /**
     * Accesseur sur l'attribut codeMatiere de ECUE
     * @return le code matiere de ECUE
     */
    public String getCodeMatiere() {
	return ecue.getCodeMatiere();
    }

    /**
     * Methode permettant la modification de la note1 des etudiants d'une ECUE
     * @param indexEtud l'index dans la listeEtud de l'etudiant a modifier
     * @param note la nouvelle note de l'etudiant
     * @throws Exception
     */
    public void setNoteSession1(int indexEtud, float note) throws Exception {
	ecue.getListeEtud().get(indexEtud).modifyNoteSession1(note);
        ecueDAO.update(ecue);
    }

    /**
     * Methode permettant la modification de la note2 des etudiants d'une ECUE
     * @param indexEtud l'index dans la listeEtud de l'etudiant a modifier
     * @param note la nouvelle note de l'etudiant
     * @throws Exception
     */
    public void setNoteSession2(int indexEtud, float note) throws Exception {
	ecue.getListeEtud().get(indexEtud).modifyNoteSession2(note);
        ecueDAO.update(ecue);
    }

    /**
     * Methode renvoyant un tableau d'Object (qui sont des des EtudiantECUE. Le
     * tableau est constitue de 4 colonnes : Nom/Prenom/Note session 1/Note session 2
     * @return
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

    /**
     * Methode permettant la modification de l'ecue dans la base de données
     * @throws Exception
     */
    public void update() throws Exception {
        ecueDAO.update(ecue);
    }

    /**
     * Redefinition de la methode toString()
     * @return
     */
    @Override
    public String toString() {
        return ecue.toString();
    }
}
