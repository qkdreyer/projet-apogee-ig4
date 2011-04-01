/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GCAM.StudentManager.Util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe permettant l'encodage des mots de passe avec la methode SHA1
 * @author Quentin
 */
public class SHA1 {

    /**
     * Methode permettant d'obtenir le hash en SHA1 de la chaine value
     * @param value La chaine a encoder en SHA1
     * @return la chaine encodée en SHA1
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getHash(String value) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return String.format("%1$032X", new BigInteger(1, MessageDigest.getInstance("SHA").digest(value.getBytes())));    }

    public static void main(String[] args) {
        try {
            System.out.println(getHash("azerty"));
        } catch (NoSuchAlgorithmException ex) {
        } catch (UnsupportedEncodingException ex) {
        }
    }
}
