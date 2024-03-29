/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Classe contenant la suite de Test pour la Base de Donnees
 * @author pierre
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    fr.GCAM.StudentManager.Persist.DB.DBDepartementTest.class,
    fr.GCAM.StudentManager.Persist.DB.DBECUETest.class,
    fr.GCAM.StudentManager.Persist.DB.DBEtapeTest.class,
    fr.GCAM.StudentManager.Persist.DB.DBEtudiantECUETest.class,
    fr.GCAM.StudentManager.Persist.DB.DBEtudiantEtapeTest.class,
    fr.GCAM.StudentManager.Persist.DB.DBEtudiantSemestreTest.class,
    fr.GCAM.StudentManager.Persist.DB.DBEtudiantUETest.class,
    fr.GCAM.StudentManager.Persist.DB.DBUETest.class,
    fr.GCAM.StudentManager.Persist.DB.DBUtilisateurTest.class
})
public class DBTestSuite {

    private static Connection conn;


    @BeforeClass
    public static void setUpClass() throws Exception {
	//Creation de la connection à la BD
        conn = ConnectionDB.getConnection();
        try {
	    System.out.println("Creation des temoins");
            //On cré une ECUE, pour laquelle on va réaliser le test
            Statement s = conn.createStatement();

            s.executeQuery("insert into Enseignant values (9999,gethash('testPass'),'testNom','testPrenom','testMail')");
            s.executeQuery("insert into Departement values ('testVDip','testNomDep','testMnemo',9999)");
            s.executeQuery("insert into Etape  values ('testCEt','9',9999,'testVDip')");
            s.executeQuery("insert into Semestre values ('99','s99',9,'testCEt')");
            s.executeQuery("insert into UE values ('testCUE',99,'testLib','f',9999,'99')");
            s.executeQuery("insert into ECUE values('TEST001','testlibelle', 99, 9999, 'testCUE')");

	    s.executeQuery("insert into Provenance values(0, 'testProv')");
	    s.executeQuery("insert into Statut values(0, 'testStat')");
	    s.executeQuery("insert into nationalite values(0, 'testNat')");
            s.executeQuery("insert into Etudiant values (99999,0,'INETEST',0,0,0,0,'testCEt','netud','petud','m@etud.com')");

	    System.out.println("Fin des temoins");

            s.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBECUETest.class.getName()).log(Level.SEVERE, null, ex);
        }
	System.out.println("Début des tests BD");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
	//On supprime les insertions de la base
        try {

	    Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	    //Il faut recuperer l'id de l'enseignant genere par la sequence.
//	    ResultSet r = s.executeQuery("Select idenseignant from enseignant "
//		    + "where nom='testNom' and prenom='testPrenom'");
//   	    int id = r.getInt("idenseignant");
//	    System.out.println("idEnseignant = " + id);

//	    Statement s_del = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            s.executeQuery("DELETE FROM Etudiant WHERE numEtudiant=99999");
	    s.executeQuery("DELETE FROM Provenance WHERE idprovenance=0");
	    s.executeQuery("DELETE FROM Statut WHERE idstatut=0");
	    s.executeQuery("DELETE FROM Nationalite WHERE idnationalite=0");
            s.executeQuery("DELETE FROM ECUE WHERE codeMatiere='TEST001'");
            s.executeQuery("DELETE FROM UE WHERE codeUE='testCUE'");
            s.executeQuery("DELETE FROM Semestre WHERE codeSemestre='99'");
            s.executeQuery("DELETE FROM Etape WHERE codeEtape='testCEt'");
            s.executeQuery("DELETE FROM Departement WHERE versionDiplome='testVDip'");

            s.executeQuery("DELETE FROM Enseignant WHERE idenseignant=9999");

//            s_del.close();
//	    s_q.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBECUETest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}