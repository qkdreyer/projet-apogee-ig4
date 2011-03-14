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
public class SHA1 {

    public static String getHash(String value) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return String.format("%1$032X", new BigInteger(1, MessageDigest.getInstance("SHA").digest(value.getBytes())));    }

    public static void main(String[] args) {
        try {
            System.out.println(getHash("testPass"));
        } catch (NoSuchAlgorithmException ex) {
        } catch (UnsupportedEncodingException ex) {
        }
    }
}
