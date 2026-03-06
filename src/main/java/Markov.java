//markov
//Chase Miranda
//3/6/26

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Markov {

    //var...............................................................................................
    private static final String BEGINS_SENTENCE = "__$";
    private static final String PUNCTUATION_MARKS = ".!?$";
    private String prevWord;
    private HashMap<String, ArrayList<String>> words;

    //constructor.......................................................................................
    Markov(){
        words = new HashMap<>();
        words.put(BEGINS_SENTENCE, new ArrayList<>());

        prevWord = BEGINS_SENTENCE;
    }

    //methods...........................................................................................
    public String getSentence(){ //calls randomWord and endsWithPunctuation
        String curWord = randomWord(BEGINS_SENTENCE);
        StringBuilder out = new StringBuilder();

        while(!endsWithPunctuation(curWord)){
            out.append(curWord).append(" ");
            curWord = randomWord(curWord);
        }
        out.append(curWord);

        return out.toString();
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
            words.get(BEGINS_SENTENCE).add(curWord);
        }else{
            if(!words.containsKey(prevWord)){
                words.put(prevWord, new ArrayList<>());
                words.get(prevWord).add(curWord);
            }else{
                words.get(prevWord).add(curWord);
            }
        }
        prevWord = curWord;
    }

    String randomWord(String word){
        ArrayList<String> nextWords = words.get(word);
        Random r = new Random();
        int nextIndex = r.nextInt(nextWords.size());

        return nextWords.get(nextIndex);
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
        char wordLastChar = ends.charAt(ends.length()-1);
        for(int i = 0; i < PUNCTUATION_MARKS.length(); i++){
            if(wordLastChar == PUNCTUATION_MARKS.charAt(i)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        return words.toString();
    }
}
