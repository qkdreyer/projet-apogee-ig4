/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.Persist.DB.DBECUE;
import java.io.FileOutputStream;
import org.jdom.output.XMLOutputter;
import org.jdom.output.Format;
import java.util.Iterator;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import org.jdom.Element;
import java.io.File;
import fr.GCAM.StudentManager.POJO.ECUE;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de units tests pour la classe XMLECUE
 *
 * @author pierre
 */
public class XMLECUETest {

    private static File file;
    private static ECUE ecue;

    public XMLECUETest() {
    }

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
	    

	    while (i.hasNext()) {
                courant = (Element) i.next();
	    }

	    System.out.println("On est à la fin");
	    ECUE = new Element("ECUE");
            ecue = new ECUE();
	    ecue.setCodeMatiere("TEST001");
	    ecue.setCodeUE("testCUE");
	    ecue.setLibelleECUE("testlibelle");
	    ecue.setNbHeures(99);
	    ecue.setResponsable("NRtest PRtest");

            listeEtud = new Element("listeEtud");
	    Etudiant = new Element("Etudiant");
	    Etudiant.addContent(new Element("numEtud").setText(Integer.toString(99999)));
	    Etudiant.addContent(new Element("nom").setText("netud"));
	    Etudiant.addContent(new Element("prenom").setText("petud"));
	    Etudiant.addContent(new Element("noteSession1").setText(Integer.toString(0)));
	    Etudiant.addContent(new Element("noteSession2").setText(Integer.toString(0)));
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
	    new XMLOutputter(Format.getPrettyFormat()).output(d, new FileOutputStream("xml/ECUE.xml"));
	} else {
	    System.out.println("Le fichier n'existe pas, tant pis");
	}
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
	//TODO : supprimer les données rajoutées
	Document d = new SAXBuilder().build("xml/ECUE.xml");
	Iterator i = d.getRootElement().getChildren("ECUE").iterator();
//	while (((Element)i.next()).) {
//                courant = (Element) i.next();
//	    }
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class XMLECUE.
     */
    @Test
    public void testCreate() throws Exception {
	System.out.println("create XMLECUE");
	ECUE obj = null;
	XMLECUE instance = new XMLECUE();
	instance.create(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class XMLECUE.
     */
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update XMLECUE");
	ECUE ecue = null;
	XMLECUE instance = new XMLECUE();
	instance.update(ecue);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class XMLECUE.
     */
    @Test
    public void testDelete() throws Exception {
	System.out.println("delete XMLECUE");
	ECUE obj = null;
	XMLECUE instance = new XMLECUE();
	instance.delete(obj);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class XMLECUE.
     */
    @Test
    public void testFind() throws Exception {
	System.out.println("find XMLECUE");
	String id = "TEST001";
	XMLECUE instance = new XMLECUE();
	
	ECUE result = instance.find(id);
	assertEquals(ecue.getLibelleECUE(), result.getLibelleECUE());
    }

    /**
     * Test of list method, of class XMLECUE.
     */
    @Test
    public void testList() throws Exception {
	System.out.println("list");
	XMLECUE instance = new XMLECUE();
	String expResult = "";
	String result = instance.list();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}