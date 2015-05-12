package week05;

import javafx.scene.layout.BackgroundImage;

import java.math.BigInteger;

/**
 * Created by Owner on 5/7/2015.
 */
public class Key {
    private BigInteger n;
    private BigInteger e;

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }

    Key(BigInteger n, BigInteger e){
        this.n = n;
        this.e = e;
    }
    public String toString(){
        String output ="";
        output = "Keypair is: " + n + " " + e;
        return output;
    }
}
