/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.Persist.DAO;
import java.io.Serializable;

/**
 * Cette classe est la classe parente de l'ensemble des classes concretes de type DAO
 * (Data Access Object) qui vont acceder aux fichiers XML
 * Elle implemente l'interface DAO qui déclare les quatre méthodes de base
 * de manipulation des données.
 *
 * @author Quentin
 */
public abstract class XML<T> implements DAO<T>, Serializable {

    protected final String filename = "data.xml";

    public XML() {
    }

}
