package fr.GCAM.StudentManager.Persist;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.Persist.DB.DBFactory;
import fr.GCAM.StudentManager.Persist.XML.XMLFactory;
import java.util.Observable;

/**
 *
 * @author Quentin
 */
public abstract class AbstractDAOFactory extends Observable {

    protected static AbstractDAOFactory fact = null;

    public abstract DAO<Utilisateur> getDAOUtilisateur();

    public abstract DAO getDAOEtudiant();

    public abstract DAO getDAOECUE();
    public abstract DAO getDAOUE();
    public abstract DAO getDAOSemestre();
    public abstract DAO getDAOEtape();
    public abstract DAO getDAODepartement();

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
