package week02;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/20/2015 at 12:05 PM
 */
public class Hand extends GroupOfCards {
    int numCards;
    int maxCards;

    @Override
    public void addCard(Card card){
        this.numCards++;
        super.addCard(card);
    }
    public Card playACard(){
        Card temp = cards.get(numCards-1);
        cards.remove(numCards-1);
        numCards--;
        return temp;
    }
    public Hand(int maxCards) {
        this.maxCards = maxCards;
    }

    public static void main(String[] args) {
        Hand testHand = new Hand(4);
        testHand.addCard(new Card(CardValue.ACE,Suit.SPADES));
        testHand.addCard(new Card(CardValue.KING,Suit.HEARTS));
        testHand.addCard(new Card(CardValue.QUEEN,Suit.CLUBS));
        testHand.addCard(new Card(CardValue.JACK,Suit.DIAMONDS));
        testHand.display();
    }
}
