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
    int currNum;

    public Card playACard(){
        Card temp = cards.get(currNum);
        cards.remove(currNum);
        return temp;
    }
    public Hand(int numCards) {
        this.numCards = numCards;
    }

    public static void main(String[] args) {

    }
}
