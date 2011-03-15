/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantECUE;
import org.junit.Ignore;
import java.sql.Connection;
import fr.GCAM.StudentManager.POJO.Etudiant.AbstractEtudiant;
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
public class DBEtudiantTest {

    private static Connection conn;

    public DBEtudiantTest() {
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
     * Test of create method, of class DBEtudiant.
     */
    @Test
    @Ignore
    public void testCreate() throws Exception {
	System.out.println("create");
	AbstractEtudiant obj = null;
	DBEtudiantECUE instance = null;
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBEtudiant.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update");
	AbstractEtudiant obj = null;
	DBEtudiantECUE instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBEtudiant.
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {
	System.out.println("delete");
	AbstractEtudiant obj = null;
	DBEtudiantECUE instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBEtudiant.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find DBEtudiant");

	AbstractEtudiant result = new DBEtudiantECUE(conn).find(99999);
	assertEquals("INETEST", result.getNumIne());
    }

    /**
     * Test of list method, of class DBEtudiant.
     */
    @Ignore
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	DBEtudiantECUE instance = null;
	String expResult = "";
	String result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}