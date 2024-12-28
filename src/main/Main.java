package main;

import Encryption.HybridEncryption;
import Encryption.SymmetricEncryption;
import Encryption.AsymmetricEncryption;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            // Step 1: Generate RSA Key Pair
            KeyPair rsaKeyPair = AsymmetricEncryption.generateRSAKeyPair();
            System.out.println("RSA Public Key: " + bytesToHex(rsaKeyPair.getPublic().getEncoded()));
            System.out.println("RSA Private Key: " + bytesToHex(rsaKeyPair.getPrivate().getEncoded()));

            // Step 2: Generate AES Key
            SecretKey aesKey = SymmetricEncryption.generateAESKey();
            System.out.println("Generated AES Key: " + bytesToHex(aesKey.getEncoded()));

            // Step 3: Encrypt Data
            System.out.println("Enter the message :");
            String data = sc.nextLine();
            String encryptedData = HybridEncryption.encryptDataWithAES(data, aesKey);
            System.out.println("Encrypted Data: " + encryptedData);

            // Step 4: Encrypt AES Key with RSA Public Key
            String encryptedAESKey = HybridEncryption.encryptAESKeyWithRSA(aesKey, rsaKeyPair.getPublic());
            System.out.println("Encrypted AES Key: " + encryptedAESKey);

            // Step 5: Decrypt AES Key with RSA Private Key
            SecretKey decryptedAESKey = HybridEncryption.decryptAESKeyWithRSA(encryptedAESKey, rsaKeyPair.getPrivate());
            System.out.println("Decrypted AES Key: " + bytesToHex(decryptedAESKey.getEncoded()));

            // Step 6: Decrypt Data
            String decryptedData = HybridEncryption.decryptDataWithAES(encryptedData, decryptedAESKey);
            System.out.println("Decrypted Data: " + decryptedData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Utility method to convert byte array to Hex string for display purposes
    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
