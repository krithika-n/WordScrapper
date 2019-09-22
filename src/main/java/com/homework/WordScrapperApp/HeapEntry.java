/**
 * HeapEntry - class for defining a custom object to be inserted into Heap
 * @author Krithika Narayanan
 */
package com.homework.WordScraperApp;

class HeapEntry implements Comparable<HeapEntry> {
    private String wordEntry;
    private Integer countOccurrences;

    /**
     * Constructor for a HeapEntry, sets up wordEntry and countOccurrences
     * @param key A string containing the word
     * @param value An Integer with the word count
     * @return No return value
     */
    public HeapEntry(String key, Integer value){
        this.wordEntry = key;
        this.countOccurrences = value;
    }

    /**
     * Gets the value of countOccurrences
     * @return Integer value of countOccurrences
     */
    Integer getValue(){
        return this.countOccurrences;
    }

    /**
     * Gets the value of wordEntry
     * @return String value of wordEntry
     */
    String getKey(){
        return this.wordEntry;
    }

    /**
     * Overrides the compareTo function to use the countOccurrences variable
     * @param other HeapEntry object to be compared with
     * @return int
     */
    @Override
    public int compareTo(HeapEntry other){
        return this.getValue().compareTo(other.getValue());
    }
}
