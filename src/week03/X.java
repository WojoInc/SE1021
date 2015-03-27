package week03;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/26/2015 at 2:13 PM.
 */
public class X extends Player{

   /* @Override
    public ActionEvent endTurnNotify() {
        return null;
    }
    */


    public X(String name){
        this.name = name;
        this.marker = "X";
    }
}
