package week04;


import com.sun.istack.internal.NotNull;
import week03.TurnEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 4/2/2015 at 12:43 AM
 */
public class GameBoard extends Container implements ActionListener{
    private final int GRID_HEIGHT = 30;
    private final int GRID_WIDTH = 30;
    private GridLayout layout;
    private ArrayList<JButton> boardButtons;
    private ArrayList<Player> players;
    private Player activePlayer;

    private void setDefaults(){
        setSize(800,800);
        setBackground(Color.black);
    }

    public ArrayList<JButton> getBoardButtons() {
        return boardButtons;
    }

    private void populateBoard() {
        boardButtons = new ArrayList<JButton>();
        for (int i = 0; i<(layout.getColumns()*layout.getRows()); i++) {
            JButton button = new JButton("Button" + i);
            button.setName("");
            button.setBackground(new Color(0, 255, 0));
            button.addActionListener(this);
            button.setSize(100, 100);
            boardButtons.add(button);
            add(button);
        }
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    GameBoard(@NotNull GridLayout layout, ArrayList<Player> players){
        this.players = players;
        this.layout = layout;
        this.setLayout(layout);
        setDefaults();

        populateBoard();
        setVisible(true);

    }
    public void setActivePlayer(Player player){
        this.activePlayer = player;
    }
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.getContentPane().add(new GameBoard(new GridLayout(8,8),null));
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(((JButton) e.getSource()).getName().equals("")){
            activePlayer.placeMarker((JButton) e.getSource());
        }

    }
}
