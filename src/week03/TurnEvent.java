package week03;


/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 4/1/2015 at 2:35 PM.
 */
public class TurnEvent{
    private Object source;
    public Object getSource(){
        return source;
    }
    public TurnEvent(Object source) {
        this.source = source;
    }
}
