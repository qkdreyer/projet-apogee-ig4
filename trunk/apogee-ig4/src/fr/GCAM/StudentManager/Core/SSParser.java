/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Core;

import fr.GCAM.StudentManager.POJO.ECUE;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Quentin
 */
public class SSParser {

    public static String sep = ";;";

    public static void createSS(ECUE e) throws IOException {
        FileWriter fw = new FileWriter("spreadsheet.csv");
        fw.write(e.getCodeMatiere() + sep + "Note session 1" + sep + "Note session 2\n");

        for (ECUE.EtudiantECUE etud : e.getListeEtud()) {
            fw.write(etud.getPrenom() + " " + etud.getNom() + "\n");
        }
        fw.close();
    }

    public static void loadSS(ECUE e, String filename) throws FileNotFoundException, IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        Float note1, note2;

        for (ECUE.EtudiantECUE etud : e.getListeEtud()) {
            line = br.readLine();
            //if (line.matches("[a-zA-Z]\s[a-zA-Z];;\d\d[.;]\d\d;;\d\d[.;]\d\d")) { test
            note1 = Float.parseFloat(line.split(";;")[1].replace(',', '.'));
            note2 = Float.parseFloat(line.split(";;")[2].replace(',', '.'));
            if (note1 >= 0 && note1 <= 20 && note2 >= 0 && note2 <= 20) {
                etud.setNoteSession1(note1);
                etud.setNoteSession2(note2);
            }
        }
    }
}
