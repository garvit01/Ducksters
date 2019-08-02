package com.atd.duckstersService.config;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONException;
import org.json.JSONObject;

public class SaltAES256 {

    private static String secretKey = "a254!!h7654587!!!!DASEjhh!!";
    private static String salt = "476bDFSH573jh!!!!";
    public static String defaultError = "kVPLM6a6m9irzv5a9Y1yPzRaSu1ScpFdamApAve/NZZmOMbIkPvHGnf2DAndKv2q6Zyd/swYkWSVWcmAbGpY1g==";

    public static String encrypt(String strToEncrypt) {
        try {
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }

    public static String decrypt(String strToDecrypt) {
        try {
            strToDecrypt = strToDecrypt.replaceAll("\\s", "");
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);

            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(secretKey.toCharArray(), salt.getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);
            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        try {
            json.put("status", "ERROR");
            json.put("data", "Invalid Request Err000.");
            String originalString = "{\"id\":1,\"name\":\"Kush\",\"email\":\"kush@mailinator.com\",\"password\":\"Qwerty@123\",\"listRoles\":[],\"state\":\"Delhi\",\"rating\":5,\"address\":\"Delhi\",\"country\":\"India\",\"pincode\":110020,\"commonParametersEmbaddable\":{\"createdAt\":\"2091-07-23T18:30:00.000+0000\",\"lastModified\":null,\"active\":true,\"verified\":true},\"listMatchAwards\":[{\"id\":1,\"award\":\"BestBatsman\"}],\"listTournamentAwards\":[],\"teamUser\":[{\"id\":1}]}";
            String smallstring = "{\"name\":\"Kush\"}";
//		    String encryptedString = "BohIwJFJ+oQSUJXxUe1OUuzmzKOYdnQV4QBr5mIar+uvbrqm6MnT5t5BasZ9wEHG7FEXpiMfwdd6axWNMopA9plJMx4cwNHZn6heyU3PRRwWbcVXW5e4rf0R6ZGJt4MdWmm+5 //Ofd6GP84ZJnh/nkL4NIvrtYnfcC+UucrvIc9E8ijXEbC5ECsG3lbzv6AT5QyGD2xbV4Ikui6ccykpTHwmzoEtaLOONNkCA68cPm4LTtFUcao+O8BFCOmBAYWtq4MBeI1UKjj5TF4KdbJt8aDvZsc/IBlMENzbEQl4HZk5h3N2d644jLQHirja7LLNMyQOe8JHeiLCoEEaanG1mzX7CdhwUHLFFlSIoUBPydL96l3VWhfy0KJZQ6PnhVlLaql7qur0tWsG6YSNypDkDtHKDwvV56s5Z4wMohrJOIs4zbxfQVpZV+qMZXO1/d4P3Woj0wFC4U+hqgypDDwjgR8E6Z9RfcWeldiUgeHgcCRr5NhV4U4mAs2tbCihqdXGsR5tFtupwnHwoG+UqNO7oQ==";
//            String encryptedString = SaltAES256.encrypt(json.toString());
           String encryptedString = SaltAES256.encrypt(smallstring);
            System.out.println("enc===="+encryptedString);
//		    String decryptedString = SaltAES256.decrypt("kAJyxqeRSWhtc0H1T5RT+UYzIZKWyPO6o7SzJcP7kSM/UGAJuOhqa53cOo6WDSJm8LbBA8qCRTrQY71eIUET9jx6FuyYhv7eTuh/o+ucjuicN+wHxIi5naZAPI+hCKMSXcDa/tRboc5EuGW5o1nYRTrhYcRA+jl/PbSowKMS/si3yVySvjCO6S7/jIf5vLFo9GWwlsY4pS7Xib16eFjDF+9//mii6wlpx/4bmeUeb51NdKiijpj7pDIzKLGTNxKZ3O9Ad+YL/S7S89FVbDyRZrtZWUbk9gEkLMNfIWD9WX6GJwaB+Zftmtch+0F7jNXYhMSKEXaRAOtoEMNvor4O6dxCutz6+tnyl6R3BmB2iXLfDm6owH7gNzx7kNVJzhng2KodtVPV7vJePe1RmTUKWeyxIxIhQIrnN4pbA429RkU5QmO1sxUerOuuNQdfM4e0OcvcbWQS0ErKlHPRQTGi/CN7Blw+l0rHgcT+l2DZVRIG8glv8Al5+I2Itl2Gs9Fu898FE1oMUjsteBRLU8SAGw==") ;
//            String decryptedString = SaltAES256.decrypt(encryptedString);
//		    System.out.println(originalString);
            System.out.println("enc  ===   " + encryptedString);
//            System.out.println(decryptedString);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
