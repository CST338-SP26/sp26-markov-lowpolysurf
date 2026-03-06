//markov
//Chase Miranda
//3/6/26

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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
        File file = new File(filename);
        try{
            Scanner fin = new Scanner(file);

            while(fin.hasNextLine()){
                addLine(fin.nextLine());
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }

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
