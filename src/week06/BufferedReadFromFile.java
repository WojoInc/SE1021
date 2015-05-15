package week06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Project: SE1021
 * Class: BufferedReadFromFile
 * Purpose:
 * Created by Owner on 5/15/2015 at 2:42 PM.
 */
public class BufferedReadFromFile {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String fileName;
        System.out.println("Enter filename: ");
        fileName = stdIn.nextLine();
        try (Scanner fileIn = new Scanner(new BufferedReader(Files.newBufferedReader(Paths.get(fileName),
                Charset.defaultCharset())))){
            while(fileIn.hasNext()){
                System.out.println(fileIn.nextLine());
            }
        }
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}
