package week04;

import week03.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 4/2/2015 at 12:51 AM
 */
public class OthelloGUI extends JFrame {
    private final int FRAME_HEIGHT = 800;
    private final int FRAME_WIDTH = 800;

    private void setDefaults(){
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    OthelloGUI(ArrayList<Player> players){
        setDefaults();

        setVisible(true);
    }
}
