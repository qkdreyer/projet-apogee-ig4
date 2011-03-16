/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import org.junit.Ignore;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantECUE;
import fr.GCAM.StudentManager.Persist.XML.Etudiant.XMLEtudiantECUE;
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
public class XMLEtudiantECUETest {

    public XMLEtudiantECUETest() {
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
     * Test of create method, of class XMLEtudiantECUE.
     */
    @Test
    @Ignore
    public void testCreate() throws Exception {
	System.out.println("create XMLEtudiantECUE");
	EtudiantECUE obj = null;
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class XMLEtudiantECUE.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update XMLEtudiantECUE");
	EtudiantECUE obj = null;
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class XMLEtudiantECUE.
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {
	System.out.println("delete XMLEtudiantECUE");
	EtudiantECUE obj = null;
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class XMLEtudiantECUE.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find XMLEtudiantECUE");
	Object id = null;
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	EtudiantECUE expResult = null;
	EtudiantECUE result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class XMLEtudiantECUE.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list XMLEtudiantECUE");
	XMLEtudiantECUE instance = new XMLEtudiantECUE();
	ArrayList expResult = null;
	ArrayList result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}