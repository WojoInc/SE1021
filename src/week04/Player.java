package week04;


import week04.TurnListener;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 4/2/2015 at 12:47 AM
 */
public interface Player{
    public String getName();
    public void setName(String name);
    public void addTurnListener(TurnListener listener);
    public void placeMarker(Object objectRef);
    public Object getLastMarkerReference();
    public Object getMarker();

}
