package week05;

import week01.Banner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Purpose: GUI that provides the user with options to choose files and textfields to enter values used to generate keys
 * for use with the RSAHelper class for the purpose of encrypting and decrypting ASCII text files
 * Created by wesolowskitj on 5/1/2015.
 */
public class GUI extends JFrame implements ActionListener{
    private final Dimension WINDOW_SIZE = new Dimension(400,400);
    private File inputFile;
    private File outputFile;
    private JFileChooser openSaveDialog = new JFileChooser();
    private SpringLayout layout;
    private RSAFile rsaFile;
    private RSAHelper rsaHelper;
    private final MenuBar menuBar = new MenuBar();
    private final Menu fileMenu = new Menu("File");
    private final Menu helpMenu = new Menu("Help");
    private JTextField seed1,seed2,pubkeyM,pubkeyE,privkeyM,privKeyD;
    private JButton encrypt,decrypt,generate;
    private JLabel lblSeed1,lblSeed2,lblpubM,lblpubE,lblprvM,lblprvD;
    private ArrayList<MenuItem> fileMenuItems;
    private ArrayList<MenuItem> helpMenuItems;
    private ArrayList<JTextField> textFields = new ArrayList<JTextField>();
    private ArrayList<JButton> buttons = new ArrayList<JButton>();
    private ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private NumberListener numberListener = new NumberListener();

