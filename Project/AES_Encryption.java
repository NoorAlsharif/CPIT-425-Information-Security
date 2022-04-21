/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

/**
 *
 * @author nooralsharif, hindalmutairi
 */

import java.util.Scanner;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * 1. Create software that can encrypt and decrypt a text as input in CBC (cipher block chaining) mode using AES.
 * 2. Then encrypt the key used in the first step using RSA algorithm.
 * 3. The software should decrypt the key using RSA first then decrypt the message using AES in CBC mode.
 */


public class AES_Encryption {

    static String plainText;
    
    public static void main(String[] args) throws Exception {
        System.out.println("\n********************* WELCOME TO THE PROGRAM *********************\n");

        //Step (1)
        //ask for the plaintext message:
        System.out.println("Please Enter The Message You Wish To Encrypt: ");
        Scanner input = new Scanner(System.in);
        plainText = input.nextLine();

        System.out.println("\n************* Encryption & Decryption Using AES & RSA *************\n");
        System.out.println("Plaintext : " + plainText);
        System.out.println("----------");

        //##########################################
        
        //Step (2)
        //generate a secret key for AES
        //SecretKey key = KeyGenerator.getInstance("AES").generateKey();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();
        //encoding key to print in string
        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());

        System.out.println("\nAES Secret Key : " + encodedKey);
        System.out.println("---------------");

        
        //##########################################
        //Step (3)
        //Encrypt the Plaintext message using AES
        byte[] IV = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(IV);

        byte[] cipherText1 = encrypt_AES(plainText.getBytes(), key, IV);
        
        System.out.println("\nAES Encrypted Message : " + Base64.getEncoder().encodeToString(cipherText1));
        System.out.println("----------------------");

        //##########################################
        
        //Step (4)
        //generating key pairs for RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(4096);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        // public and private keys
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        //##########################################
        
        //Step (5)
        //encrypt the secret key using RSA
        byte[] cipherTextArray = encrypt_RSA(key.toString(), publicKey);
        String encryptedText = Base64.getEncoder().encodeToString(cipherTextArray);
        
        
        System.out.println("\nRSA Encrypted Secret Key : " + encryptedText);
        System.out.println("-------------------------");
        
        //##########################################
        
        //Step (6)
        //decrypt the key using RSA
        String RSA_decrypted_Key = decrypt_RSA(cipherTextArray, privateKey);
        
        System.out.println("\nRSA Decrypted Secret Key : "+ RSA_decrypted_Key);
        System.out.println("-------------------------");
        
        //##########################################
        
        // Step (7)
        //lastly decrept the message using AES
        String decryptedText = decrypt_AES(cipherText1, key, IV);
        System.out.println("\nAES Decrypted Message : " + decryptedText);
        System.out.println("----------------------");
    }
    
    //########################################
    
    // encrypt key using RSA
    public static byte[] encrypt_RSA(String plainText, PublicKey publicKey) throws Exception {
        //create new cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
        
        //intilize cipher to decrypt using public key
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        
        //add the key to byte array
        byte[] cipherText = cipher.doFinal(plainText.getBytes());

        return cipherText;
    }
    
    
    // decrypt key using RSA
    public static String decrypt_RSA(byte[] cipherTextArray, PrivateKey privateKey) throws Exception {
        //create new cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-512ANDMGF1PADDING");
        
        //intilize cipher to decrypt using private key
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        //add ciphered key to byte array
        byte[] RSA_decrypted_Key = cipher.doFinal(cipherTextArray);
        
        //encode key to print as string
        String encodedDecKey = Base64.getEncoder().encodeToString(RSA_decrypted_Key);

        return new String(encodedDecKey);
    }

    //########################################
    
    // encrypt message with AES
    public static byte[] encrypt_AES(byte[] plaintext, SecretKey key, byte[] IV) throws Exception {

        //create a cipher instance using AES algorithm, CBC mode, and PKCS5 padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        
        //initialize cipher object to encrypt with the key
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        
        //encrypt message with doFinal
        byte[] cipherText = cipher.doFinal(plaintext);
        
        return cipherText;
    }

    // decrypt message with AES
    public static String decrypt_AES(byte[] cipherText, SecretKey key, byte[] IV) throws Exception {

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        
        byte[] decryptedText = cipher.doFinal(cipherText);
        
        return new String(decryptedText);
    }
    
    
}
