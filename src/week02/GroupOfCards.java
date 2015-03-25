package week02;

import java.util.ArrayList;

/**
 * Labs 1011-011
 * Purpose:A supreclass to serve as a template for creating subclasses representing a group of cards, ie a deck or hand.
 *
 * @author wesolowskitj
 * @version 1.0 Created on 3/20/2015 at 12:04 PM
 */
public class GroupOfCards {
    protected ArrayList<Card> cards = new ArrayList<Card>();
    protected int currentSize;

    /**
     * adds a card object to the array, or group, of cards
     * @param card the card object to be added
     */
    public void addCard(Card card){
        cards.add(card);
    }

    /**
     * returns the current size of the arraylist representing the group of cards.
     * @return the size of the arraylist
     */
    public int getCurrentSize() {
        if(cards.isEmpty()==true){
            currentSize = 0;
        }
        else{
            currentSize = cards.size();
        }
        return currentSize;
    }

    /**
     * displays the current cards in the arraylist by outputting the result of each cards toString method to the console.
     */
    public void display(){
        for(Card card: cards){
            System.out.println(card);
        }
    }

    /**
     * test driver for the class
     * @param args
     */
    public static void main(String[] args) {
        GroupOfCards newGroup = new GroupOfCards();
        newGroup.addCard(new Card(CardValue.ACE,Suit.SPADES));
        newGroup.addCard(new Card(CardValue.KING,Suit.HEARTS));
        newGroup.addCard(new Card(CardValue.QUEEN,Suit.CLUBS));
        newGroup.addCard(new Card(CardValue.JACK,Suit.DIAMONDS));
        newGroup.display();

    }
}
