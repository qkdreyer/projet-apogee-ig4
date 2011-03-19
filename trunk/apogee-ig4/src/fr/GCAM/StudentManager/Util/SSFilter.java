/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Util;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Quentin
 */
public class SSFilter extends FileFilter {

    private String ext = null;
    private String desc = null;

    public SSFilter(String ext, String desc) {
        this.ext = ext;
        this.desc = desc;
    }

    public boolean accept(File f) {
        return (f.isDirectory() || f.getName().endsWith(this.ext));
    }

    @Override
    public String getDescription() {
        return this.ext + " - " + this.desc;
    }
}
