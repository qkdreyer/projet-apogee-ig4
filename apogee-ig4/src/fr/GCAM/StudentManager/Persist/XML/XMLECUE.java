/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.GCAM.StudentManager.Persist.XML;

import fr.GCAM.StudentManager.POJO.ECUE;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Quentin
 */
public class XMLECUE extends XML<ECUE> {

    public XMLECUE() {
    }

    /**
     *
     * @param obj
     * @throws Exception
     */
    public void create(ECUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void update(ECUE obj) throws Exception {
	FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj); // Write the tree to the stream.
        oos.flush();
        fos.close(); // close the file.
    }

    public void delete(ECUE obj) throws Exception {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    public ECUE find(Object id) throws Exception {
	ECUE e = new ECUE();
	FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        e = (ECUE) ois.readObject();
	return e;
    }

}
