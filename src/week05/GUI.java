package week05;

import week01.Banner;

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
    private JFileChooser openSaveDialog;
    private FlowLayout layout;
    private RSAFile rsaFile;
    private RSAHelper rsaHelper;
    private final MenuBar menuBar = new MenuBar();
    private final Menu fileMenu = new Menu("File");
    private final Menu helpMenu = new Menu("Help");
    private ArrayList<MenuItem> fileMenuItems;
    private ArrayList<MenuItem> helpMenuItems;
    private static Dimension WINDOW_SIZE = new Dimension(400,400);
    private JTextField seed1,seed2,pubkeyM,pubkeyE,privkeyM,privKeyD;

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
        inFileItem.setName("inFile");
        inFileItem.addActionListener(this);
        MenuItem outFileItem = new MenuItem("Open Output File...");
        outFileItem.setName("outFile");
        outFileItem.addActionListener(this);
        fileMenuItems.add(inFileItem);
        fileMenuItems.add(outFileItem);
    }
    private void addComponents(){
        seed1 = new JTextField("Seed 1",10);
        seed2 = new JTextField("Seed 2",10);
        pubkeyM = new JTextField("Public Key Modulus");
        pubkeyE = new JTextField("Public Key Exponent");
        privkeyM = new JTextField("Private Key Modulus");
        privKeyD = new JTextField("Private Key Exponent");
        add(seed1);
        add(seed2);
        add(pubkeyM);
        add(pubkeyE);
        add(privkeyM);
        add(privKeyD);
        JButton encrypt = new JButton("Encrypt File");
        encrypt.addActionListener(this);
        encrypt.setName("encryptBtn");
        JButton decrypt = new JButton("Decrypt File");
        decrypt.addActionListener(this);
        decrypt.setName("decryptBtn");
        JButton generate = new JButton("Generate Keys");
        generate.addActionListener(this);
        generate.setName("generateBtn");
        add(generate);
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
        if(e.getSource() instanceof MenuItem){
            if(((MenuItem) e.getSource()).getName().equals("inFile")){
                openSaveDialog = new JFileChooser();
                openSaveDialog.showOpenDialog(null);
                inputFile = openSaveDialog.getSelectedFile();
            }
            if(((MenuItem) e.getSource()).getName().equals("outFile")){
                openSaveDialog.showOpenDialog(null);
                outputFile = openSaveDialog.getSelectedFile();
            }
        }

        if(e.getSource() instanceof JButton){
            if(((JButton) e.getSource()).getName().equals("encryptBtn")){
                rsaFile = new RSAFile(inputFile,outputFile,rsaHelper.getEncryptionKey());
                try {
                    rsaFile.openFile();
                    rsaFile.parseFileForEncrypt();
                    rsaFile.encryptFile();
                }
                catch(Exception ex){

                }
            }
            if (((JButton) e.getSource()).getName().equals("generateBtn")){
                rsaHelper = new RSAHelper(Integer.parseInt(seed1.getText()),Integer.parseInt(seed2.getText()));
                rsaHelper.calcInitialValues();
                rsaHelper.generateEncKey();
                rsaHelper.generateDecKey();
                pubkeyM.setText(rsaHelper.getEncryptionKey().getN().toString());
                pubkeyE.setText(rsaHelper.getEncryptionKey().getE().toString());
                privkeyM.setText(rsaHelper.getDecryptionKey().getN().toString());
                privKeyD.setText(rsaHelper.getDecryptionKey().getE().toString());
            }
            if(((JButton) e.getSource()).getName().equals("decryptBtn")){
                rsaFile = new RSAFile(inputFile,outputFile,rsaHelper.getDecryptionKey());
                try{
                    rsaFile.openFile();
                    rsaFile.parseFileForDecrypt();
                    rsaFile.decryptFile();
                }catch(Exception ex){

                }
            }
        }
    }

    public static void main(String[] args) {
        Banner welcome = new Banner("GUI","This program when finished will encrypt a text file and output the result to a new "
                +"file","wesolowskitj");
        JOptionPane.showMessageDialog(null,welcome);
        GUI gui = new GUI();
    }
}
