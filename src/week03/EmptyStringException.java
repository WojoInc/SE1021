package week03;

/**
 * Created by Owner on 4/8/2015.
 */
public class EmptyStringException extends IllegalArgumentException {

    EmptyStringException(String message){
        super(message);
    }
    EmptyStringException(String message, Throwable ex){
        super(message,ex);
    }

}
