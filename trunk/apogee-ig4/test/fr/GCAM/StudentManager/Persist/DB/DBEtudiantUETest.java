/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantUE;
import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantUE;
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
public class DBEtudiantUETest {

    public DBEtudiantUETest() {
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
     * Test of create method, of class DBEtudiantUE.
     */
    @Test
    public void testCreate() throws Exception {
	System.out.println("create");
	EtudiantUE obj = null;
	DBEtudiantUE instance = null;
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBEtudiantUE.
     */
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update");
	EtudiantUE obj = null;
	DBEtudiantUE instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBEtudiantUE.
     */
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete");
	EtudiantUE obj = null;
	DBEtudiantUE instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBEtudiantUE.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find");
	Object id = null;
	DBEtudiantUE instance = null;
	EtudiantUE expResult = null;
	EtudiantUE result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class DBEtudiantUE.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	DBEtudiantUE instance = null;
	ArrayList expResult = null;
	ArrayList result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}