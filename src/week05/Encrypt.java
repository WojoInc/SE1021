package week05;

import java.io.File;
import java.util.logging.FileHandler;

/**
 * Created by Owner on 5/6/2015.
 */
public class Encrypt extends RSAHelper{
    private File inFile;
    private File outFile;

    Encrypt(int seed1, int seed2, File inFile, File outFile){
        super(seed1,seed2);
        this.inFile = inFile;
        this.outFile = outFile;
        calcInitialValues();
    }

    public static void main(String[] args) {
        Encrypt test = new Encrypt(4545332,84564614,null,null);
        System.out.println(test.p);
        System.out.println(test.q);
        System.out.println(test.n);
        System.out.println(test.totient);
    }


}
