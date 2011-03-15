/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Etape;
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
public class XMLEtapeTest {

    public XMLEtapeTest() {
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
     * Test of create method, of class XMLEtape.
     */
    @Test
    public void testCreate() throws Exception {
	System.out.println("create");
	Etape obj = null;
	XMLEtape instance = new XMLEtape();
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class XMLEtape.
     */
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update");
	Etape obj = null;
	XMLEtape instance = new XMLEtape();
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class XMLEtape.
     */
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete");
	Etape obj = null;
	XMLEtape instance = new XMLEtape();
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class XMLEtape.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find");
	Object id = null;
	XMLEtape instance = new XMLEtape();
	Etape expResult = null;
	Etape result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class XMLEtape.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	XMLEtape instance = new XMLEtape();
	String expResult = "";
	ArrayList<Etape> result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}