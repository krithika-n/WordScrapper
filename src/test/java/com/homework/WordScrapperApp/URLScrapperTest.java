package com.homework.WordScraperApp;

import java.io.IOException;
import java.util.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class URLScraperTest {

    URLScraper url_scraper_test = new URLScraper();

    URLScraperTest() throws IOException {
    }

    @Test
    void processText_text_without() {
        List<java.lang.String> answer = url_scraper_test.processText("");
        List<String> check = new ArrayList<>();
        assertEquals(answer, check);
    }

    @Test
    void processText_text_with_sentences() {
        String text = "The extinction of the different Iberian royal dynasties, such as Guaramids and the " +
                "Chosroids,[32] and also the Abbasid preoccupation with their own civil wars and conflict with " +
                "the Byzantine Empire, led to the Bagrationi family's growth in prominence. The head of the " +
                "Bagrationi dynasty Ashot I of Iberia (r.813–826), who had migrated to the former southwestern.";
        List<String> check = new ArrayList<>(Arrays.asList("extinction", "different", "iberian", "royal", "dynasties",
                "guaramids", "chosroids", "also", "abbasid", "preoccupation", "civil", "wars",
                "conflict", "byzantine", "empire", "led", "bagrationi", "familys", "growth",
                "prominence", "head", "bagrationi", "dynasty", "ashot", "iberia", "r", "migrated",
                "former", "southwestern"));
        List<String> answer = url_scraper_test.processText(text);
        assertEquals(answer, check);
    }

    @Test
    void buildResult_less_than_25_words() {
        url_scraper_test.wordCount = new HashMap<String, Integer>() {{
            put("a", 9);
            put("c", 21);
            put("b", 3);
        }};
        LinkedHashMap<String, Integer> answer = url_scraper_test.buildResult();
        LinkedHashMap<String, Integer> check = new LinkedHashMap<String, Integer>(){{
            put("c", 21);
            put("a", 9);
            put("b", 3);
        }};
        assertEquals(answer, check);
    }

    @Test
    void buildResult_no_words() {
        url_scraper_test.wordCount = new HashMap<String, Integer>();
        LinkedHashMap<String, Integer> answer = url_scraper_test.buildResult();
        LinkedHashMap<String, Integer> check = new LinkedHashMap<>();
        assertEquals(answer, check);
    }

    @Test
    void buildResult_more_than_25_words() throws IOException {
        LinkedHashMap<String, Integer> answer = url_scraper_test.getWords("https://sherlock-holm.es/stories/html/five.html");
        LinkedHashMap<String, Integer> check = new LinkedHashMap<String, Integer>(){
            {
                put("upon", 96);
                put("said", 64);
                put("one", 59);
                put("may", 53);
                put("holmes", 50);
                put("come", 45);
                put("will", 44);
                put("k", 42);
                put("man", 40);
                put("see", 36);
                put("must", 36);
                put("well", 35);
                put("however", 34);
                put("papers", 34);
                put("shall", 32);
                put("openshaw", 31);
                put("time", 30);
                put("us", 30);
                put("last", 28);
                put("pips", 27);
                put("think", 26);
                put("john", 25);
                put("th", 25);
                put("now", 24);
                put("father", 24);
            }};
        assertEquals(answer, check);
    }

    @Test
    void getWords_with_valid_url() throws IOException {
        String url = "https://sherlock-holm.es/stories/html/five.html";
        LinkedHashMap<String, Integer> answer = url_scraper_test.getWords("https://sherlock-holm.es/stories/html/five.html");
        LinkedHashMap<String, Integer> check = new LinkedHashMap<String, Integer>(){
            {
                put("upon", 96);
                put("said", 64);
                put("one", 59);
                put("may", 53);
                put("holmes", 50);
                put("come", 45);
                put("will", 44);
                put("k", 42);
                put("man", 40);
                put("see", 36);
                put("must", 36);
                put("well", 35);
                put("however", 34);
                put("papers", 34);
                put("shall", 32);
                put("openshaw", 31);
                put("time", 30);
                put("us", 30);
                put("last", 28);
                put("pips", 27);
                put("think", 26);
                put("john", 25);
                put("th", 25);
                put("now", 24);
                put("father", 24);
            }};
        assertEquals(answer, check);
    }

    @Test
    void getWords_invalid_url() throws IOException {
        String url = "apple";
        Assertions.assertThrows(Exception.class, ()->{ url_scraper_test.getWords(url);});
    }

    @Test
    void getWords_no_url() throws IOException {
        Assertions.assertThrows(Exception.class, ()->{ url_scraper_test.getWords(null);});
    }

}
