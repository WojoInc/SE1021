package week03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private java.awt.MenuBar mb;
    private java.awt.Menu optionsMenu;
    private java.awt.MenuItem reset;
    private EventHandler handler;
    private final GridLayout layout = new GridLayout(3,3);
    private Container container;
    private ArrayList<JButton> gridButtons;
    private Player player;

    public Grid(){
        initFrame();
        populateGrid();
        setVisible(true);
    }
    private void checkWin(int gridSpot){
        boolean[] buttons = new boolean[9];
        int i=0;
        int draw=0;
        for(JButton button: gridButtons){
            if(button.getText().equals(player.getMarker())){
                buttons[i] = true;
                draw++;
            }
            i++;
        }
        for(int j = 0; j<3; j++) {
            if (buttons[j] && buttons[j+3] && buttons[j+6]){
                JOptionPane.showMessageDialog(this,player.getName() + " Wins");
                gridState(false);
            }
        }
        for(int k = 0; k<7; k+=3){
            if (buttons[k] && buttons[k+1] && buttons[k+2]){
                JOptionPane.showMessageDialog(this, player.getName() + " Wins");
                gridState(false);
            }
        }
        if(buttons[0] && buttons[4] && buttons[8]){
            JOptionPane.showMessageDialog(this,player.getName() + " Wins");
            gridState(false);
        }
        if(buttons[2] && buttons[4] && buttons[6]){
            JOptionPane.showMessageDialog(this,player.getName() + " Wins");
            gridState(false);
        }
        if(draw==5){
            JOptionPane.showMessageDialog(this,"The only way to win is not to play...");
            gridState(false);

        }

    }
    private void gridState(boolean state){
        for (Component component : getContentPane().getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setEnabled(state);
            }
        }

    }
    private void resetGrid(){
        for(Component component: getContentPane().getComponents()){
            if(component instanceof JButton)
                ((JButton) component).setText("");
                ((JButton) component).setEnabled(true);
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
    private void initFrame(){
        optionsMenu = new Menu("Options");
        mb = new MenuBar();
        reset = new MenuItem("Reset...");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGrid();
            }
        });
        optionsMenu.add(reset);
        mb.add(optionsMenu);
        setMenuBar(mb);
        setTitle("Test");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);

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
