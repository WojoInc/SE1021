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
import java.util.ArrayList;


public class RSAHelper {
    private int seed1;
    private int seed2;
    protected long p;
    protected long q;
    protected long n;
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
    public long getTotient(){
        return totient;
    }
    public int getSeed1() {
        return seed1;
    }
    public int getSeed2() {
        return seed2;
    }

    public void calcInitialValues(){
        condense(sieve(seed1));
        p = primeList.get(primeList.size()-1);
        condense(sieve(seed2));
        q = primeList.get(primeList.size()-1);
        n = p*q;
        totient = (p-1) * (q-1);
    }

    /**
     * This method iterates through the array passed into it, and counts every number that is non-zero. It then returns
     * that number in the form of an integer.
     * @param sifted the "pan" or array that has been sifted through by the sieve() method.
     * @param seed input from the user in the form of an integer, representing the number to count up to
     * @param verbose true: print a list of all primes in console false: save time by skipping verbose output.
     * @return integer representing the number of primes in the inputted array
     */
    public int countPrimes(int[] sifted, int seed, boolean verbose){
        //count all primes in array
        int numberPrimes =0;
        for(int k = 0; k <= seed; k++){
            if(sifted[k] != 0){
                if (verbose){
                    System.out.println(sifted[k]);
                }
                numberPrimes++;
            }
        }
        return numberPrimes;
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
}
