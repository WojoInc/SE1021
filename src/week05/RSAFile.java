package week05;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Owner on 5/6/2015.
 */
public class RSAFile {
    private File inFile;
    private File outFile;
    private Key key;
    private RSAHelper rsaHelper;
    private Scanner scanner;
    private InputStream inputStream;
    private FileOutputStream outputStream;
    private PrintWriter printWriter;
    private ArrayList<Integer> asciiIntArray;
    private ArrayList<String> asciiStringArray = new ArrayList<String>();

    RSAFile(File inFile, File outFile, Key key){
        rsaHelper = new RSAHelper();
        this.inFile = inFile;
        this.outFile = outFile;
        this.key = key;
    }


    public void openFile()throws IOException{
        inputStream = new FileInputStream(inFile);
        outputStream = new FileOutputStream(outFile);
        printWriter = new PrintWriter(outputStream);
    }

    public void parseFileForEncrypt()throws Exception{
        byte[] buffer = new byte[4];
        asciiIntArray = new ArrayList<Integer>();
        while(inputStream.read(buffer)!=-1)
        {
            System.out.println(wrapByteArrayToInteger(buffer));
            asciiIntArray.add(wrapByteArrayToInteger(buffer));
            buffer = new byte[4];
        }
    }
    public void parseFileForDecrypt(){
        String input="";
        scanner = new Scanner(inputStream);
        asciiStringArray = new ArrayList<String>();
        while(scanner.hasNext()) {
            input = scanner.nextLine();
            System.out.println(input);
            asciiStringArray.add(input);
        }
    }

    public Integer wrapByteArrayToInteger(byte[] byteArray)throws Exception{
        if(byteArray.length!=4)throw new Exception("Length of byte array must be equal to 4, as 4 bytes * 8 bits = 32bit integer");
        return java.nio.ByteBuffer.wrap(byteArray).getInt();
    }
    public byte[] unwrapIntToByteArray(int wrappedInt){
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte) ((wrappedInt >> 24) & 0xFF);
        byteArray[1] = (byte) ((wrappedInt >> 16) & 0xFF);
        byteArray[2] = (byte) ((wrappedInt >> 8) & 0xFF);
        byteArray[3] = (byte) (wrappedInt & 0xFF);
        return byteArray;
    }
    public char [] byteArrayToCharArray(byte[] byteArray){
        char[] charArray = new char[4];
        for (int i = 0; i < 4; i++) {
            charArray[i] = (char) byteArray[i];
            System.out.println(charArray[i]);
        }
        return charArray;
    }
    public void encryptFile(){
        asciiStringArray = new ArrayList<String>();
        for(Integer i: asciiIntArray) {
            asciiStringArray.add(rsaHelper.encryptValue(i, key).toString());
            System.out.println(rsaHelper.encryptValue(i, key).toString());
        }
        for(String s: asciiStringArray){
            printWriter.write(s);
            printWriter.println();
        }
        printWriter.close();
    }

    public void decryptFile(){
        asciiIntArray = new ArrayList<Integer>();
        for(String s: asciiStringArray){
            asciiIntArray.add((rsaHelper.decryptValue(new BigInteger(s),key)).intValue());
        }
        asciiStringArray = new ArrayList<String>();
        for(Integer i: asciiIntArray){
            asciiStringArray.add(new String(byteArrayToCharArray(unwrapIntToByteArray(i))));
        }
        System.out.println(asciiStringArray);
        for(String s: asciiStringArray){
            printWriter.write(s);
        }
        printWriter.close();
    }

    public static void main(String[] args) {
        RSAFile test = new RSAFile(new File("C:\\Users\\Wojo\\Desktop\\test.txt"),new File("C:\\Users\\Wojo\\Desktop\\test2.txt"),new Key(new BigInteger("3233"),new BigInteger("17")));
       // System.out.println(test.encryptKey.getN());
        System.out.println(test.rsaHelper.isPrime(65537));
        System.out.println(test.key.toString());
        try {
            test.openFile();
            test.parseFileForEncrypt();
            test.encryptFile();
           /* test = new RSA(new File("C:\\Users\\Wojo\\Desktop\\test2.txt"),new File("C:\\Users\\Wojo\\Desktop\\test3.txt"),new Key(new BigInteger("3233"),new BigInteger("2753")));
            test.openFile();
            test.parseFileForDecrypt();
            test.decryptFile();
            test.writeFile();*/
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Oh Shit");
        }

    }


}
