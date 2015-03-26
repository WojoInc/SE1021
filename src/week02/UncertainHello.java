package week02;

import javax.swing.*;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/25/2015 at 11:43 PM
 */
public class UncertainHello {
    public static void main(String[] args) {
        String name;
        int response;
        do {
            name = JOptionPane.showInputDialog("What's your name? ");
            response = JOptionPane.showConfirmDialog(null,"Are you sure?");
            if(response == JOptionPane.NO_OPTION){
                name = "there";
                break;
            }
        }while(response == JOptionPane.CANCEL_OPTION);
        System.out.println("Hello " + name);
    }
}
