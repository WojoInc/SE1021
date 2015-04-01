package week03;

import week01.Banner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.EventListener;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/25/2015 at 3:15 PM.
 */
public class TicTacToe {
    private static TurnListener eventHandler;
    private static Grid grid;
    private static ArrayList<Player> players;
    public static void initPlayers(){
        players = new ArrayList<Player>();
        players.add(new X(JOptionPane.showInputDialog("Please input the name of player 1 (X)")));
        players.add(new O(JOptionPane.showInputDialog("Please input the name of player 2 (O)")));
        eventHandler = new TurnListener(grid);
        players.get(0).addTurnListener(eventHandler);
        players.get(1).addTurnListener(eventHandler);

    }
    public static void initGrid(){
        grid.setPlayers(players);
        grid.setActivePlayer(0);
        grid.initFrame();
    }
    public static void main(String[] args) {
        grid = new Grid();
        initPlayers();
        initGrid();
    }
}
