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

    /**
     * Default constructor for the RSAHelper class.
     * @param inFile File for retrieving text
     * @param outFile File for outputting encrypted text
     * @param key Key object containing a modulus and exponent for encryption
     */
    RSAFile(File inFile, File outFile, Key key){
        rsaHelper = new RSAHelper();
        this.inFile = inFile;
        this.outFile = outFile;
        this.key = key;
    }

    /**
     * Opens both inFile and outFile and instantiates the appropriate streams
     * @throws IOException Exception thrown if the files specified cannot be opened
     */
    public void openFile()throws IOException{
        inputStream = new FileInputStream(inFile);
        outputStream = new FileOutputStream(outFile);
        printWriter = new PrintWriter(outputStream);
    }

    /**
     * parses the input stream to a byte array, then each 4 byte array is wrapped into an integer, and outputted to
     * asciiIntArray
     * @throws Exception thrown if inputStream could not be read
     */
    public void parseFileForEncrypt()throws IOException{
        byte[] buffer = new byte[4];
        asciiIntArray = new ArrayList<Integer>();
        while(inputStream.read(buffer)!=-1)
        {
            System.out.println(wrapByteArrayToInteger(buffer));
            asciiIntArray.add(wrapByteArrayToInteger(buffer));
            buffer = new byte[4];
        }
    }

    /**
     * parses inputStream using scanner into asciiStringArray for decryption
     */
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

    /**
     * makes an explicit call to java.nio.ByteBuffer.wrap()
     * @param byteArray the byte array to be wrapped
     * @return the wrapped integer representation of the bytes
     * @throws Exception thrown if the length of the array is not equal to 4, as the method wraps the array in the form
     * 4 bytes * 8 bits = 32bit integer
     */
    public Integer wrapByteArrayToInteger(byte[] byteArray)throws ArrayIndexOutOfBoundsException{
        if(byteArray.length!=4)throw new ArrayIndexOutOfBoundsException("Length of byte array must be equal to 4, as 4 bytes * 8 bits = 32bit integer");
        return java.nio.ByteBuffer.wrap(byteArray).getInt();
    }

    /**
     * converts a wrapped integer back into its byte[] representation
     * @param wrappedInt the wrapped integer to convert
     * @return byte array representation of the wrapped integer
     */
    public byte[] unwrapIntToByteArray(int wrappedInt){
        byte[] byteArray = new byte[4];
        byteArray[0] = (byte) ((wrappedInt >> 24) & 0xFF);
        byteArray[1] = (byte) ((wrappedInt >> 16) & 0xFF);
        byteArray[2] = (byte) ((wrappedInt >> 8) & 0xFF);
        byteArray[3] = (byte) (wrappedInt & 0xFF);
        return byteArray;
    }

    /**
     * converts a byte array of length 4 to its ASCII representation
     * @param byteArray the byte[] array to be converted
     * @return the resulting ASCII characters
     */
    public char [] byteArrayToCharArray(byte[] byteArray){
        char[] charArray = new char[4];
        for (int i = 0; i < 4; i++) {
            charArray[i] = (char) byteArray[i];
            System.out.println(charArray[i]);
        }
        return charArray;
    }

    /**
     * encrypts the contents of asciiIntArry and stores the resulting values to asciiStringArray for output, then uses
     * PrintWriter to write the contents to outFile
     */
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

    /**
     * decrypts the contents of asciiStringArray stores the decrypted integer values to asciiIntArray, then stores the
     * unwrapped ASCII values to asciiStringArray and outputs these values using PrintWriter to outFile
     */
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

    /**
     * Test method for the RSAFile class
     * @param args command line arguments
     */
    public static void main(String[] args) {
        RSAFile test = new RSAFile(new File("C:\\Users\\Wojo\\Desktop\\test.txt"),new File("C:\\Users\\Wojo\\Desktop\\test2.txt"),new Key(new BigInteger("3233"),new BigInteger("17")));
        System.out.println(test.rsaHelper.isPrime(65537));
        System.out.println(test.key.toString());
        try {

            test.openFile();
            test.parseFileForEncrypt();
            test.encryptFile();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("Whoops");
        }

    }


}
