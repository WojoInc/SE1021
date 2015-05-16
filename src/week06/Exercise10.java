package week06;

import sun.nio.fs.Globs;
import week04.Player;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 5/15/2015 at 8:22 PM
 */
public class Exercise10 {
    public static void main(String[] args) {
        Path filePath = Paths.get("Zapata");
        File directory = new File("MexicanHistory");
        Path dirPath;
        if(!directory.exists()) {
            directory.mkdir();
        }
        dirPath = Paths.get(directory.getAbsolutePath());
        try {
            System.out.println(dirPath.resolve(filePath));
            Files.move(filePath, dirPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
        }
        catch(IOException ex){
            ex.getMessage();
        }
    }
}
