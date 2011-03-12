/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;

/**
 *
 * @author Quentin
 */
public class XMLFactory extends AbstractDAOFactory {

    @Override
    public DAO<ECUE> getDAOECUE() {
	return new XMLECUE();
    }

    @Override
    public DAO<Etudiant> getDAOEtudiant() {
	return new XMLEtudiant();
    }

    @Override
    public DAO<Utilisateur> getDAOUtilisateur() {
	return new XMLUtilisateur();
    }

    @Override
    public DAO<UE> getDAOUE() {
        return new XMLUE();
    }

    @Override
    public DAO<Etape> getDAOEtape() {
        return new XMLEtape();
    }

    @Override
    public DAO<Departement> getDAODepartement() {
        return new XMLDepartement();
    }

    /*@Override
    public DAO<Semestre> getDAOSemestre() {
        return new XMLSemestre();
    }*/

}
