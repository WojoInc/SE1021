package week05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Owner on 5/1/2015.
 */
public class GUI extends JFrame implements ActionListener{
    private File inputFile;
    private File outputFile;
    private FileDialog openSaveDialog;
    private FlowLayout layout;
    private RSAHelper rsaHelper;
    private final MenuBar menuBar = new MenuBar();
    private final Menu fileMenu = new Menu("File");
    private final Menu helpMenu = new Menu("Help");
    private ArrayList<MenuItem> fileMenuItems;
    private ArrayList<MenuItem> helpMenuItems;
    private static Dimension WINDOW_SIZE = new Dimension(800,600);

    private void setFrameDefaults(){
        setSize(WINDOW_SIZE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        layout = new FlowLayout();
        setLayout(layout);
    }
    private void configureComponents(){
        fileMenuItems = new ArrayList<MenuItem>();
        helpMenuItems = new ArrayList<MenuItem>();
        MenuItem inFileItem = new MenuItem("Open Input File...");
        inFileItem.addActionListener(this);
        MenuItem outFileItem = new MenuItem("Open Output File...");
        outFileItem.addActionListener(this);
        fileMenuItems.add(inFileItem);
        fileMenuItems.add(outFileItem);
    }
    private void addComponents(){
        JButton encrypt = new JButton("Encrypt File");
        encrypt.addActionListener(this);
        encrypt.setName("encryptBtn");
        JButton decrypt = new JButton("Decrypt File");
        decrypt.addActionListener(this);
        decrypt.setName("decryptBtn");
        add(encrypt);
        add(decrypt);
        for(MenuItem item: fileMenuItems){
            fileMenu.add(item);
        }
        for(MenuItem item: helpMenuItems){
            helpMenu.add(item);
        }
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setMenuBar(menuBar);
    }
    GUI(){
        setFrameDefaults();
        configureComponents();
        addComponents();
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }
}
