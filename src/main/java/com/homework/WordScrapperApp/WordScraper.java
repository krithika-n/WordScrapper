package com.homework.WordScraperApp;

import java.io.*;
import java.util.LinkedHashMap;
/**
 * WordScraperApp  - program to print top 25 words found in a URL
 * @author    Krithika Narayanan
 */
public class WordScraper {

    /**
     * App to print the top 25 words in a URL
     * @param args A string array containing the command line arguments.
     * @exception IOException exception
     */
    public static void main(String[] args) throws IOException {
        String input_url = "";
        try{
            input_url = args[0];
        } catch (ArrayIndexOutOfBoundsException aie) {
            System.out.println("A URL input is needed. ");
            aie.printStackTrace();
            System.exit(0);
        }
        URLScraper url_scraper = new URLScraper();
        LinkedHashMap<String, Integer> resultWords =  url_scraper.getWords(input_url);
        String title = url_scraper.getTitle();
        Display dpy = new Display();
        dpy.displayResult(resultWords, title);
    }
}
