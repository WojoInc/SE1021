package week04;

import week03.TurnEvent;


/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 4/4/2015 at 10:14 PM
 */
public interface TurnListener {
    public void nextPlayer(Player player);
    public void turnEnd(TurnEvent e);
}
