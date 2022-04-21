/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabWork07;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author emanahmed
 */
public class Alice {

    int Q, a;
    int Ya; // Alice Public key 
    int Yb; //Bob Public key 
    int Xa; // Alice Private key  
    int Kab; // Shared key 

    // Alice recive Bob public key 
    public void setBobPK(int Yb) {
        this.Yb = Yb;
    }

    //Generate Q and A 
    public int[] gernateQnadA() {

        int[] arr = new int[2];
        
        //select random number for Q
        Q = (int) (Math.random() * 100);
        
        //check if prime
        while(isPrime(Q)==false){
            if(isPrime(Q)){
                arr[0] = Q;
            }
           Q = (int) (Math.random() * 100);
        }
        System.out.println(Q+" is a prime");
        System.out.println("\nthis is Q: "+Q);
        a = (int) (Math.random() * (Q - 1)) + 1;
        arr[1] = a;
        System.out.println("this is a: "+a);
        
        return arr;

    }
    
    //////////////////////////////////////////////
    public static boolean isPrime(long num) {
        long temp;
        boolean isPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            temp = num % i;
            if (temp == 0) {
                isPrime = false;
               break;
            }
            
        }
        return isPrime;
    }

    public void generateKEys() {
        // genrate the private key randomly
        int ranPU = (int)(Math.random()*(Q-1))+1;
        Xa = ranPU;
        System.out.println("\nthis is Q when generating public key: "+Q);

       // gernate the publick key 
       Ya= (int)(Math.pow(a, Xa)%Q);

    }
    // genrate the shared key with Bob

    public void generateSharedKey() {
        Kab = (int)(Math.pow(Yb, Xa)%Q);
    }
    //return Alice public key

    public int getPublicKey() {
        System.out.println("\nreturning ya which is public key: ");
        return Ya;
    }

    /* Recive a message and decrypt it using  ceaser Cipher with the 
     shared key gernated from Deffie helmen*/
    public String reciveMessage(String Ciphertext) {
        String OriginalText = "";
        for (int i = 0; i < Ciphertext.length(); i++) {
            OriginalText += (char) ((((Ciphertext.charAt(i) - 97) - Kab) % 26) + 97);
        }

        System.out.println(OriginalText);
        return OriginalText;

    }

    /*  Encrypt a message using  ceaser Cipher with the 
     shared key gernated from Deffie helmen  */
    public String senMessage(String plaintext) {
        System.out.println(Kab);
        String cyphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            cyphertext += (char) ((((plaintext.charAt(i) - 97) + Kab) % 26) + 97);
        }

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
