package com.kwic.shared;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private static final String WELCOME_MESSAGE = "Welcome to KWIC Index Generator";

    private static final String INPUT_LINES_MESSAGE = "Enter each line followed by enter " +
            "(to terminate, enter an empty line) :";

    private static final String INPUT_IGNORED_WORDS = "Enter each ignored words followed by enter " +
            "(to terminate, enter an empty line):";

    private static final String SPACE_REGEX = "\\s+";

    private static final String EMPTY_STRING = "";

    public static void main(String[] args) {
        getLines();
        getIgnoredWords();
    }

    public static void displayWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static ArrayList<ArrayList<String>> getLines() {
        System.out.println(INPUT_LINES_MESSAGE);
        return getInputLines();
    }

    public static ArrayList<String> getIgnoredWords() {
        System.out.println(INPUT_IGNORED_WORDS);
        return getInputIgnoredWords();
    }

    private static ArrayList<ArrayList<String>> getInputLines() {
        ArrayList<ArrayList<String>> lines = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        ArrayList<String> line;
        String inputLine;

        while(sc.hasNextLine()) {
            inputLine = sc.nextLine();
            if(inputLine.equals(EMPTY_STRING)) {
                break;
            } else {
                line = convertStringArrayToArrayList(inputLine.split(SPACE_REGEX));
                lines.add(line);
            }
        }
        return lines;
    }

    private static ArrayList<String> convertStringArrayToArrayList(String[] stringArray) {
        ArrayList<String> list = new ArrayList<>();
        for(String word: stringArray) {
            list.add(word.trim());
        }
        return list;
    }

    private static ArrayList<String> getInputIgnoredWords() {
        ArrayList<String> ignoredWords = new ArrayList<>();
        String inputWord;

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            inputWord = sc.nextLine();
            if(inputWord.equals(EMPTY_STRING)) {
                break;
            } else {
                ignoredWords.add(inputWord.trim());
            }
        }
        return ignoredWords;
    }
}
