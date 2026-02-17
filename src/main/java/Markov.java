//markov

import java.util.ArrayList;
import java.util.HashMap;

public class Markov {

    //var...............................................................................................
    private static final String BEGINS_SENTENCE = "__$";
    private static final String PUNCTUATION_MARKS = ".!?$";
    private String prevWord;
    private HashMap<String, ArrayList<String>> words;

    //methods...........................................................................................
    Markov(){
        words = new HashMap<>();
        words.put(BEGINS_SENTENCE, new ArrayList<>());
    }
    public String getSentence(){
        return "";
    }

    public void addFromFile(String add){

    }

    void addWord(String word){

    }

    String randomWord(String word){
        return "";
    }

    HashMap<String, ArrayList<String>> getWords(){
        return words;
    }

    void addLine(String line){

    }

    public boolean endsWithPunctuation(String ends){
        return false;
    }

    @Override
    public String toString(){
        return "";
    }
}
