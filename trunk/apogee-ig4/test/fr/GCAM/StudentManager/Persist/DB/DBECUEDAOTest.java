/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.ECUE.EtudiantECUE;
import fr.GCAM.StudentManager.POJO.ECUE;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pierre
 */
public class DBECUEDAOTest {

    private static Connection conn;
    private ECUE ecue;
    private EtudiantECUE ec;

    public DBECUEDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp(){
	//Creation de la connection à la BD
	conn = ConnectionDB.getConnection();
	try {
	    //On cré une ECUE, pour laquelle on va réaliser le test
	    Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	    s.executeQuery("insert into Enseignant values (9999,'testPass','testNom','testPrenom','testMail')");

	    s.executeQuery("insert into Departement values ('testVDip','testLibelle','testMnemo',9999)");

	    s.executeQuery("insert into Etape  values ('testCEt','9',9999,'testVDip')");

	    s.executeQuery("insert into Semestre values ('99','s99',9,'testCEt')");

	    s.executeQuery("insert into UE values ('testCUE',99,'testLib','f',9999,'99')");

	    s.executeQuery("INSERT INTO ECUE values('TEST001','testlibelle', 99, 9999, 'testCUE')");

	    s.executeQuery("insert into Etudiant values (99999,0,'INETEST',0,null,null,null,'testCEt','netud','petud','m@etud.com')");

	    s.close();

	    ecue = new ECUE();
	    ec = new EtudiantECUE(99999, "netud","petud", (float)0.0, (float)0.0);

	    ecue.setCodeMatiere("TEST001");
	    ecue.setLibelleECUE("testlibelle");
	    ecue.setNbHeures(99);
	    ecue.setIdEnseignant(9999);
	    ecue.setCodeUE("testCUE");

	} catch (SQLException ex) {
	    Logger.getLogger(DBECUEDAOTest.class.getName()).log(Level.SEVERE, null, ex);
	}

    }

    
    @After
    public void tearDown() {
	//On supprime les insertions de la base
	try {
	    //On cré une ECUE, pour laquelle on va réaliser le test
	    Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	    s.executeQuery("DELETE FROM Etudiant WHERE numEtudiant=99999");

	    s.executeQuery("DELETE FROM ECUE WHERE codeMatiere='TEST001'");

	    s.executeQuery("DELETE FROM UE WHERE codeUE='testCUE'");

	    s.executeQuery("DELETE FROM Semestre WHERE codeSemestre='99'");

	    s.executeQuery("DELETE FROM Etape WHERE codeEtape='testCEt'");

	    s.executeQuery("DELETE FROM Departement WHERE versionDiplome='testVDip'");

	    s.executeQuery("DELETE FROM Enseignant WHERE idenseignant=9999");

	    s.close();

	} catch (SQLException ex) {
	    Logger.getLogger(DBECUEDAOTest.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    /**
     * Test of create method, of class DBECUEDAO.
     */
    @Test
    public void testCreate() throws Exception {
	System.out.println("create");
	ECUE ecue = new ECUE();
	DBECUE instance = null;




    }

    /**
     * Test of update method, of class DBECUEDAO.
     */
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update");	
	//on lui modif ses notes
	DBECUE dbecuedao = new DBECUE(conn);
	dbecuedao.update(ecue);
	//recupere le resultat

	//on le compare avec ce qu'on a mis a la base

	//on supprime l'etud et l'ecue témoin
    }

    /**
     * Test of delete method, of class DBECUEDAO.
     */
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete");
	ECUE obj = null;
	DBECUE instance = null;
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBECUEDAO.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find");
	Object id = null;
	DBECUE instance = null;
	ECUE expResult = null;
	ECUE result = instance.find(id);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}