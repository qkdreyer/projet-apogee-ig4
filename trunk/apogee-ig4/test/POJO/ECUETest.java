/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package POJO;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.ECUE.EtudiantECUE;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pierre
 */
public class ECUETest {

    public ECUETest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of getCodeMatiere method, of class ECUE.
     */
    @Test
    public void testGetCodeMatiere() {
        System.out.println("getCodeMatiere");
        ECUE instance = new ECUE();
        String expResult = "";
        String result = instance.getCodeMatiere();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodeMatiere method, of class ECUE.
     */
    @Test(timeout = 400)
    public void testSetCodeMatiere() {
        System.out.println("setCodeMatiere");
        ECUE e = new ECUE();
        e.setCodeMatiere("test");
        assertEquals("test", e.getCodeMatiere());
    }

    /**
     * Test of getCodeUE method, of class ECUE.
     */
    @Test
    public void testGetCodeUE() {
        System.out.println("getCodeUE");
        ECUE instance = new ECUE();
        String expResult = "";
        String result = instance.getCodeUE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCodeUE method, of class ECUE.
     */
    @Test
    public void testSetCodeUE() {
        System.out.println("setCodeUE");
        String codeUE = "";
        ECUE instance = new ECUE();
        instance.setCodeUE(codeUE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdEnseignant method, of class ECUE.
     */
    @Test
    public void testGetIdEnseignant() {
        System.out.println("getIdEnseignant");
        ECUE instance = new ECUE();
        int expResult = 0;
        int result = instance.getIdEnseignant();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEnseignant method, of class ECUE.
     */
    @Test
    public void testSetIdEnseignant() {
        System.out.println("setIdEnseignant");
        int idEnseignant = 0;
        ECUE instance = new ECUE();
        instance.setIdEnseignant(idEnseignant);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLibelleECUE method, of class ECUE.
     */
    @Test
    public void testGetLibelleECUE() {
        System.out.println("getLibelleECUE");
        ECUE instance = new ECUE();
        String expResult = "";
        String result = instance.getLibelleECUE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLibelleECUE method, of class ECUE.
     */
    @Test
    public void testSetLibelleECUE() {
        System.out.println("setLibelleECUE");
        String libelleECUE = "";
        ECUE instance = new ECUE();
        instance.setLibelleECUE(libelleECUE);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNbHeures method, of class ECUE.
     */
    @Test
    public void testGetNbHeures() {
        System.out.println("getNbHeures");
        ECUE instance = new ECUE();
        int expResult = 0;
        int result = instance.getNbHeures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNbHeures method, of class ECUE.
     */
    @Test
    public void testSetNbHeures() {
        System.out.println("setNbHeures");
        int nbHeures = 0;
        ECUE instance = new ECUE();
        instance.setNbHeures(nbHeures);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListeEtud method, of class ECUE.
     */
    @Test
    public void testGetListeEtud() {
        System.out.println("getListeEtud");
        ECUE instance = new ECUE();
        ArrayList expResult = null;
        ArrayList result = instance.getListeEtud();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListeEtud method, of class ECUE.
     */
    @Test
    public void testSetListeEtud() {
        System.out.println("setListeEtud");
        ArrayList<EtudiantECUE> listeEtud = null;
        ECUE instance = new ECUE();
        instance.setListeEtud(listeEtud);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class ECUE.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ECUE instance = new ECUE();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}