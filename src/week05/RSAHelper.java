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
    protected long p;
    protected long q;
    protected long n;
    protected long e;
    protected long d;
    protected long totient;
    private ArrayList<Integer> primeList;

    public RSAHelper(int seed1, int seed2) {
        this.seed1 = seed1;
        this.seed2 = seed2;
        p=0;
        q=0;
        n=0;
        totient=0;

    }

    public long getP() {
        return p;
    }
    public long getQ() {
        return q;
    }
    public long getN(){
        return n;
    }

    public long getE() {
        return e;
    }

    public long getD() {
        return d;
    }

    public long getTotient(){
        return totient;
    }
    public int getSeed1() {
        return seed1;
    }
    public int getSeed2() {
        return seed2;
    }
    public Key getEncryptionKey(){
        return new Key(BigInteger.valueOf(n),BigInteger.valueOf(e));
    }
    public Key getDecryptionKey(){
        return new Key(BigInteger.valueOf(n),BigInteger.valueOf(d));
    }
    public long encryptValue(int inputInt){
        long eprime =1;
        long lastvalue =1;
        long input = Integer.toUnsignedLong(inputInt);
        for (eprime=1; eprime<=e; eprime++){
            lastvalue = ((lastvalue * input) % n);
        }
        return lastvalue;
    }
    public long decryptValue(long input){
        long dprime =1;
        long lastvalue =1;
        for (dprime=1; dprime<=d; dprime++){
            lastvalue = ((lastvalue * input) % n);
        }
        return lastvalue;
    }
    public void calcInitialValues(){
        condense(sieve(seed1));
        p = primeList.get(primeList.size()-1);
        condense(sieve(seed2));
        q = primeList.get(primeList.size()-1);
        n = p*q;
        totient = (p-1) * (q-1);
        generateE();
        generateD();
    }
    public void generateE(){
        /*Random generator = new Random();
        boolean done =false;
        while(!done){
            e = primeList.get(generator.nextInt())
        }*/
        e = 67;

        if(gcd(totient,e)!= 1){
            System.out.println("Whoops.");
        }
    }
    public void generateD(){
        long a = e;
        long b = totient;
        long x = 0, y = 1, lastx = 1, lasty = 0;
        while(b!=0)
        {
            long quotient = a/b;

            long temp = a;
            a = b;
            b=temp%b;

            temp = x;
            x=lastx-quotient*x;
            lastx=temp;

            temp = y;
            y=lasty-quotient*y;
            lasty=temp;
        }

        if(e*lastx%totient == 1)
        {
            d=lastx;
        }
        else
        {
            d=lasty;
        }
    }
    private long gcd(long x, long y) {
        if (y == 0) {
            return x;
        } else if (x == 0) {
            return y;
        } else if (x >= y) {
            return gcd(y, (x % y));
        } else if (y > x) { //y >=x would be fine too, although the = is already captured earlier
            return gcd(x, (y % x));
        }
        return 0; //doesn't really matter, this is not for math but java
    }
    public ArrayList<Integer> condense(int [] primes){
        primeList = new ArrayList<Integer>();
        for(Integer i: primes){
            if(i != 0) primeList.add(i);
        }
        return primeList;
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
    public BigInteger modExpo(BigInteger M, Key encKey){
        BigInteger base = M;
        BigInteger exponent = encKey.getE();
        BigInteger N = encKey.getN();
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
}
