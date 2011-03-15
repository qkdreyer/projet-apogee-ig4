/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Etudiant.AbstractEtudiant;
import org.junit.Ignore;
import fr.GCAM.StudentManager.POJO.ECUE;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de units test pour la classe DBECUE.
 *
 * @author pierre
 */
public class DBECUETest {

    private static Connection conn;

    private static ECUE ecue;
    private static AbstractEtudiant etud;

    public DBECUETest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {

	conn = ConnectionDB.getConnection();

	etud = new AbstractEtudiant(99999, "netud", "petud", (float) 0.0, (float) 0.0);

	ecue = new ECUE();
	ecue.setCodeMatiere("TEST001");
	ecue.setLibelleECUE("testlibelle");
	ecue.setNbHeures(99);
	//ecue.setIdEnseignant(9999);

	ecue.setCodeUE("testCUE");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {	
    }

    /**
     * Fonction s'executant des l'instanciation de la classe
     * On cré un ensemble d'élement témoins que l'on rajoute dans la base de données
     * afin de pouvoir faire des tests.
     *
     */
    @Before
    public void setUp() {
        

    }

    /**
     * Fonction s'executant apres tous les tests.
     * On supprime tous nos élements témoins inséré au préalable afin de nettoyer la
     * base de données.
     *
     */
    @After
    public void tearDown() {
        
    }

    /**
     * Test of create method, of class DBECUEDAO.
     */
    @Ignore
    @Test
    public void testCreate() throws Exception {
        System.out.println("create DBECUE");
        ECUE ecue = new ECUE();
        DBECUE instance = null;
    }

    /**
     * Test of update method, of class DBECUEDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update DBECUE");
        //on lui modif ses notes
        DBECUE dbecue = new DBECUE(conn);
        ecue.getListeEtud().add(etud);

        etud.setNoteSession1((float) 12.8);
        etud.setNoteSession2((float) 5.8);

        //on update
        dbecue.update(ecue);
        //on recupere le resultat
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT v.codematiere, v.libelleECUE,"
		+ "v.nbheures,v.nomresponsable, v.prenomresponsable,v.codeue,"
		+ "v.numetudiant, v.nom, v.prenom, v.notesession1,v.notesession2 "
		+ "FROM vo_ecue v "
		+ "WHERE v.codematiere='TEST001' AND v.numetudiant=99999");
        //on le compare avec ce qu'on a mis a la base
        if (r.first()) {
            String codematiere = r.getString("codeMatiere");
            String libelleECUE = r.getString("libelleECUE");
            int nbheures = r.getInt("nbheures");
            String prenomResp = r.getString("prenomResponsable");
	    String nomResp = r.getString("nomResponsable");
            String codeUE = r.getString("codeUE");

            int numetud = r.getInt("numetudiant");
	    String nom = r.getString("nom");
	    String prenom = r.getString("prenom");
	    float notes1 = r.getFloat("notesession1");
	    float notes2 = r.getFloat("notesession2");

	    assertEquals(numetud, 99999);
            // 0.001 est le delta (ecart autorisé) par rapport à la note.
            assertEquals(12.8, notes1, 0.001);
            assertEquals(5.8, notes2, 0.001);

        } else {
            fail("The query didn't return any results");
        }
    }

    /**
     * Test of delete method, of class DBECUEDAO.
     */
    @Ignore
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete DBECUE");
        ECUE obj = null;
        DBECUE instance = null;
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBECUEDAO.
     */
    @Test
    public void testFind() throws Exception {
        System.out.println("find DBECUE");
        Object id = null;
        DBECUE instance = new DBECUE(conn);
        ECUE result = instance.find("TEST001");
        assertEquals("testlibelle", result.getLibelleECUE());
    }
}
