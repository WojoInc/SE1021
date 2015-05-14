package week05;

import java.math.BigInteger;

/**
 * Purpose: Class representing an RSA keypair, designed to hold both the modulus and exponent of an RSA keypair for
 * use with RSAHelper class
 * Created by wesolowskitj on 5/7/2015.
 */
public class Key {
    private BigInteger n;
    private BigInteger exponent;

    /**
     * returns the modulus of the keypair
     * @return the modulus
     */
    public BigInteger getN() {
        return n;
    }

    /**
     * returns the exponent of the keypair
     * @return the exponent
     */
    public BigInteger getE() {
        return exponent;
    }

    /**
     * default constructor
     * @param n the modulus of the keypair
     * @param exponent the exponent of the keypair
     */
    Key(BigInteger n, BigInteger exponent){
        this.n = n;
        this.exponent = exponent;
    }

    /**
     * Overrides default toString method
     * @return string representing the Key object
     */
    public String toString(){
        String output ="";
        output = "Keypair is: " + n + " " + exponent;
        return output;
    }
}