    /**
     * configures defualt values such as size and location for the GUI
     */
    private void setFrameDefaults(){
        setSize(WINDOW_SIZE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("jRSA GUI");
        setLocation(400, 400);
        setResizable(false);
        layout = new SpringLayout();
        layout.preferredLayoutSize(this.getContentPane());
        setLayout(layout);
    }

    /**
     * configures and add objects to the GUI Menus
     */
    private void configureMenus(){
        fileMenuItems = new ArrayList<MenuItem>();
        helpMenuItems = new ArrayList<MenuItem>();
        MenuItem inFileItem = new MenuItem("Open Input File...");
        inFileItem.setName("inFile");
        MenuItem outFileItem = new MenuItem("Open Output File...");
        outFileItem.setName("outFile");
        MenuItem about = new MenuItem("About...");
        about.setName("about");
        fileMenuItems.add(inFileItem);
        fileMenuItems.add(outFileItem);
        helpMenuItems.add(about);

        for(MenuItem item: fileMenuItems){
            item.addActionListener(this);
            fileMenu.add(item);
        }
        for(MenuItem item: helpMenuItems){
            item.addActionListener(this);
            helpMenu.add(item);
        }
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setMenuBar(menuBar);
    }

    /**
     * configures all buttons, labels, and textfields and add them to their respective lists
     */
    private void configureComponents(){
        seed1 = new JTextField("Seed 1",15);
        seed2 = new JTextField("Seed 2",15);
        pubkeyM = new JTextField("Public Key Modulus",15);
        pubkeyE = new JTextField("Public Key Exponent",15);
        privkeyM = new JTextField("Private Key Modulus",15);
        privKeyD = new JTextField("Private Key Exponent",15);

        textFields.add(seed1);
        textFields.add(seed2);
        textFields.add(pubkeyM);
        textFields.add(pubkeyE);
        textFields.add(privkeyM);
        textFields.add(privKeyD);
        for (JTextField t: textFields){
            t.addKeyListener(numberListener);
        }

        encrypt = new JButton("Encrypt File");
        encrypt.setName("encryptBtn");
        decrypt = new JButton("Decrypt File");
        decrypt.setName("decryptBtn");
        generate = new JButton("Generate Keys");
        generate.setName("generateBtn");
        buttons.add(generate);
        buttons.add(encrypt);
        buttons.add(decrypt);
        for(JButton b: buttons){
            b.addActionListener(this);
        }

        lblSeed1 = new JLabel("P-Seed Value:");
        lblSeed2 = new JLabel("Q-Seed Value:");
        lblpubM = new JLabel("Encryption Key Modulus:");
        lblpubE = new JLabel("Encryption Key Exponent:");
        lblprvM = new JLabel("Decryption Key Modulus:");
        lblprvD= new JLabel("Decryption Key Exponent:");
        labels.add(lblSeed1);
        labels.add(lblSeed2);
        labels.add(lblpubM);
        labels.add(lblpubE);
        labels.add(lblprvM);
        labels.add(lblprvD);

    }

    /**
     * configures the layout manager to properly align the various components of the frame using SpringLayout as the
     * layout manager
     */
    private void configureLayout(){
        int padding = 10;
        for(JTextField t: textFields){
            layout.putConstraint(SpringLayout.EAST,t,-20,SpringLayout.EAST,this.getContentPane());
            layout.putConstraint(SpringLayout.NORTH, t, padding, SpringLayout.NORTH, this.getContentPane());
            padding+=30;
        }
        padding = 10;
        for(JLabel l: labels){
            layout.putConstraint(SpringLayout.EAST,l,-10,SpringLayout.WEST,pubkeyM);
            layout.putConstraint(SpringLayout.NORTH, l, padding, SpringLayout.NORTH, this.getContentPane());
            padding+=30;
        }
        padding = 40;
        for(JButton b : buttons) {
            layout.putConstraint(SpringLayout.EAST, b, -20, SpringLayout.EAST, this.getContentPane());
            layout.putConstraint(SpringLayout.NORTH, b, padding, SpringLayout.NORTH, privKeyD);
        padding+=40;
    }
}

    /**
     * adds all buttons, labels and textfields to the frame
     */
    private void addComponents(){
        for (JTextField t: textFields){
        add(t);
        }
        for(JButton b: buttons){
        add(b);
        }
        for(JLabel l: labels){
        add(l);
        }
        }
    GUI(){
        setFrameDefaults();
        configureMenus();
        configureComponents();
        addComponents();
        configureLayout();
        setVisible(true);
        }

    /**
     * overrides actionPerformed method, acts as a listener for all components of the frame, including buttons, textfields,
     * and menus
     * @param e the event trigger
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof MenuItem){
            if(((MenuItem) e.getSource()).getName().equals("inFile")){
                openSaveDialog.showOpenDialog(this);
                inputFile = openSaveDialog.getSelectedFile();
            }
            if(((MenuItem) e.getSource()).getName().equals("outFile")){
                openSaveDialog.showOpenDialog(this);
                outputFile = openSaveDialog.getSelectedFile();
            }
            if(((MenuItem) e.getSource()).getName().equals("about")){
                JOptionPane.showMessageDialog(this,"jRSA 1.3 created by TJ Wesolowski","About",JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if(e.getSource() instanceof JButton){
            if(((JButton) e.getSource()).getName().equals("encryptBtn")){

                try {
                    rsaFile = new RSAFile(inputFile,outputFile,new Key(new BigInteger(pubkeyM.getText()),new BigInteger(pubkeyE.getText())));
                    rsaFile.openFile();
                    rsaFile.parseFileForEncrypt();
                    rsaFile.encryptFile();
                }
                catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(this,ex.getMessage() + "\nPlease make sure that both: \n" + lblpubM.getText()
                    + "\n" + lblpubE.getText() + "\n have correct values entered!");
                }
                catch (ArrayIndexOutOfBoundsException ex){
                    JOptionPane.showMessageDialog(this,ex.getMessage() +"\nIncorrect buffer size, please verify file integrity and restart program");
                }
                catch(IOException ex){
                    JOptionPane.showMessageDialog(this, ex.getMessage() + "\nPlease choose the correct file");
                    openSaveDialog.showOpenDialog(this);
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
                rsaFile = new RSAFile(inputFile,outputFile,new Key(new BigInteger(privkeyM.getText()),new BigInteger(privKeyD.getText())));
                try{
                    rsaFile.openFile();
                    rsaFile.parseFileForDecrypt();
                    rsaFile.decryptFile();
                }catch(Exception ex){

                }
            }
        }
    }

    /**
     * main method that displays a welcome banner and then proceeds to load and display the GUI frame
     * @param args commandline args
     */
    public static void main(String[] args) {
        Banner welcome = new Banner("GUI","This program when finished will encrypt a text file and output the result to a new "
                +"file","wesolowskitj");
        JOptionPane.showMessageDialog(null,welcome);
        GUI gui = new GUI();
    }

    /**
     * class that acts as a listener for keystrokes, can be added to a text field via JTextField.addKeyListener()
     * This implementation filters out any keystroke that is not a number or backspace, allowing only numbers to be inputted
     * into a textfield
     */
    public class NumberListener extends KeyAdapter{
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if(((c<'0') || (c>'9')) && c != KeyEvent.VK_BACK_SPACE) {
                e.consume();
            }
            else{
                super.keyTyped(e);
            }
        }
    }
}
