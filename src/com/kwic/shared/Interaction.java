package com.kwic.shared;

import java.util.ArrayList;

/**
 * Created by kylel on 23/8/2016.
 */
public class Interaction {

    private static final int INPUT_LIMIT = 40;

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

    public static void displayWelcomeMessage() {
        Output.displayMessage(WELCOME_MESSAGE);
    }

    public static ArrayList<Line> getLines() {
        Output.displayMessage(INPUT_LINES_MESSAGE);
        return getInputLines();
    }

    public static ArrayList<String> getIgnoredWords() {
        Output.displayMessage(INPUT_IGNORED_WORDS);
        return Input.getInput(IGNORE_LIMIT);
    }

    public static void displayKWICIndex(ArrayList<String> list) {
        Output.displayMessage(OUTPUT_DISPLAY_MESSAGE);
        Output.displayArrayList(list);
    }

    private static ArrayList<Line> getInputLines() {
        ArrayList<String> input = Input.getInput(INPUT_LIMIT);
        return convertStringArrayListToLineArrayList(input);
    }

    private static ArrayList<Line> convertStringArrayListToLineArrayList(ArrayList<String> stringArrayList) {
        ArrayList<Line> lines = new ArrayList<>();

        for(String inputLine : stringArrayList) {
            ArrayList<String> words = convertStringArrayToArrayList(inputLine.split(SPACE_REGEX));
            lines.add(new Line(words));
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
}