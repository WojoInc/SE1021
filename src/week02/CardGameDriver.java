package week02;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created by wesolowskitj on 3/18/2015 at 3:30 PM.
 */
public class CardGameDriver {
    static Hand player1;
    static int player1Score;
    static Hand player2;
    static int player2Score;
    static Deck deck;
    static Card card1;
    static Card card2;

    public static void initGame(){
        player1 = new Hand(21);
        player2 = new Hand(21);
        deck = new Deck();
        deck.shuffle();
        for(int i=0; i <21; i++) {
            player1.addCard(deck.dealCard());
            player2.addCard(deck.dealCard());
        }
    }
    public static void mainGame(){
        while(player1.currNum >0 && player2.currNum>0){
            card1 = player1.playACard();
            card2 = player2.playACard();
            if(card1.getVal().getValue() > card2.getVal().getValue()){
                player1Score++;
            }
            if(card2.getVal().getValue() > card1.getVal().getValue()){
                player2Score++;
            }
        }
        if(player1Score > player2Score){
            System.out.println("player1 wins");
        }
        else{
            System.out.println("player2 wins");
        }
    }
    public static void main(String[] args) {
        initGame();
        mainGame();

    }
}
