package week06;

import TicTacToeExpanded.O;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 5/15/2015 at 8:03 PM
 */
public class Exercise9 {
    public static void main(String[] args) {
        String fileName = "Zapata";
        String text = "It is better to die on your feet than live on your knees.";
        Path filePath = Paths.get(fileName);
        byte[] byteArray = text.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(byteArray);

        try(FileChannel channel = FileChannel.open(filePath, StandardOpenOption.CREATE_NEW,StandardOpenOption.WRITE)){
            channel.write(buffer);
        }
        catch (IOException ex){
            ex.getMessage();
        }

    }
}
