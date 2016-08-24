package com.kwic.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by kylel on 20/8/2016.
 * Data Structure for tokenized words of a line.
 */
public class Line {
    /**
     * Store the line by tokens of words.
     */
    private ArrayList<String> words;

    //Todo: Remove main function
    public static void main(String[] args) {

        ArrayList<String> testString = new ArrayList<String>();
        testString.add("test");
        testString.add("String");
        Line test = new Line(testString);
        Line test2 = new Line(testString);
        System.out.println(test.equals(test2));
        testString.add("String1");
        Line test3 = new Line(testString);
        System.out.println(test.equals(test3));
        System.out.println(test.getWord(0));
        System.out.println(test.getChar(0, 0));
        System.out.println(test);
        System.out.println(new Line(new String[] {"a","a","s"}));
        test.setChar(1, 0, 's');
        System.out.println(test);
    }

    public Line(ArrayList<String> words) { this.words = new ArrayList<>(words); }

    public Line(String[] words) { this.words = new ArrayList<>(Arrays.asList(words)); }

    /**
     * Compare with the line is equalavent to this.
     * @param line      Line object to be compared with.
     * @return          True if both line are the same, false otherwise.
     */
    public boolean equals(Line line) {
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

    /**
     * Get the number of words in the line.
     * @return      The integer count of words in the line.
     */
    public int getLength() { return this.words.size(); }

    /**
     * Get a exact cloned copy of the line object.
     * @return      Cloned copy of line object.
     */
    public Line copy() {
        return new Line(getWords());
    }

    /**
     * Get the i-th word from the line.
     * @param wordIndex     Index of the word to be retrieved.
     * @return              String of word from wordIndex position.
     */
    public String getWord(int wordIndex) {
        return this.words.get(wordIndex);
    }

    /**
     * Get the arraylist of word tokens.
     * @return      Arraylist of word tokens.
     */
    public ArrayList<String> getWords() {
        return new ArrayList<>(words);
    }

    /**
     * Get the character of a particular word within the line.
     * @param wordIndex     Index of the word to be retrieved.
     * @param charIndex     Index of the character of the word to be retrieved.
     * @return              Character of the word of the line.
     */
    public char getChar(int wordIndex, int charIndex) {
        return this.words.get(wordIndex).charAt(charIndex);
    }

    /**
     * Set the character of a particular word within the line.
     * @param wordIndex     Index of the word to be retrieved.
     * @param charIndex     Index of the character of the word to be retrieved.
     * @param newChar
     */
    public void setChar(int wordIndex, int charIndex, char newChar) {

        int startIndex = 0;
        int remainderIndex = charIndex + 1;

        String oldWord = this.words.get(wordIndex);
        String newWord = oldWord.substring(startIndex, charIndex) + newChar + oldWord.substring(remainderIndex);

        this.words.remove(wordIndex);
        this.words.add(wordIndex, newWord);
    }

    public static class LinesComparator implements Comparator<Line> {
        @Override
        public int compare(Line line1, Line line2) {
            return line1.toString().compareToIgnoreCase(line2.toString());
        }
    }
}