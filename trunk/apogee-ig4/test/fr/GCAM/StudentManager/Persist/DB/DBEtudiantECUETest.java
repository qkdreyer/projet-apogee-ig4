/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import org.junit.Ignore;
import java.sql.Connection;
import fr.GCAM.StudentManager.POJO.Etudiant.AbstractEtudiant;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantECUE;
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
public class DBEtudiantECUETest {

    private static Connection conn;

    public DBEtudiantECUETest() {
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
     * Test of create method, of class DBEtudiantECUE.
     */
    @Test
    @Ignore
    public void testCreate() throws Exception {
	System.out.println("create DBEtudiantECUE");
	EtudiantECUE obj = null;
	DBEtudiantECUE instance = null;
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBEtudiantECUE.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update DBEtudiantECUE");
	EtudiantECUE obj = null;
	DBEtudiantECUE instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBEtudiantECUE.
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {
	System.out.println("delete DBEtudiantECUE");
	EtudiantECUE obj = null;
	DBEtudiantECUE instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBEtudiantECUE.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find DBEtudiantECUE");
	DBEtudiantECUE dbe = new DBEtudiantECUE(conn);
	EtudiantECUE result = dbe.find(99999);
	assertEquals("INETEST", result.getNumIne());
    }

    /**
     * Test of list method, of class DBEtudiantECUE.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list DBEtudiantECUE");
	DBEtudiantECUE instance = null;
	ArrayList expResult = null;
	ArrayList result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}