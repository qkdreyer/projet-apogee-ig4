/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Util;

import fr.GCAM.StudentManager.Business.POJO.ECUE;
import fr.GCAM.StudentManager.POJO.Business.Etudiant.EtudiantECUE;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 * Classe permettant de manipuler les fichiers SpreadSheets contenant les notes
 * des etudiants pour une ECUE.
 * @author Quentin
 */
public class SSParser {

    public static String sep = ";;";

    /**
     * Methode creant un fichier csv squelette qui sera utilisé par l'enseignant
     * pour y renseigner les notes des etudiants.
     * @param e l'ecue pour laquelle le fichier doit etre cree
     * @throws IOException
     */
    public static void createSS(ECUE e) throws IOException {
        FileWriter fw = new FileWriter("spreadsheet.csv");
        fw.write(e.getCodeMatiere() + sep + "Note session 1" + sep + "Note session 2\n");

        for (EtudiantECUE etud : e.getListeEtud()) {
            fw.write(etud.getPrenom() + " " + etud.getNom() + "\n");
        }
        fw.close();
    }

    /**
     * Methode permettant de charger un fichier csv, cree au prealable avec la methode
     * createSS()
     * @param e l'ecue pour lesquels les notes seront prises en compte.
     * @throws Exception
     */
    public static void loadSS(ECUE e) throws Exception {
        JFileChooser jfc = new JFileChooser();
        SSFilter filtreCSV = new SSFilter(".csv", "Fichier Comma Separeted Values");
        SSFilter filtreXLS = new SSFilter(".xls", "Fichier Microsoft Excel");
        SSFilter filtreODS = new SSFilter(".ods", "Fichier OpenOffice Data Sheet");
        File file;

        jfc.addChoosableFileFilter(filtreXLS);
        jfc.addChoosableFileFilter(filtreODS);
        jfc.addChoosableFileFilter(filtreCSV);

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            if (jfc.getFileFilter().accept(file)) {
                modifyECUE(e, file);
            }
        }
    }

    /**
     * Sous methode utilisee par loadSS() permettant de modifier les notes pour une ECUE
     * @param e l'ecue a modifier
     * @param filename le fichier csv contenant les notes
     * @throws Exception
     */
    private static void modifyECUE(ECUE e, File filename) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        float note1, note2;

        for (EtudiantECUE etud : e.getListeEtud()) {
            line = br.readLine();
            //if (line.matches("[a-zA-Z]\s[a-zA-Z];;\d\d[.;]\d\d;;\d\d[.;]\d\d")) { test
            note1 = Float.parseFloat(line.split(";;")[1].replace(',', '.'));
            if (line.split(";;").length == 3) {
                note2 = Float.parseFloat(line.split(";;")[2].replace(',', '.'));
                if (note2 >= 0 && note2 <= 20) {
                    etud.modifyNoteSession2(note2);
                }
            }
            if (note1 >= 0 && note1 <= 20) {
                etud.modifyNoteSession1(note1);
            }
        }
        br.close();
    }
}
