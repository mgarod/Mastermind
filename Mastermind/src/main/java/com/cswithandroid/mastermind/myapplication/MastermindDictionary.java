package com.cswithandroid.mastermind.myapplication;

/**
 * Created by Mike on 2/10/16.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.lang.String;

public class MastermindDictionary {

    private Random random = new Random();
    private static HashMap<Integer, ArrayList<String>> sizeToWords = new HashMap<>();

    public MastermindDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();

            // Add words to HashMap according to word length
            if(sizeToWords.containsKey( word.length()) ){
                if(sizeToWords.containsKey( word.length()) ){
                    sizeToWords.get(word.length()).add(word);
                }
                else{
                    ArrayList<String> list = new ArrayList<>();
                    list.add(word);
                    sizeToWords.put(word.length(),list);
                }
            }
        }
    }

    /*** Start New Game ***/
    public ArrayList<String> startNewGame(){
        ArrayList<String> masterList = sizeToWords.get(MastermindActivity.currentDifficulty);

        int r = random.nextInt(masterList.size());
        String s = masterList.get(r);
        ArrayList<String> list = new ArrayList<>();
        list.add(s);

        for(int i = MastermindActivity.visibleWords; i > 0; i--){
            do{
                r = random.nextInt(masterList.size());
            } while( list.contains(masterList.get(r)) );

            list.add(masterList.get(r));
        }

        MastermindActivity.setAnswer(s);
        list.add(random.nextInt(list.size()), s);

        return list;
    }
}
