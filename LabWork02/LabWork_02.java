package LabWork02;
/*
 * Student Name: Noor AlSharif
 * ID: 1725009
 * Section: IAR
 * Caesar Lab Work
 */

//Text: the quick brown fox jumps over the lazy dog
//-----------------------------------
import javax.swing.JOptionPane;

public class LabWork_02 {
    static public int key;
	
	// The class constructor. It receives the secret key as parameter
	public LabWork_02 (String s){
		key = Integer.parseInt(s.trim());  // convert the key from string to integer
	}
	
   
    public String encrypt(String plaintext){
         // TO DO...
         // define the ciphertext as empty string i.e. = ""
         
         String ciphertext = "";

         // define an array of the alphabetical order (OR)
         // define  string of the alphabetical order, and 
         // then fill it with the letters (A to Z)
         
         String alphabet = "abcdefghijklmnopqrstuvwxyz";
         
         // do a for loop to go through the "plaintext" variable char by char,  
         // and then calculate the index of the ciphertext letter 
         // using the Caesar algorithm, then add the 
         // letter of the calculated index to the ciphertext string
         
        for (int i = 0; i < plaintext.length(); i++) {
            // get the position of the alphabet
            int charIndex = alphabet.indexOf(plaintext.charAt(i));
            // do the Additive Cipher
            // Encryption
            int value = (key + charIndex) % 26;

            // replace alphabet with the new alphabet of value
            char replaceVal = alphabet.charAt(value);
            //System.out.println(replaceVal);

            // fill the ciphertext with new alphabet
            ciphertext += replaceVal;
        }
        // return the ciphertext
        return ciphertext.toUpperCase();
        
    }
    
    //------------------------------------------------------
    
    public String decrypt(String ciphertext){
        // TO DO...
        String plaintext = "";

        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < ciphertext.length(); i++)
        {
            int charPosition = ALPHABET.indexOf(ciphertext.charAt(i));
            int keyVal = (charPosition - key) % 26;
            if (keyVal < 0)
            {
                keyVal = ALPHABET.length() + keyVal;
            }
            char replaceVal = ALPHABET.charAt(keyVal);
            plaintext += replaceVal;
        }
        return plaintext.toUpperCase();
    }
    
    
    //---------------------------------------------------------
 
 
    /* Simple main method for testing the Caesar cipher */
    public static void main(String[] args){
    	// to input the plaintext
        String plaintext = JOptionPane.showInputDialog("Input your message: ");
        // to input the key
    	String sk = JOptionPane.showInputDialog("Input the key (a number [0-25]): ");
        LabWork_02 cipher = new LabWork_02(sk); // Create a Caesar cipher object
        String ciphertext = cipher.encrypt(plaintext); // get the encrypted text (ciphertext)
        System.out.println(ciphertext);
        plaintext = cipher.decrypt(ciphertext); // get the decrypted text (should be plaintext again)
        System.out.println(plaintext);
        JOptionPane.showMessageDialog(null,
                                  "encrypted text: " + ciphertext + "\n" +
                                  "decrypted text: " + plaintext);
                                  
    }
}
