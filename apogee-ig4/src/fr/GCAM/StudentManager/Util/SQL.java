/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Util;

import fr.GCAM.StudentManager.Persist.DB.ConnectionDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;

/**
 *
 * @author Quentin
 */
public class SQL {

    public static void imports() throws Exception {
        JFileChooser jfc = new JFileChooser();
        SSFilter filtreSQL = new SSFilter(".sql", "Structured Query Language");
        File file;
        jfc.addChoosableFileFilter(filtreSQL);

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = jfc.getSelectedFile();
            if (jfc.getFileFilter().accept(file)) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String ligne;
                Statement s = ConnectionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                while ((ligne = br.readLine()) != null) {
                    s.executeQuery(ligne);
                }
                s.close();
                br.close();
            }
        }
    }

    public static void extract() throws Exception {
        Statement s = ConnectionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet r = s.executeQuery("select noteSession1, noteSession2, numEtudiant, "
                + "codeMatiere from vo_etudiantecue where noteSession1 is not null and noteSession2 is not null");
        if (r.first()) {
            FileWriter fw = new FileWriter("extract.sql");
            do {
                fw.write("Insert into Note values("
                        + r.getFloat("noteSession1") + ", "
                        + r.getFloat("noteSession2") + ", "
                        + r.getInt("numEtudiant") + ", '"
                        + r.getString("codeMatiere") + "');\n");
            } while (r.next());
            fw.close();
            s.close();
        }

        s = ConnectionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        r = s.executeQuery("select codeUE, numEtudiant from vo_etudiantue where vae = 't'");
        if (r.first()) {
            FileWriter fw = new FileWriter("extract.sql", true);
            do {
                fw.write("Insert into VAE values('"
                        + r.getString("codeUE") + "', "
                        + r.getInt("numEtudiant") + ");\n");
            } while (r.next());
            fw.close();
            s.close();
        }

        s = ConnectionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        r = s.executeQuery("select codeUE, numEtudiant from vo_etudiantue where apdj = 't'");
        if (r.first()) {
            FileWriter fw = new FileWriter("extract.sql", true);
            do {
                fw.write("Insert into APDJ values('"
                        + r.getString("codeUE") + "', "
                        + r.getInt("numEtudiant") + ");\n");
            } while (r.next());
            fw.close();
            s.close();
        }

        s = ConnectionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        r = s.executeQuery("select pointJurySemestre, numEtudiant, codeSemestre "
                + "from vo_etudiantsemestre where pointJurySemestre > 0");
        if (r.first()) {
            FileWriter fw = new FileWriter("extract.sql", true);
            do {
                fw.write("Insert into PointsJury values("
                        + r.getFloat("pointJurySemestre") + ", "
                        + r.getInt("numEtudiant") + ", "
                        + r.getInt("codeSemestre") + ");\n");
            } while (r.next());
            fw.close();
            s.close();
        }

        s = ConnectionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        r = s.executeQuery("select moyenneEtranger, numEtudiant, codeSemestre "
                + "from vo_etudiantsemestre where moyenneEtranger is not null");
        if (r.first()) {
            FileWriter fw = new FileWriter("extract.sql", true);
            do {
                fw.write("Insert into Etranger values("
                        + r.getFloat("moyenneEtranger") + ", "
                        + r.getInt("numEtudiant") + ", "
                        + r.getInt("codeSemestre") + ");\n");
            } while (r.next());
            fw.close();
            s.close();
        }

        s = ConnectionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        r = s.executeQuery("select moyenneRedoublant, numEtudiant, codeSemestre "
                + "from vo_etudiantsemestre where moyenneRedoublant is not null");
        if (r.first()) {
            FileWriter fw = new FileWriter("extract.sql", true);
            do {
                fw.write("Insert into Redoublant values("
                        + r.getFloat("moyenneRedoublant") + ", "
                        + r.getInt("numEtudiant") + ", "
                        + r.getInt("codeSemestre") + ");\n");
            } while (r.next());
            fw.close();
            s.close();
        }

        s = ConnectionDB.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        r = s.executeQuery("select numEtudiant, pointJuryAnnee, scoreToeic "
                + "from vo_etudiantetape where pointJuryAnnee > 0 or scoreToeic is not null");
        if (r.first()) {
            FileWriter fw = new FileWriter("extract.sql", true);
            do {
                fw.write("Update Etudiant set pointJuryAnnee = "
                        + r.getFloat("pointJuryAnnee") + ", scoreToeic = "
                        + r.getInt("scoreToeic") + " where numEtudiant = "
                        + r.getInt("numEtudiant") + ";\n");
            } while (r.next());
            fw.close();
            s.close();
        }
    }
}
