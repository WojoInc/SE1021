package TicTacToeExpanded;

import java.io.IOException;

/**
 * Created by Owner on 4/10/2015.
 */
public class TestServer {
    public static void main(String[] args){
        WANGame test = new WANGame(WANGame.ConnectionMode.SERVER);
        try{
        test.initSocket();
        }
        catch (IOException ex){
            System.out.println("Could not establish server.");
        }
    }
}
