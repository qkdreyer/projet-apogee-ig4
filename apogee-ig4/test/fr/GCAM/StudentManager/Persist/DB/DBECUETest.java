/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Persist.DB;

import fr.GCAM.StudentManager.POJO.Etudiant;
import org.junit.Ignore;
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
 * Classe de units test pour la classe DBECUE.
 *
 * @author pierre
 */
public class DBECUETest {

    private static Connection conn;
    private static ECUE ecue;
    private static Etudiant ec;

    public DBECUETest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
	//Creation de la connection à la BD
        conn = ConnectionDB.getConnection();
        try {
            //On cré une ECUE, pour laquelle on va réaliser le test
            Statement s = conn.createStatement();

            s.executeQuery("insert into Enseignant values (9999,'testPass','testNom','testPrenom','testMail')");

            s.executeQuery("insert into Departement values ('testVDip','testLibelle','testMnemo',9999)");

            s.executeQuery("insert into Etape  values ('testCEt','9',9999,'testVDip')");

            s.executeQuery("insert into Semestre values ('99','s99',9,'testCEt')");

            s.executeQuery("insert into UE values ('testCUE',99,'testLib','f',9999,'99')");

            s.executeQuery("INSERT INTO ECUE values('TEST001','testlibelle', 99, 9999, 'testCUE')");

            s.executeQuery("insert into Etudiant values (99999,0,'INETEST',0,null,null,null,'testCEt','netud','petud','m@etud.com')");

            s.close();

            ec = new Etudiant(99999, "netud", "petud", (float) 0.0, (float) 0.0);

            ecue = new ECUE();
            ecue.setCodeMatiere("TEST001");
            ecue.setLibelleECUE("testlibelle");
            ecue.setNbHeures(99);
            //ecue.setIdEnseignant(9999);

            ecue.setCodeUE("testCUE");

        } catch (SQLException ex) {
            Logger.getLogger(DBECUETest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
	//On supprime les insertions de la base
        try {
            //On cré une ECUE, pour laquelle on va réaliser le test
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            //s.executeQuery("DELETE FROM ")

            s.executeQuery("DELETE FROM Etudiant WHERE numEtudiant=99999");

            s.executeQuery("DELETE FROM ECUE WHERE codeMatiere='TEST001'");

            s.executeQuery("DELETE FROM UE WHERE codeUE='testCUE'");

            s.executeQuery("DELETE FROM Semestre WHERE codeSemestre='99'");

            s.executeQuery("DELETE FROM Etape WHERE codeEtape='testCEt'");

            s.executeQuery("DELETE FROM Departement WHERE versionDiplome='testVDip'");

            s.executeQuery("DELETE FROM Enseignant WHERE idenseignant=9999");

            s.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBECUETest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fonction s'executant des l'instanciation de la classe
     * On cré un ensemble d'élement témoins que l'on rajoute dans la base de données
     * afin de pouvoir faire des tests.
     *
     */
    @Before
    public void setUp() {
        

    }

    /**
     * Fonction s'executant apres tous les tests.
     * On supprime tous nos élements témoins inséré au préalable afin de nettoyer la
     * base de données.
     *
     */
    @After
    public void tearDown() {
        
    }

    /**
     * Test of create method, of class DBECUEDAO.
     */
    @Ignore
    @Test
    public void testCreate() throws Exception {
        System.out.println("create DBECUE");
        ECUE ecue = new ECUE();
        DBECUE instance = null;




    }

    /**
     * Test of update method, of class DBECUEDAO.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update DBECUE");
        //on lui modif ses notes
        DBECUE dbecue = new DBECUE(conn);
        ecue.getListeEtud().add(ec);

        ec.setNoteSession1((float) 12.8);
        ec.setNoteSession2((float) 5.8);

        //on update
        dbecue.update(ecue);
        //on recupere le resultat
        Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("SELECT v.codematiere, v.libelleECUE,"
		+ "v.nbheures,v.nomresponsable, v.prenomresponsable,v.codeue,"
		+ "v.numetudiant, v.nom, v.prenom, v.notesession1,v.notesession2 "
		+ "FROM vo_ecue v "
		+ "WHERE v.codematiere='TEST001' AND v.numetudiant=99999");
        //on le compare avec ce qu'on a mis a la base
        if (r.first()) {
            String codematiere = r.getString("codeMatiere");
            String libelleECUE = r.getString("libelleECUE");
            int nbheures = r.getInt("nbheures");
            String prenomResp = r.getString("prenomResponsable");
	    String nomResp = r.getString("nomResponsable");
            String codeUE = r.getString("codeUE");

            int numetud = r.getInt("numetudiant");
	    String nom = r.getString("nom");
	    String prenom = r.getString("prenom");
	    float notes1 = r.getFloat("notesession1");
	    float notes2 = r.getFloat("notesession2");

	    assertEquals(numetud, 99999);
            // 0.001 est le delta (ecart autorisé) par rapport à la note.
            assertEquals(12.8, notes1, 0.001);
            assertEquals(5.8, notes2, 0.001);

        } else {
            fail("The query didn't return any results");
        }



    }

    /**
     * Test of delete method, of class DBECUEDAO.
     */
    @Ignore
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete DBECUE");
        ECUE obj = null;
        DBECUE instance = null;
        instance.delete(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class DBECUEDAO.
     */
    @Ignore
    @Test
    public void testFind() throws Exception {
        System.out.println("find DBECUE");
        Object id = null;
        DBECUE instance = null;
        ECUE expResult = null;
        ECUE result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
