/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import org.junit.Ignore;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantSemestre;
import fr.GCAM.StudentManager.Persist.DB.Etudiant.DBEtudiantSemestre;
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
public class DBEtudiantSemestreTest {

    public DBEtudiantSemestreTest() {
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
     * Test of create method, of class DBEtudiantSemestre.
     */
    @Test
    @Ignore
    public void testCreate() throws Exception {
	System.out.println("create DBEtudiantSemestre");
	EtudiantSemestre obj = null;
	DBEtudiantSemestre instance = null;
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBEtudiantSemestre.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update DBEtudiantSemestre");
	EtudiantSemestre obj = null;
	DBEtudiantSemestre instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBEtudiantSemestre.
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {
	System.out.println("delete DBEtudiantSemestre");
	EtudiantSemestre obj = null;
	DBEtudiantSemestre instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBEtudiantSemestre.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find DBEtudiantSemestre");
	Object id = null;
	DBEtudiantSemestre instance = null;
	EtudiantSemestre expResult = null;
	EtudiantSemestre result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class DBEtudiantSemestre.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list DBEtudiantSemestre");
	DBEtudiantSemestre instance = null;
	ArrayList expResult = null;
	ArrayList result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}