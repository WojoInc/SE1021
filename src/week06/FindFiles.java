package week06;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 5/15/2015 at 8:52 PM
 */
public class FindFiles {
    public static void main(String[] args) {
        Path startDir;
        Scanner stdIn = new Scanner(System.in);
        String pattern;
        FileVisitor visitor;
        System.out.println("Enter the absolute path to the starting directory: ");
        startDir = Paths.get(stdIn.nextLine());
        System.out.println("Enter filename search pattern: ");
        pattern = stdIn.nextLine();

        visitor = new FileVisitor("glob:"+ pattern);
        try{
            Files.walkFileTree(startDir,visitor);
        }
        catch (IOException ex){
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
        }
    }
}
