package week03;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    GameMenu(ArrayList<Player> players){
        playerMenus = new ArrayList<Menu>();
        for(Player player: players){
            playerMenu = new Menu(player.getName() + " (" + player.getMarker() + ")");
            changeName = new MenuItem("Change Name");
            changeName.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

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
