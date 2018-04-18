package com.auribises.enc2018android;

/**
 * Created by ishantkumar on 18/04/18.
 */

public class News {

    public int image;
    public String newsTitle;
    public String url;

    public News(){

    }

    public News(int image, String newsTitle, String url) {
        this.image = image;
        this.newsTitle = newsTitle;
        this.url = url;
    }
}
