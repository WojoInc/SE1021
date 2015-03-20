package week02;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/20/2015 at 12:07 PM
 */
public enum Suit {
    HEARTS (1,"Hearts"),
    DIAMONDS (2,"Diamonds"),
    SPADES (3,"Spades"),
    CLUBS (4,"Clubs");
    private final int suitNum;
    private final String suit;

    Suit(int suitNum, String suit){
        this.suitNum = suitNum;
        this.suit = suit;
    }
    public String getSuit(){
        return this.suit;
    }
    public String toString(){
        return getSuit();
    }
}
