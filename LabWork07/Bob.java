package LabWork07;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emanahmed
 */
public class Bob {
    int Q,a;
    int Ya; // Alice Public key 
    int Yb; //Bob Public key 
    int Xb; // Bob Private key  
    int Kab; // Shared key 
  
    
    // Bob Recive Q and a
     public void setQandA(int Q,int a)
    {
        this.Q=Q;
        this.a=a;
    }
    
    // Bob recive Alice public key 
    public void setAlicePK(int Ya)
    {
       this.Ya = Ya;
    }
     
    public void generateKEys()
    {
       // genrate the private key randomly 
        int ranPU = (int)(Math.random()*(Q-1))+1;
        Xb = ranPU;
 
       // gernate the publick key 
       Yb= (int)(Math.pow(a, Xb)%Q);

        
    }
     // genrate the shared key with Alice
     public void generateSharedKey()
    {
      Kab = (int)(Math.pow(Ya, Xb)%Q);

    }
      //return Bob Public key
     public int getPublicKey()
     { 
         return Yb;
     }
  
    /* Recive a message and decrypt it using  ceaser Cipher with the 
     shared key gernated from Deffie helmen*/
    public String reciveMessage(String Ciphertext)
    {  
        System.out.println(Kab);
          String OriginalText = "";
        for(int i=0; i<Ciphertext.length();i++)
            OriginalText += (char)((((Ciphertext.charAt(i)-97)-Kab)%26)+97);      

         System.out.println(OriginalText);
         return OriginalText;
        
    }
      /*  Encrypt a message using  ceaser Cipher with the 
     shared key gernated from Deffie helmen  */ 
    public String senMessage(String plaintext )
    {
         String cyphertext = "";
        for(int i=0; i<plaintext.length();i++)
            cyphertext += (char)((((plaintext.charAt(i)-97)+Kab)%26)+97);
        
        System.out.println(cyphertext);
        return cyphertext;
    }
    
      // return (x^n) mod p 
      public static int powerMod(int x, int n, int p) {
        if (n == 0) {
            return 1;
        }
        int tmp = powerMod((x * x) % p, n / 2, p);
        if (n % 2 != 0) {
            tmp = (tmp * x) % p;
        }
        return tmp;
    }
}
