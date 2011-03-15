/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import org.junit.Ignore;
import java.sql.Connection;
import fr.GCAM.StudentManager.Persist.DAO;
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
public class DBFactoryTest {

    private static Connection conn;

    public DBFactoryTest() {
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
     * Test of getDAOECUE method, of class DBFactory.
     */
    @Ignore
    @Test
    public void testGetDAOECUE() {
	System.out.println("getDAOECUE");
	DBFactory instance = new DBFactory();
	DAO expResult = new DBECUE(conn);
	DAO result = instance.getDAOECUE();
	assertEquals(expResult, result);
	
    }

    /**
     * Test of getDAOEtudiant method, of class DBFactory.
     */
    @Ignore
    @Test
    public void testGetDAOEtudiantECUE() {
	System.out.println("getDAOEtudiant");
	DBFactory instance = new DBFactory();
	DAO expResult = null;
	DAO result = instance.getDAOEtudiantECUE();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getDAOUtilisateur method, of class DBFactory.
     */
    @Ignore
    @Test
    public void testGetDAOUtilisateur() {
	System.out.println("getDAOUtilisateur");
	DBFactory instance = new DBFactory();
	DAO expResult = null;
	DAO result = instance.getDAOUtilisateur();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getDAOUE method, of class DBFactory.
     */
    @Ignore
    @Test
    public void testGetDAOUE() {
	System.out.println("getDAOUE");
	DBFactory instance = new DBFactory();
	DAO expResult = null;
	DAO result = instance.getDAOUE();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getDAOEtape method, of class DBFactory.
     */
    @Ignore
    @Test
    public void testGetDAOEtape() {
	System.out.println("getDAOEtape");
	DBFactory instance = new DBFactory();
	DAO expResult = null;
	DAO result = instance.getDAOEtape();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getDAODepartement method, of class DBFactory.
     */
    @Ignore
    @Test
    public void testGetDAODepartement() {
	System.out.println("getDAODepartement");
	DBFactory instance = new DBFactory();
	DAO expResult = null;
	DAO result = instance.getDAODepartement();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }


}