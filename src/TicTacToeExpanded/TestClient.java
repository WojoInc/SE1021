package TicTacToeExpanded;

import java.io.IOException;

/**
 * Created by Owner on 4/10/2015.
 */
public class TestClient {
    public static void main(String[] args){
        WANGame test = new WANGame(WANGame.ConnectionMode.CLIENT);
        try{
            test.initSocket();
            //test.closeSocket();
        }
        catch (IOException ex){
            System.out.println("Could not establish client.");
        }
    }
}
