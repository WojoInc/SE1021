package week04;

import java.awt.*;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 4/4/2015 at 10:24 PM
 */
public enum OthelloMarker {
    BLACK(new Color(0,0,0)),
    WHITE(new Color(255,255,255));
    private Color color;
    public Color getColor(){
        return color;
    }
    OthelloMarker(Color color){
        this.color = color;
    }

}
