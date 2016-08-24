package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by kylel on 23/8/2016.
 * Handles the interaction of ui between system and user, in particular the input and output.
 */
public class Interaction {

    /**
     * Number of lines that can be input.
     */
    private static final int INPUT_LIMIT = 40;

    /**
     * Number of ignored words that can be input.
     */
    private static final int IGNORE_LIMIT = 10;

    private static final String WELCOME_MESSAGE = "Welcome to KWIC Index Generator";

    private static final String INPUT_LINES_MESSAGE = "Enter each line (max. " + INPUT_LIMIT + ") followed by enter " +
            "(to terminate, enter an empty line) :";

    private static final String INPUT_IGNORED_WORDS = "Enter each ignored words (max. " + IGNORE_LIMIT + ") followed by enter " +
            "(to terminate, enter an empty line):";

    private static final String OUTPUT_DISPLAY_MESSAGE = "Generated KWIC index:";

    private static final String SPACE_REGEX = "\\s+";

    public static void main(String[] args) {
        getLines();
        getIgnoredWords();
    }

    /**
     * Display welcome message when user starts the application.
     */
    public static void displayWelcomeMessage() {
        Output.displayMessage(WELCOME_MESSAGE);
    }

    /**
     * Request the user to enter the lines.
     */
    public static ArrayList<Line> getLines() {
        Output.displayMessage(INPUT_LINES_MESSAGE);
        return getInputLines();
    }

    /**
     * Request the user to enter the ignored words.
     */
    public static ArrayList<String> getIgnoredWords() {
        Output.displayMessage(INPUT_IGNORED_WORDS);
        return Input.getInput(IGNORE_LIMIT);
    }

    /**
     * Display the KWIC index on output.
     */
    public static void displayKWICIndex(ArrayList<Line> list) {
        Output.displayMessage(OUTPUT_DISPLAY_MESSAGE);
        Output.displayArrayList(list);
    }

    /**
     * Get input lines from user and process them into arraylist of line.
     * @return      Arraylist of line object that store the input.
     */
    private static ArrayList<Line> getInputLines() {
        ArrayList<String> input = Input.getInput(INPUT_LIMIT);
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
}