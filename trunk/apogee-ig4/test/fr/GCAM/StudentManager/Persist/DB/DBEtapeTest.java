/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import org.junit.Ignore;
import java.sql.Connection;
import fr.GCAM.StudentManager.POJO.Etape;
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
public class DBEtapeTest {

    private static Etape et;
    private static Connection conn;

    public DBEtapeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
	et = new Etape("testCEt", "9","NResp PResp", "testVDip");
	conn = ConnectionDB.getConnection();
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
     * Test of create method, of class DBEtape.
     */
    @Ignore
    @Test
    public void testCreate() throws Exception {
	System.out.println("create");
	Etape obj = null;
	DBEtape instance = null;
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBEtape.
     */
    @Ignore
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update");
	Etape obj = null;
	DBEtape instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBEtape.
     */
    @Ignore
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete");
	Etape obj = null;
	DBEtape instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBEtape.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find");
	Object id = null;
	DBEtape instance = null;
	Etape result = instance.find("testCEt");
	assertEquals("9", result.getVersionEtape());
    }

    /**
     * Test of list method, of class DBEtape.
     */
    @Ignore
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	DBEtape instance = null;
	String expResult = "";
	String result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}