package week05;

import java.io.*;
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
    private FileReader fileReader;
    private FileWriter fileWriter;
    private char[] data;
    private int[] intData;

    Encrypt(int seed1, int seed2, File inFile, File outFile){
        rsaHelper = new RSAHelper(seed1,seed2);
        rsaHelper.calcInitialValues();
        encryptKey = rsaHelper.getEncryptionKey();
        this.inFile = inFile;
        this.outFile = outFile;
    }

    public void readFile()throws FileNotFoundException, IOException{
        fileReader = new FileReader(inFile);
        data = new char[(int)inFile.length()];
        intData = new int[(int) inFile.length()];
        fileReader.read(data,0,(int)inFile.length());
        System.out.println(data);
    }
    public void encryptFile(){
        int i =0;
        for(char c: data){
            intData[i] = c;
            i++;
        }

        for (int j: intData){
            j = (int)(rsaHelper.encryptValue((long)j));

        }
        i =0;
        for(char c: data){
            c = (char)intData[i];
            i++;
        }
    }
    public void writeFile()throws FileNotFoundException, IOException{
        fileWriter = new FileWriter(outFile);
        fileWriter.write(data);
    }

    public static void main(String[] args) {
        Encrypt test = new Encrypt(9854592,9456614,new File("C:\\Users\\Owner\\Desktop\\FHSWORDLIST.txt"),new File("C:\\Users\\Owner\\Desktop\\test.txt"));
        System.out.println(test.rsaHelper.getN());
        System.out.println(test.encryptKey.toString());
        try {
            test.readFile();
            test.encryptFile();
            test.writeFile();
        }
        catch(Exception e){

        }

    }


}
