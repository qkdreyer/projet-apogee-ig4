/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import org.junit.Ignore;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantEtape;
import fr.GCAM.StudentManager.Persist.XML.Etudiant.XMLEtudiantEtape;
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
public class XMLEtudiantEtapeTest {

    public XMLEtudiantEtapeTest() {
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
     * Test of create method, of class XMLEtudiantEtape.
     */
    @Test
    @Ignore
    public void testCreate() throws Exception {
	System.out.println("create XMLEtudiantEtape");
	EtudiantEtape obj = null;
	XMLEtudiantEtape instance = new XMLEtudiantEtape();
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class XMLEtudiantEtape.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update XMLEtudiantEtape");
	EtudiantEtape obj = null;
	XMLEtudiantEtape instance = new XMLEtudiantEtape();
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class XMLEtudiantEtape.
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {
	System.out.println("delete XMLEtudiantEtape");
	EtudiantEtape obj = null;
	XMLEtudiantEtape instance = new XMLEtudiantEtape();
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class XMLEtudiantEtape.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find XMLEtudiantEtape");
	Object id = null;
	XMLEtudiantEtape instance = new XMLEtudiantEtape();
	EtudiantEtape expResult = null;
	EtudiantEtape result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class XMLEtudiantEtape.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list XMLEtudiantEtape");
	XMLEtudiantEtape instance = new XMLEtudiantEtape();
	ArrayList expResult = null;
	ArrayList result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}