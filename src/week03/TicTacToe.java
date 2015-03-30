package week03;

import week01.Banner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/25/2015 at 3:15 PM.
 */
public class TicTacToe {
    private static EventHandler eventHandler;
    private static Grid grid;
    private static X x;
    private static O o;
    public static void initGame(){
        x = new X(JOptionPane.showInputDialog("Please input the name of player 1 (X)"));
        o = new O(JOptionPane.showInputDialog("Please input the name of player 2 (O)"));
    }
    public static void main(String[] args) {
        initGame();
        eventHandler = new EventHandler();
        grid = new Grid();
        x.addChangeListener(eventHandler);
        o.addChangeListener(eventHandler);
        grid.setActivePlayer(x);

    }
    public static class EventHandler implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {
            if(grid.getActivePlayer().getMarker() == "O"){
                grid.setActivePlayer(x);
            }
            else{
                grid.setActivePlayer(o);
            }
        }
    }
}
