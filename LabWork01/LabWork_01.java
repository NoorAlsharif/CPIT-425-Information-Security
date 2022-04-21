/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabWork01;

/**
 *
 * @author 1725009
 */
import java.io.*;
import java.util.Scanner;
public class LabWork_01 {

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        File FileInput = new File("message.txt");
        PrintWriter output = new PrintWriter("output.txt");
        
        //read message from file
        Scanner input = new Scanner(FileInput);
        String message = "";
        while (input.hasNextLine()) {
            message = input.nextLine();
            System.out.println(message);
        }
       
        //create frequency array with length of message
        int[] frequency = new int[message.length()];
        
        //read the message by character
        char string[] = message.toCharArray();

        for (int i = 0; i < message.length(); i++) {
            frequency[i] = 1;
            for (int j = i + 1; j < message.length(); j++) {
                if (string[i] == string[j]) {
                    frequency[i]++;
                    //avoid printing already printed character  
                    string[j] = '0';
                }
            }
        }

        System.out.println("\nfrequency of letters:");
        for (int i = 0; i < frequency.length; i++) {
            if (string[i] != ' ' && string[i] != '0') {
                System.out.println(string[i] + ": " + frequency[i]);
                output.write(string[i] + ": " + frequency[i]+"\n");
            }
        }
        
        output.close();
    }
    
}
