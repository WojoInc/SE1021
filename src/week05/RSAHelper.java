package week05;

/**
 * Purpose: This class uses worker methods to effectively count the number of primes between one and an integer
 * given by user input. It implements the multiple technique rather than the traditional division technique.
 *
 * @author:wesolowskitj
 * @version:2.2
 * Created on 12/18/2014 at 12:20 AM.
 */

import javax.swing.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LongSummaryStatistics;
import java.util.Random;


public class RSAHelper {
    private int seed1;
    private int seed2;
    protected BigInteger p;
    protected BigInteger q;
    protected BigInteger n;
    protected BigInteger e;
    protected BigInteger d;
    protected BigInteger totient;
    private ArrayList<Integer> primeList;

    /**
     * default constructor
     * @param seed1
     * @param seed2
     */
    public RSAHelper(int seed1, int seed2) {
        this.seed1 = seed1;
        this.seed2 = seed2;
    }
    public RSAHelper(){
        this(0,0);
    }

    public void calcInitialValues(){
        primeList = condense(sieve(seed1));
        p = BigInteger.valueOf(primeList.get(primeList.size() - 1));
        primeList = condense(sieve(seed2));
        q = BigInteger.valueOf(primeList.get(primeList.size() - 1));
        n = p.multiply(q);
        totient = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

    }
    public void generateE(){
        e = BigInteger.valueOf(65537);
    }
    public void generateEncKey(){
        generateE();
    }
    public void generateDecKey(){
        d = e.modInverse(totient);

    }
    public BigInteger getTotient(){
        return totient;
    }
    public Key getEncryptionKey(){
        return new Key(n,e);
    }
    public Key getDecryptionKey(){
        return new Key(n,d);
    }
    public boolean isPrime(int value){
        ArrayList<Integer> temp = condense(sieve(value+1));
        boolean prime =false;
        for(Integer i: temp){
            if(i.equals(value))prime=true;
        }
        return prime;
    }
    public ArrayList<Integer> condense(int [] primes){
        ArrayList<Integer> primeArray = new ArrayList<Integer>();
        for(Integer i: primes){
            if(i != 0) primeArray.add(i);
        }
        return primeArray;
    }
    /**
     * Sifts through an array from 0 to seed and marks all numbers in array that are not prime. Then outputs
     * the number of primes remaining in the array
     * @param seed integer representing the number to generate up to
     * @return returns the number of primes calculated
     */
    public int[] sieve(int seed){

        //create an array that holds all numbers between 0 and user number

        int[] primes = new int[seed +1 ];
        for(int i = 0; i <= seed ; i++){
            primes[i] = i;
        }
        /*follow the process of the "Sieve of Eratosthenes"
        begin with the the first prime, 2, and delete every multiple of the prime from the array,
        then move on to the next number in the array and repeat until the prime number you reach is equal
        to that of the square root of the user inputted number.
        */

        for (int j = 2; j < Math.sqrt(seed); j++){
            int currentMultiple = 2;
            //get the value of the next prime in the array
            while (primes[j] == 0){
                j++;
            }

            //remove all multiples of the prime
            while ((j * currentMultiple) <= seed){

                primes[j * currentMultiple] = 0;
                currentMultiple++;

            }

        }
        return primes;
    }
    private BigInteger gcd(BigInteger x, BigInteger y) {
        if (y.equals(BigInteger.ZERO)) {
            return x;
        } else if (x.equals(BigInteger.ZERO)) {
            return y;
        } else if (x.compareTo(y)>0) {
            return gcd(y, (x.mod(y)));
        } else if (y.compareTo(x)>0) { //y >=x would be fine too, although the = is already captured earlier
            return gcd(x, (y.mod(x)));
        }
        return BigInteger.ZERO; //doesn't really matter, this is not for math but java
    }

    public BigInteger modExpo(BigInteger value, Key key){
        BigInteger base = value;
        BigInteger exponent = key.getE();
        BigInteger N = key.getN();
        BigInteger result = BigInteger.ONE;
        BigInteger currentBit;

        while(exponent.compareTo(BigInteger.ZERO) == 1){
            currentBit = exponent.mod(BigInteger.valueOf(2));
            if(currentBit.equals(BigInteger.ONE)){
                result = ((result.multiply(base).mod(N)));
            }
            exponent = exponent.divide(BigInteger.valueOf(2));
            base = (base.multiply(base)).mod(N);
        }
        return result;
    }
    public BigInteger encryptValue(int inputInt,Key encKey){
        return modExpo(BigInteger.valueOf(inputInt),encKey);
    }

    public BigInteger decryptValue(BigInteger input, Key decKey){
        return modExpo(input, decKey);
    }



}
