package com.example.encryption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.text.CharacterIterator;
import java.text.DecimalFormat;
import java.text.StringCharacterIterator;
import java.util.Base64;

@SpringBootApplication
@Slf4j
public class EncryptionApplication {
    private static String salt = "56c6b89e-00e1-4fef-8267-2b6837f0e721";


    public static void main(String[] args) throws Exception {

//        String secretKey = "testkey";

        //encrypt
//        String strToEncrypt = "";
//        String encryptedKey = "";
//
//        try {
//
//            // AES
//            byte[] iv = new byte[16];
//            SecureRandom secRandom = new SecureRandom();
//            secRandom.nextBytes(iv);
//            IvParameterSpec ivspec = new IvParameterSpec(iv);
//            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
//            KeySpec spec =
//                    new PBEKeySpec(
//                            secretKey.toCharArray(), salt.getBytes(StandardCharsets.UTF_8), 200000, 256);
//            SecretKey tmp = factory.generateSecret(spec);
//            SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivspec);
//            encryptedKey =
//                    Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
//        } catch (Exception e) {
//            log.error("Error while encrypting: {}", e);
//            throw new Exception(e.getMessage());
//        }
//        log.error("Encrypted String .... {}",encryptedKey);

        // Decrypt
//        String secretKey = "b5612d44-68cc-4c27-a2df-962bccd45cf6"; //b5612d44-68cc-4c27-a2df-962bccd45cf6
//        String strToDecrypt = "PzDBQOqTR2y5taXviJyRuiQ4G4uuk8dhcylrPx2gHKQ=";
//        String decryptedText = "";
//
//        try {
//            // AES
//
//            byte[] iv = new byte[16];
//            SecureRandom secRandom = new SecureRandom();
//            secRandom.nextBytes(iv);
//            IvParameterSpec ivspec = new IvParameterSpec(iv);
//            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
//            KeySpec spec =
//                    new PBEKeySpec(
//                            secretKey.toCharArray(), salt.getBytes(StandardCharsets.UTF_8), 200000, 256);
//            SecretKey tmp = factory.generateSecret(spec);
//            SecretKeySpec secretKeySpec = new SecretKeySpec(tmp.getEncoded(), "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivspec);
//
//            decryptedText = new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
//        } catch (Exception e) {
//            log.error("Error while encrypting: {}", e);
//            throw new Exception(e.getMessage());
//        }
//        log.error("Decrypted String ....        "+decryptedText);

//        long byteCount = 1024 * 1024 * 1.5; // 1.5 MB
//        if(-92233720368547L == Long.MIN_VALUE){
//            System.out.println("Byte value minimum");
//        }else {
//            System.out.println("Byte value maximum");
//        }
        //1535636009  - 1535557798

        String humanReadableSize = getFileSizeInReadableFormat(1535557798-5000000);
        System.out.println(humanReadableSize); // Output: 1.5 MB
//
//        String ReadableSize = getFileSizeInReadableFormat(1535557798);
//        System.out.println(ReadableSize); // Output: 1.5 MB
//        long parseLong = Long.parseLong(
//                String.valueOf(1535557730));
//        System.out.println("parse long :  "+parseLong);
//        System.out.println("minues value "+ (1535636009  - 1535557798));
//        if(1535557730 > 1535634091){
//            System.out.println("greater");
//        }else {
//            System.out.println("smaller");
//        }
        SpringApplication.run(EncryptionApplication.class, args);
    }

    public static String humanReadableByteCount(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        int exp = (int) (Math.log(bytes) / Math.log(1024));
        String prefix = ("KMGTPE").charAt(exp-1) + "";
        String string = new DecimalFormat("#.###").format(bytes / Math.pow(1024, exp)) + " " + prefix + "B";
        return string;
    }

    public static String getFileSizeInReadableFormat(long bytes) {
        long absB = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
        if (absB < 1024) {
            return bytes + " B";
        }
        long value = absB;
        CharacterIterator ci = new StringCharacterIterator("KMGTPE");
        for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
            value >>= 10;
            ci.next();
        }
        value *= Long.signum(bytes);
        return String.format("%.6f %cB", value / 1024.0, ci.current());
    }
    public static String humanReadableByte(long bytes) {
        if (bytes == Long.MIN_VALUE) {
            return "-∞ B"; // Handle the special case of Long.MIN_VALUE
        }

        boolean isNegative = bytes < 0;
        long absBytes = Math.abs(bytes);

        if (absBytes < 1024) {
            return (isNegative ? "-" : "") + absBytes + " B";
        }

        int exp = (int) (Math.log(absBytes) / Math.log(1024));
        String prefix = ("KMGTPE").charAt(exp - 1) + "";
        String formattedSize = new DecimalFormat("#.###").format(absBytes / Math.pow(1024, exp));

        return (isNegative ? "-" : "") + formattedSize + " " + prefix + "B";
    }
}
