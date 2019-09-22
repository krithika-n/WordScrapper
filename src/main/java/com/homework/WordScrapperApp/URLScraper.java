package com.homework.WordScraperApp;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.*;

/**
 * URLScraper - class containing methods to read, scrape and process text in URL
 * to retrieve the top 25 words present in given URL
 * @author  Krithika Narayanan
 */
public class URLScraper {

    HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
    Integer maxCount = 0;
    HashSet<String> stopWords = new HashSet<>();
    StanfordCoreNLP pipeline;
    Properties props = new Properties();
    String title;

    /**
     * Constructor without arguments. Sets up property, pipeline and stopWords
     */
    public URLScraper() throws IOException {
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma");
        pipeline = new StanfordCoreNLP(props);
        try{
            InputStream in = getClass().getResourceAsStream("/stopwords-english.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String word;
            while ((word = reader.readLine()) != null)
                stopWords.add(word);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
        /**
     * Gets the value of title
     * @return the value of String variable title
     */
    String getTitle(){
        return this.title;
    }

    /**
     * Read the URL into a Document
     * @param url A string containing the url to be read
     * @exception IllegalArgumentException exception
     * @return Document of the URL which was read
     */
    public Document readURL(String url)  {
        Document document = null;
        try{
            document = (Document) Jsoup.connect(url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36").get();
            title = document.title();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println("The given URL does not exist");
            e.printStackTrace();
        }
        return document;
    }

    /**
     * Process the document by walking through each element
     * @param document Document containing elements from the URL to be read
     */
    protected void processDocument(Document document){
        for (Element element : document.body().select("*")) {
            if (element.hasText()) {
                List<String> words = processText(element.text());
                for(String word : words){
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    if(wordCount.get(word) > maxCount) maxCount = wordCount.get(word);
                }
            }
        }
    }

    /**
     * Process the text content, remove punctuation, extra characters and stop words
     * @param textBlock A string containing the text from each element in URL
     * @return ArrayList of processed words
     */
    protected List<String> processText(String textBlock){

        textBlock = textBlock.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        CoreDocument exampleDocument = new CoreDocument(textBlock);
        pipeline.annotate(exampleDocument);
        List<CoreSentence> firstSentenceTokens = exampleDocument.sentences();
        List<String> words = new ArrayList<String>();
        for (CoreSentence sentence : firstSentenceTokens) {
            for (CoreLabel token: sentence.tokens()){
                String word = token.word();
                if(! stopWords.contains(word)) words.add(word);
            }
        }
        return words;
    }

    /**
     * Creates an ArrayList of Strings containing the top 25 words in url document
     * @return LinkedHashMap of the top 25 words and their count
     */
    protected LinkedHashMap<String, Integer> buildResult(){
        int countResult = 0;
        PriorityQueue<HeapEntry> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<String, Integer> entry : wordCount.entrySet())
            pq.add(new HeapEntry(entry.getKey(), entry.getValue()));
        LinkedHashMap<String, Integer> answer = new LinkedHashMap<>();
        while (countResult < 25) {
            if(! pq.isEmpty()) {
                HeapEntry tuple = pq.remove();
                answer.put(tuple.getKey(), tuple.getValue());
                countResult += 1;
            }
            else break;
        }
        return answer;
    }

    /**
     * Retrieves top 25 words from url document
     * @param url A string containing the url to be read
     * @exception IOException exception
     * @return LinkedHashMap of the top 25 words and their count
     */
    public LinkedHashMap<String, Integer> getWords(String url) throws IOException {
        Document urlDocument = readURL(url);
        processDocument(urlDocument);
        LinkedHashMap<String, Integer> resultWords = buildResult();
        return resultWords;
    }
}
