package TicTacToeExpanded;

import java.util.EventListener;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 4/1/2015 at 2:18 PM.
 */
public class TicTacTurnListener implements EventListener {
    private Player source;
    private Grid grid;
    private void nextPlayer(){
        if(source instanceof X){
            grid.setActivePlayer(1);
        }
        else {
            grid.setActivePlayer(0);
        }
    }
    public void turnEnd(TurnEvent e){
        source = (Player) e.getSource();
        nextPlayer();
    }
    TicTacTurnListener(Grid grid){
        this.grid = grid;
    }

}
