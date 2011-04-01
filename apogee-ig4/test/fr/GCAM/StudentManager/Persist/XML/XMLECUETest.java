/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import org.jdom.Document;
import java.io.File;
import fr.GCAM.StudentManager.Util.JDOM;
import org.junit.Ignore;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantECUE;
import java.util.Iterator;
import org.jdom.input.SAXBuilder;
import org.jdom.Element;
import fr.GCAM.StudentManager.Business.POJO.ECUE;
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

    private static ECUE ecue_m;
    private static EtudiantECUE etud;


    public XMLECUETest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
	
	ecue_m = new ECUE();
	ecue_m.setCodeMatiere("TEST001");
	ecue_m.setCodeUE("testCUE");
	ecue_m.setLibelleECUE("testlibelle");
	ecue_m.setNbHeures(99);
	ecue_m.setResponsable("NRtest PRtest");

	ecue_m.getListeEtud().add(etud);
	
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
     * Test of create method, of class XMLECUE.
     */
    @Ignore
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
	ecue_m.getListeEtud().get(0).modifyNoteSession1((float)12.9);
	ecue_m.getListeEtud().get(0).modifyNoteSession2((float)7.9);
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
    @Ignore
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
	System.out.println("list XMLECUE");
	XMLECUE instance = new XMLECUE();
	String expResult = "";
	ArrayList<ECUE> result = instance.list();
	assertEquals(expResult, result);
    }

}
