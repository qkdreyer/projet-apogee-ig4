package Persist.XML;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Persist.Data;
import java.io.*;

/**
 *
 * @author Quentin
 */
public class DataXML extends Data {

    String filename = "data.xml";

    public DataXML() {
        
    }

    @Override
    public void save() throws Exception {
        FileOutputStream ostream = new FileOutputStream(filename);
        ObjectOutputStream p = new ObjectOutputStream(ostream);
        p.writeObject(this); // Write the tree to the stream.
        p.flush();
        ostream.close(); // close the file.
    }

    @Override
    public void load() throws Exception {
        FileInputStream istream = new FileInputStream(filename);
        ObjectInputStream q = new ObjectInputStream(istream);
        DataXML d = (DataXML)q.readObject();
    }

    public void display() {
	throw new UnsupportedOperationException("Not supported yet.");
    }

}
