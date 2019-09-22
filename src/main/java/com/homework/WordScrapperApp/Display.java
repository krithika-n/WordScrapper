package com.homework.WordScraperApp;

import java.util.LinkedHashMap;

/**
 * Display - class containing methods to print the output to screen
 * @author  Krithika Narayanan
 */
public class Display {

    /**
     * Prints the words in result ArrayList an
     * and the command line arguments.
     * @param result LinkedHashMap of String containing result words and their count
     * @param title String containing the title of the URL
     */
    public void displayResult(LinkedHashMap<String, Integer> result, String title){
        System.out.println("Top 25 words found in " + title);
        System.out.print("Word, Count");
        result.forEach((key, value) -> System.out.println(key + ", " + value.toString()));
    }
}
