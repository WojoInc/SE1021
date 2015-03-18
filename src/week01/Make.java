package week01;

import sun.text.resources.FormatData;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/18/2015 at 3:33 PM.
 */
public enum Make {
    Chevrolet ("Chevrolet"),
    Ford ("Ford"),
    Lamborghini ("Lamborghini"),
    Dodge ("Dodge");
    private final String name;

    Make(String name){
        this.name = name;
    }
    public String toString(){
        return name;
    }
}
