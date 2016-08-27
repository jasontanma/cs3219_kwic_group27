package com.kwic.shared;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.kwic.shared.KwicConstant.*;

/**
 * Created by kylel on 23/8/2016.
 * Handles the interaction of ui between system and user, in particular the input and output.
 */
public class Interaction {

    private static final String SPACE_REGEX = "\\s+";
    private static final String SPACE_DELIMITTER = " ";

    private static int inputMethod;
    private static int outputMethod;

    /**
     * Display welcome message when user starts the application.
     */
    public static void displayWelcomeMessage() {
        Output.displayMessage(WELCOME_MESSAGE);
    }

    /**
     * Get input method.
     */
    public static void getInputMethod() {
        Output.displayMessage(INPUT_METHOD_MESSAGE);
        int userInput = getValidIntegerInput();
        inputMethod = userInput;
    }

    /**
     * Get output method
     */
    public static void getOutputMethod() {
        Output.displayMessage(OUTPUT_METHOD_MESSAGE);
        int userInput = getValidIntegerInput();
        outputMethod = userInput;
    }

    /**
     * Get a valid integer input from user that denotes file or console preferences
     */
    public static int getValidIntegerInput() {
        int userInput = Input.getIntegerInput();
        while(userInput != KwicConstant.PREF_CONSOLE && userInput != KwicConstant.PREF_FILE) {
            Output.displayMessage(INVALID_INTEGER_INPUT_MESSAGE);
            userInput = Input.getIntegerInput();
        }
        return userInput;
    }


    /**
     * Request the user to enter the lines.
     */
    public static ArrayList<Line> getLines() {
        Scanner sc;
        if(inputMethod == KwicConstant.PREF_CONSOLE) {
            Output.displayMessage(INPUT_LINES_MESSAGE);
            sc = new Scanner(System.in);
        } else {
            Output.displayMessage(INPUT_LINES_FILE_NAME_MESSAGE);
            sc = getScanner();
        }
        return getInputLines(sc);
    }

    /**
     * Request the user to enter the ignored words.
     */
    public static ArrayList<String> getIgnoredWords() {
        Scanner sc;
        if(inputMethod == KwicConstant.PREF_CONSOLE) {
            Output.displayMessage(INPUT_IGNORED_WORDS);
            sc = new Scanner(System.in);
        } else {
            Output.displayMessage(INPUT_IGNORE_FILE_NAME_MESSAGE);
            sc = getScanner();
        }
        ArrayList<String> ignoredWords = Input.getInput(IGNORE_LIMIT, sc);
        ignoredWords = trimIgnoredWords(ignoredWords);
        return convertStringListToLowercaseList(ignoredWords);
    }

    /**
     * Display the KWIC index on output.
     */
    public static void outputKWICIndex(ArrayList<Line> lineList) {

        ArrayList<String> stringList = convertLineArrayListIntoStringList(lineList);

        if(outputMethod == KwicConstant.PREF_CONSOLE) {
            Output.displayMessage(OUTPUT_DISPLAY_MESSAGE);
            Output.displayArrayList(stringList);
        } else if(outputMethod == KwicConstant.PREF_FILE) {
            Output.displayMessage(OUTPUT_FILE_MESSAGE);
            Output.createOutputFile(stringList);
        }
    }

    /**
     * Get a valid file name and return a scanner that reads the file.
     * @return      Scanner that reads a valid file.
     */
    private static Scanner getScanner() {
        Scanner sc = new Scanner(System.in);
        String fileName = Input.getFileName();
        File file = new File(fileName);

        while(!file.exists() || file.isDirectory()) {
            Output.displayMessage(INVALID_FILE_NAME_MESSAGE);
            fileName = Input.getFileName();
            file = new File(fileName);
        }

        try {
            sc = new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            Output.displayMessage(e.getMessage());
        }
        return sc;
    }

    /**
     * Get input lines from user and process them into arraylist of line.
     * @return      Arraylist of line object that store the input.
     */
    private static ArrayList<Line> getInputLines(Scanner sc) {
        ArrayList<String> input = Input.getInput(INPUT_LIMIT, sc);
        return convertStringArrayListToLineArrayList(input);
    }

    /**
     * Convert arraylist of string object into arraylist of line object.
     * @param   stringArrayList Arraylist of string.
     * @return                  Arraylist of line object.
     */
    private static ArrayList<Line> convertStringArrayListToLineArrayList(ArrayList<String> stringArrayList) {
        ArrayList<Line> lines = new ArrayList<>();

        for(String inputLine : stringArrayList) {
            ArrayList<String> words = convertStringArrayToArrayList(inputLine.split(SPACE_REGEX));
            lines.add(new Line(words));
        }
        return lines;
    }

    /**
     * Convert array of string into arraylist of string.
     * @param   stringArray Array of string.
     * @return              Arraylist of string.
     */
    private static ArrayList<String> convertStringArrayToArrayList(String[] stringArray) {
        ArrayList<String> list = new ArrayList<>();
        for(String word: stringArray) {
            list.add(word.trim());
        }
        return list;
    }

    /**
     * Convert the arraylist of string to lowercase.
     * @param stringList     Arraylist of string to be lowercased.
     * @return               ArrayList of lowercased string.
     */
    private static ArrayList<String> convertStringListToLowercaseList(ArrayList<String> stringList) {
        ArrayList<String> lowercasedStringList = new ArrayList<>();
        for(String string: stringList) {
            lowercasedStringList.add(string.toLowerCase());
        }
        return lowercasedStringList;
    }

    /**
     * Convert the arraylist of lines to arraylist of strings.
     * @param lineList      Arraylist of lines.
    * @return               ArrayList of string.
     */
    private static ArrayList<String> convertLineArrayListIntoStringList(ArrayList<Line> lineList) {
        ArrayList<String> stringList = new ArrayList<>();
        for(Line line: lineList) {
            stringList.add(line.toString());
        }
        return stringList;
    }

    /**
     * Trim ignored words to remove excess spaces and other words
     * @param ignoredWords  ArrayList of String
     * @return              ArrayList of String that are trimmed
     */
    private static ArrayList<String> trimIgnoredWords(ArrayList<String> ignoredWords) {
        ArrayList<String> trimmedIgnoredWords = new ArrayList<>();
        for(String word: ignoredWords) {
            trimmedIgnoredWords.add(word.split(SPACE_DELIMITTER)[0]);
        }
        return trimmedIgnoredWords;
    }
}