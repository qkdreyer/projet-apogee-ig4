/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.ParserCSV;

import fr.GCAM.StudentManager.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Etudiant;
import java.io.*;

/**
 * Cette classe définie les methodes liées à la création d'un fichier CSV au
 * format qui permettra d'y inserer les notes des éléves pour une ECUE
 *
 * @author Jojo
 */
public class CreateCSV {


    /*creer mon fichier excel (voir ods...)
     * avec comme infos l'ECUE concerné
     * connaissant l'ECUE on connait la liste des eleves
     *
     */

    /* Creation du fichier .csv vide
     * le nom du fichier serz fichierNotes.csv
     */
    public static File CreateEmptyFile() {
	File f;
	f = new File("fichierNotes.csv");
	return f;


    }

    public static File CompleteFile(File f, ECUE ecue) {
	try {
	    //fos = new FileOutputStream(new File("fichierNotes.csv"));
	    FileWriter fw;
	    fw = new FileWriter(f);

	    fw.write(ecue.getCodeMatiere());
	    fw.write(",");
	    fw.write("Note session 1 , ");
	    fw.write("Note session 2");
	    fw.write("\n");

	    for (/*ECUE.*/Etudiant/*ECUE*/ etudiant : ecue.getListeEtud()) {

		fw.write(etudiant.getNom());
		fw.write(",");
		fw.write(etudiant.getPrenom());
		fw.write("\n");
	    }
	    fw.close();
	    return f;
	} catch (IOException problewritingimpossible) {
	    System.out.println("impossible d'ouvrir le fichier");
	    return null;
	}

    }

}