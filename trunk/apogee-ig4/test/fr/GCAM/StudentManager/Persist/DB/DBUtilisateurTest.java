/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import fr.GCAM.StudentManager.Util.SHA1;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Ignore;
import java.sql.Connection;
import fr.GCAM.StudentManager.POJO.Utilisateur;
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
public class DBUtilisateurTest {

    private static Utilisateur util_m1;
    private static Utilisateur util_m2;

    private static Connection conn;

    public DBUtilisateurTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
	conn = ConnectionDB.getConnection();
	ArrayList<Utilisateur.Responsabilite> listResp = new ArrayList<Utilisateur.Responsabilite>();
	listResp.add(new Utilisateur.Responsabilite("testVDip", "Departement"));
	listResp.add(new Utilisateur.Responsabilite("testCEt", "Etape"));
	listResp.add(new Utilisateur.Responsabilite("testCUE", "UE"));
	listResp.add(new Utilisateur.Responsabilite("TEST001", "ECUE"));

	util_m1 = new Utilisateur(9999, "testPrenom", "testNom", "testPass", "testMail", listResp);

	//On cré le POJO du deuxieme utilisateur
	listResp = new ArrayList<Utilisateur.Responsabilite>();
	listResp.add(new Utilisateur.Responsabilite("testCMat2", "ECUE"));

	util_m2 = new Utilisateur(10000, "testPrenom2", "testNom2", "testPass2", "testMail2", listResp);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {

	Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	//Suppression de la deuxieme ECUE créée juste pour ce test.
	s.executeQuery("delete from ecue where codeMatiere='testCMat2'");


	//Suprresion du deuxieme utilisateur créé
	s.executeQuery("delete from enseignant where nom='testNom2' and prenom='testPrenom2'");
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of create method, of class DBUtilisateur.
     */
    @Test
    public void testCreate() throws Exception {
	// TODO : Creer un autre utilisateur que celui de base
	// avec genre une seule responsabilite
	System.out.println("create DBUtilisateur");

	

	Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	Statement s_enseignant = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        s.executeQuery("insert into ECUE values('testCMat2','testLibelle2', 100, 9999, 'testCUE')");

	String str = "SELECT * from vo_utilisateur where nom = '" +
		util_m2.getNom() + "' and prenom='"+util_m2.getPrenom()+"'";
	//L'id est genere par la séquence.

	DBUtilisateur instance = new DBUtilisateur(conn);
	instance.create(util_m2);

	System.out.println("str = " + str);
	ResultSet r = s.executeQuery(str);
	if (r.first()) {
	    //On verifie que le bon nom a ete insere
	    assertEquals(util_m2.getNom(), r.getString("nom"));
	    assertEquals(util_m2.getPrenom(), r.getString("prenom"));
	    assertEquals(SHA1.getHash(util_m2.getMDP()), r.getString("mdp"));

	    //On verifie ses responsabilites, il est cense etre responsable
	    //d'une ECUE, UE, etape, departement
	    // TODO
	    //L'ECUE testCmat2 est censé etre dirigée par l'enseignant de code
	    //1000 qu'on vient de créer.
	    ResultSet r_ecue = s.executeQuery("select idenseignant from ecue where codematiere='testCMat2'");
	    ResultSet r_enseignant = s_enseignant.executeQuery("select idenseignant from enseignant where nom='testNom2'");
	    if (r_ecue.first() && r_enseignant.first())
		assertEquals(r_ecue.getString("idenseignant"), r_enseignant.getString("idenseignant") );
	    else
		fail("Erreur sur le test création");
	}
    }

    /**
     * Test of update method, of class DBUtilisateur.
     */
    @Test
    @Ignore
    public void testUpdate() throws Exception {
	System.out.println("update");
	Utilisateur obj = null;
	DBUtilisateur instance = null;
	instance.update(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DBUtilisateur.
     */
    @Test
    @Ignore
    public void testDelete() throws Exception {

	//Créer un nouvel utilisateur. et le supprimer.
	//A la limite, petit idée de derniere minute, supprimer celui qu'on a créé au
	//dessus dans le testCreate()

	System.out.println("delete DBUtilisateur");

	DBUtilisateur instance = new DBUtilisateur(conn);
	instance.delete(util_m1);
	// Le create est testé avant donc il est censé marcher.

	Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String str = "SELECT * from vo_utilisateur where idenseignant = '" +
		util_m1.getIdEnseignant() + "'";
	System.out.println("str = " + str);
	ResultSet r = s.executeQuery(str);
	if (r.first()) {
	    assertEquals(null, r.getString("nom"));
	    assertEquals(null, r.getString("prenom"));
	}

	//Tout a marché, on le reinsere :
        s.executeQuery("insert into Enseignant values (9999,gethash('testPass'),'testNom','testPrenom','testMail')");


    }

    /**
     * Test of find method, of class DBUtilisateur.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find DBUtilisateur");
	DBUtilisateur dbu = new DBUtilisateur(conn);
	
	//Test avec findwithid
        
	Utilisateur result = dbu.find(9999);
	assertEquals("testNom", result.getNom());
        
	//Test avec find whith logs
	ArrayList<String> logs = new ArrayList<String>();
	logs.add("testPrenom");
	logs.add("testNom");
	logs.add("testPass");
	result = dbu.find(logs);
	assertEquals("testprenom", result.getPrenom());
	assertEquals("testnom", result.getNom());
	assertEquals(SHA1.getHash("testPass"), result.getMDP());

        //Test avec find with logs (renvoie null)
        ArrayList<String> logs2 = new ArrayList<String>();
        logs2.add("MauvaisPrenom");
        logs2.add("MauvaisNom");
        logs2.add("MauvaisMotDePasse");
        result = dbu.find(logs2);
        assertEquals(null, result);
    }

    /**
     * Test of list method, of class DBUtilisateur.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list DBUtilisateur");
	DBUtilisateur dbu = new DBUtilisateur(conn);
	util_m1 = new Utilisateur();
	boolean trouve = false;
//	ArrayList<Utilisateur> expResult = new ArrayList<Utilisateur>();

	ArrayList<Utilisateur> result = dbu.list();
//	System.out.println("result.toString() = " + result.toString());

	//on recupere le resultat
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT distinct(idenseignant) from vo_utilisateur");
	if (r.first()) {
	    do {
		util_m1 = new Utilisateur();
		util_m1.setIdEnseignant(r.getInt("idenseignant"));
		trouve = false;
		for (Utilisateur each : result) {
		    if(each.getIdEnseignant() == util_m1.getIdEnseignant())
			trouve = true;
		}
		assertTrue(trouve);
            } while (r.next());

//	    assertEquals(expResult, result);
	} else {
	    fail("Aucun résultats du find Utilisateur");
	}

	
    }

}
