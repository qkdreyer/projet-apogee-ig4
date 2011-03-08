/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist.XML;

import Persist.DAO;
import java.io.Serializable;

/**
 *
 * @author Quentin
 */
public abstract class XMLDAO<T> implements DAO<T>, Serializable {

    String filename = "data.xml";

}
