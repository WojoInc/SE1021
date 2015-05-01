package TicTacToeExpanded;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Owner on 4/10/2015.
 */
public class WANGame{
    public enum ConnectionMode{
        SERVER(0),
        CLIENT(1);
        private int mode;

        public int getMode() {
            return mode;
        }

        ConnectionMode(int mode){
            this.mode = mode;
        }
    }
    private int mode;
    private ServerSocket srvr;
    private Socket skt;
    private PrintWriter out;
    private BufferedReader in;

    public void addMoveToQueue(JButton button, Player player){

    }

    public void initSocket() throws IOException {
        switch (mode) {

            case 0:
                String data = "this is a test";
                srvr = new ServerSocket(1234);
                skt = srvr.accept();
                out = new PrintWriter(skt.getOutputStream(), true);
                System.out.print("Sending string: '" + data + "'\n");
                out.print(data);
                out.close();

            case 1:
                skt = new Socket("localhost", 1234);
                in = new BufferedReader(new
                        InputStreamReader(skt.getInputStream()));
                System.out.print("Received string: '");

                while (!in.ready()) {}
                System.out.println(in.readLine()); // Read one line and output it

                System.out.print("'\n");

        }
    }
    public void closeSocket ()throws IOException{
        switch(mode) {
            case 0:

                skt.close();
                srvr.close();
            case 1:
                in.close();
                skt.close();
        }
    }
    public WANGame(ConnectionMode mode) {
        this.mode = mode.getMode();
    }
}
