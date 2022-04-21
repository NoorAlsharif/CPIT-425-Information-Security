/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabWork04;

/**
 *
 * @author nooralsharif
 */

import java.util.*;
import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
public class des {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        
        //String we want to encrypt
        String  message= "This is a confidential message.";
        
        //convert string to byte array using getBytes() method
        
            byte [] textBytes = message.getBytes();


        //Generate the Key for DES algorithm (two lines)
        
            KeyGenerator kg = KeyGenerator.getInstance("DES");
        
            SecretKey key = kg.generateKey();

        //Create the Cipher object with DES algorithm
        
            Cipher c = Cipher.getInstance("DES");
        

        //initialize the cipherobject, set mode to encrypt and pass the key.
        
            c.init(Cipher.ENCRYPT_MODE, key);
        
        //encrypt the message using doFinal
        
            byte [] encryptedBytes = c.doFinal(textBytes);

       
        
        // to convert the byte array to a readable string use the encoding scheme "base64"
        //Ex. String encryptedText =Base64.getEncoder().encodeToString(myEncryptedBytes);
        
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        
        

        //to decrypt initialize the same cipher object, set mode to decrypt and pass the key.
            c.init(Cipher.DECRYPT_MODE, key);
        
        // decrypt using doFinal
            byte [] myDecryptedBytes = c.doFinal(encryptedBytes);

       // convert byte array to string for printing 
        String decrypteddata=new String(myDecryptedBytes);

        System.out.println("Message : "+ message);
        System.out.println("Encrypted - "+ encryptedText);
        System.out.println("Decrypted Message - "+ decrypteddata);
    }
}
