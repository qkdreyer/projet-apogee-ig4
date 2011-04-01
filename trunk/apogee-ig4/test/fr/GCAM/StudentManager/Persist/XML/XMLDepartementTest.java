/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import org.junit.Ignore;
import fr.GCAM.StudentManager.Business.POJO.Departement;
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
public class XMLDepartementTest {

    private static Departement dep_m;

    public XMLDepartementTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
	dep_m = new Departement("v", "d", "mnemo", null);
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
     * Test of create method, of class XMLDepartement.
     */
    @Test
    @Ignore
    public void testCreate() throws Exception {
	System.out.println("create XMLDepartement");
	Departement obj = null;
	XMLDepartement instance = new XMLDepartement();
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class XMLDepartement.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update XMLDepartement");
	Departement obj = null;
	XMLDepartement instance = new XMLDepartement();
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class XMLDepartement.
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {
	System.out.println("delete XMLDepartement");
	Departement obj = null;
	XMLDepartement instance = new XMLDepartement();
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class XMLDepartement.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find XMLDepartement");
	XMLDepartement instance = new XMLDepartement();
	
	String id = "TEST001";
	Departement result = instance.find(id);

	assertEquals(dep_m.getMnemo(), result.getMnemo());

    }

    /**
     * Test of list method, of class XMLDepartement.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list XMLDepartement");
	XMLDepartement instance = new XMLDepartement();
	String expResult = "";
	ArrayList<Departement> result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}