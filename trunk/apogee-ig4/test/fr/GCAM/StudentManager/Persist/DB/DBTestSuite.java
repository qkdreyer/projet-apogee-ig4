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
 *
 * @author pierre
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    fr.GCAM.StudentManager.Persist.DB.DBDepartementTest.class,
    fr.GCAM.StudentManager.Persist.DB.DBECUETest.class,
    fr.GCAM.StudentManager.Persist.DB.DBEtapeTest.class,
    fr.GCAM.StudentManager.Persist.DB.DBEtudiantTest.class,
    fr.GCAM.StudentManager.Persist.DB.DBUETest.class,
    fr.GCAM.StudentManager.Persist.DB.DBUtilisateurTest.class,
    fr.GCAM.StudentManager.Persist.DB.DBFactoryTest.class
})
public class DBTestSuite {

    private static Connection conn;


    @BeforeClass
    public static void setUpClass() throws Exception {
	//Creation de la connection à la BD
        conn = ConnectionDB.getConnection();
        try {
            //On cré une ECUE, pour laquelle on va réaliser le test
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            s.executeQuery("insert into Enseignant values (9999,'testPass','testNom','testPrenom','testMail')");
            s.executeQuery("insert into Departement values ('testVDip','testNomDep','testMnemo',9999)");
            s.executeQuery("insert into Etape  values ('testCEt','9',9999,'testVDip')");
            s.executeQuery("insert into Semestre values ('99','s99',9,'testCEt')");
            s.executeQuery("insert into UE values ('testCUE',99,'testLib','f',9999,'99')");
            s.executeQuery("insert into ECUE values('TEST001','testlibelle', 99, 9999, 'testCUE')");

	    s.executeQuery("insert into Provenance values(0, 'testProv')");
	    s.executeQuery("insert into Statut values(0, 'testStat')");
	    s.executeQuery("insert into nationalite values(0, 'testNat')");
            s.executeQuery("insert into Etudiant values (99999,0,'INETEST',0,0,0,0,'testCEt','netud','petud','m@etud.com')");

            s.close();

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
	    s.executeQuery("DELETE FROM Provenance WHERE idprovenance=0");
	    s.executeQuery("DELETE FROM Statut WHERE idstatut=0");
	    s.executeQuery("DELETE FROM Nationalite WHERE idnationalite=0");
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

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}