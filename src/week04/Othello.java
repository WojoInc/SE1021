package week04;

import week03.TurnEvent;

import javax.jnlp.JNLPRandomAccessFile;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 4/2/2015 at 12:26 AM
 */
public class Othello implements TurnListener{
    private static GameBoard board;
    private static ArrayList<Player> players;
    private static JButton[][] buttons;
    public enum AdjacentMarkers {
        topleft(-9),
        //top(-8),
        topRight(-7),
        //left(-1),
        //right(1),
        bottomLeft(7),
       // bottom(8),
        bottomRight(9);
        private int increment;
        public int getIncrement(){
            return increment;
        }
        AdjacentMarkers(int increment) {
            this.increment = increment;
        }
    }
    public void initGame(){
        buttons = new JButton[8][8];
        BlackChip blackChip = new BlackChip("TJ");
        blackChip.addTurnListener(this);
        WhiteChip whiteChip = new WhiteChip("Anna");
        whiteChip.addTurnListener(this);
        players = new ArrayList<Player>();
        players.add(blackChip);
        players.add(whiteChip);
        OthelloGUI gui = new OthelloGUI(players);
        board = new GameBoard(new GridLayout(8, 8), players);
        gui.setContentPane(board);
        board.setActivePlayer(players.get(0));
    }
    public void flipMarkers(Player player){
        ArrayList<JButton> markers = board.getBoardButtons();
        ArrayList<JButton> toFlip = new ArrayList<JButton>();
        JButton lastmarked = (JButton) board.getActivePlayer().getLastMarkerReference();
        JButton currentButton;
        JButton endButton = new JButton();
        int location =0;
        boolean terminate = false;
        int increment= 0;
        int currentLocation=0;
        int a=0;
        for(JButton button: markers){
            if(button.equals(lastmarked)){
              location =a;
            }
            a++;
        }
        markers.get(location).setBackground(((OthelloMarker) player.getMarker()).getColor());
        markers.get(location).setName(player.getName());
        for(AdjacentMarkers marker: AdjacentMarkers.values()){
            increment = marker.getIncrement();
            switch (increment) {
                default:
                    currentLocation = location+ increment;
                    currentButton = markers.get(currentLocation);
                    for(currentLocation=currentLocation;currentLocation<64 &&currentLocation>-1; currentLocation+=increment) {
                        currentButton = markers.get(currentLocation);
                        if (!markers.get(currentLocation).getName().equals(player.getName()) && !markers.get(currentLocation).getText().equals("")) {
                            toFlip.add(currentButton);
                        }
                        if (currentButton.getName().equals(player.getName()) && terminate == false) {
                            terminate = true;
                            endButton = currentButton;
                        }
                    }
                    if(terminate){
                        int i =0;
                        do{
                            currentButton = toFlip.get(i);
                            currentButton.setBackground(OthelloMarker.BLACK.getColor());
                            currentButton.setName(player.getName());
                            i++;
                        }while(!currentButton.getName().equals(player.getName()));
                    }
            }
        }


    }

    public Othello(){
        initGame();
    }

    @Override
    public void nextPlayer(Player player) {
        if (player.getMarker().equals(OthelloMarker.BLACK)) {
            board.setActivePlayer(players.get(1));
        } else {
            board.setActivePlayer(players.get(0));
        }
    }

    @Override
    public void turnEnd(TurnEvent e) {
        flipMarkers((Player) e.getSource());
        nextPlayer((Player) e.getSource());
    }

}
