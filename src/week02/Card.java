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

    public CardValue getCardValue() {
        return val;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString(){
        return getCardValue() + " of " + getSuit();
    }

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
