package TicTacToeExpanded;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/25/2015 at 3:15 PM.
 */
public class TicTacToe {
    private static TicTacTurnListener eventHandler;
    private static Grid grid;
    private static ArrayList<Player> players;
    public static void initPlayers() {
        boolean done1 = false, done2 = false;
        players = new ArrayList<Player>();
        while (!done1) {
            try {
                String input = "";
                input = JOptionPane.showInputDialog("Please input the name of player 1 (X)");
                if(input.equals("")) {
                    throw new EmptyStringException("Please enter a name!");
                }
                players.add(new X(input));
                done1 = true;
            } catch (EmptyStringException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
        while (!done2){
            try {
                String input;
                input = JOptionPane.showInputDialog("Please input the name of player 2 (O)");
                if(input.isEmpty()) throw new EmptyStringException("Please enter a name!");
                players.add(new O(input));
                done2 = true;
            } catch (EmptyStringException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
        }
            eventHandler = new TicTacTurnListener(grid);
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
