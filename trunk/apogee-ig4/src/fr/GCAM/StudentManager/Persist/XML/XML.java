/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.Persist.DAO;
import java.io.Serializable;

/**
 *
 * @author Quentin
 */
public abstract class XML<T> implements DAO<T>, Serializable {

    protected final String filename = "data.xml";

    public XML() {
    }

}
