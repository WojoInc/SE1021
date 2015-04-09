package week04;

import week03.TurnEvent;

import javax.jnlp.JNLPRandomAccessFile;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Labs 1011-011
 * Purpose:
 *
 * @author wesolowskitj
 * @version 1.0 Created on 4/2/2015 at 12:26 AM
 */
public class Othello implements TurnListener, FlipListener{
    private static GameBoard board;
    private static ArrayList<Player> players;
    private static JButton[][] buttons;

    @Override
    public void terminates(FlipEvent e) {
        int i= e.getStartX();
        int j= e.getStartY();
        do{
            buttons[i][j].setBackground(((OthelloMarker)e.getPlayer().getMarker()).getColor());
            buttons[i][j].setName(e.getPlayer().getName());
            i+=e.getxIncr();
            j+=e.getyIncr();
        }while(i!=e.getxValue()&&j!=e.getyValue());
    }

    public enum AdjacentMarkers {
        topleft(-1,-1),
        top(0,-1),
        topRight(1,-1),
        left(-1,0),
        right(1,0),
        bottomLeft(-1,1),
        bottom(0,1),
        bottomRight(1,1);
        private int x;
        private int y;
        public int getX(){
            return x;
        }

        public int getY() {
            return y;
        }

        AdjacentMarkers(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void initGame(){
        buttons = new JButton[8][8];
        BlackChip blackChip = new BlackChip("TJ");
        blackChip.addTurnListener(this);
        WhiteChip whiteChip = new WhiteChip("Anna");
        whiteChip.addTurnListener(this);
        players = new ArrayList<Player>();
        players.add(blackChip);
        players.add(whiteChip);
        OthelloGUI gui = new OthelloGUI(players);
        board = new GameBoard(new GridLayout(8, 8), players);
        gui.setContentPane(board);
        parseButtonsToArray();
        board.setActivePlayer(players.get(0));
    }
    private void parseButtonsToArray(){
        ArrayList<JButton> markers = board.getBoardButtons();
        int i,j,k=0;
        for(i=0;i<8;i++){
            for(j=0; j<8;j++){
                buttons[i][j] = markers.get(k);
                k++;
            }
        }
    }
    public void flipMarkers(Player player){
        JButton lastMarked = (JButton)player.getLastMarkerReference();
        ArrayList<JButton> toFlip = new ArrayList<JButton>();
        boolean terminates =false;
        int startX=0,startY=0;
        int endX=0,endY=0;
        for(int i=0;i<8;i++){
            for(int j=0; j<8;j++){
                if(buttons[i][j].equals(lastMarked)){
                    startX = i;
                    startY = j;
                }
            }
        }
        for(AdjacentMarkers marker: AdjacentMarkers.values()){
            int i=startX+ marker.getX(),j=startY + marker.getY();
            while(i>-1 && i<8 && j>-1 && j<8) {
                    if (!buttons[i][j].getName().equals(player.getName()) && !buttons[i][j].getName().equals("")) {
                        toFlip.add(buttons[i][j]);
                    }
                    else if(buttons[i][j].getName().equals(player.getName())){
                        terminates(new FlipEvent(startX, startY, i,j, marker.getX(),marker.getY(), player));
                    }
                i+=marker.getX();
                j+=marker.getY();
            }
        }
    }

    public Othello(){
        initGame();
    }

    @Override
    public void nextPlayer(Player player) {
        if (player.getMarker().equals(OthelloMarker.BLACK)) {
            board.setActivePlayer(players.get(1));
        } else {
            board.setActivePlayer(players.get(0));
        }
    }

    @Override
    public void turnEnd(TurnEvent e) {
        flipMarkers((Player) e.getSource());
        nextPlayer((Player) e.getSource());
    }

}
