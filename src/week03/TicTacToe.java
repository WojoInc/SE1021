package week03;

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
    public static void main(String[] args) {
        eventHandler = new EventHandler();
        grid = new Grid();
        x = new X("Player 1");
        o = new O("Player 2");
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
