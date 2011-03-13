/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Core;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Quentin
 */
public class MD5 {

    public static String getHash(String value) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return String.format("%1$032X", new BigInteger(1, MessageDigest.getInstance("MD5").digest(value.getBytes())));
    }
}
