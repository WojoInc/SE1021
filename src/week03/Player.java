package week03;

import javax.swing.*;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * Created by wesolowskitj on 3/26/2015 at 2:07 PM.
 */
public class Player{
    protected String name;
    protected String marker;
    protected TicTacTurnListener turnListener;
    protected TurnEvent event;

    /**
     * adds a turn listener to the player.
     * @param listener the listener object to add
     */
    public void addTurnListener(TicTacTurnListener listener){
        this.turnListener = listener;
    }

    /**
     * sets the name of the player
     * @param name the player's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set the string to be used as the player's marker
     * @param marker the string to be used
     */
    public void setMarker(String marker) {
        this.marker = marker;
    }

    /**
     * return the name of the player
     * @return player's name as a string
     */
    public String getName(){
        return name;
    }

    /**
     * sets the particular buttons text value to the player's marker
     * @param button the button to set
     */
    public void placeMarker(JButton button){
        button.setText(marker);
    }

    /**
     * ends the players turn and passes @this to the turn listener
     */
    public void endTurn(){
        event = new TurnEvent(this);
        turnListener.turnEnd(event);
    }

    /**
     * returns the player's marker
     * @return the player's current marker
     */
    public String getMarker() {
        return marker;
    }

    /**
     * toString override that returns the player's name
     * @return the player's name
     */
    public String toString(){
        return getName();

    }
}
