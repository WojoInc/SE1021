package week03;

/**
 * Created by Owner on 4/8/2015.
 */
public class EmptyStringException extends Throwable {
    String message;

    @Override
    public String getMessage() {
        return message;
    }

    EmptyStringException(String message){
        this.message = message;
    }

}
