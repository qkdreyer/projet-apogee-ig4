/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.ParserCSV;

import fr.GCAM.StudentManager.POJO.ECUE;
import java.io.*;

/**
 *
 * @author Jojo
 */
public class CreateCSV {


    /*creer mon fichier excel (voir ods...)
     * avec comme infos l'ECUE concerné
     * connaissant l'ECUE on connait la liste des eleves
     *
    */

    /* Creation du fichier .xls vide
     * le nom du fichier serz fichierNotes.xls
     */
    public void CreateEmptyFile(){
        FileOutputStream file;
        try{
            file = new FileOutputStream("fichierNotes.csv");
            file.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void CompleteFile(File file, ECUE ecue){
        FileOutputStream fos;
        try{
            //fos = new FileOutputStream(new File("fichierNotes.csv"));
            FileWriter fw;
            fw = new FileWriter(file);

            fw.write(ecue.getLibelleECUE());
            fw.write(",");
            fw.write("Note session 1");
            fw.write("Note session 2");
            fw.write("\n");

        for(ECUE.EtudiantECUE etudiant : this.getListeEtud()) {

            fw.write(etudiant.getNom());
            fw.write(",");
            fw.write(etudiant.getPrenom());
            fw.write("\n");
            }
        fos.close();
        }
        catch(IOException problewritingimpossible){
            System.out.println("impossible d'ouvrir le fichier");
        }

    };


}
