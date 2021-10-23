package user;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bala
 */
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class AESUtil {

     private static final String ALGO = "AES";
    public static  byte[] keyValue =
        new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',

'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'e' };

    
    static char [] val = new char[] {'A','C','B'};

public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

   
 
    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
        
        /*
        int tot=0;
        for (int i=0;i<keyValue.length;i++)
        {
            tot = tot + keyValue[i];
        }
        tot = tot%(val.length-1);
        
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<encryptedData.length();i++)
        {
            
            char nc = (char)(encryptedData.charAt(i)-'A');
            //nc = encryptedData.charAt(i);
            sb.append(nc);
            
        }
        return sb.toString();
        */
        
        
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }

    

}
