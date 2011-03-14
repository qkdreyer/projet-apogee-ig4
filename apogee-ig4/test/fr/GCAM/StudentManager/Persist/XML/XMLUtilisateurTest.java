/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Utilisateur;
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
public class XMLUtilisateurTest {

    public XMLUtilisateurTest() {
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
     * Test of create method, of class XMLUtilisateur.
     */
    @Test
    public void testCreate() throws Exception {
	System.out.println("create");
	Utilisateur obj = null;
	XMLUtilisateur instance = new XMLUtilisateur();
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class XMLUtilisateur.
     */
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update");
	Utilisateur obj = null;
	XMLUtilisateur instance = new XMLUtilisateur();
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class XMLUtilisateur.
     */
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete");
	Utilisateur obj = null;
	XMLUtilisateur instance = new XMLUtilisateur();
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class XMLUtilisateur.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find");
	Object request = null;
	XMLUtilisateur instance = new XMLUtilisateur();
	Utilisateur expResult = null;
	Utilisateur result = instance.find(request);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class XMLUtilisateur.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	XMLUtilisateur instance = new XMLUtilisateur();
	String expResult = "";
	String result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}