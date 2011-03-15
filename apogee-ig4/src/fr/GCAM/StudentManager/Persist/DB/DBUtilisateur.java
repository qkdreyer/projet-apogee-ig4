/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.Util.SHA1;
import fr.GCAM.StudentManager.POJO.*;
import fr.GCAM.StudentManager.POJO.Utilisateur.Responsabilite;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Cette classe définit les methodes de l'interface DAO pour le type Utilsateur
 * (POJO).
 *
 * @author Quentin
 */
public class DBUtilisateur extends DB<Utilisateur> {

    public DBUtilisateur(Connection conn) {
        super(conn);
    }

    /**
     * Methode permettant la création d'un Utilisateur
     *
     * @param obj l'utilisateur qui doit être insérée dans la base de données
     * @throws Exception
     */
    public void create(Utilisateur obj) throws Exception {
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        s.execute("insert into Enseignant values(utilSeq.nextval, '"
                + SHA1.getHash(obj.getMDP()) + "', '"
                + obj.getNom() + "', '"
                + obj.getPrenom() + "', '"
                + obj.getMail() + "'");
        for (Responsabilite r : obj.getListeResponsabilites()) {
            if (r.getLibelle().equals("ECUE")) {
                ECUE e = new DBECUE(conn).find(r.getCodeResponsabilite());
                s.execute("insert into ECUE values("
                        + r.getCodeResponsabilite() + ", '"
                        + e.getLibelleECUE() + "', "
                        + e.getNbHeures() + ", "
                        + "utilSeq.currval, '"
                        + e.getCodeUE() + "'");
            } else if (r.getLibelle().equals("UE")) {
                UE u = new DBUE(conn).find(r.getCodeResponsabilite());
                s.execute("insert into UE values("
                        + r.getCodeResponsabilite() + ", "
                        + u.getNbECTS() + ", '"
                        + u.getLibelleUE() + "', "
                        + (u.isOptionnel() ? 't' : 'f') + ", "
                        + "utilSeq.currval, '"
                        + u.getCodeSemestre() + "'");
            } else if (r.getLibelle().equals("Etape")) {
                Etape e = new DBEtape(conn).find(r.getCodeResponsabilite());
                s.execute("insert into Etape values("
                        + r.getCodeResponsabilite() + ", '"
                        + "utilSeq.currval, '"
                        + e.getVersionDiplome() + "'");
            } else if (r.getLibelle().equals("Departement")) {
                Departement d = new DBDepartement(conn).find(r.getCodeResponsabilite());
                s.execute("insert into Departement values("
                        + r.getCodeResponsabilite() + ", '"
                        + d.getNomDepartement() + "', '"
                        + d.getMnemo() + "', "
                        + "utilSeq.currval");
            }
        }
    }

