package week03;

import week01.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.jar.JarFile;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/25/2015 at 3:01 PM.
 */
public class Grid extends JFrame {
    private final int FRAME_HEIGHT = 600;
    private final int FRAME_WIDTH = 600;
    private final int GRID_HEIGHT = 30;
    private final int GRID_WIDTH = 30;
    private EventHandler handler;
    private JLabel label,label2,label3;
    private final GridLayout layout = new GridLayout(3,3);
    private Container container;
    private ArrayList<JButton> gridButtons;

    public Grid(){

        setDefaults();
        populateGrid();
        setVisible(true);
    }
    private void populateGrid(){
         gridButtons = new ArrayList<JButton>();
        for(int i =0; i<9; i++){
            JButton button = new JButton();
            button.setName("Grid spot " +i);
            button.setText("");
            button.setFont(button.getFont().deriveFont(Font.BOLD,70));
            gridButtons.add(button);
        }

        for(JButton button: gridButtons){
            button.addActionListener(handler);
            container.add(button);
        }
    }
    private void setDefaults(){
        setTitle("Test");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        container = getContentPane();
        container.setLayout(new GridLayout(3, 3));
        handler = new EventHandler();
    }
    private void setButtonValue(JButton button){

        if(button.getText().equals("")){
            button.setText("X");
        }
        else if(button.getText().equals("X")){
            button.setText("O");
        }
        else{
            button.setText("");
        }
    }
    private class EventHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                setTitle("You clicked " + ((JButton) e.getSource()).getName());
                setButtonValue((JButton) e.getSource());
            }
        }
    }
}
