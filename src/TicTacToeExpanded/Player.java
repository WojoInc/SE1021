package TicTacToeExpanded;

import javax.swing.*;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/26/2015 at 2:07 PM.
 */
public class Player{
    protected String name;
    protected String marker;
    protected TicTacTurnListener turnListener;
    protected TurnEvent event;
    public void addTurnListener(TicTacTurnListener listener){
        this.turnListener = listener;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public String getName(){
        return name;
    }

    public void placeMarker(JButton button){
        button.setText(marker);
    }
    public void endTurn(){
        event = new TurnEvent(this);
        turnListener.turnEnd(event);
    }

    public String getMarker() {
        return marker;
    }

    public String toString(){
        return getName();

    }
}
