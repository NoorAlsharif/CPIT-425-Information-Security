/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabWork08;

/**
 *
 * @author nooralsharif
 */
import java.security.*;

//---------------------------
// Digital Signature LAB WORK
// Name : Noor Al Sharif
// ID : 1725009
//---------------------------
/**
 * SignatureExample
 *
 * Simple example of using a digital signature. 
 * This class creates an RSA key pair 
 * and then signs the text of the first argument passed to it. 
 * It displays the signature , and then verifies the signature 
 * with the corresponding public key. 
 * Where u see TO DO, put your code.
 */
public class DSLabWork {

    public static void main(String[] args) throws Exception {

        String msg = "A digital signature is an electronic signature.";
        
        System.out.println("Generating RSA key pair...");
        
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        KeyPair keyPair = kpg.generateKeyPair();

        // Get the bytes of the message
        // TO DO ...
        byte[] data = msg.getBytes("UTF8");
        
        // Get an instance of the Signature object using "MD5WithRSA" as parameter and initialize it
        // with the private key for signing
        // TO DO ...
        Signature sig = Signature.getInstance("MD5withRSA");
        
        sig.initSign(keyPair.getPrivate());

        
        // Prepare to sign the data by updating the signature object with the original text
        // TO DO ...
        
        sig.update(data); 
        

       
        // Actually sign it, and then dispaly the array of the digital signature
        System.out.println("****************The Signature****************");
        // TO DO ...
        
        byte[] signatureBytes = sig.sign();
        
        for(int i = 0; i < signatureBytes.length; i++){
            System.out.print(signatureBytes[i]+" ");
        }
        
        System.out.println("\nThe length of the signature array: "+ signatureBytes.length);
        

        System.out.println("*********************************************");

        // Now we want to verify that signature. We'll need to reinitialize
        // our Signature object with the public key for verification. This
        // resets the signature's data, so we'll need to pass it in update method.
        // TO DO ...
        
        sig.initVerify(keyPair.getPublic());  

        
        // Pass in the original data to the update method
        // TO DO ...
        
        sig.update(data); 
        
        // Verify the signature 
        boolean verified = false;
        // TO DO ...
        
        verified = sig.verify(signatureBytes);

        

        if (verified) {
            System.out.println("\nVerfiying Process--------Signature verified.");
        } else {
            System.out.println("\nVerfiying Process--------Signature did not match.");
        }
    }
}
