package week03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 4/1/2015 at 3:20 PM.
 */
public class GameMenu extends java.awt.MenuBar {
    MenuItem changeName;
    Menu playerMenu;
    ArrayList<Menu> playerMenus;
    GameMenu(final ArrayList<Player> players){
        playerMenus = new ArrayList<Menu>();
        for(final Player player: players){
            playerMenu = new Menu(player.getName() + " (" + player.getMarker() + ")");
            changeName = new MenuItem("Change Name");
            changeName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    String newName;
                    try{
                        newName = JOptionPane.showInputDialog("Please type the new name: ");
                        if(newName.length()<1){
                            throw new EmptyStringException("Please Enter a name: ");
                        }
                        MenuItem change = (MenuItem) e.getSource();
                        Menu parentMenu = (Menu) change.getParent();
                        parentMenu.setLabel(newName + " (" +player.getMarker() + ")");
                        player.setName(newName);
                        players.set(players.indexOf(player), player);
                    }
                    catch(EmptyStringException ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }
            });
            playerMenu.add(changeName);
            playerMenus.add(playerMenu);
        }
        for(Menu menu: playerMenus){
            add(menu);
        }
    }
}
