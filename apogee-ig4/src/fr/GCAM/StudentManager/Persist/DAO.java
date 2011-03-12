/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist;

import fr.GCAM.StudentManager.POJO.Departement;
import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Etape;
import fr.GCAM.StudentManager.POJO.Etudiant;
import fr.GCAM.StudentManager.POJO.Semestre;
import fr.GCAM.StudentManager.POJO.UE;
import fr.GCAM.StudentManager.POJO.Utilisateur;

/**
 * Cette classe définit les 4 méthodes de base qui vont être redefinies par les
 * classes concretes.
 *
 * @author Quentin
 */
public interface DAO<T> {

    /**
     *
     * @param obj Le POJO que l'on veut créer
     * @throws Exception
     */
    public abstract void create(T obj) throws Exception;

    /**
     *
     * @param obj Le POJO que l'on veut modifier
     * @throws Exception
     */
    public abstract void update(T obj) throws Exception;

    /**
     *
     * @param obj Le POJO que l'on veut supprimer
     * @throws Exception
     */
    public abstract void delete(T obj) throws Exception;

    /**
     *
     * @param id L'identifiant d'un élément que l'on veut récuperer. Nous
     * utilisons un identifiant de type Object car celui ci peut etre un entier
     * ou une chaine de caractere en fonction de l'element recherché.
     * @return Le POJO que l'on a récuperer si l'id correspondait à la clé
     * primaire d'un élément
     * @throws Exception
     */
    public abstract T find(Object id) throws Exception;


}
