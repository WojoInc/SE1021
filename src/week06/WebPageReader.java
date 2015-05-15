package week06;

import java.io.BufferedReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Project: SE1021
 * Class: WebPageReader
 * Purpose:
 * Created by Owner on 5/15/2015 at 2:50 PM.
 */
public class WebPageReader {
    BufferedReader reader;
    public WebPageReader(String webAddress)throws MalformedURLException{
        URL url = new URL(webAddress);
        URLConnection connection = url.openConnection();
    }
}
