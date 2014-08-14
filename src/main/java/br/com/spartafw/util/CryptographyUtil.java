/*
 * CryptographyUtil.java
 *
 * Created on 25 de Agosto de 2007, 15:27
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.com.spartafw.util;

import br.com.spartafw.encode.BASE64Encoder;
import br.com.spartafw.exception.CryptographyException;
import java.security.MessageDigest;

/**
 *
 * @author mohfus
 * @since 25 de Agosto de 2007
 */
public class CryptographyUtil {
    
    public static String passwordToHash(String password) throws CryptographyException {
        String message = "The password could not be convertered into hash.";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes("ISO-8859-1"));
            BASE64Encoder encoder = new BASE64Encoder (); 
            //System.out.println(md.digest ().length);
            return encoder.encode (md.digest ());
        } catch (Exception ex) {
            message = ex.getMessage();
        }
        throw new CryptographyException(message);
    }
    
    public static void main(String args[]) throws CryptographyException {
        System.out.println(CryptographyUtil.passwordToHash("pefropra"));
    }
    
}
