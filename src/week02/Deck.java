package week02;

import java.util.Random;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/20/2015 at 12:05 PM
 */
public class Deck extends GroupOfCards {
    public Deck() {
        for(Suit suit: Suit.values()) {
            for(CardValue val: CardValue.values()){
                addCard(new Card(val,suit));
            }
        }
    }
    public Card shuffle(){
        Card temp;
        Random generator = new Random();
        for(int i=0; i<27; i++){
            generator
            temp = cards.get();
        }
    }
    public static void main(String[] args) {
        Deck newDeck = new Deck();
        newDeck.display();
    }
}
