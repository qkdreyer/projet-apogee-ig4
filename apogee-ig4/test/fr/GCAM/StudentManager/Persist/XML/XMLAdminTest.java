/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Admin;
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
public class XMLAdminTest {

    public XMLAdminTest() {
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
     * Test of create method, of class XMLAdmin.
     */
    @Test
    public void testCreate() throws Exception {
	System.out.println("create");
	Admin obj = null;
	XMLAdmin instance = new XMLAdmin();
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class XMLAdmin.
     */
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update");
	Admin obj = null;
	XMLAdmin instance = new XMLAdmin();
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class XMLAdmin.
     */
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete");
	Admin obj = null;
	XMLAdmin instance = new XMLAdmin();
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class XMLAdmin.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find");
	Object id = null;
	XMLAdmin instance = new XMLAdmin();
	Admin expResult = null;
	Admin result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class XMLAdmin.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	XMLAdmin instance = new XMLAdmin();
	String expResult = "";
	String result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}