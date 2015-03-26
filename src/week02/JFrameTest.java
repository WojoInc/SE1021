package week02;

import javax.swing.*;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/25/2015 at 11:49 PM
 */
public class JFrameTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World!");
        frame.setSize(250,0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
