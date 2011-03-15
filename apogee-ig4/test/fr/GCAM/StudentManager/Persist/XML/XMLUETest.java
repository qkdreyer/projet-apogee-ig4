/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.UE;
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
public class XMLUETest {

    public XMLUETest() {
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
     * Test of create method, of class XMLUE.
     */
    @Test
    public void testCreate() throws Exception {
	System.out.println("create");
	UE obj = null;
	XMLUE instance = new XMLUE();
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class XMLUE.
     */
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update");
	UE obj = null;
	XMLUE instance = new XMLUE();
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class XMLUE.
     */
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete");
	UE obj = null;
	XMLUE instance = new XMLUE();
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class XMLUE.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find");
	Object id = null;
	XMLUE instance = new XMLUE();
	UE expResult = null;
	UE result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class XMLUE.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	XMLUE instance = new XMLUE();
	String expResult = "";
	ArrayList<UE> result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}