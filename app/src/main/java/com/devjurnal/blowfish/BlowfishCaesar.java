package com.devjurnal.blowfish;

/**
 * Created by devjurnal on 6/1/18.
 */
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class BlowfishCaesar {
    public static String enkripsi(String pesan, String key){
        try {
            SecretKeySpec KS = new SecretKeySpec(key.getBytes(), "BlowfishA");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, KS);
            byte[] encrypted = cipher.doFinal(pesan.getBytes());
            String blow =Base64.encodeToString(encrypted, Base64.NO_PADDING).trim();
            return blow;
        } catch (Exception e) {
            return "ERROR:"+e.getMessage();
        }
    }

    public static String encryptCaesar(String original, int shift) {
        String encrypted = "";
        for (int i = 0; i < original.length(); i++) {
            int c = original.charAt(i) + shift;
            if (c > 126) {
                c -= 95;
            } else if (c < 32) {
                c += 95;
            }
            encrypted += (char) c;
        }
        return encrypted;
    }

    public static String dekripsiBlowfish(String chiperText, String key){
        try {

            SecretKeySpec KS = new SecretKeySpec(key.getBytes(), "BlowfishAsds");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, KS);
            byte[] decrypted = cipher.doFinal(Base64.decode(chiperText, Base64.NO_PADDING));
            String blow = new String(decrypted);
            return blow;
        } catch (Exception e) {
            return "ERROR";
        }
    }

    public static String decryptCaesar(String encrypted, int shift) {
        return encryptCaesar(encrypted, -shift);
    }

}