    /**
     * Methode permettant la modification d'un Utilisateur
     *
     * @param obj l'Utilisateur qui doit être modifiée dans la base de données
     * @throws Exception
     */
    public void update(Utilisateur obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Methode permettant la suppression d'un Utilisateur
     *
     * @param obj l'Utilisateur qui doit être supprimée dans la base de données
     * @throws Exception
     */
    public void delete(Utilisateur obj) throws Exception {
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        for (Responsabilite r : obj.getListeResponsabilites()) {
            if (r.getLibelle().equals("ECUE")) {
                s.execute("update ECUE set idEnseignant = null where idEnseignant = " + obj.getIdEnseignant());
            } else if (r.getLibelle().equals("UE")) {
		s.execute("update UE set idEnseignant = null where idEnseignant = " + obj.getIdEnseignant());
            } else if (r.getLibelle().equals("Etape")) {
		s.execute("update Etape set idEnseignant = null where idEnseignant = " + obj.getIdEnseignant());
            } else if (r.getLibelle().equals("Departement")) {
		s.execute("update Departement set idEnseignant = null where idEnseignant = " + obj.getIdEnseignant());
            }
        }
	s.execute("delete from Enseignant where idEnseignant = " + obj.getIdEnseignant());
    }

    /**
     * La fonction, renvoie un POJO Utilisateur, a partir de l'objet request
     * passé en parametre.<br>
     * Le parametre peut etre de deux types : <br>
     * - Soit un entier, afin de chercher l'utilisateur par son id
     * - Soit un ArrayList de String au format {Prenom, Nom, MDP}
     * La fonction delegue le travail en fonction du type de parametre
     *
     * @param id(int ou ArrayList<String>) L'id de l'utilisateur que l'on souhaite charger
     * @return L'utilisateur correspondant à la ligne trouvé dans la BD a partir de l'id
     * @throws Exception
     */
    public Utilisateur find(Object request) throws Exception {
        if (request instanceof ArrayList) {
            return this.findWithLogin((ArrayList) request);
        } else if (request instanceof Integer) {
            return this.findWithID((Integer) request);
        } else {
            return null;
        }
    }

    /**
     * Methode appelée par la méthode find dans le cas où l'Object était un int.
     *
     * @param num(int) L'id de l'utilisateur à rechercher.
     * @return Renvoie l'utilisateur correspondant ayant comme id 'num'.
     * @throws Exception
     */
    private Utilisateur findWithID(Integer num) throws Exception {
        Utilisateur util = new Utilisateur();
        ArrayList<Utilisateur.Responsabilite> listeResp;

        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT * from VO_Utilisateur "
                + "where idEnseignant = " + num);
        if (result.first()) {
	    util.setIdEnseignant(result.getInt("idEnseignant"));
            util.setNom(result.getString("nom"));
            util.setPrenom(result.getString("prenom"));
            util.setMDP(result.getString("mdp"));
            util.setMail(result.getString("mail"));

            listeResp = new ArrayList<Utilisateur.Responsabilite>();
            do {
                listeResp.add(new Utilisateur.Responsabilite(
                        result.getString("codeResponsabilite"),
                        result.getString("libelle")));
            } while (result.next());
            util.setListeResponsabilites(listeResp);
        }
        return util;
    }

    /**
     * Methode appelée par la méthode find dans le cas où l'Object était un ArrayList.
     *
     * @param a(ArrayList<String>) L'ArrayList contenant toutes les informations de l'utilisateur.
     * au format {Prenom, Nom, MDP}
     * @return Renvoie l'utilisateur correspondant ayant comme prenom a[0], comme
     * nom a[1] et mot de passe a[2].
     * @throws Exception
     */
    private Utilisateur findWithLogin(ArrayList a) throws Exception {
        Utilisateur util = new Utilisateur();
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("SELECT idEnseignant, lower(nom) as nom, "
		+ "lower(prenom) as prenom, mdp, mail, coderesponsabilite, libelle from VO_Utilisateur "
                + "where lower(nom) = '" + ((String) a.get(1)).toLowerCase() + "' and "
                + "lower(prenom) = '" + ((String) a.get(0)).toLowerCase() + "' and "
                + "mdp = getHash('" + (String) a.get(2) + "')");
        if (result.first()) {
	    util.setIdEnseignant(result.getInt("idEnseignant"));
            util.setNom(result.getString("nom"));
            util.setPrenom(result.getString("prenom"));
            util.setMDP(result.getString("mdp"));
            util.setMail(result.getString("mail"));

            do {
                util.getListeResponsabilites().add(new Utilisateur.Responsabilite(
                        result.getString("codeResponsabilite"),
                        result.getString("libelle")));
            } while (result.next());
        }
        return util;
    }

    /**
     * Methode renvoyant l'ensemble des utilisateurs
     *
     * @return L'ensemble des utilisateurs
     * @throws Exception
     */
    public ArrayList<Utilisateur> list() throws Exception {
        ArrayList<Utilisateur> listeUtil = new ArrayList<Utilisateur>();
        Statement s = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet result = s.executeQuery("select * from Enseignant order by idEnseignant");
        if (result.first()) {
            do {
                listeUtil.add(this.findWithID(result.getInt("idEnseignant")));
            } while (result.next());
        }
        return listeUtil;
    }
}
