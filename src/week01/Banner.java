package week01;

import java.util.Date;

/**
 * Purpose: This class functions as a simple class to store multiple string variables that can be called by the driver
 * class by using the various get methods.
 *
 * @author:wesolowskitj
 * @version: 1.1
 * <p/>
 * Created on 1/8/2015 at 3:02 PM.
 */
public class Banner {

    private String title;
    private String description;
    private String author = "wesolowskitj";
    private Date date;

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){
        String output;
        output = description + "\nCreated by: " + author + "\nRun on: " + date;
        return output;
    }
//constructor
    public Banner(String title, String description, String author){
        this.title = title;
        this.description = description;
        this.author = author;
        this.date = new Date();
    }
}
