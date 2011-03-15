/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.Core.JDOM;
import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Etudiant.EtudiantECUE;
import java.io.File;
import java.util.Iterator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
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
    fr.GCAM.StudentManager.Persist.XML.XMLDepartementTest.class,
    fr.GCAM.StudentManager.Persist.XML.XMLECUETest.class,
    fr.GCAM.StudentManager.Persist.XML.XMLEtapeTest.class,
    fr.GCAM.StudentManager.Persist.XML.XMLEtudiantECUETest.class,
    fr.GCAM.StudentManager.Persist.XML.XMLUETest.class,
    fr.GCAM.StudentManager.Persist.XML.XMLUtilisateurTest.class
})
public class XMLTestSuite {

    private static File file;

    @BeforeClass
    public static void setUpClass() throws Exception {
	file = new File("xml/ECUE.xml");
	if (file.exists()) {
	    System.out.println("Le fichier existe");
	    Element courant;
	    Document d = new SAXBuilder().build("xml/ECUE.xml");
	    Iterator i = d.getRootElement().getChildren("ECUE").iterator();
	    Iterator j;
	    Element ECUE, listeEtud, Etudiant;
	    EtudiantECUE etud = new EtudiantECUE(99999, "testINE", "testProv", "testStat", "nEtud", "pEtud", "test@mail.final", 0, 0);
	    ECUE ecue = new ECUE();

	    ecue.setCodeMatiere("TEST001");
	    ecue.setCodeUE("testCUE");
	    ecue.setLibelleECUE("testlibelle");
	    ecue.setNbHeures(99);
	    ecue.setResponsable("NRtest PRtest");

	    ecue.getListeEtud().add(etud);

	    while (i.hasNext()) {
                courant = (Element) i.next();
	    }

	    ECUE = new Element("ECUE");

            listeEtud = new Element("listeEtud");
	    Etudiant = new Element("Etudiant");
	    Etudiant.addContent(new Element("numEtudiant").setText(Integer.toString(etud.getNumEtudiant())));
	    Etudiant.addContent(new Element("nom").setText(etud.getNom()));
	    Etudiant.addContent(new Element("prenom").setText(etud.getPrenom()));
	    Etudiant.addContent(new Element("noteSession1").setText(Float.toString(etud.getNoteSession1())));
	    Etudiant.addContent(new Element("noteSession2").setText(Float.toString(etud.getNoteSession2())));
	    //s.executeQuery("insert into Etudiant values (99999,0,'INETEST',0,null,null,null,'testCEt','netud','petud','m@etud.com')");
	    listeEtud.addContent(Etudiant);

	    ECUE.addContent(new Element("codeMatiere").setText(ecue.getCodeMatiere()));
	    ECUE.addContent(new Element("libelleECUE").setText(ecue.getLibelleECUE()));
	    ECUE.addContent(new Element("nbHeures").setText(Integer.toString(ecue.getNbHeures())));
	    ECUE.addContent(new Element("responsable").setText(ecue.getResponsable()));
	    ECUE.addContent(new Element("codeUE").setText(ecue.getCodeUE()));
	    ECUE.addContent(listeEtud);
	    d.getRootElement().addContent(ECUE);

	    //Sauvegarde du fichier
	    JDOM.save(d, "xml/ECUE.xml");
//	    new XMLOutputter(Format.getPrettyFormat()).output(d, new FileOutputStream("xml/ECUE.xml"));
	} else {
	    System.out.println("Le fichier n'existe pas, tant pis");
	}
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
	System.out.println("tearDownClass");
	//TODO : supprimer les données rajoutées
	Document d = new SAXBuilder().build("xml/ECUE.xml");
	d.getRootElement().getChildren("ECUE").remove( d.getRootElement().getChildren("ECUE").size() - 1 );

	JDOM.save(d, "xml/ECUE.xml");
	//new XMLOutputter(Format.getPrettyFormat()).output(d, new FileOutputStream("xml/ECUE.xml"));
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}