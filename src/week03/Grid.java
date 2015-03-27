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
    private final GridLayout layout = new GridLayout(3,3);
    private Container container;
    private ArrayList<JButton> gridButtons;
    private Player player;

    public Grid(){
        setDefaults();
        populateGrid();
        setVisible(true);
    }
    private void checkWin(int gridSpot){
        boolean[] buttons = new boolean[9];
        int i=0;
        for(JButton button: gridButtons){
            if(button.getText().equals(player.getMarker())){
                buttons[i] = true;
            }
            i++;
        }
        for(int j = 0; j<3; j++) {
            if (buttons[j] && buttons[j+3] && buttons[j+6]){
                JOptionPane.showMessageDialog(this,player.getName() + " Wins");
                populateGrid();
            }
        }
        for(int k = 0; k<7; k+=3){
            if (buttons[k] && buttons[k+1] && buttons[k+2]){
                JOptionPane.showMessageDialog(this,player.getName() + " Wins");
                populateGrid();
            }
        }

    }
    private void populateGrid(){
         gridButtons = new ArrayList<JButton>();
        for(int i =0; i<9; i++){
            JButton button = new JButton();
            button.setName("Grid spot: "+i);
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
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        container = getContentPane();
        container.setLayout(new GridLayout(3, 3));
        handler = new EventHandler();
    }
    public void setActivePlayer(Player player){
        this.player = player;
    }
    public Player getActivePlayer(){
        return this.player;
    }
    private void setButtonValue(JButton button){
        if(!button.getText().equals("O") && !button.getText().equals("X")){
            player.placeMarker(button);
            checkWin(gridButtons.indexOf(button));
            player.endTurn();
        }
    }
    private class EventHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                setTitle(player.getName() +" clicked " + ((JButton) e.getSource()).getName());
                setButtonValue((JButton) e.getSource());

            }
        }
    }

}
