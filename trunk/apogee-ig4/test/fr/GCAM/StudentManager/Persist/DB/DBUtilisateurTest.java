/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import java.sql.Statement;
import java.sql.ResultSet;
import fr.GCAM.StudentManager.Util.SHA1;
import org.junit.Ignore;
import java.sql.Connection;
import fr.GCAM.StudentManager.POJO.Utilisateur;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pierre
 */
public class DBUtilisateurTest {

    private Utilisateur util;

    private static Connection conn;

    public DBUtilisateurTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
	conn = ConnectionDB.getConnection();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class DBUtilisateur.
     */
    @Test
    public void testCreate() throws Exception {
	System.out.println("create DBUtilisateur");
	Utilisateur obj = null;
	DBUtilisateur instance = null;
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBUtilisateur.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update");
	Utilisateur obj = null;
	DBUtilisateur instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBUtilisateur.
     */
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete DBUtilisateur");
	Utilisateur obj = null;
	DBUtilisateur instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBUtilisateur.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find DBUtilisateur");
	DBUtilisateur dbu = new DBUtilisateur(conn);
	Utilisateur result = dbu.find(9999);
	assertEquals("testNom", result.getNom());

	ArrayList<String> logs = new ArrayList<String>();
	logs.add("testPrenom");
	logs.add("testNom");
	logs.add("testPass");
	result = dbu.find(logs);
	assertEquals("testprenom", result.getPrenom());
	assertEquals("testnom", result.getNom());
    }

    /**
     * Test of list method, of class DBUtilisateur.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list DBUtilisateur");
	DBUtilisateur dbu = new DBUtilisateur(conn);
	util = new Utilisateur();
	boolean Trouve = false;
//	ArrayList<Utilisateur> expResult = new ArrayList<Utilisateur>();

	ArrayList<Utilisateur> result = dbu.list();
//	System.out.println("result.toString() = " + result.toString());

	 //on recupere le resultat
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT distinct(idenseignant) from vo_utilisateur");
	if (r.first()) {
	    do {
		util = new Utilisateur();
		util.setIdEnseignant(r.getInt("idenseignant"));
		System.out.println("util.getIdEnseignant() = " + util.getIdEnseignant());
//		trouve = false;
                for (Utilisateur each : result) {
		    
		}
		assertTrue(Trouve);
            } while (r.next());

//	    assertEquals(expResult, result);
	} else {
	    fail("Aucun résultats du find Utilisateur");
	}

	
    }

}