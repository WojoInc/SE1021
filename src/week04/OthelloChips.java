package week04;

import week03.TurnEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 4/4/2015 at 10:57 PM
 */
public abstract class OthelloChips implements Player {
    protected String name;
    protected week04.TurnListener listener;
    protected TurnEvent event;
    protected OthelloMarker marker;
    protected Object markerRef;

    @Override
    public Object getLastMarkerReference() {
        return markerRef;
    }

    public static void main(String[] args) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addTurnListener(TurnListener listener) {
        this.listener = listener;
    }

    @Override
    public void placeMarker(Object objectRef) {
        //((JButton) objectRef).setBackground(marker.getColor());
        //((JButton) objectRef).setName(getName());
        this.markerRef = objectRef;
        listener.turnEnd(event);
    }

    @Override
    public Object getMarker() {
        return marker;
    }

    public OthelloChips(String name, OthelloMarker marker) {
        this.name = name;
        this.marker = marker;
        this.event = new TurnEvent(this);

    }
}
