package TicTacToeExpanded;

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
    private GameMenu mb;
    private Menu optionsMenu;
    private Menu lastActionLabel;
    private MenuItem reset;

    private EventHandler handler;
    private Container container;
    private ArrayList<JButton> gridButtons;
    private ArrayList<Player> players;
    private Player player;

    public Grid(){
    }
    private void checkWin(){
        boolean[] buttons = new boolean[9];
        int i=0;
        int draw=0;
        boolean win = false;
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
                win = true;
                setGridState(false);
            }
        }
        for(int k = 0; k<7; k+=3){
            if (buttons[k] && buttons[k+1] && buttons[k+2]){
                JOptionPane.showMessageDialog(this, player.getName() + " Wins");
                win = true;
                setGridState(false);
            }
        }
        if(buttons[0] && buttons[4] && buttons[8]){
            JOptionPane.showMessageDialog(this,player.getName() + " Wins");
            win = true;
            setGridState(false);
        }
        if(buttons[2] && buttons[4] && buttons[6]){
            JOptionPane.showMessageDialog(this,player.getName() + " Wins");
            win = true;
            setGridState(false);
        }
        if(draw==5 && win==false){
            JOptionPane.showMessageDialog(this,"The only way to win is not to play...");
            setGridState(false);

        }

    }
    private void setGridState(boolean state){
        if(!state){
            for(Menu parent: mb.playerMenus){
                if(!parent.getItem(1).isEnabled()){
                    parent.getItem(1).setEnabled(true);
                }
            }
        }
        for (Component component : getContentPane().getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setEnabled(state);
            }
        }
    }
    private void resetGrid(){
        for(Menu parent: mb.playerMenus){
            if(!parent.getItem(1).isEnabled()){
                parent.getItem(1).setEnabled(true);
            }
        }
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
    public void initFrame(){
        mb = new GameMenu(players);
        lastActionLabel = new Menu("Last Move: ");
        optionsMenu = new Menu("Options");
        reset = new MenuItem("Reset...");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGrid();
            }
        });
        optionsMenu.add(reset);
        mb.add(optionsMenu);
        mb.add(lastActionLabel);
        setMenuBar(mb);
        setTitle("Test");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        container = getContentPane();
        container.setLayout(new GridLayout(3, 3));
        handler = new EventHandler();
        populateGrid();
        setVisible(true);
    }
    public void setPlayers(ArrayList<Player> players){
        this.players = players;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setActivePlayer(int player){
        this.player = players.get(player);
    }
    public Player getActivePlayer(){
        return this.player;
    }
    private void setButtonValue(JButton button){
        if(!button.getText().equals("O") && !button.getText().equals("X")){
            player.placeMarker(button);
            checkWin();
            player.endTurn();
        }
    }
    private class EventHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() instanceof JButton){
                for(Menu parent: mb.playerMenus){
                    if(parent.getItem(1).isEnabled()){
                    parent.getItem(1).setEnabled(false);
                    }
                }
                lastActionLabel.setLabel("Last Move: " + player.getName() +" clicked " + ((JButton) e.getSource()).getName());
                setButtonValue((JButton) e.getSource());

            }
        }
    }

}
