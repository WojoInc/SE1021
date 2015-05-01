package TicTacToeExpanded;

import javax.swing.*;
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
public class GameMenu extends MenuBar {
    MenuItem changeName;
    MenuItem changeMarker;
    Menu playerMenu;
    ArrayList<Menu> playerMenus;
    GameMenu(final ArrayList<Player> players){
        playerMenus = new ArrayList<Menu>();
        for(final Player player: players){
            playerMenu = new Menu(player.getName() + " (" + player.getMarker() + ")");
            changeName = new MenuItem("Change Name...");
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
                    catch (NullPointerException ex){
                        System.out.println("User cancelled changes.");
                    }
                }
            });
            changeMarker = new MenuItem("Change Marker...");
            changeMarker.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String newMarker;
                    try {
                        newMarker = JOptionPane.showInputDialog("Please type one character to use as a marker: ");
                        if (newMarker.length() != 1) {
                            throw new EmptyStringException("Please enter one valid character for the marker: ");
                        }
                        MenuItem change = (MenuItem) e.getSource();
                        Menu parentMenu = (Menu) change.getParent();
                        player.setMarker(newMarker);
                        players.set(players.indexOf(player), player);
                        parentMenu.setLabel(player.getName() + " (" + player.getMarker() + ")");
                    } catch (EmptyStringException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    catch (NullPointerException ex){
                        System.out.println("User cancelled changes.");
                    }
                }
            });
            playerMenu.add(changeName);
            playerMenu.add(changeMarker);
            playerMenus.add(playerMenu);
        }
        for(Menu menu: playerMenus){
            add(menu);
        }
    }
}
