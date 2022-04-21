//-----------------------
//LAB#6 Message Digest (LAB WORK)
//Student Name:
//ID:
//Section:
//------------------------
package LabWork06;

/**
 *
 * @author nooralsharif
 */
import java.security.*;
import java.io.*;
import java.math.BigInteger;

public class LabWork_06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception {

        MessageDigest sh = MessageDigest.getInstance("SHA-1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        int i;

        String str = "Java security technology includes a large set of APIs, tools, and implementations of "
                + "commonly used security algorithms, mechanisms, and protocols. The Java security APIs span a wide range of areas,"
                + "	including cryptography, public key infrastructure, secure communication, authentication, and access control. "
                + "	Java security technology provides the developer with a comprehensive security framework for writing applications,"
                + "and also provides the user or administrator with a set of tools to securely manage applications. ";

        String str2 = "Java security technology includes a large set of APIs, tools, and implementations of "
                + "commonly used security algorithms, mechanisms, and protocols. The Java security APIs span a wide range of areas,"
                + "	including cryptography, public key infrastructure, secure communication, authentication, and access control. ";

        byte[] data1 = str.getBytes("UTF8");
        sh.update(data1);
        byte[] msgDigest_sh = sh.digest();
        // TO DO...
        sh.reset();
        
        ///////////////////////////////////////
        
        byte[] data2 = str2.getBytes("UTF8");
        sh.update(data2);
        byte[] msgDigest_sh2 = sh.digest();
        // TO DO...
        sh.reset();
        
        ///////////////////////////////////////
        
        byte[] MDdata1 = str.getBytes("UTF8");
        md5.update(MDdata1);
        byte[] msgDigest_md5 = md5.digest();
        // TO DO...
        md5.reset();
        
        ///////////////////////////////////////
        
        byte[] MDdata2 = str2.getBytes("UTF8");
        md5.update(MDdata2);
        byte[] msgDigest_md52 = md5.digest();
        // TO DO...
        md5.reset();
        

        //--------------------------------------------------Using SHA-1-------------------------------------------------
        System.out.println("--- The First Message Digest Using SHA-1---");
        System.out.println(new String(msgDigest_sh));
        for (i = 0; i < msgDigest_sh.length; i++) {
            System.out.print(msgDigest_sh[i] + " ");
        }
        
        System.out.println("\n");
        // Convert to hex String
        String output = String. format ("%032X", new BigInteger (1, msgDigest_sh));
        System.out.println("Converted to hex: " +output);
        
        
        System.out.println("\nThe output size is  : " + i + "   ");
        System.out.print("\n");

        ///////////////////////////////////////
        
        System.out.println("--- The Second Message Digest Using SHA-1---");
        // TO DO...
        System.out.println(new String(msgDigest_sh2));
        for (i = 0; i < msgDigest_sh2.length; i++) {
            System.out.print(msgDigest_sh2[i] + " ");
        }
        
        System.out.println("\n");
        // Convert to hex String
        String output2 = String. format ("%032X", new BigInteger (1, msgDigest_sh2));
        
        System.out.println("Converted to hex: " +output2);
        
            
        System.out.println("\nThe output size is  : " + i + "   ");
        System.out.print("\n");

        
        System.out.println("//////////////////////////////////////////////////////////////////////////////////\n");
        //--------------------------------------------------Using MD5-------------------------------------------------
        // TO DO...
        System.out.println("--- The First Message Digest Using MD5---");
        System.out.println(new String(msgDigest_md5));
        for (i = 0; i < msgDigest_md5.length; i++) {
            System.out.print(msgDigest_md5[i] + " ");
        }
        
        System.out.println("\n");
        // Convert to hex String
        String output3 = String. format ("%032X", new BigInteger (1, msgDigest_sh2));
        System.out.println("Converted to hex: " +output3);
        
        System.out.println("\nThe output size is  : " + i + "   ");
        System.out.print("\n");

        ///////////////////////////////////////
        
        System.out.println("--- The Second Message Digest Using SHA-1---");
        System.out.println(new String(msgDigest_md52));
        for (i = 0; i < msgDigest_md52.length; i++) {
            System.out.print(msgDigest_md52[i] + " ");
        }
        
        System.out.println("\n");
        // Convert to hex String
        String output4 = String. format ("%032X", new BigInteger (1, msgDigest_sh2));
        System.out.println("Converted to hex: " +output4);
        
        System.out.println("\nThe output size is  : " + i + "   ");
        System.out.print("\n");
    }
}
