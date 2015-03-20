package week02;

import java.util.ArrayList;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/20/2015 at 12:04 PM
 */
public class GroupOfCards {
    protected ArrayList<Card> cards = new ArrayList<Card>();
    protected int currentSize;
    public void addCard(Card card){
        cards.add(card);
    }

    public int getCurrentSize() {
        if(cards.isEmpty()==true){
            currentSize = 0;
        }
        else{
            currentSize = cards.size();
        }
        return currentSize;
    }

    public void display(){
        for(Card card: cards){
            System.out.println(card);
        }
    }
    public static void main(String[] args) {
        GroupOfCards newGroup = new GroupOfCards();
        newGroup.addCard(new Card(CardValue.ACE,Suit.SPADES));
        newGroup.addCard(new Card(CardValue.KING,Suit.HEARTS));
        newGroup.addCard(new Card(CardValue.QUEEN,Suit.CLUBS));
        newGroup.addCard(new Card(CardValue.JACK,Suit.DIAMONDS));
        newGroup.display();

    }
}
