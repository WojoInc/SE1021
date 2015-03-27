package week03;

import com.sun.xml.internal.ws.api.Component;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/26/2015 at 2:07 PM.
 */
public class Player implements ChangeListener{
    protected String name;
    protected String marker;
    protected ChangeListener changeListener;
    protected ChangeEvent event;
    public void addChangeListener(ChangeListener listener){
        this.changeListener = listener;
    }
    public String getName(){
        return name;
    }

    public void placeMarker(JButton button){
        button.setText(marker);
    }
    public void endTurn(){
        event = new ChangeEvent(this);
        changeListener.stateChanged(event);
    }

    public String getMarker() {
        return marker;
    }

    public String toString(){
        return getName();

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }
}
