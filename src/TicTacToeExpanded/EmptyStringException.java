package TicTacToeExpanded;

/**
 * Created by Owner on 4/8/2015.
 */
public class EmptyStringException extends IllegalArgumentException {
    Object parent;
    EmptyStringException(String message){
        super(message);
    }
    EmptyStringException(String message, Object parent){
        super(message);
        this.parent = parent;
    }
    EmptyStringException(String message, Throwable ex){
        super(message,ex);
    }

}
