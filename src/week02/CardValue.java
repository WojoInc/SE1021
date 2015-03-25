package week02;

/**
 * Labs 1011-011
 * Purpose: To hold the possible values for the Card class, along with their integer values and string names.
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

    /**
     * Creates each enumerator with both an integer value and string
     * @param CardVal the value of the card
     * @param valString the String literal of the cards value
     */
    CardValue(int CardVal, String valString){
        this.value = CardVal;
        this.valString = valString;
    }

    /**
     * returns the integer value of the enumerator
     * @return the integer value
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the string representing the enumerators value
     * @return the string
     */
    @Override
    public String toString() {
        return valString;
    }
}
