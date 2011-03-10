/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.Persist.AbstractDAOFactory;
import fr.GCAM.StudentManager.Persist.DAO;

/**
 *
 * @author Quentin
 */
public class XMLDAOFactory extends AbstractDAOFactory {

    @Override
    public DAO getECUEDAO() {
	return new XMLECUEDAO();
    }

    @Override
    public DAO getEleveDAO() {
	return new XMLEtudiantDAO();
    }

    @Override
    public DAO getLoginDAO() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
