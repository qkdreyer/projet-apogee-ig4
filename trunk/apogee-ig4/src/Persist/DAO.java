/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persist;

import java.util.ArrayList;

/**
 *
 * @author Quentin
 */
public interface DAO<T> {

    public abstract void create(T obj) throws Exception;
    public abstract void update(T obj) throws Exception;
    public abstract void delete(T obj) throws Exception;
    public abstract T find(Object id) throws Exception;
    public abstract ArrayList<T> load(Object parent) throws Exception;

}
