/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.Etudiant;
import java.io.FileOutputStream;
import org.jdom.output.XMLOutputter;
import org.jdom.output.Format;
import java.util.Iterator;
import org.jdom.input.SAXBuilder;
import org.jdom.Document;
import org.jdom.Element;
import java.io.File;
import fr.GCAM.StudentManager.POJO.ECUE;
import java.util.ArrayList;
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
    private static ECUE ecue_m;

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
	    Etudiant etud = new Etudiant(99999, "netud", "petud", 0, 0);
	    

	    while (i.hasNext()) {
                courant = (Element) i.next();
	    }

	    ECUE = new Element("ECUE");
            ecue_m = new ECUE();
	    ecue_m.setCodeMatiere("TEST001");
	    ecue_m.setCodeUE("testCUE");
	    ecue_m.setLibelleECUE("testlibelle");
	    ecue_m.setNbHeures(99);
	    ecue_m.setResponsable("NRtest PRtest");

	    ecue_m.getListeEtud().add(etud);
	    
            listeEtud = new Element("listeEtud");
	    Etudiant = new Element("Etudiant");
	    Etudiant.addContent(new Element("numEtudiant").setText(Integer.toString(etud.getNumEtudiant())));
	    Etudiant.addContent(new Element("nom").setText(etud.getNom()));
	    Etudiant.addContent(new Element("prenom").setText(etud.getPrenom()));
	    Etudiant.addContent(new Element("noteSession1").setText(Float.toString(etud.getNoteSession1())));
	    Etudiant.addContent(new Element("noteSession2").setText(Float.toString(etud.getNoteSession2())));
	    //s.executeQuery("insert into Etudiant values (99999,0,'INETEST',0,null,null,null,'testCEt','netud','petud','m@etud.com')");
	    listeEtud.addContent(Etudiant);

	    ECUE.addContent(new Element("codeMatiere").setText(ecue_m.getCodeMatiere()));
	    ECUE.addContent(new Element("libelleECUE").setText(ecue_m.getLibelleECUE()));
	    ECUE.addContent(new Element("nbHeures").setText(Integer.toString(ecue_m.getNbHeures())));
	    ECUE.addContent(new Element("responsable").setText(ecue_m.getResponsable()));
	    ECUE.addContent(new Element("codeUE").setText(ecue_m.getCodeUE()));
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
    }

    /**
     * Test of update method, of class XMLECUE.
     */
    @Test
    public void testUpdate() throws Exception {
	System.out.println("update XMLECUE");
	XMLECUE instance = new XMLECUE();
	ecue_m.getListeEtud().get(0).setNoteSession1((float)12.9);
	ecue_m.getListeEtud().get(0).setNoteSession2((float)7.9);
	instance.update(ecue_m);
	float note_r1 = 0;
	float note_r2 = 0;

	Element courant;
        Iterator i = new SAXBuilder().build("xml/ECUE.xml").getRootElement().getChildren("ECUE").iterator();
        Iterator j;
        while (i.hasNext()) {
            courant = (Element) i.next();
            if (courant.getChild("codeMatiere").getText().equals((String) "TEST001")) {
                //ecue_m.setCodeMatiere(courant.getChild("codeMatiere").getText());
                //ecue_m.setLibelleECUE(courant.getChild("libelleECUE").getText());
                //ecue_m.setNbHeures(Integer.parseInt(courant.getChild("nbHeures").getText()));
                //ecue_m.setResponsable(courant.getChild("responsable").getText());
                //ecue_m.setCodeUE(courant.getChild("codeUE").getText());

                j = courant.getChild("listeEtud").getChildren("Etudiant").iterator();
                while (j.hasNext()) {
                    courant = (Element) j.next();
//                    ecue_m.getListeEtud().add(new Etudiant(
//                            Integer.parseInt(courant.getChild("numEtudiant").getText()),
//                            courant.getChild("nom").getText(),
//                            courant.getChild("prenom").getText(),
//                            Float.parseFloat(courant.getChild("noteSession1").getText()),
//                            Float.parseFloat(courant.getChild("noteSession2").getText())));
		    note_r1 = Float.parseFloat(courant.getChild("noteSession1").getText());		    
		    note_r2 = Float.parseFloat(courant.getChild("noteSession2").getText());
                }
            }
        }

	assertEquals(12.9, note_r1, 0.001);
	assertEquals(7.9, note_r2, 0.001);

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
	assertEquals(ecue_m.getLibelleECUE(), result.getLibelleECUE());
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
    }

}
