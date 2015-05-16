package week06;

import week04.Player;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 5/15/2015 at 9:00 PM
 */
public class FileVisitor extends SimpleFileVisitor<Path> {
    private PathMatcher matcher;
    private int tab = 0;
    public FileVisitor(String syntaxAndPattern){
        FileSystem system = FileSystems.getDefault();
        this.matcher = system.getPathMatcher(syntaxAndPattern);
    }

  /*  @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        for (int i = 0; i < tab; i++) {
            System.out.println(" ");
        }
        tab++;
        System.out.println(dir.getFileName());
        return FileVisitResult.CONTINUE;
    }
*/
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path name = file.getFileName();
        if(name != null && matcher.matches(name)){
            name = name.toAbsolutePath();
            System.out.printf("-%25s%6d bytes\n",name,Files.size(file));
        }

        return FileVisitResult.SKIP_SUBTREE;
    }

  /*  @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        tab--;
        return FileVisitResult.CONTINUE;
    }
    */
}
