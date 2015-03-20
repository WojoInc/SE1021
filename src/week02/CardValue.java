package week02;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/20/2015 at 1:02 PM
 */
public enum CardValue{

    TWO (2,"Two"),
    THREE (3,"Three"),
    FOUR (4,"Four"),
    FIVE (5,"Five"),
    SIX (6,"Six"),
    SEVEN (7,"Seven"),
    EIGHT (8,"Eight"),
    NINE (9,"Nine"),
    TEN (10,"Ten"),
    JACK (10,"Jack"),
    QUEEN (10,"Queen"),
    KING (10,"King"),
    ACE (11,"Ace");
    private final int value;
    private final String valString;
    CardValue(int CardVal, String valString){
        this.value = CardVal;
        this.valString = valString;
    }

    @Override
    public String toString() {
        return valString;
    }
}
