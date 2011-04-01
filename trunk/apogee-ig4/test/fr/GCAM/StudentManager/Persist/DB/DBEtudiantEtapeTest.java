/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import org.junit.Ignore;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantEtape;
import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantEtape;
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
public class DBEtudiantEtapeTest {

    public DBEtudiantEtapeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
     * Test of create method, of class DBEtudiantEtape.
     */
    @Test
    @Ignore
    public void testCreate() throws Exception {
	System.out.println("create DBEtudiantEtapeTest");
	EtudiantEtape obj = null;
	DBEtudiantEtape instance = null;
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBEtudiantEtape.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update DBEtudiantEtape");
	EtudiantEtape obj = null;
	DBEtudiantEtape instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBEtudiantEtape.
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {
	System.out.println("delete DBEtudiantEtapeTest");
	EtudiantEtape obj = null;
	DBEtudiantEtape instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBEtudiantEtape.
     */
    @Test
    @Ignore
    public void testFind() throws Exception {
	System.out.println("find DBEtudiantEtapeTest");
	Object id = null;
	DBEtudiantEtape instance = null;
	EtudiantEtape expResult = null;
	EtudiantEtape result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class DBEtudiantEtape.
     */
    @Test
    @Ignore
    public void testList() throws Exception {
	System.out.println("list DBEtudiantEtapeTest");
	DBEtudiantEtape instance = null;
	ArrayList expResult = null;
	ArrayList result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}