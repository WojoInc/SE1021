package week02;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/25/2015 at 11:56 PM
 */
public class BigHello extends JFrame{
    public BigHello(){
        JLabel label = new JLabel("Hello World!");
        setSize(200,100);
        setLayout(new FlowLayout());
        add(label);
        label.setFont(label.getFont().deriveFont(Font.ITALIC, 30));
        label.setToolTipText("Life is great!");
        label.setBorder(BorderFactory.createRaisedBevelBorder());
        setVisible(true);
    }
    public static void main(String[] args) {
        BigHello hello = new BigHello();
    }
}
