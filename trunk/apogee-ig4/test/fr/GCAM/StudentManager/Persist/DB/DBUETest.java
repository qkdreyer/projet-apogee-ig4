/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import java.sql.Connection;
import java.util.ArrayList;
import org.junit.Ignore;
import fr.GCAM.StudentManager.POJO.UE;
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
public class DBUETest {

    private static Connection conn;

    public DBUETest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
     * Test of create method, of class DBUE.
     */
    @Test
    @Ignore
    public void testCreate() throws Exception {
	System.out.println("create");
	UE obj = null;
	DBUE instance = null;
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBUE.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update");
	UE obj = null;
	DBUE instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBUE.
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {
	System.out.println("delete");
	UE obj = null;
	DBUE instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBUE.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find UE");

	UE result = new DBUE(conn).find("testCUE");
	assertEquals("testLib", result.getLibelleUE());
    }

    /**
     * Test of list method, of class DBUE.
     */
    @Test
    @Ignore
    public void testList() throws Exception {
	System.out.println("list");
	DBUE instance = null;
	String expResult = "";
	ArrayList<UE> result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}