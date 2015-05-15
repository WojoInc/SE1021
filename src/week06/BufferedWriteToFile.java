package week06;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * Project: SE1021
 * Class: BufferedWriteToFile
 * Purpose:
 * Created by Owner on 5/15/2015 at 2:06 PM.
 */
public class BufferedWriteToFile {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String fileName, openOption;
        System.out.println("Enter filename: ");
        fileName = stdIn.nextLine();
        System.out.print("Enter TRUNCATE_EXISTING or APPEND: ");
        openOption = stdIn.nextLine();

        try (PrintWriter fileOut = new PrintWriter(new BufferedWriter(Files.newBufferedWriter(Paths.get(fileName),
                Charset.defaultCharset(),
                StandardOpenOption.CREATE,
                StandardOpenOption.valueOf(openOption))))){
            System.out.println("Enter a line of text: ");
            fileOut.write(stdIn.nextLine() + "\n");
        }
        catch (Exception e){
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
    }
}
