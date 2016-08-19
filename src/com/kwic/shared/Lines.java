package com.kwic.shared;

import java.util.ArrayList;

public class Lines {

    private ArrayList<String> words;

    //Todo: Remove main function
    public static void main(String[] args) {

        ArrayList<String> testString = new ArrayList<String>();
        testString.add("test");
        testString.add("String");
        Lines test = new Lines(testString);

        System.out.println(test.getWord(0));
        System.out.println(test.getChar(0, 0));
        System.out.println(test);
        
        test.setChar(1, 0, 's');
        System.out.println(test);
    }

    public Lines(ArrayList<String> words) {
        this.words = words;
    }

    private void setWords(ArrayList<String> words) {
        this.words = words;
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

    public String getWord(int wordIndex) {
        return this.words.get(wordIndex);
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
}