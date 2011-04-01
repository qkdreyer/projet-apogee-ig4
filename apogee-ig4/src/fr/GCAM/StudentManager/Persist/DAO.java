/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist;

import java.util.ArrayList;

/**
 * Cette classe définit les 4 méthodes de base qui vont être redefinies par les
 * classes concretes.
 *
 * @author Quentin
 */
public interface DAO<T> {


    /**
     * Methode de creation d'un objet T
     * @param obj Le POJO que l'on veut créer
     * @throws Exception
     */
    public abstract void create(T obj) throws Exception;

    /**
     * Methode de modification d'un objet T
     * @param obj Le POJO que l'on veut modifier
     * @throws Exception
     */
    public abstract void update(T obj) throws Exception;

    /**
     * Methode de suppression d'un objet T
     * @param obj Le POJO que l'on veut supprimer
     * @throws Exception
     */
    public abstract void delete(T obj) throws Exception;

    /**
     * Methode de recherche d'un objet T
     * @param id L'identifiant d'un élément que l'on veut récuperer. Nous
     * utilisons un identifiant de type Object car celui ci peut etre un entier
     * ou une chaine de caractere en fonction de l'element recherché.
     * @return Le POJO que l'on a récuperer si l'id correspondait à la clé
     * primaire d'un élément
     * @throws Exception
     */
    public abstract T find(Object id) throws Exception;

    /**
     * Methode permettant de lister l'ensemble des elements de type T
     * @return L'arrayliste contenant l'ensemble des elements de type T
     * @throws Exception
     */
    public abstract ArrayList<T> list() throws Exception;

}
