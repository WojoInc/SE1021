package week02;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/20/2015 at 12:01 PM
 */
public class Card {
    private CardValue val;
    private Suit suit;

    public Card(CardValue val, Suit suit) {
        this.val = val;
        this.suit = suit;
    }

    public CardValue getVal() {
        return val;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString(){
        return getVal() + " of " + getSuit();
    }

    public static void main(String[] args) {
        Card testCard = new Card(CardValue.ACE, Suit.SPADES);
        System.out.println(testCard);
    }
}
