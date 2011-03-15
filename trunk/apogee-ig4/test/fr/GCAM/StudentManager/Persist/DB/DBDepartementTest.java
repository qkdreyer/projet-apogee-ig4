/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import java.sql.Connection;
import java.util.ArrayList;
import org.junit.Ignore;
import fr.GCAM.StudentManager.POJO.Departement;
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
public class DBDepartementTest {

    private static Connection conn;
    private static Departement dep;

    public DBDepartementTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
	conn = ConnectionDB.getConnection();
	dep = new Departement("testVDip", "testNomDep", "testMnemo", null);
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
     * Test of create method, of class DBDepartement.
     */
    @Ignore
    @Test
    public void testCreate() throws Exception {
	System.out.println("create");
	Departement obj = null;
	DBDepartement instance = null;
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DBDepartement.
     */
    @Ignore
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update");
	Departement obj = null;
	DBDepartement instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBDepartement.
     */
    @Ignore
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete");
	Departement obj = null;
	DBDepartement instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBDepartement.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find DBDepartement");
	Object id = null;
	DBDepartement instance = new DBDepartement(conn);
	Departement result = instance.find("testVDip");
	assertEquals(dep.getNomDepartement(), result.getNomDepartement());
    }

    /**
     * Test of list method, of class DBDepartement.
     */
    @Ignore
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	DBDepartement instance = null;
	String expResult = "";
	ArrayList<Departement> result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}
