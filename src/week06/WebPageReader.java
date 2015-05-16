package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * Project: SE1021
 * Class: WebPageReader
 * Purpose:
 * Created by Owner on 5/15/2015 at 2:50 PM.
 */
public class WebPageReader {
    BufferedReader reader;
    public WebPageReader(String webAddress)throws MalformedURLException, IOException{
        URL url = new URL(webAddress);
        URLConnection connection = url.openConnection();
        InputStream in = connection.getInputStream();
        reader = new BufferedReader(new InputStreamReader(in));
    }
    public String readLine()throws IOException{
        return reader.readLine();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String url,line;
        System.out.println("Enter a full url address: ");
        url = stdIn.nextLine();
        try {
            WebPageReader wpr = new WebPageReader(url);
            while ((line = wpr.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(Exception ex){
            System.out.println(ex.getClass());
            System.out.println(ex.getMessage());
        }
    }
}
