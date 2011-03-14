/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Core;

import org.jdom.Document;
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
public class JDOMTest {

    public JDOMTest() {
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
     * Test of main method, of class JDOM.
     */
    @Test
    public void testMain() {
	System.out.println("main");
	String[] args = null;
	JDOM.main(args);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class JDOM.
     */
    @Test
    public void testSave() throws Exception {
	System.out.println("save");
	Document d = null;
	String fichier = "";
	JDOM.save(d, fichier);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}