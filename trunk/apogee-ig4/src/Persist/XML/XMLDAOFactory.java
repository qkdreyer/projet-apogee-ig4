/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist.XML;

import Persist.AbstractDAOFactory;
import Persist.DAO;

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

}
