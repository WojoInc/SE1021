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

    public void initGame(){
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
        JButton lastmarked = (JButton) board.getActivePlayer().getLastMarkerReference();
        JButton adjacent;
        adjacent = markers.get(markers.indexOf(lastmarked) - 8);
        if( adjacent.getName() != lastmarked.getName() && !adjacent.getName().isEmpty()){
            if(markers.get(markers.indexOf(adjacent)-8).getName().equals(lastmarked.getName())) {
                do {
                    adjacent.setName(board.getActivePlayer().getName());
                    adjacent.setBackground(lastmarked.getBackground());
                    adjacent = markers.get(markers.indexOf(adjacent) - 8);
                } while (adjacent.getBackground() != lastmarked.getBackground());
            }
            System.out.println("Logic works");
        }
        adjacent = markers.get(markers.indexOf(lastmarked) + 8);
        if(adjacent.getName() != lastmarked.getName() && !adjacent.getName().isEmpty()){
            do{
                adjacent.setName(board.getActivePlayer().getName());
                adjacent.setBackground(lastmarked.getBackground());
                adjacent =  markers.get(markers.indexOf(adjacent)+8);
            }while (adjacent.getBackground() != lastmarked.getBackground());
            System.out.println("Logic works");
        }
        adjacent = markers.get(markers.indexOf(lastmarked) - 1);
        if(adjacent.getName() != lastmarked.getName() && !adjacent.getName().isEmpty()){
            do{
                adjacent.setName(board.getActivePlayer().getName());
                adjacent.setBackground(lastmarked.getBackground());
                adjacent =  markers.get(markers.indexOf(adjacent)-1);
            }while (adjacent.getBackground() != lastmarked.getBackground());
            System.out.println("Logic works");
        }
        adjacent = markers.get(markers.indexOf(lastmarked) + 1);
        if(adjacent.getName() != lastmarked.getName() && !adjacent.getName().isEmpty()){
            do{
                adjacent.setName(board.getActivePlayer().getName());
                adjacent.setBackground(lastmarked.getBackground());
                adjacent =  markers.get(markers.indexOf(adjacent)+1);
            }while (adjacent.getBackground() != lastmarked.getBackground());
            System.out.println("Logic works");
        }
        adjacent = markers.get(markers.indexOf(lastmarked) - 9);
        if(adjacent.getName() != lastmarked.getName() && !adjacent.getName().isEmpty()){
                do {
                    adjacent.setName(board.getActivePlayer().getName());
                    adjacent.setBackground(lastmarked.getBackground());
                    adjacent = markers.get(markers.indexOf(adjacent) - 9);
                } while (adjacent.getBackground() != lastmarked.getBackground());
            System.out.println("Logic works");
        }
        adjacent = markers.get(markers.indexOf(lastmarked) - 7);
        if(adjacent.getName() != lastmarked.getName() && !adjacent.getName().isEmpty()){
            do{
                adjacent.setName(board.getActivePlayer().getName());
                adjacent.setBackground(lastmarked.getBackground());
                adjacent =  markers.get(markers.indexOf(adjacent)-7);
            }while (adjacent.getBackground() != lastmarked.getBackground());
            System.out.println("Logic works");
        }
        adjacent = markers.get(markers.indexOf(lastmarked) + 7);
        if(adjacent.getName() != lastmarked.getName() && !adjacent.getName().isEmpty()){
            do{
                adjacent.setName(board.getActivePlayer().getName());
                adjacent.setBackground(lastmarked.getBackground());
                adjacent =  markers.get(markers.indexOf(adjacent)+7);
            }while (adjacent.getBackground() != lastmarked.getBackground());
            System.out.println("Logic works");
        }
        adjacent = markers.get(markers.indexOf(lastmarked) + 9);
        if(adjacent.getName() != lastmarked.getName() && !adjacent.getName().isEmpty()){
            do{
                adjacent.setName(board.getActivePlayer().getName());
                adjacent.setBackground(lastmarked.getBackground());
                adjacent =  markers.get(markers.indexOf(adjacent)+9);
            }while (adjacent.getBackground() != lastmarked.getBackground());
            System.out.println("Logic works");
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
