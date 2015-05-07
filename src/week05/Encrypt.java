package week05;

import java.io.File;
import java.util.logging.FileHandler;

/**
 * Created by Owner on 5/6/2015.
 */
public class Encrypt {
    private File inFile;
    private File outFile;
    private Key encryptKey;
    private RSAHelper rsaHelper;

    Encrypt(int seed1, int seed2, File inFile, File outFile){
        rsaHelper = new RSAHelper(seed1,seed2);
        rsaHelper.calcInitialValues();
        encryptKey = rsaHelper.getEncryptionKey();
        this.inFile = inFile;
        this.outFile = outFile;

    }

    public static void main(String[] args) {
        Encrypt test = new Encrypt(9854592,9456614,null,null);
        System.out.println(test.rsaHelper.getN());
        System.out.println(test.encryptKey.toString());

    }


}
