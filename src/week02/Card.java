package week02;

/**
 * Labs 1011-011
 * Purpose:Class to represent a card. Makes use of two enumerators for value and suit.
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/20/2015 at 12:01 PM
 */
public class Card {
    private CardValue val;
    private Suit suit;

    /**
     * Creates a card object using the specified enumerators for card value and suit
     * @param val the card value
     * @param suit the card's suit
     */
    public Card(CardValue val, Suit suit) {
        this.val = val;
        this.suit = suit;
    }

    /**
     * returns the card value by reference to the enumerator
     * @return the card value
     */
    public CardValue getCardValue() {
        return val;
    }

    /**
     * returns the card suit by reference to the enumerator
     * @return the card suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Overrides the toString method to output the card in the form of [card value] of [suit]
     * @return the card's string representation
     */
    public String toString(){
        return getCardValue() + " of " + getSuit();
    }

    /**
     * test driver for the class
     * @param args
     */
    public static void main(String[] args) {
        Card testCard = new Card(CardValue.ACE, Suit.SPADES);
        Card testCard2 = new Card(CardValue.QUEEN, Suit.DIAMONDS);
        Card testCard3 = new Card(CardValue.JACK, Suit.CLUBS);
        Card testCard4 = new Card(CardValue.KING, Suit.HEARTS);
        System.out.println(testCard);
        System.out.println(testCard2);
        System.out.println(testCard3);
        System.out.println(testCard4);
    }
}
