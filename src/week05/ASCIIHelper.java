package week05;

import javax.swing.*;
import java.io.File;

/**
 * Created by Owner on 5/1/2015.
 */
public class ASCIIHelper {
    private File file;

    public ASCIIHelper(File textFile) {
        this.file = textFile;
    }

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        ASCIIHelper helper = new ASCIIHelper(chooser.getSelectedFile());
        System.out.println(helper.file.getAbsolutePath());
    }
}