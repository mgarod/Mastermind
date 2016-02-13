package com.cswithandroid.mastermind.myapplication;

/**
 * Created by Mike on 2/12/16.
 */
public class WordScorePair implements Comparable<WordScorePair> {

    public int numHits;
    public String word;

    public WordScorePair(int score, String word){
        this.numHits = score;
        this.word = word;
    }

    public WordScorePair(WordScorePair other){
        this.numHits = other.numHits;
        this.word = other.word;
    }

    @Override
    public int compareTo(WordScorePair other) {
        return Integer.valueOf(numHits).compareTo(other.numHits);
    }

    public boolean equals(WordScorePair other){
        return (this.word).equals(other.word);
    }
}