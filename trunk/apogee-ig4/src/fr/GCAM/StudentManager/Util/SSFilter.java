/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Classe heritant de FileFilter, permettant de refinir le fonctionnement
 * pour l'adapter aux fichier SpreadSheet.
 * @author Quentin
 */
public class SSFilter extends FileFilter {

    private String ext = null;
    private String desc = null;

    public SSFilter(String ext, String desc) {
        this.ext = ext;
        this.desc = desc;
    }

    /**
     * Methode definissant le type de fichier a accepter dans le FileFilter
     * @param f le File correspondant au Fichier a accepter
     * @return
     */
    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().endsWith(this.ext));
    }

    /**
     * Redefinition de la fonction parente
     */
    @Override
    public String getDescription() {
        return this.ext + " - " + this.desc;
    }
}
