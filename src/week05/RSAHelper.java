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


public class RSAHelper {

    public static String[] getInput(){
        String userString, option = "";
        String [] output = new String[2];
        JOptionPane.showMessageDialog(null, "Welcome, this program will determine the number of "
                + "primes between 0 and a number you input. Including 1.");     
        userString = JOptionPane.showInputDialog("Please input a number: ");
        option = JOptionPane.showInputDialog("Print verbose output? (y/n)");
        output[0] = userString;
        output[1] = option;

        return output;
    }

    /**
     * This method iterates through the array passed into it, and counts every number that is non-zero. It then returns
     * that number in the form of an integer.
     * @param siftedPan the "pan" or array that has been sifted through by the sieve() method.
     * @param userInput input from the user in the form of an integer, representing the number to count up to
     * @param verbose true: print a list of all primes in console false: save time by skipping verbose output.
     * @return integer representing the number of primes in the inputted array
     */
    public static int countPrimes(int[] siftedPan, int userInput, boolean verbose){
        //count all primes in array
        int numberPrimes =0;
        for(int k = 0; k <= userInput; k++){
            if(siftedPan[k] != 0){
                if (verbose){
                    System.out.println(siftedPan[k]);
                }
                numberPrimes++;
            }
        }
        return numberPrimes;
    }

    /**
     * Sifts through an array from 0 to userInput and marks all numbers in array that are not prime. Then outputs
     * the number of primes remaining in the array
     * @param userInput integer representing the number to generate up to
     * @return returns the number of primes calculated
     */
    public static int[] sieve(int userInput){

        //create an array that holds all numbers between 0 and user number

        int [] primes = new int[userInput +1 ];
        for(int i = 0; i <= userInput ; i++){
            primes[i] = i;
        }
        /*follow the process of the "Sieve of Eratosthenes"
        begin with the the first prime, 2, and delete every multiple of the prime from the array,
        then move on to the next number in the array and repeat until the prime number you reach is equal
        to that of the square root of the user inputted number.
        */

        for (int j = 2; j < Math.sqrt(userInput); j++){
            int currentMultiple = 2;
            //get the value of the next prime in the array
            while (primes[j] == 0){
                j++;
            }

            //remove all multiples of the prime
            while ((j * currentMultiple) <= userInput){

                primes[j * currentMultiple] = 0;
                currentMultiple++;

            }

        }

        return primes;
    }
    public static void main(String[] args) {

        String[] inputStrings = getInput();
        int[] output = new int[Integer.parseInt(inputStrings[0]) + 1];
        int numberOfPrimes = 0;

        output = sieve(Integer.parseInt(inputStrings[0]));

        if (inputStrings[1].compareTo("y")== 0){
            numberOfPrimes = countPrimes(output, Integer.parseInt(inputStrings[0]), true);
        }
        else{
            numberOfPrimes = countPrimes(output, Integer.parseInt(inputStrings[0]), false);
        }

        JOptionPane.showMessageDialog(null,"There are " + numberOfPrimes + " primes.");

    }
}
