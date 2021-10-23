/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datasecuritycloud;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author DELL
 */
public class DESEncryption {
     private static SecretKeySpec secretKey;
    private static byte[] key;
    private static final String ALGORITHM = "DES";

    public void prepareSecreteKey(String myKey) {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String strToEncrypt,String secret ) {
        try {
            //String secret="secrete";
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public String decrypt(String strToDecrypt,String secret) {
        try {
            //String secret="secrete";
            prepareSecreteKey(secret);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static String encryptdecrypt (String str) {
        final String secretKey = "secrete";

        String originalString = str;

        DES_Utils aesEncryptionDecryption = new DES_Utils();
        String encryptedString = aesEncryptionDecryption.encrypt(originalString, secretKey);
        String decryptedString = aesEncryptionDecryption.decrypt(encryptedString, secretKey);

        System.out.println("original String :"+originalString);
        System.out.println("encrypted String  :"+encryptedString);
        System.out.println("decrypted String :"+decryptedString);
        
        return encryptedString;
      
    }
}
