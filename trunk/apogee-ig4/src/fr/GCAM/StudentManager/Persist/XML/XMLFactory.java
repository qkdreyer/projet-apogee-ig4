/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.Persist.XML.Etudiant.XMLEtudiantECUE;
import fr.GCAM.StudentManager.Business.POJO.*;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;

/**
 * Cette classe est la fabrique concrete de DAO(Data Access Object) qui
 * interagissent avec les fichiers XML.
 *
 * @author Quentin
 */
public class XMLFactory extends AbstractDAOFactory {

    /**
     * Méthode utilisée pour obtenir un objet DAO<ECUE>.
     *
     * @return Renvoie un DAOECUE qui est un DAO concret instancié avec le POJO
     * ECUE.
     */
    public DAO<ECUE> getDAOECUE() {
	return new XMLECUE();
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<Etudiant>.
     *
     * @return Renvoie un DAOEtudiant qui est un DAO concret instancié avec le POJO
     * Etudiant.
     */
    public DAO<EtudiantECUE> getDAOEtudiantECUE() {
	return new XMLEtudiantECUE();
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<Utilisateur>.
     *
     * @return Renvoie un DAOUtilisateur qui est un DAO concret instancié avec le POJO
     * Utilisateur.
     */
    public DAO<Utilisateur> getDAOUtilisateur() {
	return new XMLUtilisateur();
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<UE>.
     *
     * @return Renvoie un DAOUE qui est un DAO concret instancié avec le POJO
     * UE.
     */
    public DAO<UE> getDAOUE() {
        return new XMLUE();
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<ECUE>.
     *
     * @return Renvoie un DAOECUE qui est un DAO concret instancié avec le POJO
     * ECUE.
     */
    public DAO<Etape> getDAOEtape() {
        return new XMLEtape();
    }

    /**
     * Méthode utilisée pour obtenir un objet DAO<Departement>.
     *
     * @return Renvoie un DAODepartement qui est un DAO concret instancié avec le POJO
     * Departement.
     */
    public DAO<Departement> getDAODepartement() {
        return new XMLDepartement();
    }


}
