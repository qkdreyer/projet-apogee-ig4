/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.Persist.XML.Etudiant.XMLEtudiantECUE;
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
public class XMLEtudiantTest {

    public XMLEtudiantTest() {
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
     * Test of create method, of class XMLEtudiant.
     */
    @Test
    public void testCreate() throws Exception {
	System.out.println("create");
	AbstractEtudiant obj = null;
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class XMLEtudiant.
     */
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update");
	AbstractEtudiant obj = null;
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class XMLEtudiant.
     */
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete");
	AbstractEtudiant obj = null;
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class XMLEtudiant.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find");
	Object id = null;
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	AbstractEtudiant expResult = null;
	AbstractEtudiant result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class XMLEtudiant.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	String expResult = "";
	String result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}