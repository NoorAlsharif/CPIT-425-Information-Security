/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabWork05;

/**
 *
 * @author nooralsharif
 */

import java.util.*;
import javax.crypto.*;
import java.io.*;
import java.security.*;

public class rsa {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        
        //String we want to encrypt
        String  message= "This is a confidential message.";
        
        //convert string to byte array using getBytes() method
        
            byte [] textBytes = message.getBytes();


        //Generate the Key Pairs for RSA algorithm (two lines)
        
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        
            KeyPair myPair = generator.generateKeyPair();
            
        
        //Create the Cipher object with DES algorithm
        
            Cipher c = Cipher.getInstance("RSA");
        

            
        //This class is a simple holder for a key pair (a public key and a private key).
        //It has two important methods getPublic() and getPrivate().
        
        //initialize the cipherobject, set mode to encrypt and pass the key.
            
            PublicKey pk = myPair.getPublic();
            c.init(Cipher.ENCRYPT_MODE, pk);
        
        //encrypt the message using doFinal
        
            byte [] encryptedBytes = c.doFinal(textBytes);

       
        
        // to convert the byte array to a readable string use the encoding scheme "base64"
        //Ex. String encryptedText =Base64.getEncoder().encodeToString(myEncryptedBytes);
        
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        
        

        //to decrypt initialize the same cipher object, set mode to decrypt and pass the key.
            
            PrivateKey pv = myPair.getPrivate();
            c.init(Cipher.DECRYPT_MODE, pv);
        
        // decrypt using doFinal
            byte [] myDecryptedBytes = c.doFinal(encryptedBytes);

       // convert byte array to string for printing 
        String decrypteddata=new String(myDecryptedBytes);

        System.out.println("Message : "+ message);
        System.out.println("Encrypted - "+ encryptedText);
        System.out.println("Decrypted Message - "+ decrypteddata);
    }
}
