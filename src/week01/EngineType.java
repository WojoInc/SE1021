package week01;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/18/2015 at 3:05 PM.
 */
public enum EngineType {
    DIESEL ("Diesel"),
    GAS ("Gas");

    private final String type;

    EngineType(String type){
        this.type = type;
    }

    public String toString(){
        return this.type;
    }
}
