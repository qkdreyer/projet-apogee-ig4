/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import java.sql.Statement;
import java.sql.ResultSet;
import fr.GCAM.StudentManager.Util.SHA1;
import org.junit.Ignore;
import java.sql.Connection;
import fr.GCAM.StudentManager.Business.POJO.Utilisateur;
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

    private static Utilisateur util1_m;
    private static Utilisateur util2_m;

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

	util1_m = new Utilisateur(9999, "testPrenom", "testNom", "testPass", "testMail", listResp);

	//On cré le POJO du deuxieme utilisateur
	listResp = new ArrayList<Utilisateur.Responsabilite>();
	listResp.add(new Utilisateur.Responsabilite("testCMat2", "ECUE"));

	util2_m = new Utilisateur(10000, "testPrenom2", "testNom2", "testPass2", "testMail2", listResp);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {

	Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	//Suppression de la deuxieme ECUE créée juste pour ce test.
	s.executeQuery("delete from ecue where codeMatiere='testCMat2'");


	//Suprresion du deuxieme utilisateur créé
	//Maintenant il est delete depuis la methode delete
	//s.executeQuery("delete from enseignant where nom='testNom2' and prenom='testPrenom2'");
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
		util2_m.getNom() + "' and prenom='"+util2_m.getPrenom()+"'";
	//L'id est genere par la séquence.

	DBUtilisateur instance = new DBUtilisateur(conn);
	instance.create(util2_m);

	ResultSet r = s.executeQuery(str);
	if (r.first()) {
	    //On verifie que le bon nom a ete insere
	    assertEquals(util2_m.getNom(), r.getString("nom"));
	    assertEquals(util2_m.getPrenom(), r.getString("prenom"));
	    assertEquals(SHA1.getHash(util2_m.getMDP()), r.getString("mdp"));

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
    public void testDelete() throws Exception {

	//Créer un nouvel utilisateur. et le supprimer.
	//A la limite, petit idée de derniere minute, supprimer celui qu'on a créé au
	//dessus dans le testCreate()

	System.out.println("delete DBUtilisateur");

	Statement s_id = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	String req_id = "SELECT idenseignant from enseignant where nom = 'testNom2'";


	ResultSet r_id = s_id.executeQuery(req_id);
	int id_reel = 0;
	if (r_id.first() ) {
	     id_reel = r_id.getInt("idenseignant");
	}
	util2_m.setIdEnseignant(id_reel);

	DBUtilisateur instance = new DBUtilisateur(conn);

	//TODO : assertTrue que l'util2_m est present dans la base

	instance.delete(util2_m);
	// Le create est testé avant donc il est censé marcher.

	Statement s_del = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String str = "SELECT * from vo_utilisateur where idenseignant = '" +
		util2_m.getIdEnseignant() + "'";

	ResultSet r = s_del.executeQuery(str);
	if (r.first()) {
	    assertEquals(null, r.getString("nom"));
	    assertEquals(null, r.getString("prenom"));

	    // TODO : verifier que ce dont il était responsable a bien était mis a jour
	    // TODO : 2 : en fait ce genre d'update, comme la maj des relations de
	    // responsabilité, ce serait peut etre mieux que ce soient des triggers SQL non ?
//	    Statement s_res
	    assertEquals(null, str);
	}

	


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
	util1_m = new Utilisateur();
	boolean trouve = false;
//	ArrayList<Utilisateur> expResult = new ArrayList<Utilisateur>();

	ArrayList<Utilisateur> result = dbu.list();

	//on recupere le resultat
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT distinct(idenseignant) from vo_utilisateur");
	if (r.first()) {
	    do {
		util1_m = new Utilisateur();
		util1_m.setIdEnseignant(r.getInt("idenseignant"));
		trouve = false;
		for (Utilisateur each : result) {
		    if(each.getIdEnseignant() == util1_m.getIdEnseignant())
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
