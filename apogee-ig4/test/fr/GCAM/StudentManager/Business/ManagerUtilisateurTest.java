/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Business;

import fr.GCAM.StudentManager.Business.Manager.ManagerUtilisateur;
import java.util.ArrayList;
import java.sql.Connection;
import fr.GCAM.StudentManager.Persist.DB.ConnectionDB;
import fr.GCAM.StudentManager.Business.POJO.Utilisateur;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ben
 */
public class ManagerUtilisateurTest {

    private static Connection conn;
    private static Utilisateur util_m;

    public ManagerUtilisateurTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
	conn = ConnectionDB.getConnection();
	ArrayList<Utilisateur.Responsabilite> listResp = new ArrayList<Utilisateur.Responsabilite>();
	listResp.add(new Utilisateur.Responsabilite("testVDip", "Departement"));
	listResp.add(new Utilisateur.Responsabilite("testCEt", "Etape"));
	listResp.add(new Utilisateur.Responsabilite("testCUE", "UE"));
	listResp.add(new Utilisateur.Responsabilite("TEST001", "ECUE"));

	util_m = new Utilisateur(9999, "prenomdansbase", "nomdansbase", "motdepasse", "testMail", listResp);
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
     * Test of login method, of class ManagerUtilisateur.
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        ManagerUtilisateur instance = null;
        //instance.login();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class ManagerUtilisateur.
     */
    @Test
    public void testLogin_3args() {

        //base de données
        System.out.println("login");
        String nom = "nomdansbase";
        String prenom = "prenomdansbase";
        String mdp = "motdepasse";
        ManagerUtilisateur instance = new ManagerUtilisateur("db");
        HashMap<String,String> expResult = new HashMap<String, String>();
        expResult.put("nom", "nomdansbase");
        expResult.put("prenom", "prenomdansbase");
        expResult.put("mds", "motdepasse");

        HashMap result = instance.login(nom, prenom, mdp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}