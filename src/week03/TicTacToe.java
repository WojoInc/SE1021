package week03;

import week01.Banner;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

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
    private JOptionPane optionPane;
    public static void initPlayers(){
        boolean done1 = false, done2 = false;
        players = new ArrayList<Player>();
        while (!done1) {
            try {
                String input;
                input = JOptionPane.showInputDialog("Please input the name of player 1 (X)");
                if(input.isEmpty()) throw new EmptyStringException("Please enter a name for player 1!");
                players.add(new X(input));
                done1 = true;
            } catch (EmptyStringException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            catch (NullPointerException ex){
                Runtime.getRuntime().exit(-1);

            }
        }
        while (!done2){
            try {
                String input;
                input = JOptionPane.showInputDialog("Please input the name of player 2 (O)");
                if(input.isEmpty()) throw new EmptyStringException("Please enter a name for player 2!");
                players.add(new O(input));
                done2 = true;
            } catch (EmptyStringException ex) {
                JOptionPane.showMessageDialog(null,ex.getMessage());
            }
            catch (NullPointerException ex){
                Runtime.getRuntime().exit(-1);
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
        Banner welcome = new Banner("TicTacToe","A java implementation of a TicTacToe game.","wesolowskitj");
        JOptionPane.showMessageDialog(null,welcome,welcome.getTitle(),JOptionPane.INFORMATION_MESSAGE);
        grid = new Grid();
        initPlayers();
        initGrid();

    }
}
