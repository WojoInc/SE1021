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
    public void shuffle(){
        Card temp;
        int current;
        Random generator = new Random();
        for(int i=0; i<78; i++){
            current = generator.nextInt(51);
            temp = cards.get(current);
            cards.remove(current);
            addCard(temp);
        }
    }
    public Card dealCard(){
        Card temp;
        temp = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return temp;
    }
    public static void main(String[] args) {
        Deck newDeck = new Deck();
        newDeck.display();
        newDeck.shuffle();
        newDeck.display();
    }
}
