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

        prevWord = BEGINS_SENTENCE;
    }
    public String getSentence(){
        return "";
    }

    public void addFromFile(String filename){ //calls addLine

    }

    void addWord(String curWord){ //calls endsWithPunctuation
        if(endsWithPunctuation(prevWord)){
            words.put(BEGINS_SENTENCE, new ArrayList<>());//TEMP<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        }
    }

    String randomWord(String word){
        return "";
    }

    HashMap<String, ArrayList<String>> getWords(){
        return words;
    }

    void addLine(String line){ //passes into addWord
        if(!line.isEmpty()){
            String[] words = line.split(" ");
            for(String word : words){
                addWord(word);
            }
        }
    }

    public static boolean endsWithPunctuation(String ends){
        return false;
    }

    @Override
    public String toString(){
        return "";
    }
}
