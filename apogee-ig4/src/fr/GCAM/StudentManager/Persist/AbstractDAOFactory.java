package fr.GCAM.StudentManager.Persist;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.DB.DBFactory;
import fr.GCAM.StudentManager.Persist.XML.XMLFactory;
import java.util.Observable;

/**
 * Cette classe represente la fabrique abstraite de DAO(Data Access Object)
 * La classe fournit soit une DBFactory soit une XMLFactory en fonction de la
 * chaine passée en parametre du constructeur
 * La classe déclare un ensemble de méthodes abstraites d'acces aux données.
 * Chaque méthode correspond à l'accès a une maquette écran.
 *
 * @author Quentin
 */
public abstract class AbstractDAOFactory extends Observable {

    protected static AbstractDAOFactory fact = null;

    /**
     * Methode renvoyant un DAO(Data Access Object) pour un Utilisateur
     *
     * @return Renvoie le DAO instancié avec le POJO utilisateur
     */
    public abstract DAO<Utilisateur> getDAOUtilisateur();

    /**
     * Methode renvoyant un DAO(Data Access Object) pour un Etudiant
     *
     * @return Renvoie le DAO instancié avec le POJO etudiant
     */
    public abstract DAO<EtudiantECUE> getDAOEtudiantECUE();

    /**
     * Methode renvoyant un DAO(Data Access Object) pour une ECUE
     *
     * @return Renvoie le DAO instancié avec le POJO ECUE
     */
    public abstract DAO<ECUE> getDAOECUE();

    /**
     * Methode renvoyant un DAO(Data Access Object) pour une UE
     *
     * @return Renvoie le DAO instancié avec le POJO UE
     */
    public abstract DAO<UE> getDAOUE();

    /**
     * Methode renvoyant un DAO(Data Access Object) pour une Etape
     *
     * @return Renvoie le DAO instancié avec le POJO Etape
     */
    public abstract DAO<Etape> getDAOEtape();

    /**
     * Methode renvoyant un DAO(Data Access Object) pour une Departement
     *
     * @return Renvoie le DAO instancié avec le POJO Departement
     */
    public abstract DAO<Departement> getDAODepartement();

    /**
     * Methode statique utilisée pour renvouer une AbstractDAOFactoru qui servira
     * à creer des DAO concrets
     *
     * @param s La chaine doit avoir comme valeur "db" ou "xml"
     * @return Si la chaine s vaut "db", un objet DBFactory est renvoyé<br>
     * Si la chaine s vaut "xml", un objet XMLFactory est renvoyé
     */
    public static AbstractDAOFactory getDAOFactory(String s) {
        if (fact == null) {
            if (s.equals("db")) {
                fact = new DBFactory();
            } else if (s.equals("xml")) {
                fact = new XMLFactory();
            } else {
                System.err.println("No factory declared");
            }
        }
        return fact;
    }
}
