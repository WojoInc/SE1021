package week05;

import sun.nio.cs.US_ASCII;

import java.io.*;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;

/**
 * Created by Owner on 5/6/2015.
 */
public class Encrypt {
    private File inFile;
    private File outFile;
    private Key encryptKey;
    private RSAHelper rsaHelper;
    private Scanner scanner;
    private InputStream inputStream;
    private FileOutputStream outputStream;
    private PrintWriter printWriter;
    private ArrayList<Integer> asciiIntArray;
    private ArrayList<String> asciiStringArray;
    private BigInteger asciiValues;
    InputStreamReader inputStreamReader;

    Encrypt(int seed1, int seed2, File inFile, File outFile){
        rsaHelper = new RSAHelper(seed1,seed2);
        rsaHelper.calcInitialValues();
        encryptKey = rsaHelper.getEncryptionKey();
        this.inFile = inFile;
        this.outFile = outFile;
    }


    public void openFile()throws IOException{
        inputStream = new FileInputStream(inFile);
        outputStream = new FileOutputStream(outFile);
        printWriter = new PrintWriter(outputStream);
    }

    public void parseFile()throws IOException{
        byte[] buffer = new byte[4];
        asciiIntArray = new ArrayList<Integer>();
        while(inputStream.read(buffer)!=-1)
        {
            asciiIntArray.add(java.nio.ByteBuffer.wrap(buffer).getInt());
            buffer = new byte[4];
        }

    }
    public void encryptFile(){
        for(Integer i: asciiIntArray){
            //System.out.println(65);
            //System.out.println(rsaHelper.encryptValue(65));
           // System.out.println(rsaHelper.decryptValue(rsaHelper.encryptValue(65)));
        }
    }
    public void writeFile(){
        String output;
        for(Integer i: asciiIntArray){
            System.out.println(i);
            output = "" +i;
            printWriter.write(output);
           /* byte[] test = new byte[4];
            test[0] = (byte) ((i >> 24) & 0xFF);
            test[1] = (byte) ((i >> 16) & 0xFF);
            test[2] = (byte) ((i >> 8) & 0xFF);
            test[3] = (byte) (i & 0xFF);
            System.out.print((char)test[0]);
            System.out.print((char)test[1]);
            System.out.print((char)test[2]);
            System.out.print((char)test[3]);
            System.out.println();*/
        }
        printWriter.close();

    }

    public static void main(String[] args) {
        Encrypt test = new Encrypt(54484,545254,new File("C:\\Users\\Wojo\\Desktop\\test.txt"),new File("C:\\Users\\Wojo\\Desktop\\test2.txt"));
        System.out.println(test.rsaHelper.getN());
        System.out.println(test.encryptKey.toString());
        try {
            test.openFile();
            test.parseFile();
            test.encryptFile();
            test.writeFile();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Oh Shit");
        }

    }


}
