package week02;

/**
 * Labs 1011-011
 * Purpose:Extends the superclass GroupOfCards in order to represent a hand of cards.
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/20/2015 at 12:05 PM
 */
public class Hand extends GroupOfCards {
    int numCards;
    int maxCards;

    /**
     * overrides the superclass method to also increment numCards each time a card is added. (To be changed later)
     * @param card the card object to be added
     */
    @Override
    public void addCard(Card card){
        this.numCards++;
        super.addCard(card);
    }

    /**
     * returns a card object and then removes that card from the hand
     * @return the card object
     */
    public Card playACard(){
        Card temp = cards.get(numCards-1);
        cards.remove(numCards-1);
        numCards--;
        return temp;
    }

    /**
     * Instantiates a Hand object and limits the number of cards in the hand to the number indicated by maxCards(to be implemented later)
     * @param maxCards the maximum number of cards allowed in the hand
     */
    public Hand(int maxCards) {
        this.maxCards = maxCards;
    }

    /**
     * Test driver for the class.
     * @param args
     */
    public static void main(String[] args) {
        Hand testHand = new Hand(4);
        testHand.addCard(new Card(CardValue.ACE,Suit.SPADES));
        testHand.addCard(new Card(CardValue.KING,Suit.HEARTS));
        testHand.addCard(new Card(CardValue.QUEEN,Suit.CLUBS));
        testHand.addCard(new Card(CardValue.JACK,Suit.DIAMONDS));
        testHand.display();
    }
}
