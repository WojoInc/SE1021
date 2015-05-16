package week06;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 5/15/2015 at 9:43 PM
 */
public class DirectoryDescription {
    public static void main(String[] args) {
        Path pathToDirectory = Paths.get(".");
        String pattern;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter file pattern: ");
        pattern = scanner.nextLine();
        FileSystem fs = FileSystems.getDefault();
        PathMatcher matcher = fs.getPathMatcher("glob:" + pattern);
        try(DirectoryStream<Path>  paths = Files.newDirectoryStream(pathToDirectory))
        {
            for(Path path: paths){
                if(matcher.matches(path.getFileName())) {
                    System.out.printf("%-30s%6d bytes\n", path.getFileName(), Files.size(path));
                }
            }
        }
        catch (IOException ex){
            ex.getClass();
            ex.getMessage();
        }
    }
}
