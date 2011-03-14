/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.ParserCSV;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jojo
 */
public class LoadCSV {

    /*
     * Recuperer un fichier csv (au format normalisé)
     * recuperer toutes les donnes du fichier
     * les charger dans la vue
     */

    public void loadCSV(String FileName) throws FileNotFoundException{
    String l;
    FileInputStream f;
    DataInputStream d;
    BufferedInputStream b;
    f = new FileInputStream(new File(FileName));
    b = new BufferedInputStream(f);
    d = new DataInputStream(b);
        try {
            l = d.readLine();
        } catch (IOException ex) {
            Logger.getLogger(LoadCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

    /* je dois pour chaque ligne recuperer toutes les informations necessaires
     * premiere ligne: ECUE concerné
     * les autres lignes: nom et prenom de l'eleve ainsi que la/les notes
     */

    



    }

    //public void GetMarkStudent(String file){};





}
