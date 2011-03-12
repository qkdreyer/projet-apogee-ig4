/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.Persist.DAO;
import java.sql.Connection;

/**
 * Cette classe est la classe parente de l'ensemble des classes concretes de type DAO
 * (Data Access Object) qui vont acceder à la base de données.
 * Elle implemente l'interface DAO qui déclare les quatre méthodes de base
 * de manipulation des données.
 *
 * @author Quentin
 */
public abstract class DB<T> implements DAO<T> {

    protected Connection conn = null;

    public DB(Connection conn) {
	this.conn = conn;
    }

}
