package week02;

import week01.Banner;

import javax.swing.*;

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
    static int round;

    public static void initGame(){
        Banner welcome = new Banner("War","This program will simulate the card game war between two computer-based players", "wesolowskitj");
        JOptionPane.showMessageDialog(null,welcome);
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
        while(player1.numCards >0 && player2.numCards>0){
            card1 = player1.playACard();
            card2 = player2.playACard();
            System.out.println("Round " + round + ": Player 1: " + card1 + " | " + card2 + " :Player 2 || Score: " + player1Score + " " + player2Score);
            if(card1.getCardValue().getValue() > card2.getCardValue().getValue()){
                player1Score++;
            }
            if(card2.getCardValue().getValue() > card1.getCardValue().getValue()){
                player2Score++;
            }
            if(card2.getCardValue().getValue() == card1.getCardValue().getValue()){
                player1Score--;
                player2Score--;
            }
            round++;
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
