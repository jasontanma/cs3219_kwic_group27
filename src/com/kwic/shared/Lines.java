package com.kwic.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kylel on 20/8/2016.
 */
public class Lines {

    private ArrayList<String> words;

    //Todo: Remove main function
    public static void main(String[] args) {

        ArrayList<String> testString = new ArrayList<String>();
        testString.add("test");
        testString.add("String");
        Lines test = new Lines(testString);
        Lines test2 = new Lines(testString);
        System.out.println(test.equals(test2));
        testString.add("String1");
        Lines test3 = new Lines(testString);
        System.out.println(test.equals(test3));
        System.out.println(test.getWord(0));
        System.out.println(test.getChar(0, 0));
        System.out.println(test);
        System.out.println(new Lines(new String[] {"a","a","s"}));
        test.setChar(1, 0, 's');
        System.out.println(test);
    }

    public Lines(ArrayList<String> words) { this.words = (ArrayList<String>) words.clone(); }

    public Lines(String[] words) { this.words = new ArrayList<String>(Arrays.asList(words)); }

    private void setWords(ArrayList<String> words) { this.words = words;}

    public boolean equals(Lines line) {
        if(getLength() != line.getLength()) {
            return false;
        } else {
            for(int i = 0; i < words.size(); ++i) {
                if(!getWord(i).equals(line.getWord(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    public String toString() {
        String line = "";
        String space = " ";

        int numOfWordsInLine = words.size();
        int numOfSpaces = numOfWordsInLine - 1;

        for(int i = 0; i < numOfWordsInLine; i++){
            line = line.concat(words.get(i));
            if(i < numOfSpaces) {
                line = line.concat(space);
            }
        }
        return line;
    }

    public int getLength() { return this.words.size(); }

    public Lines copy() {
        return new Lines(getWords());
    }

    public String getWord(int wordIndex) {
        return this.words.get(wordIndex);
    }

    public ArrayList<String> getWords() {
        return (ArrayList<String>) words.clone();
    }

    public char getChar(int wordIndex, int charIndex) {
        return this.words.get(wordIndex).charAt(charIndex);
    }

    public void setChar(int wordIndex, int charIndex, char newChar) {

        int startIndex = 0;
        int remainderIndex = charIndex + 1;

        String oldWord = this.words.get(wordIndex);
        String newWord = oldWord.substring(startIndex, charIndex) + newChar + oldWord.substring(remainderIndex);

        this.words.remove(wordIndex);
        this.words.add(wordIndex, newWord);
    }

    public static class LinesComparator implements Comparator<Lines> {
        @Override
        public int compare(Lines line1, Lines line2) {
            return line1.toString().compareToIgnoreCase(line2.toString());
        }
    }
}