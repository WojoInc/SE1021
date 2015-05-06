package week05;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Owner on 5/1/2015.
 */
public class GUI extends Frame implements ActionListener{
    private File inputFile;
    private File outputFile;
    private FileDialog openSaveDialog;
    private static Dimension WINDOW_SIZE = new Dimension(800,600);

    private void setFrameDefaults(){
        setSize(WINDOW_SIZE);
    }
    GUI(){
        setFrameDefaults();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
