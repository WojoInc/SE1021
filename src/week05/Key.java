package week05;

import javafx.scene.layout.BackgroundImage;

import java.math.BigInteger;

/**
 * Created by Owner on 5/7/2015.
 */
public class Key {
    private BigInteger n;
    private BigInteger exponent;

    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return exponent;
    }

    Key(BigInteger n, BigInteger exponent){
        this.n = n;
        this.exponent = exponent;
    }
    public String toString(){
        String output ="";
        output = "Keypair is: " + n + " " + exponent;
        return output;
    }
}
